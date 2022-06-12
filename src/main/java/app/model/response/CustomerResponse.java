package app.model.response;

import app.model.Customer;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse implements Serializable {

  @Getter @Setter private long id;

  @ApiModelProperty(example = "João")
  @Getter
  @Setter
  private String name;

  public CustomerResponse fromCustomer(Customer customer) {
    this.id = customer.getId();
    this.name = customer.getName();
    return this;
  }
}
