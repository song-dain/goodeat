     const memberId = document.getElementById("memberId");
     const memberPwd = document.getElementById("password");
     const memberName = document.getElementById("memberName");
     const phone = document.getElementById("phone");
     const zipCode = document.getElementById("zipCode");
     const detailAddress = document.getElementById("detailAddress");
     const emailCode = document.getElementById("emailCode");
	 const email1 = document.getElementById("email1");
	 const email2 = document.getElementById("email2");
     
     var id_RegExp = /^[a-zA-Z0-9]{4,10}$/; //아이디
     var pwd_RegExp = /(?=.*\d)(?=.*[a-zA-ZS]).{6,16}/; // 패스워드
     var n_RegExp = /^[가-힣]{2,}$/; // 이름
     var p_RegExp = /^[0-9]{11,}$/; // 번호 
     var e_RegExp = /^[a-zA-Z0-9]{4,}$/; /// 이메일
     
     const checkedId = document.getElementById("checkedId");
     const checkedPwd = document.getElementById("checkedPwd");
     const password2 = document.getElementById("password2");
     const checkedName = document.getElementById("checkedName");
     const checkedPhone = document.getElementById("checkedPhone");
     const checkedZipCode = document.getElementById("checkedZipCode");
     const checkedAddress = document.getElementById("checkedAddress");
     const checkedAgreement = document.getElementById("checkedAgreement");
     const checkedEmail = document.getElementById("checkedEmail");
     
	const sendCodeBtn = document.getElementById("sendCodeBtn");

     function checkForm() {
    	 
    	 if(!id_RegExp.test(memberId.value.trim()) || document.getElementById("cannotUse")){
    		 alert('아이디를 확인해주세요.');
    		 memberId.focus();
    		 return false;
    	 }
    	 
     	 if(!pwd_RegExp.test(memberPwd.value.trim())){
     		alert('비밀번호를 확인해주세요.');
    		 memberPwd.focus();
    		 return false;
    	 }
     	 
       	 if(password.value != password2.value){
       		alert('비밀번호가 일치하지 않습니다.');
     		password2.focus();
     		return false;
     	 }
    	 
    	 if(!n_RegExp.test(memberName.value.trim())){
    		 alert('이름을 확인해주세요.');
    		 memberName.focus();
    		 return false;
    	 }
    	 
    	 if(!p_RegExp.test(phone.value.trim())){
    		 alert('휴대전화 번호를 확인해주세요.');
    		 phone.focus();
    		 return false;
    	 }
    	 
    	 if(zipCode.value.trim() == ''){
    		 alert('주소를 입력해주세요.');
    		 detailAddress.focus();
    		 return false;
    	 }
    	 
    	 if(detailAddress.value.trim() == ''){
    		 alert('상세 주소를 입력해주세요.');
    		 detailAddress.focus();
    		 return false;
    	 }
    	 
    	 if(emailCode.value.trim() == '' || document.getElementById("discord")){
			 alert('인증번호를 확인해주세요.');
			 emailCode.focus();
			 return false;
		 }
     }
     
     if(document.getElementById("memberId")){
	     
	     memberId.onkeyup = function () {
	    	 
	    	 let memberIdValue = memberId.value.trim();
	    	 
	    	 if(!id_RegExp.test(memberIdValue)){
	    		 checkedId.innerHTML = '<div class="result"> 4~6자 영문 또는 숫자만 입력 가능합니다. <div>';
	    		 return;
	    	 }
	    	 
	    	 fetch("/idDupCheck", {
	    		 method: "POST",
	    		 headers: {
	    			 'Content-Type': 'application/json;charset=UTF-8'
	    		 },
	    		 body: JSON.stringify({memberId: memberIdValue})
	    	 })
	    	 	.then(result => result.text())
	    	 	.then(result => {
	    	 		
	    	 		if(result == "cannotUse"){
	    	 			checkedId.innerHTML = '<div id="cannotUse" class="result"> 이미 사용 중인 아이디입니다. </div>';
	    	 			return;
	    	 		} else {
	    	 			checkedId.innerHTML = '';
	    	 		}
	    	 		
	    	 	})
	    	 	.catch((error) => error.text().then((res) => alert(res)));
	     }
     }
    

     if(document.getElementById("password")){
    	 
    	 memberPwd.onkeyup = function() {
    		 
    		 let memberPwdValue = memberPwd.value.trim();
    		 
    		 if(!pwd_RegExp.test(memberPwdValue)){
    			 checkedPwd.innerHTML = '<div class="result"> 6~16자 영문, 숫자 혼합 비밀번호만 가능합니다. <div>';
    			 return;
    		 } else {
    			 checkedPwd.innerHTML = '';
    			 return;
    		 }
    	 }
     }
     
     
     if(document.getElementById("password2")){
    	 
    	 password2.onkeyup = function(){
    		 
    		 let memberPwdValue = memberPwd.value.trim();
    		 let password2Value = password.value.trim();
    		 
    		 console.log(memberPwdValue, password2Value);
    		 
    		 if(password.value != password2.value)  {
    			 checkedPwd.innerHTML = '<div class="result"> 비밀번호가 일치하지 않습니다. <div>';
    			 return;
    		 } else {
    			 checkedPwd.innerHTML = '';
    		 }
    	 }
     }
     

     if(document.getElementById("memberName")){
    	 
    	 memberName.onkeyup = function() {
    		 
    		 let memberNameValue = memberName.value.trim();
    		 
    		 if(!n_RegExp.test(memberNameValue)){
    			 checkedName.innerHTML = '<div class="result"> 2~15자 한글만 입력 가능합니다. <div>';
    			 return;
    		 } else {
    			 checkedName.innerHTML = '';
    		 }
    	 }
     }
     

     if(document.getElementById("phone")){
    	 
    	 phone.onkeyup = function() {
    		 
    		 let phoneValue = phone.value.trim();
    		 
    		 if(!p_RegExp.test(phoneValue)){
    			 checkedPhone.innerHTML = '<div class="result"> 휴대전화 번호 11자리를 입력하세요. <div>';
    			 return;
    		 } else {
    			 checkedPhone.innerHTML = '';
    		 }
    	 }
     }
     
	let sendCode = '';
	
	if(document.getElementById("email1")){ 
		
		sendCodeBtn.onclick = function(){
			
			let email1Value = email1.value.trim();
			let email2Value = email2.value.trim();
			let email = email1Value + "@" + email2Value;
			
			console.log('완성된 이메일' + email)
			
  			if(!e_RegExp.test(email1Value)){
				checkedEmail.innerHTML = '<div class="result"> 올바른 이메일 형식을 입력해주세요. <div>'
				return;
			}
			
			fetch("/emailCheck", {
				method: "POST",
	    		 headers: {
	    			 'Content-Type': 'application/json;charset=UTF-8'
	    		 },
				body: JSON.stringify({email})
			})
				.then(result => result.text())
				.then(result => sendCode = result)
				.then(result => checkedEmail.innerHTML = '<div class="result"> 이메일로 인증번호가 전송되었습니다. <div>')
				.catch((error) => error.text().then((res) => alert(res)));
		}
	}
	 
	 if(document.getElementById("emailCode")){
	 
		emailCode.onkeyup = function(){
			 
			 let emailCodeValue = emailCode.value.trim();
			 console.log("send : " + sendCode);
			 console.log("input : " + emailCodeValue);
			 
			 if(emailCodeValue != sendCode){
				 checkedEmail.innerHTML = '<div class="result" id ="discord"> 인증번호가 일치하지 않습니다. <div>';
				 return;
			 } else {
				 checkedEmail.innerHTML = '<div class="result"> 이메일이 인증되었습니다. <div>'
				 return;
			 }
		 }
	 }

     const $searchAddress = document.getElementById("search");
     
     $searchAddress.onclick = function () {
     
	     new daum.Postcode({
	    	 oncomplete: function(data){
	    		 document.getElementById("zipCode").value = data.zonecode;
	    		 document.getElementById("searchAddress").value = data.address;
	    		 document.getElementById("detailAddress").focus();
	    	 }
	     }).open();
     }