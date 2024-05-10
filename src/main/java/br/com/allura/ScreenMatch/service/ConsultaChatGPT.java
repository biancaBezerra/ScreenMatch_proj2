//package br.com.allura.ScreenMatch.service;
//
//import com.theokanning.openai.completion.CompletionRequest;
//import com.theokanning.openai.completion.CompletionResult;
//import com.theokanning.openai.service.OpenAiService;
//
//
//public class ConsultaChatGPT {
//    public static String obterTraducao(String texto) {
//        OpenAiService service = new OpenAiService(System.getenv("OPENAPI_KEY);
//
//        CompletionRequest requisicao = CompletionRequest.builder()
//                .model("gpt-3.5-turbo-instruct")
//                .prompt("traduza para o português o texto: " + texto)
//                .maxTokens(100)
//                .temperature(0.7)
//                .build();
//
//        try {
//            // Faça a solicitação de completude
//            CompletionResult resposta = service.createCompletion(requisicao);
//
//            // Obtenha o texto da primeira escolha da resposta
//            String textoTraduzido = resposta.getChoices().get(0).getText();
//            return textoTraduzido; // Retorne o texto traduzido
//        } catch (Exception e) {
//            System.err.println("Erro ao processar a solicitação: " + e.getMessage());
//            return null; // Retorne null em caso de erro
//        }
//    }
//
//}
