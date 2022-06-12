package app.model.response;

import app.model.Payment;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

public class PaymentRequest implements Serializable {

  @Getter @Setter long id;

  public PaymentRequest fromPayment(Payment payment) {
    this.id = payment.getId();
    return this;
  }
}
