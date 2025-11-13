package com.qaima.external;

import com.qaima.domain.Stock;
import com.qaima.dto.MarketStackTickersResponse;
import com.qaima.dto.StockDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KrStockClient implements StockClient {

    @Override
    public StockDto fetchStock(Stock stock) {
        return null; // 더미
    }

    @Override
    public MarketStackTickersResponse.TickerData fetchTickerMeta(String symbol) {
        return null;
    }
}

