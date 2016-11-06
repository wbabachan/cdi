package cdi;

import cdi.interceptor.Payment;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cdi-interceptor", urlPatterns = {"/cdi-interceptor"})
public class InterceptorServlet extends HttpServlet {
    
    @Inject
    Payment payment;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String result = payment.pay();
            out.println("Payment ist intercepted and logged in server error log after displaying the result of payment: " + result + "<br><br>");
        }
        
    }
}
