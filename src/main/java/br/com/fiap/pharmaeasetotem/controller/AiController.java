package br.com.fiap.pharmaeasetotem.controller;
import br.com.fiap.pharmaeasetotem.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    @Autowired
    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/generate")
    public String generateText(@RequestBody String prompt) {
        return aiService.generateText(prompt);
    }
}
