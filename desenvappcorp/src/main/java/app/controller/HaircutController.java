package app.controller;

import app.model.Haircut;
import app.repository.HaircutRepo;
import app.service.HaircutService;
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

/** Controller for Haircut services. */
@RestController
@RequestMapping("/haircut")
public class HaircutController {

  private HaircutRepo haircutRepo;

  public HaircutController(HaircutRepo haircutRepo) {
    this.haircutRepo = haircutRepo;
  }

  @ApiOperation(value = "Search haircut by ID.", response = Haircut.class)
  @GetMapping(value = "/{haircutId}", produces = "application/json")
  public ResponseEntity getHaircut(@PathVariable(value = "haircutId") long id)
      throws JsonProcessingException {
    return new ResponseEntity(new HaircutService(haircutRepo).getHaircut(id), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new haircut.", response = Haircut.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity getHaircut(@RequestBody Haircut haircut) throws JsonProcessingException {
    return new ResponseEntity(new HaircutService(haircutRepo).postHaircut(haircut), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates a haircut.", response = Haircut.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateHaircut(@RequestBody Haircut haircut) {
    return new ResponseEntity(
        new HaircutService(haircutRepo).updateHaircut(haircut), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes a haircut.")
  @DeleteMapping(value = "/delete/{haircutId}", produces = "application/json")
  public ResponseEntity deleteHaircut(@PathVariable(value = "haircutId") long haircutId) {
    new HaircutService(haircutRepo).deleteHaircut(haircutId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
