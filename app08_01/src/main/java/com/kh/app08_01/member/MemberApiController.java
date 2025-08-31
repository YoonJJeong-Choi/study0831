package com.kh.app08_01.member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/member")
@CrossOrigin
public class MemberApiController {

    private final MemberService service;

    @PostMapping("join")
    public Long join(@RequestBody MemberDto dto){
        return service.join(dto);
    }

    @PostMapping("login")
    public MemberDto login(@RequestBody MemberDto dto, HttpSession session){
        MemberDto loginMemberDto = service.login(dto);
        session.setAttribute("loginMemberDto", loginMemberDto);
        return loginMemberDto;
    }

}
