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
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Barber implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;

  @Getter @Setter private String name;

  @Getter @Setter private String username;

  @Getter @Setter private String email;

  @Getter @Setter private String passwordHash;

  @Getter @Setter private String address;

  @Getter @Setter private int age;

  @OneToMany(mappedBy = "barber", cascade = CascadeType.REMOVE)
  @Getter
  private List<Appointment> appointments = new ArrayList<>();

  @OneToOne(mappedBy = "barber")
  @Getter
  @Setter
  private Queue queue;

  @ManyToOne(optional = false)
  @Getter
  @Setter
  private Shop shop;
}
