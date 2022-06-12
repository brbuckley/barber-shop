package app.controller;

import app.model.Appointment;
import app.repository.AppointmentRepo;
import app.service.AppointmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Controller for Appointment services. */
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

  private AppointmentRepo appointmentRepo;

  public AppointmentController(AppointmentRepo appointmentRepo) {
    this.appointmentRepo = appointmentRepo;
  }

  @ApiOperation(value = "Search appointment by ID.", response = Appointment.class)
  @GetMapping(value = "/{appointmentId}", produces = "application/json")
  public ResponseEntity getAppointment(@PathVariable(value = "appointmentId") long id)
      throws JsonProcessingException {
    return new ResponseEntity(
        new AppointmentService(appointmentRepo).getAppointment(id), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new appointment.", response = Appointment.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity getAppointment(@RequestBody Appointment appointment)
      throws JsonProcessingException {
    return new ResponseEntity(
        new AppointmentService(appointmentRepo).postAppointment(appointment), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates an appointment.", response = Appointment.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateAppointment(@RequestBody Appointment appointment) {
    return new ResponseEntity(
        new AppointmentService(appointmentRepo).updateAppointment(appointment), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates the status of an appointment by ID.", response = Appointment.class)
  @PutMapping(value = "/{appointmentId}/status/{status}", produces = "application/json")
  public ResponseEntity updateStatus(
      @PathVariable(value = "appointmentId") long appointmentId,
      @PathVariable(value = "status") String status) {
    return new ResponseEntity(
        new AppointmentService(appointmentRepo).updateStatus(appointmentId, status), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes an appointment.")
  @DeleteMapping(value = "/delete/{appointmentId}", produces = "application/json")
  public ResponseEntity deleteAppointment(
      @PathVariable(value = "appointmentId") long appointmentId) {
    new AppointmentService(appointmentRepo).deleteAppointment(appointmentId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
