package sprint.aop.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * this is an Aspect
 * @author linux_user
 *
 */
@Aspect
public class LoggingAspect {

	
	
	/**
	 * this is an Advice Method 
	 * this method has to run before execution of "public String getName()"
	 */
	@Before("allMethodsInCircle()")//specifier the wildcard
	//(..) specifier it can be o or more argument
	// JoinPoint is all the place in your code witch you can applied an advice
	public void LoggingAdvice(JoinPoint joinPoint){
		
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters(){
		
	}
	
	// all methods take string arguments
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void allMethodStringArg(String name,Exception ex){
		System.out.println("A method with String arguments has called ="+name);
		System.out.println("Exception was  ="+ex);
	}
	
	
	@AfterReturning(pointcut="args(name)",returning="returnStrigValue")
	public void allMethodStringArg2(String name,String returnStrigValue){
		System.out.println("A method with String arguments has called and the return ="+returnStrigValue);
	}
	
	/**
	 * within is specify a particular class to execute all methods.
	 * it can be in specify package ex=sprint.aop.*.model..
	 */
	@Pointcut("within(sprint.aop.javabrains.model.Circle)")
	public void allMethodsInCircle(){
		System.out.println("Advice run. all methode in Circle");
	}
	
	@Around("@annotation(sprint.aop.javabrains.aspect.Loggable)")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		Object ob=null;
		System.out.println("start around methode "+proceedingJoinPoint.toString());
		
		try {
			 ob=proceedingJoinPoint.proceed();
			 System.out.println("end around methode "+proceedingJoinPoint.toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("after throwing around methode "+proceedingJoinPoint.toString());
		}
		return ob;
	}
/*	@Before("allGetters()")
	public void LoggingAdvice2(){
		System.out.println("Advice run. Get Method called 2");
	}
	
	
	
	
	@Pointcut("execution(* sprint.aop.javabrains.model.Circle.*(..))")
	public void allCircleMethods(){
		
	}
*/
	
	

	
} 
