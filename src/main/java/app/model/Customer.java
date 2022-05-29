package app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

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

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date birthDay;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
  @Getter
  @JsonIgnore
  private List<Appointment> appointments = new ArrayList<>();
}
