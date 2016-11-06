package cdi.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@Loggable
@Priority(Interceptor.Priority.APPLICATION)
public class LogInterceptor {

    @AroundInvoke
    public Object log(InvocationContext invocationContext) throws Exception {
        System.err.println("#### Entering method: " + invocationContext.getMethod().getName() + " in class: " + invocationContext.getMethod().getDeclaringClass().getName());
        return invocationContext.proceed();
    }

}
