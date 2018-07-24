package com.education.intercept;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <dl>
 * <dt> WebLogAspect</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate:2018/7/16</dd>
 * </dl>
 *
 * @author lizhu
 */
@Aspect
@Component
public class WebLogAspect {
    Logger logger  = Logger.getLogger(WebLogAspect.class);
    @Pointcut("execution(public * com.education.controller..*.*(..))")
    public void webLog(){
    }

    @Around("webLog()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        long start = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        StringBuilder sb = new StringBuilder();
        sb.append("调用URL:[" + request.getRequestURL().toString() + "]," +
                "调用方法为:[" +proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." + proceedingJoinPoint.getSignature().getName() + "],args=[");
        for (Object o : proceedingJoinPoint.getArgs()) {
            if (o == null || o instanceof HttpServletRequest || o instanceof HttpServletResponse) {
                continue;
            }
            sb.append(o.toString() + ",");
        }
        sb.append("]");
        logger.info(sb.toString());
        Object obj = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("调用时间：[" + (end - start) + "].");
        return obj;
    }
}
