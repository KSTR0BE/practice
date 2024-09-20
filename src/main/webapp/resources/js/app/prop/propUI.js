//1. UI가 랜더링된 이후
document.addEventListener("DOMContentLoaded", ()=>{
//2. 데이터(json)를 비동기 요청
	const contextPath = document.body.dataset.contextPath;
	const listBody = document.getElementById("list-body");
	const singleUI = (prop)=>{
		return `
			<tr>
	            <td>${prop.propertyName}</td>
	           	<td>${prop.propertyValue}</td>
				<td>${prop.description}</td>
	        </tr>
		`;
	}
		fetch(`${contextPath}/case2/propList`, {
	        headers : {
	            "accept" : "application/json"
			}
		}).then(resp=>{
			if(resp.ok){
				return resp.json();
			} else {
				throw new Error(`상태코드 : ${resp.status}`);
			}
//3. json 응답을 수신하고, [{propertyName, propertyValue, description}...]
		//구조분해문법(destructing)
		}).then(({propList})=>listBody.innerHTML = `${propList.map(singleUI).join("\n")}`)
		.catch(console.log);
		
		
});

	