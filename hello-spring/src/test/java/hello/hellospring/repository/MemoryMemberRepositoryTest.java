package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //하나의 테스트가 끝날 때마다 아래 코드를 실행
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result=repository.findById(member.getId()).get();
        Assertions.assertEquals(member,result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertEquals(member1,result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member2);
        List<Member> expected = List.of(Arrays.array(member1, member2));
        List<Member> result = repository.findAll();

        Assertions.assertEquals(expected,result);
    }
}
