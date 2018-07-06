package codesquad.web;

import codesquad.domain.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    private List<Question> questions = new ArrayList<>();

    @GetMapping("/")
    public String redirect(Model model){
        model.addAttribute("ask", questions);
        return "/qna/index";
    }

    @PostMapping("/ask")
    public String create(Question question) {
        questions.add(question);
        return "redirect:/ask";
    }

    @GetMapping("/ask")
    public String list(Model model) {
        model.addAttribute("ask", questions);
        return "/qna/index";
    }
}
