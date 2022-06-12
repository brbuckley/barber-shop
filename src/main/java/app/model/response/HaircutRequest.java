package app.model.response;

import app.model.Haircut;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class HaircutRequest implements Serializable {

    @Getter
    @Setter
    long id;

    public HaircutRequest fromHaircut(Haircut haircut) {
        this.id = haircut.getId();
        return this;
    }
}
