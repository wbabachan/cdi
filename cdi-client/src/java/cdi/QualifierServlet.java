package cdi;

import static cdi.qualifier.Language.Languages.FRENCH;
import static cdi.qualifier.Language.Languages.GERMAN;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
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
import cdi.qualifier.Language;
import cdi.qualifier.TranslationService;

@WebServlet(name = "cdi-qualifier", urlPatterns = {"/cdi-qualifier"})
public class QualifierServlet extends HttpServlet {
    
    @Inject
    @French
    TranslationService frenchTranslationService;
    
    @Inject
    @German
    TranslationService germanTranslationService;
    
    @Inject
    @Language(FRENCH)
    TranslationService frenchLanguageTranslationService;
    
    @Inject
    @Language(GERMAN)
    TranslationService germanLanguageTranslationService;

    @Inject
    @Any
    Instance<TranslationService> translationServiceInstance;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            String frenchHello = frenchTranslationService.translateHello();
            out.println("French: " + frenchHello + "<br><br>");
    
            String germanHello = germanTranslationService.translateHello();
            out.println("German: " + germanHello + "<br><br>");
    
            String frenchLanguageHello = frenchLanguageTranslationService.translateHello();
            out.println("French Language: " + frenchLanguageHello + "<br><br>");
    
            String germanLanguageHello = germanLanguageTranslationService.translateHello();
            out.println("German Language: " + germanLanguageHello + "<br><br>");

            String translatedFrench = translationServiceInstance.select(
                new AnnotationLiteral<French>() {
                }
            ).get().translateHello();
            out.println("French Language (Qualifier Any): " + translatedFrench + "<br><br>");

            Iterator<TranslationService> iterator = translationServiceInstance.iterator();
            while(iterator.hasNext()) {
                TranslationService next = iterator.next();
                out.println("Translations: " + next.translateHello() + "<br>");
            }

        }
        
    }
    
    
}
