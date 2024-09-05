package giorgiaipsarop.menuPizzeriaD3;

import giorgiaipsarop.menuPizzeriaD3.entities.classes.Pizza;
import giorgiaipsarop.menuPizzeriaD3.entities.classes.Topping;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    @Test
    public void testPizzaPrices() {

        Topping tomato = new Topping("Tomato", 0, 0.0);
        Topping cheese = new Topping("Cheese", 92, 0.69);
        Topping ham = new Topping("Ham", 35, 0.99);
        Topping pineapple = new Topping("Pineapple", 24, 0.79);
        Topping salami = new Topping("Salami", 86, 0.99);


        List<Topping> margheritaToppings = new ArrayList<>();
        margheritaToppings.add(tomato);
        margheritaToppings.add(cheese);
        Pizza margherita = new Pizza("Pizza Margherita", margheritaToppings, false);

        List<Topping> hawaiianToppings = new ArrayList<>();
        hawaiianToppings.add(tomato);
        hawaiianToppings.add(cheese);
        hawaiianToppings.add(ham);
        hawaiianToppings.add(pineapple);
        Pizza hawaiian = new Pizza("Hawaiian Pizza", hawaiianToppings, false);

        List<Topping> salamiToppings = new ArrayList<>();
        salamiToppings.add(tomato);
        salamiToppings.add(cheese);
        salamiToppings.add(salami);
        Pizza salamiPizza = new Pizza("Salami Pizza", salamiToppings, false);

        List<Topping> salamiXLToppings = new ArrayList<>();
        salamiXLToppings.add(tomato);
        salamiXLToppings.add(cheese);
        salamiXLToppings.add(salami);
        Pizza salamiXLPizza = new Pizza("Salami Pizza XL", salamiXLToppings, true);

        // Verifica i prezzi delle pizze
        assertEquals(4.3 + 0.0 + 0.69, margherita.getPrice(), 0.01, "Il prezzo della Pizza Margherita non è corretto");
        assertEquals(4.3 + 0.69 + 0.99 + 0.79, hawaiian.getPrice(), 0.01, "Il prezzo della Hawaiian Pizza non è corretto");
        assertEquals(4.3 + 0.69 + 0.99, salamiPizza.getPrice(), 0.01, "Il prezzo della Salami Pizza non è corretto");
        assertEquals(4.3 + 0.69 + 0.99, salamiXLPizza.getPrice(), 0.01, "Il prezzo della Salami Pizza XL non è corretto");
    }
}
