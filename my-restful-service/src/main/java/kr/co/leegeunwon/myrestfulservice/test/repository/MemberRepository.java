package kr.co.leegeunwon.myrestfulservice.test.repository;

import kr.co.leegeunwon.myrestfulservice.test.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
