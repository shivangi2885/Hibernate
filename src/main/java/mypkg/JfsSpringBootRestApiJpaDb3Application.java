//Dispatcher Servlet has the function to pass on the user service to the controller
//request -> dispatcher servlet -> controller -> service -> repository -> database

package mypkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JfsSpringBootRestApiJpaDb3Application {

	public static void main(String[] args) {
		SpringApplication.run(JfsSpringBootRestApiJpaDb3Application.class, args);
	}

}
