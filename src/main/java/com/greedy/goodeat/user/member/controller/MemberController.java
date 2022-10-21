package com.greedy.goodeat.user.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.user.member.service.AuthenticationService;
import com.greedy.goodeat.user.member.service.MailSendService;
import com.greedy.goodeat.user.member.service.MemberService;

@Controller
public class MemberController {
	
	private final PasswordEncoder passwordEncoder;
	private final MemberService memberService;
	private final MailSendService mailSendService;
	private final AuthenticationService authenticationService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder, 
			MessageSourceAccessor messageSourceAccessor, MailSendService mailSendService,
			AuthenticationService authenticationService) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
		this.messageSourceAccessor = messageSourceAccessor;
		this.mailSendService = mailSendService;
		this.authenticationService = authenticationService;
	}
	
	
	/* 로그인, 이전 페이지 전달 */
	@GetMapping("/login")
	public String goLogin(HttpServletRequest request) {
		
		String referrer = request.getHeader("Referer");
		request.getSession().setAttribute("prevePage", referrer);

		return "user/login/login";
	}
	
	
	/* 로그인 실패 */
    @PostMapping("/loginfail")
    public String loginFailed(RedirectAttributes rttr) {
    	
    	rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.loginfail"));
    	
    	return "redirect:/login";
    }

    
    /* 회원가입 페이지 이동 */
	@GetMapping("/join")
	public String goJoin() 
	{
		return "user/join/join";
	}
   
	/* 회원가입 - 아이디 중복 체크 */
	@PostMapping("/idDupCheck")
	public ResponseEntity<String> idDupCheck(@RequestBody MemberDTO reqInfo){
		
		String result = "canUse";
		
		if(memberService.selectMemberById(reqInfo.getMemberId())) {
			result = "cannotUse";
		}
		
		return ResponseEntity.ok(result);
	}

	/* 회원가입 - 이메일 중복 체크 후 인증번호 전송 */
	@PostMapping("/emailAthnt")
	public ResponseEntity<String> emailAthnt(@RequestBody MemberDTO reqInfo){
		
		String result = "";
		
		if(memberService.selectMemberByEmail(reqInfo.getEmail())){
			result = "cannotUse";
		} else {
			result = mailSendService.sendEmailForm(reqInfo.getEmail());
		}
		
		return ResponseEntity.ok(result);
	}
	
	/* 회원가입 */
	@PostMapping("/join")
	public String joinMembership(@ModelAttribute MemberDTO reqInfo, String emailId, String emailAddress, 
				String year, String month, String day, RedirectAttributes rttr) {
		
		reqInfo.setMemberPwd(passwordEncoder.encode(reqInfo.getMemberPwd()));
		reqInfo.setEmail(emailId + "@" + emailAddress);
		
		if(!year.equals("") && !month.equals("") && !day.equals("")) {
			java.sql.Date birthDate = java.sql.Date.valueOf(year + "-" + month + "-" + day);
			reqInfo.setBirthDate(birthDate);
		}
		
		memberService.joinMembership(reqInfo);
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.join"));
		
		return "redirect:/login";
	}
	
	
	/* 아이디 찾기 페이지 이동 */
	@GetMapping("/findId")
	public String goFindId() {
	  
		return "user/findInfo/findId";
	}

	/* 아이디 찾기 */
	@PostMapping("/findId")
	public String sendId(@ModelAttribute MemberDTO reqInfo, RedirectAttributes rttr) {
		
		String redirectUrl = "";
		
		if(memberService.selectMemberByNameAndEmail(reqInfo.getMemberName(), reqInfo.getEmail())) {
		
			MemberDTO matchMember = memberService.findByMemberNameAndEmail(reqInfo);
			
			mailSendService.findIdEmailForm(matchMember.getMemberId(), matchMember.getEmail());
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.found"));
			redirectUrl = "redirect:/login";
			
		} else {
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.notfound"));
			redirectUrl = "redirect:/findId";
			
		}
			
		return redirectUrl;
	}
	
	
	/* 비밀번호 찾기 페이지 이동 */
	@GetMapping("/findPwd")
	public String goFindPwd() {
		
		return "user/findInfo/findPwd";
	}
	
	/* 비밀번호 찾기 */
	@PostMapping("/findPwd")
	public String sendTmprrPwd(@ModelAttribute MemberDTO reqInfo, RedirectAttributes rttr) {
		
		String redirectUrl = "redirect:/login";
		
		if(memberService.selectMemberByIdAndEmail(reqInfo.getMemberId(), reqInfo.getEmail())) {
			
			MemberDTO matchMember = memberService.findByMemberIdAndEmail(reqInfo);
			
			String tmprrPwd = mailSendService.findPwdEmailForm(matchMember);
			
			matchMember.setMemberPwd(passwordEncoder.encode(tmprrPwd));
			
			memberService.changeMemberPwd(matchMember);
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.pwdIssue"));
			
		} else {
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.notfound"));
			redirectUrl = "redirect:/findPwd";
			
		}
			
		return redirectUrl;
	}
	

	/* 마이페이지 이동 */
	@GetMapping("/mypage")
	public String goMypage() {
		   
		return "user/mypage/mypage";
	}
	
	/* 마이페이지 - 비밀번호 재확인 */
	@PostMapping("/mypage")
	public String pwdReinput(@RequestParam String inputPwd, @AuthenticationPrincipal MemberDTO loginMember,
				RedirectAttributes rttr) {
		
		String redirectUrl = "";
		
		if(passwordEncoder.matches(inputPwd, loginMember.getMemberPwd())) {
			
			redirectUrl = "redirect:/mypage/info";
			
		} else {
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.enterMypageFail"));
			redirectUrl = "redirect:/mypage";
			
		}

		return redirectUrl;
	}
	
	
	/* 내 정보 조회/수정 페이지로 이동 */
	@GetMapping("/mypage/info")
	public String goInfo() {
		   
		return "user/mypage/info";
	}
	
	/* 내 정보 조회/수정 */
	@PostMapping("/mypage/info")
	public String updateMemberInfo(@ModelAttribute MemberDTO updateInfo, String year, String month, String day,
			@AuthenticationPrincipal MemberDTO loginMember, RedirectAttributes rttr) {
		
		updateInfo.setMemberNo(loginMember.getMemberNo());
		updateInfo.setMemberPwd(passwordEncoder.encode(updateInfo.getMemberPwd()));
		
		memberService.modifyInfo(updateInfo);
		
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(authentication, loginMember.getMemberId()));
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.update"));
		
		return "redirect:/mypage/info";
	}
	

	/* 회원 탈퇴 페이지 이동 */
	@GetMapping("/unjoin")
	public String goUnjoin() {
		   
		return "user/join/unjoin";
	}
	
	/* 회원 탈퇴 */
	@PostMapping("/unjoin")
	public String unjoinMembership(@AuthenticationPrincipal MemberDTO loginMember, RedirectAttributes rttr) {
		
		memberService.unjoinMembership(loginMember);
		
        SecurityContextHolder.clearContext();
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.unjoin"));
		
        return "redirect:/";
	}
	
	
	/* 로그인되어 있는 회원 정보를 갱신하는 메소드 */
    protected Authentication createNewAuthentication(Authentication currentAuth, String memberId) {
    	
    	UserDetails newPrincipal = authenticationService.loadUserByUsername(memberId);
    	UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(newPrincipal, currentAuth.getCredentials(), newPrincipal.getAuthorities());
    	newAuth.setDetails(currentAuth.getDetails());
    	
        return newAuth;
    }

	
}
