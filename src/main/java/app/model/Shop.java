package app.model;

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
public class Shop implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;

  @Getter @Setter private String name;

  @Getter @Setter private String phone1;

  @Getter @Setter private String phone2;

  @Getter @Setter private String email;

  @Getter @Setter private String address;

  @OneToMany(mappedBy = "shop", cascade = CascadeType.REMOVE)
  @Getter
  private List<Barber> barbers = new ArrayList<>();

  @ManyToOne @Getter @Setter private City city;
}