package util;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，抽取了一些与日志相关的方法。
 */
public class Logger {
    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）。
     */
    public void beforePrintLog() {
        System.out.println("Logger类中的printLog()方法开始记录日志了...前置通知");
    }

    /**
     * 用于打印日志，计划让其在切入点方法执行之后执行（切入点方法就是业务层方法）。
     */
    public void afterPrintLog() {
        System.out.println("Logger类中的printLog()方法开始记录日志了...后置通知");
    }

    /**
     * 用于打印日志，计划让其在切入点方法catch中执行（切入点方法就是业务层方法）。
     */
    public void throwPrintLog() {
        System.out.println("Logger类中的printLog()方法开始记录日志了...异常通知");
    }

    /**
     * 用于打印日志，计划让其在切入点方法final里执行（切入点方法就是业务层方法）。
     */
    public void finalPrintLog() {
        System.out.println("Logger类中的printLog()方法开始记录日志了...最终通知");
    }

    /**
     * 用于打印日志，计划让其在切入点环绕执行（切入点方法就是业务层方法）。
     */
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint) {
        /*问题：
            当我们配置了环绕通知后，切入点方法没有执行，而通知方法执行了
          分析：
            通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，
            而我们的代码中没有
          解决：
            Spring框架为我们提供了一个接口：ProceedingJoinpoint。该接口会有一个方法 proceed() ，此方法就相当于明确调用切入点方法
            该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用
            spring中的环绕通知他是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式*/

        Object returnVal;
        try {
            // 得到方法执行所需的参数
            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了...前置通知");
            // 明确调用业务层方法（切入点方法）
            returnVal = proceedingJoinPoint.proceed(args);
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了...后置通知");
            return returnVal;
        } catch (Throwable throwable) {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了...异常通知");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了...最终通知");
        }
    }
}
