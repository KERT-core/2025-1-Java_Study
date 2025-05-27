package com.javachip.study.config;

import com.javachip.study.controller.CommentController;
import com.javachip.study.controller.UserController;
import com.javachip.study.controller.PostController;
import com.javachip.study.mapper.*;
import com.javachip.study.repository.*;
import com.javachip.study.service.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public PostRepository postRepository() {
        return new InMemoryPostRepository();
    }

    @Bean
    public PostMapper postMapper() {
        return new PostMapperImpl();
    }

    @Bean
    public PostService postService(
            PostRepository postRepository,
            UserRepository userRepository,
            PostMapper postMapper
    ) {
        return new PostServiceImpl(postRepository, userRepository, postMapper);
    }

    @Bean
    public PostController postController(PostService postService) {
        return new PostController(postService);
    }

    @Bean
    public CommentMapper commentMapper() {
        return new CommentMapperImpl();
    }

    @Bean
    public CommentRepository commentRepository() {
        return new InMemoryCommentRepository();
    }

    @Bean
    public CommentService commentService() {
        return new CommentServiceImpl(
                commentRepository(),
                userRepository(),
                postRepository(),
                commentMapper()
        );
    }

    @Bean
    public CommentController commentController() {
        return new CommentController(commentService());
    }
}
