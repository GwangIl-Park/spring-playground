package hello.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepositoryTwo;
import hello.hellospring.service.MemberServiceTwo;

@Configuration
public class SpringConfig {

    @Bean
    public MemberServiceTwo memberServiceTwo() {
        return new MemberServiceTwo(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepositoryTwo();
    }
}
