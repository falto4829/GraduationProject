package com.qaima.external;
import com.qaima.dto.StockDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class StockApiClient {

    private final WebClient webClient;

    public StockApiClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://example-stock-api.com")  // TODO 실제 외부 API base url
                .build();
    }

    public StockDto fetchStock(String stockCode) {
        // 외부 API 응답 구조에 맞게 수정
        return webClient.get()
                .uri("/stocks/{code}", stockCode)
                .retrieve()
                .bodyToMono(StockDto.class)
                .onErrorResume(e -> Mono.empty())
                .block();
    }
}

