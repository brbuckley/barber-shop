package app.controller;

import app.model.Barber;
import app.repository.BarberRepo;
import app.service.BarberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Controller for Barber services. */
@RestController
@RequestMapping("/barber")
public class BarberController {

  private BarberRepo barberRepo;

  public BarberController(BarberRepo barberRepo) {
    this.barberRepo = barberRepo;
  }

  @ApiOperation(value = "Search barber by ID.", response = Barber.class)
  @GetMapping(value = "/{barberId}", produces = "application/json")
  public ResponseEntity getBarber(@PathVariable(value = "barberId") long id)
      throws JsonProcessingException {
    return new ResponseEntity(new BarberService(barberRepo).getBarber(id), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new barber.", response = Barber.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity getBarber(@RequestBody Barber barber) throws JsonProcessingException {
    return new ResponseEntity(new BarberService(barberRepo).postBarber(barber), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates a barber.", response = Barber.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateBarber(@RequestBody Barber barber) {
    return new ResponseEntity(new BarberService(barberRepo).updateBarber(barber), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes a barber.")
  @DeleteMapping(value = "/delete/{barberId}")
  public ResponseEntity deleteBarber(@PathVariable(value = "barberId") long barberId) {
    BarberService barberService = new BarberService(barberRepo);
    barberService.deleteBarber(barberId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
