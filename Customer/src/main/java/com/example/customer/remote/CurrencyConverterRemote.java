package com.example.customer.remote;

import com.example.customer.responseBody.CurrencyResponse;
import com.example.customer.responseBody.CustomerResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyConverterRemote {
    public double currencyConverter() {
        String url = "https://open.er-api.com/v6/latest/USD";
        RestTemplate restTemplate = new RestTemplate();
        // Gửi yêu cầu POST
        double VND = 0;
        ResponseEntity<CurrencyResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                CurrencyResponse.class
        );
        // Lấy đối tượng response từ phản hồi
        CurrencyResponse currencyResponse = responseEntity.getBody();

        // Kiểm tra xem phản hồi có giá trị không và lấy giá trị chuyển đổi VND nếu có
        if (currencyResponse != null && currencyResponse.getRates() != null) {
            // Lấy giá trị chuyển đổi VND từ rates
            return currencyResponse.getVNDExchangeRate();
        } else {
            // Xử lý trường hợp không có giá trị hoặc có lỗi
            throw new RuntimeException("Không thể lấy giá trị chuyển đổi VND từ API.");
        }
    }
}
