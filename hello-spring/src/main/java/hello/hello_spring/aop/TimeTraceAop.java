package hello.hello_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class TimeTraceAop {

    /*
    AOP: Aspect Oriented Programming
    공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern) 분리
     */
    @Around("execution(* hello.hello_spring..*(..)) && !target(hello.hello_spring.SpringConfig)")
//    @Around("execution(* hello.hello_spring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs +
                    "ms");
        }

    }
}
