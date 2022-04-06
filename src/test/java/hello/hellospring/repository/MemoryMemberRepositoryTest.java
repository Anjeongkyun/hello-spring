package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    // 테스트는 순서를 보장하지 않기 때문에
    // 항상 새로운 테스트를 시작 시 클리어를 해줘야한다.
    // 순서를 생각해서 테스트 코드를 짜면 큰 오산이다!

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 어느 동작이 끝날 때마다 타는 애노테이션
    // 여기서 클리어 처리를 해주면 됨.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(result, member);
        System.out.println("repository.findById(member.getId()) = " + repository.findById(member.getId()));
        System.out.println("member.getId() = " + member.getId());
        System.out.println("result = " + (result == member));

        assertThat(member).isEqualTo(result);

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

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
