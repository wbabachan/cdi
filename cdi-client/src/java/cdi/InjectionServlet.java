package cdi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdi.inject.car.CarService;
import cdi.inject.person.Customer;
import cdi.inject.person.PersonService;
import cdi.inject.person.User;

@WebServlet(name = "cdi-injection", urlPatterns = {"/cdi-injection"})
public class InjectionServlet extends HttpServlet {
    
    @Inject
    CarService autoService;
    
    @Inject
    PersonService<User> userPersonService;
    
    @Inject
    PersonService<Customer> customerPersonService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String status = autoService.getServiceStatus();
            out.println("Your Car Status: " + status + "<br><br>");
    
            User user  = new User();
            String userStatus = userPersonService.getPersonStatus(user);
            out.println("User Status: " + userStatus + "<br><br>");
            
            Customer customer = new Customer();
            String customerStatus = customerPersonService.getPersonStatus(customer);
            out.println("Customer Status: " + customerStatus + "<br><br>");
        }
        
    }
    
    
}
