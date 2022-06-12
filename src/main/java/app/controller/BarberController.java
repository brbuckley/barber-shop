package app.controller;

import app.model.Barber;
import app.repository.BarberRepo;
import app.service.BarberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ExampleProperty;
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

  /**
   * GET request for barber by id.
   *
   * @param id The id of the barber.
   * @return Barber.
   * @throws JsonProcessingException Exceptions while parsing the JSON response.
   */
  @ApiResponses(
      value = {
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
      })
  @ApiOperation(value = "Search barber by ID.", response = Barber.class)
  @GetMapping(value = "/{barberId}", produces = "application/json")
  public ResponseEntity getBarber(@PathVariable(value = "barberId") long id)
      throws JsonProcessingException {
    return new ResponseEntity(new BarberService(barberRepo).getBarber(id), HttpStatus.OK);
  }

  /**
   * POST request to add a new Barber.
   *
   * @param barber The new barber.
   * @return Barber.
   * @throws JsonProcessingException Exceptions while parsing the JSON response.
   */
  @ApiResponses(
      value = {
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
      })
  @ApiOperation(value = "Creates a new barber.", response = Barber.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity getBarber(@RequestBody Barber barber) throws JsonProcessingException {
    return new ResponseEntity(new BarberService(barberRepo).postBarber(barber), HttpStatus.OK);
  }

  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateBarber(@RequestBody Barber barber) throws JsonProcessingException {
    return new ResponseEntity(new BarberService(barberRepo).updateBarber(barber), HttpStatus.OK);
  }

  @DeleteMapping(value = "/delete/{barberId}")
  public ResponseEntity deleteBarber(@PathVariable(value = "barberId") long barberId)
      throws JsonProcessingException {
    BarberService barberService = new BarberService(barberRepo);
    barberService.deleteBarber(barberId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
