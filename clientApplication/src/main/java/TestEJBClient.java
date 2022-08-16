import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;
import msg.ejb.MessageEJB;
public class TestEJBClient {

    public static void main(String[] args) throws NamingException {

        Properties properties =new Properties();

        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");

        properties.setProperty(Context.PROVIDER_URL, "http://127.0.0.1:8080");

        properties.put(Context.SECURITY_PRINCIPAL, "admin");

        properties.put(Context.SECURITY_CREDENTIALS, "password");

        InitialContext context = new InitialContext(properties);

        //MessageEJB msg = (MessageEJB) context.lookup("java:msg/ejb/MessageEJB.java");

        MessageEJB msg = (MessageEJB) context.lookup("java:module/MessageEJB");

        msg.getMessage("EJB Bean");

    }
}
