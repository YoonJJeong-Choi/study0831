package com.kh.app08_01.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public Long join(MemberDto dto) {
        MemberEntity entity = MemberEntity.from(dto);
        repository.join(entity);
        return entity.getNo();
    }

    public MemberDto login(MemberDto dto) {
        MemberEntity entity = repository.login(dto);
        MemberDto loginMemberDto = MemberDto.from(entity);
        return loginMemberDto;
    }
}
