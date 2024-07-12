package com.lec.spring.di05;

import com.lec.spring.beans.MessageBean;
import com.lec.spring.beans.Score;
import com.lec.spring.beans.Student;
import com.lec.spring.di01.MessageEng;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config05 {
    public Config05() {
        System.out.println("Config05() 생성");
    }

    @Bean
    public Score scoreA() {return new Score(77, 55, 89, "괜찮니?");}

    @Bean(name="사천왕")
    public Student stu1(){
        return new Student("조심해영", 19, scoreA());
    }

    @Bean
    public Student stu2(){
        return new Student("홍길동", 25, scoreA());
    }

    @Bean
    public MessageBean msg1() {return new MessageEng();}

}























