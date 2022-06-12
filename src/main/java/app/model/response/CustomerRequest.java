package app.model.response;

import app.model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class CustomerRequest implements Serializable {

    @Getter
    @Setter
    long id;

    public CustomerRequest fromCustomer(Customer customer) {
        this.id = customer.getId();
        return this;
    }
}
