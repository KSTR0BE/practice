const EventUtils = {
	submitForText : (e) => {
		e.preventDefault();
		const form = e.target;
		let url = form.action;
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
		return { url, options };
	},
	submitForJSON : (e) => {
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
		return { url, options };
	}
}
// const {url, options } = submitEventUtills.submitForText(a) 이런식으로 호출