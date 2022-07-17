package app.service;

import app.model.Appointment;
import app.model.Status;
import app.model.response.AppointmentRequest;
import app.repository.AppointmentRepo;
import java.util.List;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppointmentService {

  @Setter private AppointmentRepo appointmentRepo;

  /** Custom constructor with spring injected repository. */
  public AppointmentService(AppointmentRepo appointmentRepo) {
    this.appointmentRepo = appointmentRepo;
  }

  public Appointment getAppointment(long id) {
    // findBy() vs getBy()
    return appointmentRepo.findById(id).get();
  }

  public List<Appointment> getAllAppointments() {
    return appointmentRepo.findAll();
  }

  public AppointmentRequest postAppointment(AppointmentRequest appointment) {
    return new AppointmentRequest()
        .fromAppointment(appointmentRepo.save(appointment.toAppointment()));
  }

  public AppointmentRequest updateAppointment(AppointmentRequest appointment) {
    Appointment appointmentEntity = appointmentRepo.findById(appointment.getId()).get();
    appointmentEntity = appointment.toAppointment();
    appointmentRepo.save(appointmentEntity);
    return new AppointmentRequest().fromAppointment(appointmentEntity);
  }

  public Appointment updateStatus(long appointmentId, String status) {
    Appointment appointmentEntity = appointmentRepo.findById(appointmentId).get();
    appointmentEntity.setStatus(Status.fromValue(status));
    appointmentRepo.save(appointmentEntity);
    return appointmentEntity;
  }

  public List<Appointment> filterWaiting(long queueId) {
    return appointmentRepo.filterWaiting(queueId);
  }

  public void deleteAppointment(long appointmentId) {
    appointmentRepo.deleteById(appointmentId);
  }
}
