package app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shop implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;

  @ApiModelProperty(example = "Barbearia do Zé")
  @Getter
  @Setter
  private String name;

  @ApiModelProperty(example = "3741-2500")
  @Getter
  @Setter
  private String phone1;

  @ApiModelProperty(example = "3741-2600")
  @Getter
  @Setter
  private String phone2;

  @ApiModelProperty(example = "barbeariadoze@gmail.com")
  @Getter
  @Setter
  private String email;

  @ApiModelProperty(example = "Rua Mem de Sá, 151 - Icaraí")
  @Getter
  @Setter
  private String address;

  @OneToMany(mappedBy = "shop", cascade = CascadeType.REMOVE)
  @Getter
  private List<Barber> barbers = new ArrayList<>();

  @ManyToOne @Getter @Setter private City city;
}
