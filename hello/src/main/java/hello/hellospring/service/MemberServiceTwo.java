package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepositoryTwo;

public class MemberServiceTwo {

    //지금은 바로 생성하기 때문에 new로 선언했을때 다른 memberRepository를 볼 수밖에 없음
    private final MemberRepository memberRepository;

    //private final MemberRepository memberRepository;
    //이렇게 repository를 직접 넣어주는 것을 Dependency Injection이라고 함
    public MemberServiceTwo(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재");
            });
    }
    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //중복 이름 회원 X
        // Optional<Member> result = memberRepository.findByName(member.getName());
        // result.ifPresent(m -> {
        //     throw new IllegalStateException("이미 존재");
        // });
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
