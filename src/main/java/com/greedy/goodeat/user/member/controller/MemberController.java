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
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/login")
	public String goLogin(HttpServletRequest request) {
		
		String referrer = request.getHeader("Referer");
		request.getSession().setAttribute("prevePage", referrer);

		return "user/login/login";
	}
	
	
    @PostMapping("/loginfail")
    public String loginFailed(RedirectAttributes rttr) {
    	
    	rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.loginfail"));
    	
    	return "redirect:/login";
    }

   
	@GetMapping("/join")
	public String goJoin() 
	{
		return "user/join/join";
	}
   
	@PostMapping("/idDupCheck")
	public ResponseEntity<String> idDupCheck(@RequestBody MemberDTO reqInfo){
		
		String result = "canUse";
		
		if(memberService.selectMemberById(reqInfo.getMemberId())) {
			result = "cannotUse";
		}
		
		return ResponseEntity.ok(result);
	}
	
	@ResponseBody
	@PostMapping("/emailAthnt")
	public String emailAthnt(@RequestBody MemberDTO reqInfo){
		
		return mailSendService.sendEmailForm(reqInfo.getEmail());
	}
	
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
	
	
	@GetMapping("/findId")
	public String goFindId() {
	  
		return "user/findInfo/findId";
	}

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
	
	
	@GetMapping("/findPwd")
	public String goFindPwd() {
		
		return "user/findInfo/findPwd";
	}
	
	@PostMapping("/findPwd")
	public String sendTmprrPwd(@ModelAttribute MemberDTO reqInfo, RedirectAttributes rttr) {
		
		String redirectUrl = "";
		
		if(memberService.selectMemberByIdAndEmail(reqInfo.getMemberId(), reqInfo.getEmail())) {
			
			MemberDTO matchMember = memberService.findByMemberIdAndEmail(reqInfo);
			
			String tmprrPwd = mailSendService.findPwdEmailForm(matchMember);
			
			matchMember.setMemberPwd(passwordEncoder.encode(tmprrPwd));
			
			memberService.changeMemberPwd(matchMember);
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.pwdIssue"));
			redirectUrl = "redirect:/login";
			
		} else {
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.notfound"));
			redirectUrl = "redirect:/findPwd";
			
		}
			
		return redirectUrl;
	}
	

	@GetMapping("/mypage")
	public String goMypage() {
		   
		return "user/mypage/mypage";
	}
	
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
	
	
	@GetMapping("/mypage/info")
	public String goInfo() {
		   
		return "user/mypage/info";
	}
	
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

	@GetMapping("/unjoin")
	public String goUnjoin() {
		   
		return "user/join/unjoin";
	}
	
	@PostMapping("/unjoin")
	public String unjoinMembership(@AuthenticationPrincipal MemberDTO loginMember, RedirectAttributes rttr) {
		
		memberService.unjoinMembership(loginMember);
		
        SecurityContextHolder.clearContext();
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.unjoin"));
		
        return "redirect:/";
	}
	
    protected Authentication createNewAuthentication(Authentication currentAuth, String memberId) {
    	
    	UserDetails newPrincipal = authenticationService.loadUserByUsername(memberId);
    	UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(newPrincipal, currentAuth.getCredentials(), newPrincipal.getAuthorities());
    	newAuth.setDetails(currentAuth.getDetails());
    	
        return newAuth;
    }

	
}
