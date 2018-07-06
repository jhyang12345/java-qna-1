package codesquad.web;

import codesquad.domain.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    private List<Question> questions = new ArrayList<>();

    @GetMapping("/qna/{index}")
    public String show(@PathVariable int index, Model model) {
        model.addAttribute("question", questions.get(index - 1));
        return "/qna/show";
    }


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("ask", questions);
        return "/qna/index";
    }

    @PostMapping("/ask")
    public String create(Question question) {
        question.setIndex(questions.size() + 1);
        questions.add(question);
        return "redirect:/";
    }

}
