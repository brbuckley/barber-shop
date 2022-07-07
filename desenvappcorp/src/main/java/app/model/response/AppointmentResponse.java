package app.model.response;

import app.model.Appointment;
import app.model.Haircut;
import app.model.Payment;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse implements Serializable {

  @Getter @Setter private long id;

  @ApiModelProperty(example = "Esperando")
  @Getter
  @Setter
  private String status;

  @ApiModelProperty(example = "11/6/2022")
  @Getter
  @Setter
  private Date date;

  @Getter @Setter private CustomerResponse customer;

  @Getter @Setter private Haircut haircut;

  @Getter @Setter private Payment payment;

  public AppointmentResponse fromAppointment(Appointment appointment) {
    this.id = appointment.getId();
    this.status = appointment.getStatus();
    this.date = appointment.getDate();
    this.customer = new CustomerResponse().fromCustomer(appointment.getCustomer());
    this.haircut = appointment.getHaircut();
    this.payment = appointment.getPayment();
    return this;
  }
}
