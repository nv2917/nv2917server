import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/patients",}, loadOnStartup = 1)
public class MyServlet extends HttpServlet {

    String patients = "/patients";
    String doctors = "/doctors";
    Pat_DB db;

    public MyServlet() throws SQLException {
        db = new Pat_DB();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("Hello patients");
        db.insertPatient("Smith","Jackie boy","0789");
        response.getWriter().write(db.getPatient(2));

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        resp.setContentType("application/json");
        resp.getWriter().write("Thank you client! "+reqBody);
    }
}