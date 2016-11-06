package cdi;

import cdi.event.MessageReciver;
import cdi.event.MessageSender;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cdi-event", urlPatterns = {"/cdi-event"})
public class EventServlet extends HttpServlet {

    @Inject
    MessageSender messageSender;

    @Inject
    MessageReciver messageReciver;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String message = "##### This is CDI Event Sender-Observer Test and must be logged in error log. #####";
            messageSender.sendMessage(message);
            out.print("The following Message was send by CDI Event Sender: <br><br><i>" + message + "</i><br><br> The Reciver has published it in error log. Please look at your log file to ensure the message has published.");
        }
        
    }

}
