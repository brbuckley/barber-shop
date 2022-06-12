package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Appointment implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;

  @ApiModelProperty(example = "Esperando")
  @Setter
  private Status status;

  public String getStatus() {
    if (this.status == null) {
      return null;
    } else {
      return this.status.getValue();
    }
  }

  @ApiModelProperty(example = "11/6/2022")
  @Getter
  @Setter
  private Date date;

  @ManyToOne(optional = false)
  @Getter
  @Setter
  private Customer customer;

  @ManyToOne(optional = false)
  @Getter
  @Setter
  private Barber barber;

  @ManyToOne(optional = false)
  @Getter
  @Setter
  private Haircut haircut;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @ManyToOne
  @Getter
  @Setter
  private Queue queue;

  @ManyToOne @Getter @Setter private Payment payment;
}
