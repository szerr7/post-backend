package edu.miu.postbackend.aspect.anotation;

import edu.miu.postbackend.domain.ExceptionEntity;
import edu.miu.postbackend.repo.ExceptionRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionExecutionImpl {
    @Aspect
    @Component
    public class ExceptionExecutionAspect {


        @Autowired
        private final ExceptionRepository exceptionRepository;

        public ExceptionExecutionAspect(ExceptionRepository exceptionRepository) {
            this.exceptionRepository = exceptionRepository;
        }

        @Pointcut("@annotation(edu.miu.postbackend.aspect.anotation.ExceptionExecution)")
        public void exceptionExecutionAnnotation() {
        }

        @AfterThrowing(value = "exceptionExecutionAnnotation()", throwing = "exception")
        public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
            System.out.println("Log after throwing the method: " + joinPoint.getSignature().getName());

            String principle = "user principle";
            String operation = joinPoint.getSignature().getName();
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            ExceptionEntity exceptionEntity = new ExceptionEntity();
            exceptionEntity.setDate(date);
            exceptionEntity.setTime(time);
            exceptionEntity.setPrinciple(principle);
            exceptionEntity.setOperation(operation);
            exceptionEntity.setExceptionType(exception.getClass().getName());

            exceptionRepository.save(exceptionEntity);
        }
    }

}