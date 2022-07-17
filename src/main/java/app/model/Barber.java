package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Barber implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;

  @ApiModelProperty(example = "Zé")
  @Getter
  @Setter
  private String name;

  @ApiModelProperty(example = "zebarbeiro")
  @Getter
  @Setter
  private String username;

  @ApiModelProperty(example = "zebarbeiro@gmail.com")
  @Getter
  @Setter
  private String email;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Getter
  @Setter
  @ApiModelProperty(example = "11253981b29c11f5c01a392db940846a809e2022993ab0ca5d13ae95c3b8456b")
  private String passwordHash;

  @ApiModelProperty(example = "Rua do Zé, 123")
  @Getter
  @Setter
  private String address;

  @ApiModelProperty(example = "32")
  @Getter
  @Setter
  private Integer age;

  @OneToMany(mappedBy = "barber", cascade = CascadeType.REMOVE)
  @Getter
  @JsonIgnore
  private List<Appointment> appointments = new ArrayList<>();

  @OneToOne(mappedBy = "barber")
  @Getter
  @Setter
  @JsonIgnore
  private Queue queue;

  @ManyToOne
  @Getter
  @Setter
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Shop shop;

  public Barber(long id) {
    this.id = id;
  }
}
