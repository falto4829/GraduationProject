package com.qaima.service;
import com.qaima.dto.StockDto;
import com.qaima.external.StockApiClient;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockApiClient stockApiClient;

    public StockService(StockApiClient stockApiClient) {
        this.stockApiClient = stockApiClient;
    }

    public StockDto getStock(String stockCode) {
        // 1) 외부에서 가져오기
        StockDto dto = stockApiClient.fetchStock(stockCode);

        // 2) 여기서 DB 캐시 저장, analysis_request랑 묶음
        //    stockRepository.save(...)

        return dto;
    }
}

// entity 넣을때 주의점
// 0) 우선 DB 캐시 확인
// ex: var cached = stockRepository.findByStockCode(stockCode);
// if (cached != null) return mapper(cached);

// 1) 외부에서 가져오기
// 2) DB 저장

