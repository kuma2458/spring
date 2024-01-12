package ex.spring.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DITestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =new AnnotationConfigApplicationContext(
				AppContext.class);
				
		Greeting g = ctx.getBean("greeter",Greeting.class);
		System.out.println(g.getId()+" "+g.getContent());
		System.out.println(System.identityHashCode(g));
		
		g = ctx.getBean("greeter",Greeting.class);
		System.out.println(System.identityHashCode(g));
		
		MemberDTO m = (MemberDTO)ctx.getBean("memberdto");		
		System.out.println(System.identityHashCode(m));
		
		MemberDTO e = ctx.getBean("memberdto",MemberDTO.class);
		System.out.println(System.identityHashCode(e));
		
	}

}
