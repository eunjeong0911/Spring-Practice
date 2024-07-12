package com.lec.spring.di02;

import com.lec.spring.beans.MessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DIMain02 implements CommandLineRunner {
                                //애플리케이션 실행 후 run메소드 호출

    public MessageBean msg;

    @Autowired  // 자동주입 (field injection) 어노테이션은 스프링컨테이너가 해당필드를 자동으로 주입하도록 지시
    ApplicationContext ctx;  // 스프링 컨테이너, 컨텍스트, IoC 컨테이너, Bean Factory 등 지칭하는 용어 다양
    //ctx 필드에 ApplicationContext 객체가 주입

    @Autowired  // 자동주입 (setter injection) - 스프링이 해당 메서드를 호출하여 의존성을 주입
    public void setMsg(MessageBean msg) { //MessageBean 타입의 객체가 주입된다.
        System.out.println("setMsg() 호출");
        this.msg = msg;
    }

    public DIMain02(){
        System.out.println(getClass().getName() + "() 생성");
    }

    public static void main(String[] args) {
        System.out.println("Main() 시작");
        SpringApplication.run(DIMain02.class, args);
        System.out.println("Main() 종료");
    }

    // 컨테이너 생성후 실행
    @Override
    public void run(String... args) throws Exception {
        System.out.println("run() 실행");
        msg.sayHello();

        System.out.println("생성된 빈의 개수: " + ctx.getBeanDefinitionCount());

        // 모든 bean 에는 name(id) 이 부여된다.
        for(var name : ctx.getBeanDefinitionNames()){
            System.out.println(name + " : " + ctx.getBean(name));
        }

    }
}













