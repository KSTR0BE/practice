/**
 * 
 */
document.addEventListener("DOMContentLoaded", ()=>{
	const contextPath = document.body.dataset.contextPath;
	const selectTag = document.querySelector('[name="type"]');
	const updateList = (jsonObj) => {
		let mbtiList = jsonObj.mbtiList;
		selectTag.innerHTML = 
			mbtiList.map(mbti=>`<option value="${mbti.id}">${mbti.title}</option>`)
					.join("\n")
		};
	fetch(`${contextPath}/case2/mbtiList`)
	.then(resp=>resp.json())
	.then(updateList);

	//이벤트 처리 구조를 통해 하나의 MBTI 유형의 정보를 비동기로 처리할 것.
	// 1. mbti-list 를 대상으로
	const mbtiList = document.getElementById("mbti-list");
	const mbtiArea = document.getElementById("mbti-area");
	// 2. submit 이벤트 처리
	mbtiList.addEventListener("submit", e => {
		// 3. 이벤트 중단
		e.preventDefault();
		// 4. 비동기 요청 전송
		const form = e.target;
		let url = form.action
		let method = form.method;
		let options = {
			method:method,
			headers:{
				"accept":"text/html"
			}
		};
		let formData = new FormData(form);
		let data = new URLSearchParams(formData).toString();
		if(method=="post"){
			let contentType = form.enctype
			options.headers["content-type"] = contentType;
			options.body = data;
		} else {
			url = `${url}?${data}`;
		}
//		let ll = EventUtils.submitForText(e);
//		const { url, options } = EventUtils.submitForText(e);
//		FetchUtils.fetchForText(url, options)
		fetch(url, options) //ll.url, ll.options 
			.then(resp=>{
				if(resp.ok){
					return resp.text();
				} else {
					throw Error(`상태코드 : ${resp.status}, 메세지 : ${resp.statusText}`);
				}
			}).then(html=>{
				// 5. 응답 수신 후 mbti-area에 넣기
				mbtiArea.innerHTML = html;
			})
//			.then(html=>{
//				mbtiArea.innerHTML = html;
//			})
			.catch(console.log);
	});

	const newMbti = document.getElementById("new-mbti");
	newMbti.addEventListener("submit", e => {
		e.preventDefault();
		const form = e.target;
		let url = form.action
		let method = form.method;
		let options = {
			method:method,
			headers:{
				"accept":"application/json"
			}
		};
		let formData = new FormData(form);
		let data = new URLSearchParams(formData).toString();
		if(method=="post"){
			let contentType = form.enctype
			options.headers["content-type"] = contentType;
			options.body = data;
		} else {
			url = `${url}?${data}`;
		}
//		const { url, options } = EventUtils.submitForJSON(e);
//		FetchUtils.fetchForJSON(url, options)
		fetch(url, options)
			.then(resp=>{
				if(resp.ok){
					return resp.json();
				} else {
					throw Error(`상태코드 : ${resp.status}, 메세지 : ${resp.statusText}`);
				}
			}).then(updateList)
			.catch(console.log)
//			.then(updateList)
//			.finally(()=> newMbti.reset());
	})
});