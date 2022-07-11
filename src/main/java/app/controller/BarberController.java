package app.controller;

import app.model.Barber;
import app.service.BarberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Controller for Barber services. */
@RestController
@RequestMapping("/barber")
public class BarberController {

  private BarberService barberService;

  public BarberController(BarberService barberService) {
    this.barberService = barberService;
  }

  @ApiOperation(value = "Search barber by ID.", response = Barber.class)
  @GetMapping(value = "/{barberId}", produces = "application/json")
  public ResponseEntity getBarber(@PathVariable(value = "barberId") long id) {
    return new ResponseEntity(barberService.getBarber(id), HttpStatus.OK);
  }

  @GetMapping(value = "/all", produces = "application/json")
  public ResponseEntity getAllBarbers() {
    return new ResponseEntity(barberService.getAllBarbers(), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new barber.", response = Barber.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity postBarber(@RequestBody Barber barber) {
    return new ResponseEntity(barberService.postBarber(barber), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates a barber.", response = Barber.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateBarber(@RequestBody Barber barber) {
    return new ResponseEntity(barberService.updateBarber(barber), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes a barber.")
  @DeleteMapping(value = "/delete/{barberId}")
  public ResponseEntity deleteBarber(@PathVariable(value = "barberId") long barberId) {
    barberService.deleteBarber(barberId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
