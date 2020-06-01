package util;

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
}
