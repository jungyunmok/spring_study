package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 스프링 빈으로 자동 등록
public class MemberController {

    private final MemberService memberService;

    /* setter 주입 방식
    컨트롤러가 public하게 노출됨
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/

    /* 필드 주입 방식
    @Autowired private MemberService memberService; */

    /*스프링이 알아서 연관된 객체 찾아서 연결해줌
     * 자동 의존관계 설정 - 의존성 주입(DI, Dependency Injection)
     * 생성자 주입 방식 - 가장 권장하는 의존성 주입 방식(의존관계가 실행중 바뀌는 경우는 없으므로)*/
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

        System.out.println("member=>"+member.getName());

        memberService.join(member);

        return "redirect:/"; // 홈 화면으로 이동
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
