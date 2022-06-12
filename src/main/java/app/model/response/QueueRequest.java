package app.model.response;

import app.model.Queue;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

public class QueueRequest implements Serializable {

  @Getter @Setter long id;

  public QueueRequest fromQueue(Queue queue) {
    this.id = queue.getId();
    return this;
  }
}
