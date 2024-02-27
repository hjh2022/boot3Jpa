package com.example.boot3jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot3JpaApplication {

	/**
	 * 모든 프로젝트에는 메인클래스가 있어야 한다. 아래와 같이 main() 를 코딩하면 이 클래스가 메인 클래스가 된다.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Boot3JpaApplication.class, args);
	}

}
