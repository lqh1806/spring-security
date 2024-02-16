package com.colossal.springsecurity.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    @Query(value = """
            select t.* from Token as t inner join User u on u.id = t.user_id
            where u.id = :id and (t.expired = false or t.revoked = false)
            """,
            nativeQuery = true)
    List<Token> findAllValidTokensByUser(Integer id);

    Optional<Token> findByToken (String token);
}
