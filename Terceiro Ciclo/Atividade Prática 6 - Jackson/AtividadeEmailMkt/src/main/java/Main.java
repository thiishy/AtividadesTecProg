import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        List<String> emails = new ArrayList<String>();
        List<String> emailsValidos = new ArrayList<String>();
        List<String> emailsInvalidos = new ArrayList<String>();

        // Requisição para a API e captura da resposta
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/comments"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();

        //  Transforma o corpo da requisição em um JsonNode
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(responseBody);

        for(JsonNode e : rootNode) {
            emails.add(e.get("email").asString());
        }

        // Regex define se o email é válido ou não (apenas emails .com, .net e .org são válidos)
        // e exibe para o usuário os emails verificados e a quantidade de emails válidos e inválidos.
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|net|org)$";
        Pattern patternEmail = Pattern.compile(regexEmail);

        sb.append("-------------------- \uD83D\uDCE7 EMAILS VERIFICADOS --------------------\n");
        for(String s : emails) {
            Matcher matcherEmail = patternEmail.matcher(s);

            if (matcherEmail.matches()) {
                emailsValidos.add(s);
                sb.append("✅ Email válido: ").append(s).append("\n");
            } else {
                emailsInvalidos.add(s);
                sb.append("❌ Email inválido: ").append(s).append("\n");
            }
        }
        sb.append("--------------------------------------------------------------\n");

        int qtdEmailsValidos = emailsValidos.size();
        int qtdEmailsInvalidos = emailsInvalidos.size();

        sb.append("\n------------------------ \uD83E\uDDFE RESULTADO ------------------------\n");
        sb.append("✅ Quantidade de emails válidos: ").append(qtdEmailsValidos).append("\n");
        sb.append("❌ Quantidade de emails inválidos: ").append(qtdEmailsInvalidos);
        sb.append("\n--------------------------------------------------------------\n");

        System.out.println(sb);

    }
}
