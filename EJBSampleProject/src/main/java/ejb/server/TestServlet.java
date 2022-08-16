package ejb.server;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet {

    @EJB
    TestStatelessEjb testStatelessEjb;

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        testStatelessEjb.sayHello("World ");
    }

}
