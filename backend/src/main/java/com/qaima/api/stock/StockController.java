package com.qaima.api.stock;
import com.qaima.dto.StockDto;
import com.qaima.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/v1/stocks")
public class StockController {

    private final StockService stockService;
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // GET /api/v1/stocks/005930  이런 느낌 예상
    @GetMapping("/{stockCode}")
    public ResponseEntity<StockDto> getStock(@PathVariable String stockCode) {
        StockDto stock = stockService.getStock(stockCode);
        if (stock == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stock);
    }
}
