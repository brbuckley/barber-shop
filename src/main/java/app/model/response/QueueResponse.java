package app.model.response;

import app.model.Appointment;
import app.model.Barber;
import app.model.Queue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class QueueResponse implements Serializable {

  @Getter @Setter private long id;

  @Getter @Setter private Barber barber;

  @Getter private List<AppointmentResponse> appointments = new ArrayList<>();

  public QueueResponse fromQueue(Queue queue) {
    this.id = queue.getId();
    this.barber = queue.getBarber();
    return this;
  }

  public QueueResponse fromAppointments(List<Appointment> appointments) {
    for (Appointment appointment : appointments) {
      this.appointments.add(new AppointmentResponse().fromAppointment(appointment));
    }
    return this;
  }
}
