package hello.hellospring.repository;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //각 메서드가 끝날때마다 동작
    //아래 예제에서는 테스트가 끝날때마다 데이터 지워주는 용도
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result);
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
 public void findByName() {
    //given
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);
    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);
    //when
    Member result = repository.findByName("spring1").get();
    //then
     assertThat(result).isEqualTo(member1);
 }
 @Test
 public void findAll() {
    //given
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);
    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);
    //when
    List<Member> result = repository.findAll();
    //then
     assertThat(result.size()).isEqualTo(2);
 }
}
