import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/patients","/doctors"},loadOnStartup = 1)
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path=="/patients"){
            response.setContentType("text/html");
            response.getWriter().print("These are the patients");
        }
        else if (path=="/doctors"){
            response.setContentType("text/html");
            response.getWriter().print("These are the doctors");
        }
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        resp.setContentType("application/json");
        resp.getWriter().write("Thank you client! "+reqBody);
    }



}