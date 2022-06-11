package app.service;

import app.model.Appointment;
import app.repository.AppointmentRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

    public Appointment getAppointment(long id) throws JsonProcessingException {
        // findBy() vs getBy()
        return appointmentRepo.findById(id).get();
    }

    public Appointment postAppointment(Appointment appointment) throws JsonProcessingException {
        return appointmentRepo.save(appointment);
    }

    public Appointment updateAppointment(Appointment appointment) {
        Appointment appointmentEntity = appointmentRepo.findById(appointment.getId()).get();
        appointmentEntity = appointment;
        appointmentRepo.save(appointmentEntity);
        return appointmentEntity;
    }

    public void deleteAppointment(long appointmentId) {
        appointmentRepo.deleteById(appointmentId);
    }
}
