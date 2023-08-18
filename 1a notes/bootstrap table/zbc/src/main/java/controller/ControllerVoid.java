package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.Row;
import vo.ClassA;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/Void")
public class ControllerVoid {

	@RequestMapping(value = "/some.do")
	@ResponseBody
	public ClassA dosome() {

		Row r1 = new Row(1, "1a");
		Row r2 = new Row(2, "2a");
		Row r3 = new Row(3, "1c");

		Row[] a = new Row[] { r1, r2, r3 };

		ClassA c1 = new ClassA();
		c1.sum1 = 3;
		c1.rows = a;
		return c1;
	}

	@RequestMapping(value = "/some2.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String dosome2() {
		return "SpingMVC返回字符串！！！！";
	}

}
