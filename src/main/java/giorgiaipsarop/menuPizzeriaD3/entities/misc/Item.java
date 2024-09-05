package giorgiaipsarop.menuPizzeriaD3.entities.misc;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class Item {

    protected long id;

    protected int calories;

    protected double price;

    public Item(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

}