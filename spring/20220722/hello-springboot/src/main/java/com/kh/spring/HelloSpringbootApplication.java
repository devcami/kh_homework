package com.kh.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *  @Configuration : bean 설정 관련
 *  @EnableAutoConfiguration : 자동 context 구성
 *  @ComponentScan : 현재 패키지 하위의 @Component를 bean으로 등록
 */
@SpringBootApplication
public class HelloSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringbootApplication.class, args);
	}

}
