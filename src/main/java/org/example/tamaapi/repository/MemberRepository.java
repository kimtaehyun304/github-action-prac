package org.example.tamaapi.repository;

import org.example.tamaapi.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    @Query("select m from Member m join fetch m.addresses where m.id = :memberId")
    Optional<Member> findWithAddressesById(Long memberId);

}
