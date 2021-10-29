package ru.filippov.app.logic;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface userRepository extends Repository<MortgageApplication, String> {

    Optional<MortgageApplication> findById(String id);

    MortgageApplication save(MortgageApplication userEntity);

    MortgageApplication findByFirstNameAndSecondNameAndLastNameAndPassport(String firstName, String secondName,
                                                                           String lastName, String passport);
}
