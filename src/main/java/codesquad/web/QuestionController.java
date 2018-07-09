package codesquad.web;

import codesquad.domain.Question;
import codesquad.domain.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    private List<Question> questions = new ArrayList<>();

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/ask")
    public String create(Question question) {
        questionRepository.save(question);
        return "redirect:/";
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("ask", questionRepository.findAll());
        return "/qna/index";
    }

    @GetMapping("/questions/{index}")
    public String show(@PathVariable int index, Model model) {
        model.addAttribute("question", questionRepository.findById(index).get());
        return "/qna/show";
    }

    @DeleteMapping("/questions/delete/{index}")
    public String delete(@PathVariable int index, Model model) {
        questionRepository.deleteById(index);
        return "redirect:/";
    }

    @GetMapping("/questions/updateForm/{index}")
    public String getQuestionInfo(@PathVariable int index, Model model) {
        model.addAttribute("question", questionRepository.findById(index).get());
        return "qna/updateForm";
    }

    @PostMapping("questions/update/{index}")
    public String updateQuestionInfo(@PathVariable int index, Question question, Model model) {
        question.setIndex(index);
        questionRepository.save(question);
        return "redirect:/questions/" + index;
    }

}
