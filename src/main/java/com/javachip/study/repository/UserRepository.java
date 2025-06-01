package com.javachip.study.repository;

import com.javachip.study.domain.UserEntity;
import java.util.List;

//User 테이블 repository를 위한 인터페이스
//구현체는 지금 InMemory버전만 존재하지만, 필요에 따라서 DB버전의 구현체도 만들수있음(해야할 일임)
//구현체를 갈아끼울때는 AppConfig를 이용

public interface UserRepository {
    void saveAll(List<UserEntity> userEntities);
    UserEntity findById(String id);
    String findNameById(String id);
    List<UserEntity> findAll();
}
