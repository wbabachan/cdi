package cdi;

import cdi.qualifier.TranslationService;
import cdi.stereotype.Business;
import cdi.stereotype.Translator;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cdi-stereotype", urlPatterns = {"/cdi-stereotype"})
public class StereotypeServlet extends HttpServlet {
    
    @Inject
    @Business
    @Translator
    TranslationService translationService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String stereotypeHello = translationService.translateHello();
            out.println("Stereotype: " + stereotypeHello + "<br><br>");
        }
        
    }
    
    
}
