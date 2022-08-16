package msg.ejb;

import javax.ejb.Stateless;
import java.util.Random;

@Stateless
public class MessageEJB {

    private final String[] messages={"Hey", "Hi", "Hello"};

    public String getMessage(String name){
        return String.format("%s %s", messages[new Random().nextInt(3)], name);
    }
}
