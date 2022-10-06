window.onload = function() {
	
	if(document.getElementById("Cart")) {
		const $Cart = document.getElementById("Cart");
		$Cart.onclick = function() {
			location.href = "/user/cartList";
		}
	}
}