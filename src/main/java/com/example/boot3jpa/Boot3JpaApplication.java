package com.example.boot3jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트 사용에 필요한 기본 설정을 해준다.
public class Boot3JpaApplication {

	/**
	 * 모든 프로젝트에는 메인클래스가 있어야 한다. 아래와 같이 main() 를 코딩하면 이 클래스가 메인 클래스가 된다.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Boot3JpaApplication.class, args);
		// run() 메소드는 어플리케이션을 실행 시켜준다. 1번 인수는 어플리케이션의 메인클래스로 사용할 클래스
		// 두번째 인수는 커맨드 라인의 인수들을 전달한다.
	}

}
