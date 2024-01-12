package ex.spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean
	public Greeting greeter() {
		Greeting g= new Greeting(1,"test");
		return g;
	}
	
	@Bean
	public MemberDTO memberdto() {
		MemberDTO m = new MemberDTO("aa4444", "123456", "김철수", 20, "M", 4);
		return m;
	}
}
