package app.service;

import app.model.Queue;
import app.repository.QueueRepo;
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
public class QueueService {

    private ObjectMapper mapper;
    @Setter private RestTemplate restTemplate;

    @Setter private QueueRepo queueRepo;

    /** Custom constructor with spring injected repository. */
    public QueueService(QueueRepo queueRepo) {
        this.restTemplate = new RestTemplateBuilder().build();
        this.queueRepo = queueRepo;
        this.mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        this.mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        this.mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    }

    public Queue getQueue(long id) throws JsonProcessingException {
        // findBy() vs getBy()
        return queueRepo.findById(id).get();
    }

    public Queue postQueue(Queue queue) throws JsonProcessingException {
        return queueRepo.save(queue);
    }

    public Queue updateQueue(Queue queue) {
        Queue queueEntity = queueRepo.findById(queue.getId()).get();
        queueEntity = queue;
        queueRepo.save(queueEntity);
        return queueEntity;
    }

    public void deleteQueue(long queueId) {
        queueRepo.deleteById(queueId);
    }
}
