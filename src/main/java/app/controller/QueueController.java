package app.controller;

import app.model.Appointment;
import app.model.Queue;
import app.model.response.QueueResponse;
import app.service.AppointmentService;
import app.service.QueueService;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Controller for Queue services. */
@RestController
@RequestMapping("/queue")
public class QueueController {

  private QueueService queueService;
  private AppointmentService appointmentService;

  public QueueController(QueueService queueService, AppointmentService appointmentService) {
    this.queueService = queueService;
    this.appointmentService = appointmentService;
  }

  @ApiOperation(value = "Get All information about a queue.", response = QueueResponse.class)
  @GetMapping(value = "/{queueId}/info", produces = "application/json")
  public ResponseEntity getQueueInfo(@PathVariable(value = "queueId") long id) {
    Queue queue = queueService.getQueue(id);
    QueueResponse response = new QueueResponse().fromQueue(queueService.getQueue(id));
    return new ResponseEntity(response.fromAppointments(queue.getAppointments()), HttpStatus.OK);
  }

  @GetMapping(value = "/all", produces = "application/json")
  public ResponseEntity getAllQueues() {
    List<Queue> queues = queueService.getQueuesByStatus("aberto");
    List<QueueResponse> responses = new ArrayList<>();
    for (Queue queue: queues) {
      List<Appointment> appointments = appointmentService.filterWaiting(queue.getId());
      QueueResponse response = new QueueResponse().fromQueue(queue);
      responses.add(response.fromAppointments(appointments));
    }
    return new ResponseEntity(responses, HttpStatus.OK);
  }

  @ApiOperation(value = "Get queue of waiting customers.", response = QueueResponse.class)
  @GetMapping(value = "/{queueId}", produces = "application/json")
  public ResponseEntity getQueue(@PathVariable(value = "queueId") long id) {
    List<Appointment> appointments = appointmentService.filterWaiting(id);
    QueueResponse response = new QueueResponse().fromQueue(queueService.getQueue(id));
    return new ResponseEntity(response.fromAppointments(appointments), HttpStatus.OK);
  }

  @ApiOperation(value = "Get queue by barber.", response = QueueResponse.class)
  @GetMapping(value = "/barber/{barberId}", produces = "application/json")
  public ResponseEntity getByBarber(@PathVariable(value = "barberId") long id) {
    QueueResponse response = new QueueResponse().fromQueue(queueService.getByBarber(id));
    List<Appointment> appointments = appointmentService.filterWaiting(response.getId());
    return new ResponseEntity(response.fromAppointments(appointments), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new queue.", response = Queue.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity postQueue(@RequestBody Queue queue) {
    return new ResponseEntity(queueService.postQueue(queue), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates a queue.", response = Queue.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateQueue(@RequestBody Queue queue) {
    return new ResponseEntity(queueService.updateQueue(queue), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates a queue's status.", response = Queue.class)
  @PutMapping(value = "/{queueId}/status/{status}", produces = "application/json")
  public ResponseEntity updateQueue(@PathVariable(value = "queueId") long queueId,
                                    @PathVariable(value = "status") String status) {
    return new ResponseEntity(queueService.updateStatus(queueId,status), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes a queue.")
  @DeleteMapping(value = "/delete/{queueId}")
  public ResponseEntity deleteQueue(@PathVariable(value = "queueId") long queueId) {
    queueService.deleteQueue(queueId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
