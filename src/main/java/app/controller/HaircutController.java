package app.controller;

import app.model.Haircut;
import app.service.HaircutService;
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

  private HaircutService haircutService;

  public HaircutController(HaircutService haircutService) {
    this.haircutService = haircutService;
  }

  @ApiOperation(value = "Search haircut by ID.", response = Haircut.class)
  @GetMapping(value = "/{haircutId}", produces = "application/json")
  public ResponseEntity getHaircut(@PathVariable(value = "haircutId") long id) {
    return new ResponseEntity(haircutService.getHaircut(id), HttpStatus.OK);
  }

  @GetMapping(value = "/all", produces = "application/json")
  public ResponseEntity getAllHaircuts() {
    return new ResponseEntity(haircutService.getAllHaircuts(), HttpStatus.OK);
  }

  @ApiOperation(value = "Creates a new haircut.", response = Haircut.class)
  @PostMapping(value = "/new", produces = "application/json")
  public ResponseEntity postHaircut(@RequestBody Haircut haircut) {
    return new ResponseEntity(haircutService.postHaircut(haircut), HttpStatus.OK);
  }

  @ApiOperation(value = "Updates a haircut.", response = Haircut.class)
  @PutMapping(value = "/update", produces = "application/json")
  public ResponseEntity updateHaircut(@RequestBody Haircut haircut) {
    return new ResponseEntity(haircutService.updateHaircut(haircut), HttpStatus.OK);
  }

  @ApiOperation(value = "Deletes a haircut.")
  @DeleteMapping(value = "/delete/{haircutId}", produces = "application/json")
  public ResponseEntity deleteHaircut(@PathVariable(value = "haircutId") long haircutId) {
    haircutService.deleteHaircut(haircutId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
