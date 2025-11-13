package com.qaima.external;

import com.qaima.domain.Stock;
import com.qaima.dto.MarketStackTickersResponse;
import com.qaima.dto.StockDto;

public interface StockClient {
    StockDto fetchStock(Stock stock);

    // Marketstack 티커 하나 조회용
    MarketStackTickersResponse.TickerData fetchTickerMeta(String symbol);
}