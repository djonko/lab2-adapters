package sprint.aop.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sprint.aop.javabrains.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring_aspectj.xml");
		ShapeService shapeService=ctx.getBean("shapeService",ShapeService.class);
		
		System.out.println(shapeService.getCircle().getName());
		//shapeService.getCircle().setName3("@@@circle");
		
		//System.out.println(shapeService.getCircle().getName());
	}
}
