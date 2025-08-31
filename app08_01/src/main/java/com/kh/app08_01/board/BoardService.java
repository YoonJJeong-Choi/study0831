package com.kh.app08_01.board;

import com.kh.app08_01.member.MemberEntity;
import com.kh.app08_01.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public Long insert(BoardDto dto) {
        MemberEntity memberEntity = memberRepository.findByNo(dto.getWriterNo());
        BoardEntity entity = BoardEntity.from(dto, memberEntity);
        boardRepository.insert(entity);
        return entity.getNo();
    }

    public BoardDto findBoardByNo(Long no) {
        BoardEntity entity = boardRepository.findBoardByNo(no);
        return BoardDto.from(entity);
    }

    public List<BoardDto> findBoardAll() {
        List<BoardEntity> entityList = boardRepository.findBoardAll();
        return entityList.stream().map(BoardDto::from).toList();
    }

    public void delete(Long no, Long loginMemberNo) {
        BoardEntity entity = boardRepository.findBoardByNo(no);
    if (entity.getWriter().getNo() != loginMemberNo){
        throw new BoardException("[board-001]");
    }
        entity.delete();
    }

    public void update(BoardDto dto, Long loginMemberNo) {
        BoardEntity entity = boardRepository.findBoardByNo(dto.getNo());
        if(entity.getWriter().getNo() != loginMemberNo){
            throw new BoardException("[board-002]");
        }
        entity.update(dto);
    }
}
