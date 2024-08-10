package kr.co.leegeunwon.myrestfulservice.repository;

import kr.co.leegeunwon.myrestfulservice.bean.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
