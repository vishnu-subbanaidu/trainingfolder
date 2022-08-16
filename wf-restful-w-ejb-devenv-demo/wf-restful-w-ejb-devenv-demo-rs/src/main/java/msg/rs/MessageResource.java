package msg.rs;

import msg.ejb.MessageEJB;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class MessageResource {

    @EJB
    private MessageEJB messageEJB;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(@QueryParam("name") String name) {
        return messageEJB.getMessage(name);
    }

}
