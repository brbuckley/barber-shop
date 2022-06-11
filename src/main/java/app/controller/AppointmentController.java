package app.controller;

import app.model.Appointment;
import app.repository.AppointmentRepo;
import app.service.AppointmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    /**
     * GET request for appointment by id.
     *
     * @param id The id of the appointment.
     * @return Appointment.
     * @throws JsonProcessingException Exceptions while parsing the JSON response.
     */
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
            })
    @ApiOperation(value = "Search appointment by ID.", response = Appointment.class)
    @GetMapping(value = "/{appointmentId}", produces = "application/json")
    public ResponseEntity getAppointment(@PathVariable(value = "appointmentId") long id)
            throws JsonProcessingException {
        return new ResponseEntity(new AppointmentService(appointmentRepo).getAppointment(id), HttpStatus.OK);
    }

    /**
     * POST request to add a new Appointment.
     *
     * @param id The id of the appointment.
     * @return Appointment.
     * @throws JsonProcessingException Exceptions while parsing the JSON response.
     */
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
            })
    @ApiOperation(value = "Creates a new appointment.", response = Appointment.class)
    @PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity getAppointment(@RequestBody Appointment appointment) throws JsonProcessingException {
        return new ResponseEntity(
                new AppointmentService(appointmentRepo).postAppointment(appointment), HttpStatus.OK);
    }

    @PutMapping(value = "/update", produces = "application/json")
    public ResponseEntity updateAppointment(@RequestBody Appointment appointment)
            throws JsonProcessingException {
        return new ResponseEntity(
                new AppointmentService(appointmentRepo).updateAppointment(appointment), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{appointmentId}", produces = "application/json")
    public ResponseEntity deleteAppointment(@PathVariable(value = "appointmentId") long appointmentId)
            throws JsonProcessingException {
        new AppointmentService(appointmentRepo).deleteAppointment(appointmentId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
