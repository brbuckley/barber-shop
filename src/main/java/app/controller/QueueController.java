package app.controller;

import app.model.Queue;
import app.repository.QueueRepo;
import app.service.QueueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Controller for Queue services. */
@RestController
@RequestMapping("/queue")
public class QueueController {

    private QueueRepo queueRepo;

    public QueueController(QueueRepo queueRepo) {
        this.queueRepo = queueRepo;
    }

    /**
     * GET request for queue by id.
     *
     * @param id The id of the queue.
     * @return Queue.
     * @throws JsonProcessingException Exceptions while parsing the JSON response.
     */
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
            })
    @ApiOperation(value = "Search queue by ID.", response = Queue.class)
    @GetMapping(value = "/{queueId}", produces = "application/json")
    public ResponseEntity getQueue(@PathVariable(value = "queueId") long id)
            throws JsonProcessingException {
        return new ResponseEntity(new QueueService(queueRepo).getQueue(id), HttpStatus.OK);
    }

    /**
     * POST request to add a new Queue.
     *
     * @param id The id of the queue.
     * @return Queue.
     * @throws JsonProcessingException Exceptions while parsing the JSON response.
     */
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
            })
    @ApiOperation(value = "Creates a new queue.", response = Queue.class)
    @PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity getQueue(@RequestBody Queue queue) throws JsonProcessingException {
        return new ResponseEntity(new QueueService(queueRepo).postQueue(queue), HttpStatus.OK);
    }

    @PutMapping(value = "/update", produces = "application/json")
    public ResponseEntity updateQueue(@RequestBody Queue queue) throws JsonProcessingException {
        return new ResponseEntity(new QueueService(queueRepo).updateQueue(queue), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{queueId}")
    public ResponseEntity deleteQueue(@PathVariable(value = "queueId") long queueId)
            throws JsonProcessingException {
        QueueService queueService = new QueueService(queueRepo);
        queueService.deleteQueue(queueId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
