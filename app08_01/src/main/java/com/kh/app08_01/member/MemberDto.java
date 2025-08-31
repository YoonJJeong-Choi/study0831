package com.kh.app08_01.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MemberDto {

    private Long no;
    private String userId;
    private String userNick;
    private String userPwd;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //entity -> dto
    public static MemberDto from(MemberEntity entity){
        MemberDto dto = new MemberDto();
        dto.no = entity.getNo();
        dto.userId = entity.getUserId();
        dto.userNick = entity.getUserNick();
        dto.userPwd = entity.getUserPwd();
        dto.delYn = entity.getDelYn();
        dto.createdAt = entity.getCreatedAt();
        dto.updatedAt = entity.getUpdatedAt();
        return dto;
    }

}
