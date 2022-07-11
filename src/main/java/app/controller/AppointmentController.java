package app.controller;

import app.model.Appointment;
import app.model.response.AppointmentRequest;
import app.service.AppointmentService;
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

  private AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @ApiOperation(value = "Search appointment by ID.", response = Appointment.class)
  @GetMapping(value = "/{appointmentId}", produces = "application/json")
  public ResponseEntity getAppointment(@PathVariable(value = "appointmentId") long id) {
    return new ResponseEntity(appointmentService.getAppointment(id), HttpStatus.OK);
  }

  @GetMapping(value = "/all", produces = "application/json")
  public ResponseEntity getAllAppointments() {
    return new ResponseEntity(appointmentService.getAllAppointments(), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new appointment.", response = Appointment.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity postAppointment(@RequestBody AppointmentRequest appointment) {
    return new ResponseEntity(appointmentService.postAppointment(appointment), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates an appointment.", response = Appointment.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateAppointment(@RequestBody AppointmentRequest appointment) {
    return new ResponseEntity(appointmentService.updateAppointment(appointment), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates the status of an appointment by ID.", response = Appointment.class)
  @PutMapping(value = "/{appointmentId}/status/{status}", produces = "application/json")
  public ResponseEntity updateStatus(
      @PathVariable(value = "appointmentId") long appointmentId,
      @PathVariable(value = "status") String status) {
    return new ResponseEntity(
        appointmentService.updateStatus(appointmentId, status), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes an appointment.")
  @DeleteMapping(value = "/delete/{appointmentId}", produces = "application/json")
  public ResponseEntity deleteAppointment(
      @PathVariable(value = "appointmentId") long appointmentId) {
    appointmentService.deleteAppointment(appointmentId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
