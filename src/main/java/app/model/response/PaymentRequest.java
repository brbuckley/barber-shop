package app.model.response;

import app.model.Payment;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class PaymentRequest implements Serializable {

    @Getter @Setter long id;

    public PaymentRequest fromPayment(Payment payment) {
        this.id = payment.getId();
        return this;
    }
}
