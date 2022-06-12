package app.controller;

import app.model.Appointment;
import app.model.Queue;
import app.model.response.QueueResponse;
import app.repository.AppointmentRepo;
import app.repository.QueueRepo;
import app.service.AppointmentService;
import app.service.QueueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Controller for Queue services. */
@RestController
@RequestMapping("/queue")
public class QueueController {

  private QueueRepo queueRepo;
  private AppointmentRepo appointmentRepo;

  public QueueController(QueueRepo queueRepo, AppointmentRepo appointmentRepo) {
    this.queueRepo = queueRepo;
    this.appointmentRepo = appointmentRepo;
  }

  @ApiOperation(value = "Get All information about a queue.", response = QueueResponse.class)
  @GetMapping(value = "/{queueId}/all", produces = "application/json")
  public ResponseEntity getAllQueue(@PathVariable(value = "queueId") long id)
      throws JsonProcessingException {
    Queue queue = new QueueService(queueRepo).getQueue(id);
    QueueResponse response =
        new QueueResponse().fromQueue(new QueueService(queueRepo).getQueue(id));
    return new ResponseEntity(response.fromAppointments(queue.getAppointments()), HttpStatus.OK);
  }

  @ApiOperation(value = "Get queue of waiting customers.", response = QueueResponse.class)
  @GetMapping(value = "/{queueId}", produces = "application/json")
  public ResponseEntity getQueue(@PathVariable(value = "queueId") long id)
      throws JsonProcessingException {
    List<Appointment> appointments = new AppointmentService(appointmentRepo).filterWaiting(id);
    QueueResponse response =
        new QueueResponse().fromQueue(new QueueService(queueRepo).getQueue(id));
    return new ResponseEntity(response.fromAppointments(appointments), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new queue.", response = Queue.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity postQueue(@RequestBody Queue queue) throws JsonProcessingException {
    return new ResponseEntity(new QueueService(queueRepo).postQueue(queue), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates a queue.", response = Queue.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateQueue(@RequestBody Queue queue) {
    return new ResponseEntity(new QueueService(queueRepo).updateQueue(queue), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes a queue.")
  @DeleteMapping(value = "/delete/{queueId}")
  public ResponseEntity deleteQueue(@PathVariable(value = "queueId") long queueId) {
    QueueService queueService = new QueueService(queueRepo);
    queueService.deleteQueue(queueId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
