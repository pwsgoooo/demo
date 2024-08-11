package com.pws.board.controller;

import com.pws.board.entity.Board;
import com.pws.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

//    @GetMapping("/")
//    @ResponseBody
//    public String main() {
//        return "hellllllo";
//    }

    @GetMapping("/write")
    public String writeform(){
        return "write";

    }

    @PostMapping("write/save")
    public String saveform(Board board, Model model) throws Exception {
        System.out.println(board.getTitle());

        boardService.write(board);

        model.addAttribute("board", board);
        model.addAttribute("msg", "글 작성 완료");

        return "msg";
    }

//    @GetMapping("/list")
//    public String list(){
//        return "list";
//    }
}
