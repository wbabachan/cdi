package cdi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.inject.Instance;
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
import cdi.qualifier.French;
import cdi.qualifier.German;
import cdi.qualifier.TranslationService;

@WebServlet(name = "cdi-lazy-injection", urlPatterns = {"/cdi-lazy-injection"})
public class LazyInjectionServlet extends HttpServlet {
    
    @Inject
    Instance<CarService> carService;
    
    @Inject
    @French
    Instance<TranslationService> frenchTranslationService;
    
    @Inject
    @German
    Instance<TranslationService> germanTranslationService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String status = carService.get().getServiceStatus();
            out.println("Your Car Status: " + status + "<br><br>");
    
            String frenchHello = frenchTranslationService.get().translateHello();
            out.println("French: " + frenchHello + "<br><br>");
    
            String germanHello = germanTranslationService.get().translateHello();
            out.println("German: " + germanHello + "<br><br>");
        }
        
    }
    
    
}
