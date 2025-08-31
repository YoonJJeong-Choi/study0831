package com.kh.app08_01.member;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
@Getter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String userId;
    private String userNick;
    private String userPwd;
    private String delYn;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MemberEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
    }

    //dto -> entity
    public static MemberEntity from(MemberDto dto){
        MemberEntity entity = new MemberEntity();
        entity.userId = dto.getUserId();
        entity.userPwd = dto.getUserPwd();
        entity.userNick = dto.getUserNick();
        return entity;
    }

}
