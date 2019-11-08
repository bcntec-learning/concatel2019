package concatel.curso2019.demo.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AspectosSimple1 implements BeanNameAware {


    //definicion de donde
    @Pointcut("execution(public * concatel.curso2019.demo.Controladores+.find*(..))")
    public void pointcut() {
        //nada
    }


    @Before("pointcut()")
    public void traceBefore(JoinPoint point) {
        System.err.println("Before :" + point.getSignature().getName() + ", " + point.getArgs()[0]);
    }


    @After("pointcut()")
    public void trace(JoinPoint point) {
        System.err.println("After :" + point.getSignature().getName() + ", " + point.getArgs()[0]);
    }
    @AfterReturning("pointcut()")
    public void afterRetrun(JoinPoint point) {

        System.err.println("AfterReturning :" + point.getSignature().getName() + ", " + point.getArgs()[0]);
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint point) {

        Object o = null;
        try {
            
            o = point.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        System.err.println(o);


    }

    @AfterThrowing(value = "@annotation(concatel.curso2019.demo.aspectj.Auditar)", throwing = "e")
    public void e(Exception e){
        System.err.println(e.getMessage());

    }


    @Override
    public void setBeanName(String s) {
        System.err.println("Weeeee "+s);
    }
}