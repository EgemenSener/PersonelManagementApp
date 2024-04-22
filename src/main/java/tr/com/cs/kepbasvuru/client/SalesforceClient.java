package tr.com.cs.kepbasvuru.client;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.Map;

@Service
public class SalesforceClient {
    private final RestClient restClient;

    public SalesforceClient(RestClient.Builder builder) {

        JdkClientHttpRequestFactory requestFactory = new JdkClientHttpRequestFactory();
        requestFactory.setReadTimeout(10000);

        this.restClient = builder
                .baseUrl("https://efinansdev--dev1.sandbox.my.salesforce.com/services/")
                .requestFactory(requestFactory)
                .build();
    }

    public String getBearerToken() {
        ResponseEntity<Map> responseEntity = null;
        responseEntity = restClient.post()
                .uri("/oauth2/token?grant_type=password&client_id=3MVG9hq7jmfCuKffgYwAb_9az5zbR_CRYsPzEy9QjZMOfSirRtO13IYaNbG6cZfKUN5CffM2qFfAKj2fftVH3\n" +
                        "&client_secret=271FDE30897DB1548B8624E2F45E239DCF7210B4671D3DA236BCB6E9125BA713&username=gunhan.gultekin@experteam.com.tr.dev1&password=Welcome2_6CskHswnf1M6E2FkFgVj4Ayzm")
                .retrieve()
                .toEntity(Map.class);
        Map<String, String> response = responseEntity.getBody();
        return response.get("access_token");
    }

    public String getProducts(String token) {
        return Collections.singletonList(restClient.get()
                .uri("apexrest/KepProducts?customerType=Bireysel")
                        .header("Authorization", "Bearer " + token)
                .retrieve()
                .body(String.class)).toString();
    }
}
