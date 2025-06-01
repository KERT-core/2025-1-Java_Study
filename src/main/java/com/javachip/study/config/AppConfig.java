package com.javachip.study.config;

import com.javachip.study.controller.*;
import com.javachip.study.mapper.*;
import com.javachip.study.repository.*;
import com.javachip.study.service.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//의존성 주입 (생성자 주입)
//객체의 생명주기를 스프링이 관리할 수 있도록 등록(Bean으로 관리)

@Configuration
public class AppConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // or "/api/**"
                        .allowedOrigins("http://localhost:5173") // Vite 기본 포트
                        .allowedMethods("*");
            }
        };
    }

    //controller
    @Bean
    public UserController userController() {
        return new UserController(userService());
    }

    @Bean
    public LectureController lectureController() { return new LectureController(lectureService()); }

    @Bean
    public HistoryController historyController() { return new HistoryController(historyService()); }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository(), userMapper());
    }

    @Bean
    public LectureService lectureService() { return new LectureServiceImpl(userRepository(), lectureRepository(), lectureMapper(), participantRepository()); }

    @Bean
    public HistoryService historyService() { return new HistoryServiceImpl(participantRepository()); }

    @Bean
    public UserRepository userRepository() { return new InMemoryUserRepository(); }

    @Bean
    public LectureRepository lectureRepository() { return new InMemoryLectureRepository(); }

    @Bean
    public ParticipantRepository participantRepository() { return new InMemoryParticipantRepository(); }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public LectureMapper lectureMapper() { return new LectureMapperImpl(); }
}
