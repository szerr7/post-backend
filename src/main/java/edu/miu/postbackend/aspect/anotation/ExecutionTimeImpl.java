package edu.miu.postbackend.aspect.anotation;

import edu.miu.postbackend.domain.Logger;
import edu.miu.postbackend.repo.LoggerRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExecutionTimeImpl {
    @Autowired
    LoggerRepository loggerRepository;

    @Pointcut("@annotation(edu.miu.postbackend.aspect.anotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }
    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        String principle = "user principle";
        String operation = proceedingJoinPoint.getSignature().getName();

        LocalDate date = LocalDate.now();
        LocalTime time =LocalTime.now();

        System.out.println(time);
        Logger logger = new Logger(date,time,operation);
        logger.setPrinciple(principle);
        loggerRepository.save(logger);
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + (finish - start));
        return result;
    }

}