package com.javachip.study.service;

import com.javachip.study.domain.CommentEntity;
import com.javachip.study.domain.PostEntity;
import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.CommentDto;
import com.javachip.study.exception.CommentNotFoundException;
import com.javachip.study.exception.PostNotFoundException;
import com.javachip.study.exception.UserNotFoundException;
import com.javachip.study.mapper.CommentMapper;
import com.javachip.study.repository.CommentRepository;
import com.javachip.study.repository.PostRepository;
import com.javachip.study.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepo;
    private final UserRepository userRepo;
    private final PostRepository postRepo;
    private final CommentMapper mapper;
    public CommentServiceImpl(
        CommentRepository commentRepo,
        UserRepository userRepo,
        PostRepository postRepo,
        CommentMapper mapper
    ) {
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.mapper = mapper;
    }
    @Override
    public CommentDto create(CommentDto dto){
        UserEntity user = Optional.ofNullable(userRepo.findByStudentId(dto.userId()))
                .orElseThrow(() -> new UserNotFoundException(dto.userId()));

        PostEntity post = postRepo.findById(dto.postId())
                .orElseThrow(() -> new PostNotFoundException(dto.postId()));
        CommentEntity parent = dto.parentId() != null ?
                commentRepo.findById(dto.parentId()).orElse(null) : null;

        CommentEntity saved = commentRepo.save(mapper.toEntity(dto, post, parent, user));
        return mapper.toDto(saved);
    }

    @Override
    public List<CommentDto> getAll() {
        List<CommentEntity> commentEntities = commentRepo.findAll();
        return commentEntities.stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public CommentDto getById(Long id) {
        CommentEntity commentEntity = commentRepo.findById(id).orElseThrow(() -> new CommentNotFoundException(id));
        return mapper.toDto(commentEntity);
    }

    @Override
    public void delete(Long id) {
        if (commentRepo.findById(id).isPresent()) {
            commentRepo.deleteById(id);
        }else{
            throw new CommentNotFoundException(id);
        }
    }
}
