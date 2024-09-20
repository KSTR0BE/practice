/**
 * 
 */
document.addEventListener("DOMContentLoaded", () => {
	const listBody = document.getElementById("list-body");
	const contextPath = document.dataset("");
	const singleUI = (buyer) => {
		return `
			<tr>
				<td>${buyer.buyerId}</td>
				<td>${buyer.lprod.lprodNm}</td>
				<td>
				<c:url value="/buyer/buyerDetail.do" var="detailUrl" scope="request" >
				<c:param name="what" value="${i.buyerId }"></c:param>
				</c:url>
				<a 
				data-bs-toggle="offcanvas"  
 				href="#offcanvasExample"  
 				role="button" -->
 				aria-controls="offcanvasExample" 
				data-detail-url="${detailUrl }">
				${buyer.buyerName}
				</a>
				</td>
				<td>${buyer.buyerAdd1}</td>
 				<td>${buyer.buyerComtel}</td>
 				<td>${buyer.buyerCharger}</td>
				<td>${buyer.cartCount }</td>
			</tr>
		</tr>
		`;
	}
	FetchUtils.fetchForJSON("", {
		headers:{
			"accept":"application/json"
		}
	}).then(({buyerList}) => listBody.innerHTML = `${buyerList.map(singleUI).join("\n")}`)
//	listBody.innerHTML = `${buyerList.map(singleUI).join("\n")}`
	
	
	
	
	
	
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