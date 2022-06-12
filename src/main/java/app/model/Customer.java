package app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;

  @ApiModelProperty(example = "João")
  @Getter @Setter private String name;

  @ApiModelProperty(example = "joaozinho99")
  @Getter @Setter private String username;

  @ApiModelProperty(example = "joao99silva@gmail.com")
  @Getter @Setter private String email;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Getter
  @Setter
  @ApiModelProperty(example = "d341fd43df066c445a13820099354e07d9db466a780bd642097f8d03d8b7065e")
  private String passwordHash;

  @ApiModelProperty(example = "Rua do Joao, 12")
  @Getter @Setter private String address;

  @ApiModelProperty(example = "23")
  @Getter @Setter private Integer age;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  @ApiModelProperty(example = "01/02/1999")
  private Date birthDay;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
  @Getter
  @JsonIgnore
  private List<Appointment> appointments = new ArrayList<>();
}
