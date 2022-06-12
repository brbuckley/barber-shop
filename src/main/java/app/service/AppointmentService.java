package app.service;

import app.model.Appointment;
import app.model.Status;
import app.model.response.AppointmentRequest;
import app.repository.AppointmentRepo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.List;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AppointmentService {

  private ObjectMapper mapper;
  @Setter private RestTemplate restTemplate;

  @Setter private AppointmentRepo appointmentRepo;

  /** Custom constructor with spring injected repository. */
  public AppointmentService(AppointmentRepo appointmentRepo) {
    this.restTemplate = new RestTemplateBuilder().build();
    this.appointmentRepo = appointmentRepo;
    this.mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    this.mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
    this.mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
  }

  public Appointment getAppointment(long id) {
    // findBy() vs getBy()
    return appointmentRepo.findById(id).get();
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
    return appointmentRepo.filterWaiting(1);
  }

  public void deleteAppointment(long appointmentId) {
    appointmentRepo.deleteById(appointmentId);
  }
}
