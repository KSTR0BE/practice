/**
 * 
 */
document.addEventListener("DOMContentLoaded", () => {
	const contextPath = document.body.dataset.contextPath;
	const listBody = document.getElementById("list-body");
	const singleUI = (buyer) => {
		let detailUrl = `${contextPath}/buyer/buyerDetail.do?what=${buyer.buyerId }`;
		return `
				<tr>
					<td>${buyer.buyerId }</td>
					<td>${buyer.lprod.lprodNm }</td>
					<td>
					<a 
					data-bs-toggle="offcanvas" 
					href="#offcanvasExample" 
					role="button"
					aria-controls="offcanvasExample" 
					data-detail-url="${detailUrl }">
					${buyer.buyerName }
					</a>
					</td>
					<td>${buyer.buyerAdd1 }</td>
					<td>${buyer.buyerComtel }</td>
					<td>${buyer.buyerCharger }</td>
					<td>${buyer.cartCount }</td>
				</tr>
		
				`;
	}	
	FetchUtils.fetchForJSON("", {
		headers:{
			"accept":"application/json"
		}
	}).then(({bList})=>{
		let trTags = null;
		if(bList && bList.length > 0){
			trTags = bList.map(singleUI).join("\n");
		} else {
			trTags = `
					<tr>
						<td colspan="7"> 해당 제조사 없음.</td>
					</tr>
					`;
		}
		listBody.innerHTML = trTags;
				

	});
	
	
   const myOffcanvas = document.getElementById('offcanvasExample')
   myOffcanvas.addEventListener('show.bs.offcanvas', event => {
      console.log(event);
      let offcanvas = event.target;
      let offcanvasBody= offcanvas.querySelector(".offcanvas-body")
      let aTag = event.relatedTarget;
      let url = aTag.dataset.detailUrl; 
      FetchUtils.fetchForText(url, {
         headers:{
            "accept" : "text/html"
         }
      }).then((html)=>{offcanvasBody.innerHTML=html});
   })
});