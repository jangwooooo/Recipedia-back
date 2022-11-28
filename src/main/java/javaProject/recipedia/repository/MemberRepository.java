package javaProject.recipedia.repository;

import javaProject.recipedia.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberByUserIdAndUserPassword(String userId, String userPassword);
}
