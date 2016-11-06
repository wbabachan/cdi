package cdi.event;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class MessageSender {

    @Inject
    Event<Message> event;

    public void sendMessage(String text) {
        Message message = new Message();
        message.setText(text);
        event.fire(message);
    }

}
