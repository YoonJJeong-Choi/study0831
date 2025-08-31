package com.kh.app08_01.board;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BoardDto {

    private Long no;
    private String title;
    private String content;
    private String delYn;
    private Long writerNo;
    private String writerNick;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //entity -> dto
    public static BoardDto from(BoardEntity entity){
        BoardDto dto = new BoardDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.content = entity.getContent();
        dto.delYn = entity.getDelYn();
        dto.createdAt = entity.getCreatedAt();
        dto.updatedAt = entity.getUpdatedAt();
        dto.writerNick = entity.getWriter().getUserNick();
        dto.writerNo = entity.getWriter().getNo();
        return dto;
    }

}
