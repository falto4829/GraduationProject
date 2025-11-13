package com.qaima.api.stock;

import com.qaima.common.ApiResponse;
import com.qaima.dto.MarketStackTickersResponse;
import com.qaima.dto.StockDto;
import com.qaima.service.StockService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // Marketstack 티커 API 테스트용 엔드포인트
    // 예시:
    //  - 전체:  /api/v1/stocks/marketstack/tickers
    //  - 코스닥: /api/v1/stocks/marketstack/tickers?exchange=XKOS
    //  - 나스닥: /api/v1/stocks/marketstack/tickers?exchange=XNAS&limit=50
    //  - 검색:  /api/v1/stocks/marketstack/tickers?search=samsung
    // 삼성전자: /api/v1/stocks/marketstack/ticker/005930.XKRX
    // 애플: /api/v1/stocks/marketstack/ticker/AAPL
    @GetMapping("/marketstack/ticker/{symbol}")
    public ApiResponse<MarketStackTickersResponse.TickerData> getTickerMeta(
            @PathVariable String symbol
    ) {
        var data = stockService.getTickerMeta(symbol);
        return ApiResponse.success(data);
    }
}
