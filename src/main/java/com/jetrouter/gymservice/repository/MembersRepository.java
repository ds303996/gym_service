package com.jetrouter.gymservice.repository;

import com.jetrouter.gymservice.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MembersRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByName(String principalName);
}
