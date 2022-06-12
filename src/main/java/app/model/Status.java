package app.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum Status {
  WAITING("Esperando"),
  CUTTING("Cortando"),
  FINISHED("Concluído"),
  CANCELED("Cancelado");

  private String value;

  Status(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  /**
   * String to gender.
   *
   * @param text Gender lowercase.
   * @return Gender object.
   */
  public static Status fromValue(String text) {
    for (Status b : Status.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
