package cdi;

import cdi.qualifier.TranslationService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cdi-producer", urlPatterns = {"/cdi-producer"})
public class ProducerServlet extends HttpServlet {
    
    @Inject
    TranslationService translationService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String hello = translationService.translateHello();
            out.println("Transaltion Service: " + hello + "<br><br>");
        }
        
    }
    
    
}
