package app.model.response;

import app.model.Appointment;
import app.model.Barber;
import app.model.Queue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class QueueResponse implements Serializable {

  @Getter @Setter private long id;

  @Getter @Setter private Barber barber;

  @Getter @Setter private int resultCount;

  @Getter @Setter private String status;

  @Getter private List<AppointmentResponse> appointments = new ArrayList<>();

  public QueueResponse fromQueue(Queue queue) {
    this.id = queue.getId();
    this.status = queue.getStatus();
    this.barber = queue.getBarber();
    return this;
  }

  public QueueResponse fromAppointments(List<Appointment> appointments) {
    for (Appointment appointment : appointments) {
      this.appointments.add(new AppointmentResponse().fromAppointment(appointment));
    }
    this.resultCount = appointments.size();
    return this;
  }
}
