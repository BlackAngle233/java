package cn.edu.wordladder.controller;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.wordladder.domain.WordLadder;

@RestController
public class WordLadderController {

    @RequestMapping("/index")
    public String home() {
        return "index";
    }

    @RequestMapping("/wordladder")
    public String register(HttpServletRequest request) throws FileNotFoundException {
        String start = request.getParameter("startword");
        String destination = request.getParameter("targetword");
        WordLadder wordLadder = new WordLadder();
        wordLadder.readEnglish();
        wordLadder.inputWords(start, destination);
        String ans = wordLadder.showAns();
        return ans;
    }
}