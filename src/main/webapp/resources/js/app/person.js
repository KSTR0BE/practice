// DOMContentLoaded :바디가 완성이 되고 그안에 스크립트에 대한 로딩이 다 끝난시점
document.addEventListener("DOMContentLoaded", (event)=>{
    const contextPath = document.body.dataset.contextPath
    const listBody = document.getElementById("list-body");
    const detailArea = document.getElementById("detail-area");
    
    FetchUtils.fetchForJSON(`${contextPath}/case2/personList.do`, {
        method : "get",
        headers : {
            accept:"application/json"
        }
    }).then(jsonObj=>{
        let trTags = "";
        for(let person of jsonObj ){
            trTags += `
                <tr>
                    <td>${person.id}</td>
                    <td><a href="${contextPath}/case2/person.do?who=${person.id}">${person.name}</a></td>
                </tr>
            `
        }
        listBody.innerHTML = trTags;
    });

    listBody.addEventListener("click", (clickEvent)=>{
        clickEvent.preventDefault();
        let target = clickEvent.target;
        if(!target.href){
            return false;
        }

        console.log("atag href : ", target.href)
        //fetch로 비동기 요청 전송
        //json 응답을 수신하고, detail-area 테이블에 CSR완성.
        FetchUtils.fetchForJSON(target.href,{
            headers:{
                accept : "application/json"
            }
        }).then(person=>{  // obj덩어리 해석하는데 10분걸린다 그뒤에 예약
            // detailArea.querySelector("#td_id").innerHTML = person.id;
            for (let prop in person) {
                detailArea.querySelector(`#td_${prop}`).innerHTML = person[prop];
            }
        });
    });
});
