package br.com.fiap.pharmaeasetotem.service;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final OpenAiService openAiService;

    public AiService(@Value("${openai.api.key}") String apiKey) {
        this.openAiService = new OpenAiService(apiKey);
    }

    public String generateText(String prompt) {
        CompletionRequest request = CompletionRequest.builder()
                .prompt(prompt)
                .model("text-davinci-003")
                .maxTokens(100)  // Limite de tokens da resposta
                .build();

        CompletionResult result = openAiService.createCompletion(request);
        return result.getChoices().get(0).getText();
    }
}

