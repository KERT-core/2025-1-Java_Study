package com.javachip.study.service;

import com.javachip.study.domain.PostEntity;
import com.javachip.study.domain.UserEntity;
import com.javachip.study.dto.PostDto;
import com.javachip.study.exception.PostNotFoundException;
import com.javachip.study.exception.UserNotFoundException;
import com.javachip.study.mapper.PostMapper;
import com.javachip.study.repository.PostRepository;
import com.javachip.study.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private final PostMapper mapper;

    public PostServiceImpl(
            PostRepository postRepo,
            UserRepository userRepo,
            PostMapper mapper
    ) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public PostDto create(PostDto dto) {
        // 1) 사용자 조회 (Optional.ofNullable → orElseThrow)
        UserEntity user = Optional.ofNullable(userRepo.findById(dto.userId()))
                .orElseThrow(() -> new UserNotFoundException(dto.userId()));

        // 2) 엔티티 변환 & 저장
        PostEntity saved = postRepo.save(mapper.toEntity(dto, user));

        // 3) DTO 변환 후 반환
        return mapper.toDto(saved);
    }

    @Override
    public List<PostDto> getAll(String search) {
        List<PostEntity> entities = (search != null && !search.isBlank())
                ? postRepo.findByTitleContainingOrTagContaining(search, search)
                : postRepo.findAll();

        return entities.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getById(Long id) {
        PostEntity entity = postRepo.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        return mapper.toDto(entity);
    }

    @Override
    public PostDto update(Long id, PostDto dto) {
        // 1) 기존 엔티티 조회
        PostEntity old = postRepo.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        // 2) 수정된 새 객체 생성 (불변 스타일 유지)
        PostEntity updated = new PostEntity(
                id,
                dto.title(),
                dto.tag(),
                dto.description(),
                dto.content(),
                old.getUser(),
                old.getCreatedAt(),
                LocalDateTime.now()
        );

        // 3) 저장 및 DTO 반환
        PostEntity saved = postRepo.save(updated);
        return mapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        // 존재 확인 후 삭제
        if (postRepo.findById(id).isEmpty()) {
            throw new PostNotFoundException(id);
        }
        postRepo.deleteById(id);
    }
}
