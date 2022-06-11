package app.service;

import app.model.Barber;
import app.repository.BarberRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BarberService {

    private ObjectMapper mapper;
    @Setter private RestTemplate restTemplate;

    @Setter private BarberRepo barberRepo;

    /** Custom constructor with spring injected repository. */
    public BarberService(BarberRepo barberRepo) {
        this.restTemplate = new RestTemplateBuilder().build();
        this.barberRepo = barberRepo;
        this.mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        this.mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        this.mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    }

    public Barber getBarber(long id) throws JsonProcessingException {
        // findBy() vs getBy()
        return barberRepo.findById(id).get();
    }

    public Barber postBarber(Barber barber) throws JsonProcessingException {
        return barberRepo.save(barber);
    }

    public Barber updateBarber(Barber barber){
        Barber barberEntity = barberRepo.findById(barber.getId()).get();
        barberEntity=barber;
        barberRepo.save(barberEntity);
        return barberEntity;
    }

    public void deleteBarber(long barberId){
        barberRepo.deleteById(barberId);
    }

}
