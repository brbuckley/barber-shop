package app.model.response;

import app.model.Appointment;
import app.model.Barber;
import app.model.Customer;
import app.model.Haircut;
import app.model.Payment;
import app.model.Queue;
import app.model.Status;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

public class AppointmentRequest implements Serializable {

  @Getter @Setter private long id;

  @ApiModelProperty(example = "Esperando")
  @Getter
  @Setter
  private String status;

  @ApiModelProperty(example = "11/6/2022")
  @Getter
  @Setter
  private Date date;

  @Getter @Setter private CustomerRequest customer;

  @Getter @Setter private BarberRequest barber;

  @Getter @Setter private HaircutRequest haircut;

  @Getter @Setter private PaymentRequest payment;

  @Getter @Setter private QueueRequest queue;

  public Appointment toAppointment() {
    Appointment appointment = new Appointment();
    appointment.setStatus(Status.fromValue(this.status));
    appointment.setDate(this.date);
    appointment.setBarber(new Barber(this.barber.getId()));
    appointment.setCustomer(new Customer(this.customer.getId()));
    appointment.setHaircut(new Haircut(this.haircut.getId()));
    appointment.setPayment(new Payment(this.payment.getId()));
    appointment.setQueue(new Queue(this.queue.getId()));

    return appointment;
  }

  public AppointmentRequest fromAppointment(Appointment appointment) {
    this.setBarber(new BarberRequest().fromBarber(appointment.getBarber()));
    this.setCustomer(new CustomerRequest().fromCustomer(appointment.getCustomer()));
    this.setHaircut(new HaircutRequest().fromHaircut(appointment.getHaircut()));
    this.setPayment(new PaymentRequest().fromPayment(appointment.getPayment()));
    this.setQueue(new QueueRequest().fromQueue(appointment.getQueue()));
    this.setStatus(appointment.getStatus());
    this.setDate(appointment.getDate());
    this.id = appointment.getId();
    return this;
  }
}
