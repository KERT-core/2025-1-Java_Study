package com.javachip.study.config;

import com.javachip.study.controller.UserController;
import com.javachip.study.mapper.*;
import com.javachip.study.repository.*;
import com.javachip.study.service.*;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javachip.study.mapper.BoardMapper;
import com.javachip.study.mapper.BoardMapperImpl;
import com.javachip.study.repository.BoardRepository;
import com.javachip.study.repository.InMemoryBoardRepository;
import com.javachip.study.service.BoardService;

//의존성 주입 (생성자 주입)
//객체의 생명주기를 스프링이 관리할 수 있도록 등록(Bean으로 관리)

@Configuration
public class AppConfig {

    @Bean
    public UserController userController() {
        return new UserController(userService());
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository(), userMapper());
    }

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public BoardRepository boardRepository() {
        return new InMemoryBoardRepository();
    }

    @Bean
    public BoardMapper boardMapper() {
        return new BoardMapperImpl();
    }

    @Bean
    public BoardService boardService(@Qualifier("boardRepository") BoardRepository repo, @Qualifier("boardMapper")BoardMapper mapper) {
        return new BoardService(repo, mapper);
    }
}
