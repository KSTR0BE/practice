/**
 *
 */
document.addEventListener("DOMContentLoaded", ()=>{
	const contextPath = document.body.dataset["contextPath"]; //닷노테이션을 안하는 이유 ko-KR에서 -하나 때문에 이건 문자를 인식못함 그래서 배열구조로 한다
	const localeSelect = document.querySelector("[name='locale']");
	
	FetchUtils.fetchForJSON(`${contextPath}/serverLocales`, {
		headers:{
			accept: "application/json"
		}
	}).then(nativeObj => {
		const currentLocale = localeSelect.dataset.initValue;
		let options = "";
		for(let key in nativeObj){
			let text = nativeObj[key]; //value
			let selected = currentLocale == key ? "selected" : "";
			options+=`
				<option ${selected} value="${key}">${text}</option>
			`;	
		}
		localeSelect.innerHTML = options;
		
	});
	
	const calForm = document.getElementById("cal-form");
	const calArea = document.getElementById("cal-area");
	calForm.addEventListener("submit", e=>{
		e.preventDefault();
		const form = e.target;
		let url = form.action;
		let method = form.method;
		//request header
		let headers = {
			"accept":"text/html"
		}
		let options = {
			method:method,
			headers:headers
		};
		//year=2024&month=7&locale=en-US
		let formData = new FormData(form);
		let data = new URLSearchParams(formData).toString();
		if(method == "post"){
			headers["content-type"] = form.enctype;
			options.body = data
		} else {
			url = `${url}?${data}`;
		}
		fetch(url, options)
			.then(resp=>resp.text())
			.then(html=>calArea.innerHTML=html);
	});
	
	calArea.addEventListener("click", e=>{
		//이벤트는 버블링 되더라도 target이 변경되지 않음.
		if(!e.target.classList.contains("ctrl-a")) return;
		e.preventDefault();
		let aTag = e.target;
		let year = aTag.dataset.calYear;
		let month = aTag.dataset.calMonth;
		calForm.year.value = year;
		calForm.month.value = month;
		//calForm.submit(); //submit 이벤트가 발생하지 않음.
		calForm.requestSubmit(); //submit 이벤트가 발생함.
	});
	
	calForm.requestSubmit();
});