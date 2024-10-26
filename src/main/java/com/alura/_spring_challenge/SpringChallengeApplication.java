package com.alura._spring_challenge;
import com.alura._spring_challenge.main.Principal;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class SpringChallengeApplication {

	public static void main(String[] args) throws IOException, InterruptedException {

		Principal principal = new Principal();
		System.out.println(principal.principalLogic());
	}

}
