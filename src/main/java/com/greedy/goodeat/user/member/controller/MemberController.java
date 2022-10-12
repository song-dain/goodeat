package com.greedy.goodeat.user.member.controller;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
import com.greedy.goodeat.user.member.service.MailSendService;
import com.greedy.goodeat.user.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	private final PasswordEncoder passwordEncoder;
	private final MemberService memberService;
	private final MailSendService mailSendService;
	private final MessageSourceAccessor messageSourceAccessor;
	
	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder, 
			MessageSourceAccessor messageSourceAccessor, MailSendService mailSendService) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
		this.messageSourceAccessor = messageSourceAccessor;
		this.mailSendService = mailSendService;
	}
	
	@GetMapping("/login")
	public String goLogin() {
		return "user/login/login";
	}
	
	@GetMapping("/join")
	public String goJoin() {
		return "user/join/join";
	}
  
  @GetMapping("/findId")
	public String goFindId() {
		return "user/findInfo/findId";
	}
	

	@GetMapping("/findPwd")
	public String goFindPwd() {
		return "user/findInfo/findPwd";
  }
	
   @GetMapping("/mypage")
   public String goMypage() {
	   return "user/mypage/mypage";
   }
   
   @GetMapping("/mypage/info")
   public String goInfo() {
	   return "user/mypage/info";
   }
   
	@PostMapping("/idDupCheck")
	public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO member){
		
		String result = "canUse";
		
		if(memberService.selectMemberById(member.getMemberId())) {
			result = "cannotUse";
		}
		
		return ResponseEntity.ok(result);
	}
	
	@ResponseBody
	@PostMapping(value = "/emailCheck", produces="text/html; charset=UTF-8")
	public String emailCheck(@RequestBody MemberDTO member){
		
		return mailSendService.sendEmailForm(member.getEmail());
	}
	
	
	@PostMapping("/join")
	public String joinMembership(@ModelAttribute MemberDTO member, String email, String email2, 
				String year, String month, String day, RedirectAttributes rttr) {
		
		member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
		member.setEmail(email + "@" + email2);
		
		if(!year.equals("") && !month.equals("") && !day.equals("")) {
			java.sql.Date birthDate = java.sql.Date.valueOf(year + "-" + month + "-" + day);
			member.setBirthDate(birthDate);
		}	
		
		member.setPhone(member.getPhone().replace("-", ""));
		
		memberService.joinMembership(member);
		
		rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.join"));
		
		return "redirect:/login";
	}
	

	@PostMapping("/findId")
	public String findId(@ModelAttribute MemberDTO member, RedirectAttributes rttr) {
		
		String result = "";
		
		if(memberService.selectMemberByNameAndEmail(member.getMemberName(), member.getEmail())) {
		
			MemberDTO findMember = memberService.findByMemberNameAndEmail(member);
			
			log.info("[MemberController] findMember : {}", findMember);
			log.info("[MemberController] findMemberId : {}", findMember.getMemberId());
			
			mailSendService.findIdEmailForm(findMember.getMemberId(), member.getEmail());
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.found"));
			result = "redirect:/login";
			
		} else {
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.notfound"));
			result = "redirect:/findId";
		}
			
		return result;
	}
	

	@PostMapping("/findPwd")
	public String findPwd(@ModelAttribute MemberDTO member, RedirectAttributes rttr) {
		
		String result = "";
		
		if(memberService.selectMemberByIdAndEmail(member.getMemberId(), member.getEmail())) {
			
			MemberDTO findMember = memberService.findByMemberIdAndEmail(member);
			
			String pwdIssue = mailSendService.findPwdEmailForm(findMember);
			
			findMember.setMemberPwd(passwordEncoder.encode(pwdIssue));
			
			memberService.changeMemberPwd(findMember);
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.pwdIssue"));
			result = "redirect:/login";
			
		} else {
			
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.notfound"));
			result = "redirect:/findPwd";
			
		}
			
		return result;
	}
	
	@PostMapping("/mypage")
	public String pwdReinput(@RequestParam String inputPwd, @AuthenticationPrincipal MemberDTO loginMember, 
				RedirectAttributes rttr) {
		
		log.info("[memberController] inputPwd : {}", inputPwd);
		log.info("[memberController] loginMember : {}", loginMember);
		
		String result = "";
		
		if(passwordEncoder.matches(inputPwd, loginMember.getMemberPwd())) {
			result = "redirect:/mypage/info";
		} else {
			rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.enterMypageFail"));
			result = "redirect:/mypage";
		}

		return result;
		
	}
	
	
}
