package app.service;

import app.model.Haircut;
import app.repository.HaircutRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HaircutService {

  private ObjectMapper mapper;
  @Setter private RestTemplate restTemplate;

  @Setter private HaircutRepo haircutRepo;

  /** Custom constructor with spring injected repository. */
  public HaircutService(HaircutRepo haircutRepo) {
    this.restTemplate = new RestTemplateBuilder().build();
    this.haircutRepo = haircutRepo;
    this.mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    this.mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
    this.mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
  }

  public Haircut getHaircut(long id) throws JsonProcessingException {
    // findBy() vs getBy()
    return haircutRepo.findById(id).get();
  }

  public Haircut postHaircut(Haircut haircut) throws JsonProcessingException {
    return haircutRepo.save(haircut);
  }

  public Haircut updateHaircut(Haircut haircut) {
    Haircut haircutEntity = haircutRepo.findById(haircut.getId()).get();
    haircutEntity = haircut;
    haircutRepo.save(haircutEntity);
    return haircutEntity;
  }
}
