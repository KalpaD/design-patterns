package org.kds.dp.client;

import org.kds.dp.model.client.ExtBsbAccNumPaymentResponse;
import org.kds.dp.model.client.ExtPayIdPaymentRequest;
import org.kds.dp.model.client.ExtPayIdPaymentResponse;
import org.kds.dp.model.client.ExtbsbAccNumPaymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExternalPaymentClient {

    Logger logger = LoggerFactory.getLogger(ExternalPaymentClient.class);

   public ExtBsbAccNumPaymentResponse executeBsbAccNumPaymentEndpoint(ExtbsbAccNumPaymentRequest request) {
       logger.info("Executing bsb acc num payment to remote system {}", request);
       return new ExtBsbAccNumPaymentResponse("bsb-acc-num-receipt");
   }

   public ExtPayIdPaymentResponse executePayIdPaymentEndpoint(ExtPayIdPaymentRequest request) {
       logger.info("Executing bsb acc num payment to remote system {}", request);
       return new ExtPayIdPaymentResponse("payId-reference");
   }
}
