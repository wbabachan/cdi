package cdi;

import cdi.decorator.TicketService;
import cdi.inject.car.CarService;
import cdi.inject.person.Customer;
import cdi.inject.person.PersonService;
import cdi.inject.person.User;
import cdi.qualifier.TranslationService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cdi-decorator", urlPatterns = {"/cdi-decorator"})
public class DecoratorServlet extends HttpServlet {
    
    @Inject
    TicketService ticketService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String status = ticketService.orderTicket();
            out.println("Your Ticket Service: " + status + "<br><br>");

        }
        
    }
    
    
}
