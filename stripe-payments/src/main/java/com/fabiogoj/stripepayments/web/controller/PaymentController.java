package com.fabiogoj.stripepayments.web.controller;

import com.fabiogoj.stripepayments.dto.CreatePayment;
import com.fabiogoj.stripepayments.dto.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.RequestEntity.post;

@RestController
public class PaymentController {

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(CreatePayment createPayment) throws StripeException {

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                        .setAmount(15 + 100L)
                        .setCurrency("eur")
                        .build();

        // Create a PaymentIntent with the order amount and currency
        PaymentIntent paymentIntent = PaymentIntent.create(params);

        return new CreatePaymentResponse(paymentIntent.getClientSecret());

    }
}
