import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.when;
/*
public class TestServlet {
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGet() throws IOException, ServletException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);
        when(request.getServletPath()).thenReturn("/patients");
        MyServlet s = new MyServlet();
        s.doGet(request,response);
        String output=stringWriter.getBuffer().toString();
        Assert.assertEquals(output,"Hello World");
    }

}*/
