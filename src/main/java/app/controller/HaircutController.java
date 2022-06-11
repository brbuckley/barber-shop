package app.controller;

import app.model.Haircut;
import app.repository.HaircutRepo;
import app.service.HaircutService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * GET request for haircut by id.
     *
     * @param id The id of the haircut.
     * @return Haircut.
     * @throws JsonProcessingException Exceptions while parsing the JSON response.
     */
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
            })
    @ApiOperation(value = "Search haircut by ID.", response = Haircut.class)
    @GetMapping(value = "/{haircutId}", produces = "application/json")
    public ResponseEntity getHaircut(@PathVariable(value = "haircutId") long id)
            throws JsonProcessingException {
        return new ResponseEntity(new HaircutService(haircutRepo).getHaircut(id), HttpStatus.OK);
    }

    /**
     * POST request to add a new Haircut.
     *
     * @param id The id of the haircut.
     * @return Haircut.
     * @throws JsonProcessingException Exceptions while parsing the JSON response.
     */
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
            })
    @ApiOperation(value = "Creates a new haircut.", response = Haircut.class)
    @PostMapping(value = "/newHaircut", produces = "application/json")
    public ResponseEntity getHaircut(@RequestBody Haircut haircut) throws JsonProcessingException {
        return new ResponseEntity(
                new HaircutService(haircutRepo).postHaircut(haircut), HttpStatus.OK);
    }

    @PutMapping(value="/updateHaircut", produces = "application/json")
    public ResponseEntity updateHaircut(@RequestBody Haircut haircut) throws JsonProcessingException {
        return new ResponseEntity(
                new HaircutService(haircutRepo).updateHaircut(haircut), HttpStatus.OK);
    }

    /**
    @DeleteMapping(value="/deleteHaircut", produces = "application/json")
    public ResponseEntity deleteHaircut(@RequestBody Haircut haircut) throws JsonProcessingException {
        return new ResponseEntity(
                new HaircutService(haircutRepo).deleteHaircut(haircut), HttpStatus.OK);
    }
    */
}
