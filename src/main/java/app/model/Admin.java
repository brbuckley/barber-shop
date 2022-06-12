package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;

  @ApiModelProperty(example = "José Viterbo")
  @Getter
  @Setter
  private String name;

  @ApiModelProperty(example = "jviterbo")
  @Getter
  @Setter
  private String username;

  @ApiModelProperty(example = "viterbo@gmail.com")
  @Getter
  @Setter
  private String email;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Getter
  @Setter
  @ApiModelProperty(example = "dfb88348fd3752550838ce95418e76d76010d66c2a33cafe5345d5a4b522fff6")
  private String passwordHash;
}
