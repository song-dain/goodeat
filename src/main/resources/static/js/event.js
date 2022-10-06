if(document.getElementById("id")) {

        const $checkId = document.getElementById("checkId");
        const $checkedId = document.getElementById("checkedId");

        $checkId.onclick = function() {
            let memberId = document.getElementById("id").value.trim();

			console.log("클릭됨");
			
            fetch("/idDupCheck", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                body: JSON.stringify({memberId: memberId})
            })
                .then(result => result.text())
                .then(result => $checkedId.innerHTML = result)
                .catch((error) => error.text().then((res) => alert(res)));

        }
    }