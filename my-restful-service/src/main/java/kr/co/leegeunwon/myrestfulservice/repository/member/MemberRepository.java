package kr.co.leegeunwon.myrestfulservice.repository.member;

import kr.co.leegeunwon.myrestfulservice.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
