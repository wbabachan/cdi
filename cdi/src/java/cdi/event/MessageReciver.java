package cdi.event;

import javax.enterprise.event.Observes;

public class MessageReciver {

    public void reciveText(@Observes Message message) {
        System.err.println(message.getText());
    }

}
