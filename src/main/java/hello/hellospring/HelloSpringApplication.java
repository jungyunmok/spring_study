package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*기본적으로 SpringBootApplication이 있는 패키지와 하위 패키지만
* 스프링이 컴포넌트를 스캔해서 등록을 함 -> 다른 패키지에 넣으면 등록되지 않음
* 스프링은 컨테이너에 빈을 등록할 때 싱글톤으로 등록함 - 하나만 등록해서 공유한다 */
@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}