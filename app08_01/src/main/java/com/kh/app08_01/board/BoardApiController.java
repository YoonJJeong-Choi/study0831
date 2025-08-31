package com.kh.app08_01.board;

import com.kh.app08_01.member.MemberDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/board")
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping
    public Long insert(@RequestBody BoardDto dto, HttpSession session){
        MemberDto loginMemberDto = (MemberDto) session.getAttribute("loginMemberDto");
        dto.setWriterNo(loginMemberDto.getNo());
        return boardService.insert(dto);
    }

    @GetMapping("{no}")
    public BoardDto findBoardByNo(@PathVariable Long no){
        return boardService.findBoardByNo(no);
    }

    @GetMapping
    public List<BoardDto> findBoardAll(){
        return boardService.findBoardAll();
    }

    @DeleteMapping("{no}")
    public void delete(@PathVariable Long no){
        boardService.delete(no);
    }

    @PutMapping
    public void update(@RequestBody BoardDto dto){
        boardService.update(dto);
    }
}
