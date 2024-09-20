/**
 * 
 */
document.addEventListener("DOMContentLoaded", ()=>{
	$(":input[name]").on("focus", ({target})=>{ //포커스르 얻었을때
		console.log(target, "포커스 얻었음.");
		$(target).removeClass("invalid");
	}).on("blur", ({target})=>{ //blur  포커스를 잃었을때
		console.log(target, "포커스 잃었음.");
		if(!target.checkValidity()){
			$(target).addClass("invalid");
		}
	});
})