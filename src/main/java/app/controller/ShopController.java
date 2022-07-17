package app.controller;

import app.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Controller for Shop services. */
@RestController
@RequestMapping("/shop")
public class ShopController {

  private ShopService service;

  public ShopController(ShopService service) {
    this.service = service;
  }

  @GetMapping(value = "/{shopId}", produces = "application/json")
  public ResponseEntity getAdmin(@PathVariable(value = "shopId") long id) {
    return new ResponseEntity(service.getShop(id), HttpStatus.OK);
  }
}
