package app.model.response;

import app.model.Queue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class QueueRequest implements Serializable {

    @Getter
    @Setter
    long id;

    public QueueRequest fromQueue(Queue queue) {
        this.id=queue.getId();
        return this;
    }
}
