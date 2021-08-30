package net.msj0319.api.designPatterns;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StrategyTest {
    @Test
    @DisplayName("전략 패턴 테스트")
    void main() {
        List<Stock> stockList = new ArrayList<>();
        //수 많은 주식 데이터가 있다고 가정한다.
        stockList.add(new Stock("AAPL", 318.65, 10));
        stockList.add(new Stock("MSFT", 166.86, 45));
        stockList.add(new Stock("Google", 99, 12.5));
        stockList.add(new Stock("AMZ", 1866.74, 45));
        stockList.add(new Stock("GOOGL", 1480.20, 3.5));
        stockList.add(new Stock("AAPL", 318.65, 8));
        stockList.add(new Stock("AMZ", 1866.74, 9));
        //stockList 중 종목의 symbol이 AMZ인 종목을 모두 출력하라
        StockFilters.filter(stockList, stock -> stock.getSymbol().equals("AMZ"))
                .forEach(System.out::println);
    }
}
@Data class Stock {
    private final String symbol;
    private final double price;
    private final double units;
}
//주식 종목 필터링 알고리즘
//주식 데이터 list와 Predicate를 입력받는다.
//명시된 filtering 대로 test() 결과가 true인 종목들을 filteredData 리스트에 모두 삽입하고 반환한다.
class StockFilters {
    static List<Stock> filter(List<Stock> list, Predicate<Stock> predicate) {
        List<Stock> filteredData = new ArrayList<>();
        for (Stock stock : list) {
            if (predicate.test(stock)) filteredData.add(stock);
        }
        return filteredData;
    }
}
