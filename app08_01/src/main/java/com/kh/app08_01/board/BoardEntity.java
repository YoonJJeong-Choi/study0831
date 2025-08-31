package com.kh.app08_01.board;

import com.kh.app08_01.member.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
@Getter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String title;
    private String content;
    private String delYn;

    @JoinColumn(name = "writerNo")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity writer; //MemberEntity타입

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BoardEntity() {
        delYn = "N";
        createdAt = LocalDateTime.now();
    }

    //dto -> entity
    public static BoardEntity from(BoardDto dto, MemberEntity writer){
        BoardEntity entity = new BoardEntity();
        entity.title = dto.getTitle();
        entity.content = dto.getContent();
        entity.writer = writer;
        return entity;
    }

    public void delete() {
        delYn = "Y";
    }

    public void update(BoardDto dto) {
        no = dto.getNo();
        title = dto.getTitle();
        content = dto.getContent();
        updatedAt = LocalDateTime.now();
    }

}
