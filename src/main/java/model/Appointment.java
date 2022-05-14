package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Date;

@Entity
@NoArgsConstructor
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Getter
    @Setter
    private String status;

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

    @ManyToOne
    @Getter
    @Setter
    private Queue queue;

    @OneToOne(mappedBy = "appointment")
    @Getter
    @Setter
    private Reservation reservation;

    @ManyToOne
    @Getter @Setter
    private Payment payment;
}
