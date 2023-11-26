package com.example.customer.remote;

import com.example.customer.domain.Order;
import com.example.customer.responseBody.BodyResponsePayment;
import com.example.customer.responseBody.DataResponsePayment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class PaymentRemote {
    public DataResponsePayment getQrFromOtherClient(Order requestBody) {
        String url =  UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api-merchant.payos.vn")
                .path("v2/payment-requests")
                .build()
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-client-id", "9f9afe18-099b-4cd0-81c1-fc229326dccf");
        headers.set("x-api-key", "f13eb249-fa4d-4a01-95f6-3656f8d81406");


        HttpEntity<Order> requestEntity = new HttpEntity<>(requestBody, headers);

        RestOperations restOperations = new RestTemplate();

        BodyResponsePayment x = restOperations.postForEntity(url, requestEntity, BodyResponsePayment.class).getBody();
        assert x != null;
        return x.getData();
    }
}