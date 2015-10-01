package sprint.aop.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
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
	@Before("args(name)")
	public void allMethodStringArg(String name){
		System.out.println("A method with String arguments has called ="+name);
	}
	
	/**
	 * within is specify a particular class to execute all methods.
	 * it can be in specify package ex=sprint.aop.*.model..
	 */
	@Pointcut("within(sprint.aop.javabrains.model.Circle)")
	public void allMethodsInCircle(){
		System.out.println("Advice run. all methode in Circle");
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
