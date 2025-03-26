package hello.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepositoryTwo;
import hello.hellospring.service.MemberServiceTwo;
import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {


    private EntityManager em;

    @Bean
    public MemberServiceTwo memberServiceTwo() {
        return new MemberServiceTwo(memberRepository());
    }

    // @Bean
    // public MemberRepository memberRepository() {
    //     return new MemoryMemberRepositoryTwo();
    // }

    @Bean
    public MemberRepository memberRepository() {
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
