package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {

    //findBy*** ==> select m from Member m where m.name=?
    //메소드 이름만으로 기능 제공. findBy***And*** 등도 있음.
    @Override
    Optional<Member> findByName(String name);
}
