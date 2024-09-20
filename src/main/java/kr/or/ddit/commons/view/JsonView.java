package kr.or.ddit.commons.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/jsonView")
public class JsonView extends HttpServlet {
	
	
	@Override // 안에 슈퍼클래스를 없애면 doget dopost로 안가고 지혼자 처리하겠다는 뜻
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		Map<String, Object> nativeObj = new HashedMap();
		Enumeration<String> attrName = req.getAttributeNames();
		while (attrName.hasMoreElements()) {
			String name = (String) attrName.nextElement();
			Object value = req.getAttribute(name);
			nativeObj.put(name, value);
		}
		//marshalling + serialization
		ObjectMapper mapper = new ObjectMapper();
		try(
			PrintWriter out = resp.getWriter();
		){
			mapper.writeValue(out, nativeObj);
		}
	}
}
