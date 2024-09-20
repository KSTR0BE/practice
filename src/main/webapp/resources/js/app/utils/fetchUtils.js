const FetchUtils = { //언마샬링
    fetchForText : (url, options)=>{
        return fetch(url, options)
            .then(resp => {
                if(resp.ok){
                    return resp.text();
                } else {
                    throw new Error(`상태코드 : ${resp.status}, ${resp.statusText}`);
                }
            })
            .catch(err => console.error(err));
    },
    fetchForJSON : (url, options)=>{
        return fetch(url, options)
            .then(resp => {
                if(resp.ok){
                    return resp.json();
                } else {
                    throw new Error(`상태코드 : ${resp.status}, ${resp.statusText}`);
                }
            })
            .catch(err => console.error(err));
    }
}
// FetchUtils.fetchForText("주소",{옵션객체}).then(txt=>console(txt)); 이런식으로 호출