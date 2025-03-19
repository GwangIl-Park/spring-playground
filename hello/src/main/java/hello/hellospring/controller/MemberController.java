package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.hellospring.service.MemberService;

@Controller
public class MemberController {

    //다른 컨트롤러에서도 이 서비스를 가져다 쓸 수도 있음
    //그런데 아래처럼 하면 다른 컨트롤러에서도 새로운 인스턴스를 만들게 됨
    //따라서 아래처럼 하는 것보다는 다른 방식이 좋음
    //private final MemberService memberService = new MemberService();

    //이렇게 하면 컨테이너에 하나만 등록됨
    private final MemberService memberService;

    //이걸 쓰면 MemberService를 spring 컨테이너가 만들고 연결해줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
