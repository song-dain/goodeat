window.onload = function() {
	
	if(document.getElementById("Cart")) {
		const $Cart = document.getElementById("Cart");
		$Cart.onclick = function() {
			location.href = "/user/cartList";
		}
	}
	
	
	
	
	
	$(document).ready(function() {
			
			setTotalInfo();
			
		});
		
		/* 체크여부에따른 종합 정보 변화 */
		$(".individual_cart_checkbox").on("change", function(){
			setTotalInfo($(".cart_info_div"));
		});
		
		/* 체크박스 전체 선택 */
		$(".all_check_input").on("click", function(){

			if($(".all_check_input").prop("checked")) {
				$(".individual_cart_checkbox").prop("checked",true);
			} else {
				$(".individual_cart_checkbox").prop("checked", false);
			}
			setTotalInfo($(".cart_info_div"));
			
		});
		
		
		function setTotalInfo() {
			
			let totalPrice = 0;
			let finalTotalPrice = 0;
			
			$(".cart_info_div").each(function(index, element) {
				
				if($(element).find(".individual_cart_checkbox").is(":checked") === true){
					// 총 가격
					totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
				}
				
				
			});
			
			finalTotalPrice = totalPrice;

			$(".totalPrice_span").text(totalPrice.toLocaleString());
			$(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString);
		}
		
		/* 수량버튼 */
		$(".plus_btn").on("click", function(){
			let quantity = $(this).parent("div").find("input").val();
			$(this).parent("div").find("input").val(++quantity);
		});
		$(".minus_btn").on("click", function(){
			let quantity = $(this).parent("div").find("input").val();
			if(quantity > 1){
				$(this).parent("div").find("input").val(--quantity);		
			}
		});
		
		/* 수량 수정 버튼 */
		$(".quantity_modify_btn").on("click", function(){
			let cartId = $(this).data("cartId");
			let productCount = $(this).parent("div").find("input").val();
			$(".update_cartCode").val(cartId);
			$(".update_productAmount").val(productCount);
			$(".quantity_update_form").submit();
			
		});
		
		
	
}