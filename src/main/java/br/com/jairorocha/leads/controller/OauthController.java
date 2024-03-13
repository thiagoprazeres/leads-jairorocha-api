package br.com.jairorocha.leads.controller;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import okhttp3.*;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
public class OauthController {

    private static final String URL = "https://leads-jairorocha-api.azurewebsites.net";
    private static final String CLIENT_ID = "563247ed31d2044ee725dedcf5b0076ac14a3caf";
    private static final String CLIENT_SECRET = "e90f41c9ba21794c14305b5849daf03c";
    private static final String AUTH_HOST = "auth.olx.com.br";
    private static final String REDIRECT_URI = URL + "/oauth";
    private static final String GRANT_TYPE = "authorization_code";
    private static final String RESPONSE_TYPE = "code";
    private static final String SCOPE = "basic_user_info";
    private static final String STATE = "test";

    @GetMapping("/")
    public RedirectView home() {
        String url = String.format("https://%s/oauth?client_id=%s&response_type=%s&scope=%s&redirect_uri=%s&state=%s",
                AUTH_HOST, CLIENT_ID, RESPONSE_TYPE, SCOPE, REDIRECT_URI, STATE);
        return new RedirectView(url);
    }

    @ResponseBody
    @GetMapping("/oauth")
    public Object oauth(@RequestParam("code") String code) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = okhttp3.RequestBody.create(
                "code=" + code +
                        "&client_id=" + CLIENT_ID +
                        "&client_secret=" + CLIENT_SECRET +
                        "&redirect_uri=" + REDIRECT_URI +
                        "&grant_type=" + GRANT_TYPE,
                mediaType
        );

        Request request = new Request.Builder()
                .url("https://" + AUTH_HOST + "/oauth/token")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            String responseBody = response.body().string();

            // Desserializar a resposta JSON em uma instância de AccessTokenResponse
            AccessTokenResponse accessTokenResponse = gson.fromJson(responseBody, AccessTokenResponse.class);

            // Retornar o access_token
            return accessTokenResponse.getAccessToken();
        }
    }

    public static class AccessTokenResponse {
        @SerializedName("access_token")
        private String accessToken;

        public String getAccessToken() {
            return accessToken;
        }
    }
}
