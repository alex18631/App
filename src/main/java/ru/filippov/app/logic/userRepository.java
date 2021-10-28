package ru.filippov.app.logic;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface userRepository  extends Repository<userEntity,String> {

    Optional<userEntity> findById(String id);

    userEntity save (userEntity userEntity);
}
