window.onload = function() {
	
	if(document.getElementById("mil1")) {
		const $mil = document.getElementById("mil1");
		$mil.onclick = function() {
			location.href = "/user/mil";
		}
	}
	
	if(document.getElementById("lunch1")) {
		const $lunchbox = document.getElementById("lunch1");
		$lunchbox.onclick = function() {
			location.href = "/user/lunchbox";
		}
	}	
	
	if(document.getElementById("chicken1")) {
		const $chicken = document.getElementById("chicken1");
		$chicken.onclick = function() {
			location.href = "/user/chicken";
		}
	}
	
	if(document.getElementById("convenince")) {
		const $convenince = document.getElementById("convenince");
		$convenince.onclick = function() {
			location.href = "/user/convenince";
		}
	}
	
	if(document.getElementById("vegan")) {
		const $vegan= document.getElementById("vegan");
		$vegan.onclick = function() {
			location.href = "/user/vegan";
		}
	}
	
		if(document.getElementById("post")) {
		const $post= document.getElementById("post");
		$post.onclick = function() {
			location.href = "/post/list";
		}
	}
	
	if(document.getElementById("notice")) {
		const $notice= document.getElementById("notice");
		$notice.onclick = function() {
			location.href = "/post/notice";
		}
	}
	
	if(document.getElementById("event")) {
		const $event= document.getElementById("event");
		$event.onclick = function() {
			location.href = "/post/event";
		}
	}
	
}


 

