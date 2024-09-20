/**
 * 
 */
document.addEventListener("DOMContentLoaded", () => {
   const myOffcanvas = document.getElementById('offcanvas')
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