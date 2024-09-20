/**
 * 
 */
document.addEventListener("DOMContentLoaded", ({target})=>{
    const listBody = document.getElementById("list-body");
	const singleUI = (board) => {
		return `
			<tr>
				<td>${board.boardNo}</td>
				<td><a href= "detail.do?what=${board.boardNo}">${board.boardTitle}</a></td>
				<td>${board.boardWriter}</td>
				<td>${board.boardDate}</td>
			</tr>
		`;
	}
    fetch("", {
		headers:{
			"accept" : "application/json"
		}
	}).then(resp => {
        if(resp.ok){
            return resp.json();
        } else {
            throw new Error(`상태코드 : ${resp.status}, ${resp.statusText}`);
        }
    })
    .then(({boardList}) => listBody.innerHTML = `${boardList.map(singleUI).join("\n")}`)
	.catch(console.log)
	
	let obj$ = $("a");
	console.log("--->", obj$.length);

	const listBody$ = $(listBody);
	console.log(listBody == listBody$);
	const exampleModal$ = $("#exampleModal").on("hidden.bs.modal", ({target})=>{
		target.querySelector("form").reset();
		target.querySelector(".modal-body").innerHTML = "";
	});
	const myModal = new bootstrap.Modal(exampleModal$[0]);
	// listBody$.addEventListener X
	// listBody.on X
	listBody$.on("click", "a" , (e)=>{
		e.preventDefault();
		const a = e.target;
		console.log("href : ", a.href);
		let params = new URLSearchParams(a.href.split("?")[1]);
		let what = params.get("what");
		$.ajax({
			url:a.href,
			dataType:"html",
			success:function(html){
				console.log(html);
				
				exampleModal$.find(".modal-body").html(html);
				exampleModal$.find("input[name=what]").val(what);
				myModal.show();
				
			}, error: function(jqXHR, errorStatus, errorText){
				console.log(jqXHR);
				console.log(errorStatus);
				console.log(errorText);
			}
			
		})
	});
	
});