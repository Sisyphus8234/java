package xxxpackage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

public class ControllerA extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------------doGet方法");

        resp.setHeader("Content-type", "text/html");
        resp.setCharacterEncoding("UTF-8");

        //请求行
        resp.getWriter().print("请求行"+"<br>"+req.getMethod()+" "+req.getRequestURI()+" "+req.getProtocol()+"<br>");



        //请求头
        String String_headers = "";
        Enumeration<String> e = req.getHeaderNames();
        while (e.hasMoreElements()) {
            String s = (String) e.nextElement();
            String_headers+=s;
            String_headers+=" ";
            String_headers+=req.getHeader(s);
            String_headers+="<br>";
        }
        resp.getWriter().print("<br>"+"请求头"+"<br>"+String_headers+"<br>");

        //请求体
        String String_Parameters = "";
        Enumeration<String> e2 = req.getParameterNames();
        while (e2.hasMoreElements()) {
            String s2 = (String) e2.nextElement();

            String[] aaa=req.getParameterValues(s2);
            for(String a:aaa){
                String_Parameters+=s2;
                String_Parameters+=" ";
                String_Parameters+=a;
                String_Parameters+="<br>";
            }
        }
        resp.getWriter().print("请求体"+"<br>"+String_Parameters);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法");
    }
}
