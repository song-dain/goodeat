     $("#checkId").click(function(){
    	
    	 var id = $('#id').val();
    	 
    	 $.ajax({
    		 url: '${pageContext.request.contextPath}/user/join/join/idCheck?userId='+ id,
    		 type: 'get',
    		 success: function(data){
    			 console.log("1 = 중복o / 0 = 중복 x : "+ data);
    		
    			 if(data == 1) {
    				 
    				 $("#checkedId").text("사용 중인 아이디입니다.");
    				 $("#checkedId").css("color", "red");
    				 $("checkedId").attr("disabled", true);
    			 } else {
    				 
    				 if(idJ.text(id)){
						$("#id_check").text("");
						$("#reg_submit").attr("disabled", false);
    				 } else if(id == ""){
						$('#id_check').text('아이디를 입력해주세요 :)');
						$('#id_check').css('color', 'red');
						$("#reg_submit").attr("disabled", true);
    				 } else {
						$('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 :) :)");
						$('#id_check').css('color', 'red');
						$("#reg_submit").attr("disabled", true);
    				 }
    			 }
    		 }, error: function(){
    			 cosole.log("실패");
    		 }
    	 })
     })