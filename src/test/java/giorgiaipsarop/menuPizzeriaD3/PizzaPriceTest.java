package giorgiaipsarop.menuPizzeriaD3;

import giorgiaipsarop.menuPizzeriaD3.entities.classes.Pizza;
import giorgiaipsarop.menuPizzeriaD3.entities.misc.AppConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaPriceTest {

    private static AnnotationConfigApplicationContext ctx;

    @BeforeAll
    static void setup() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @AfterAll
    static void clear() {
        ctx.close();
    }

    @Test
    public void testPizzaPrices() {
        // Ottieni i bean delle pizze
        Pizza margherita = (Pizza) ctx.getBean("pizza_margherita");
        Pizza hawaiian = (Pizza) ctx.getBean("hawaiian_pizza");
        Pizza salamiPizza = (Pizza) ctx.getBean("salami_pizza");
        Pizza salamiXLPizza = (Pizza) ctx.getBean("salami_pizza_xl");

        // Verifica i prezzi delle pizze
        assertEquals(4.3 + 0.0 + 0.69, margherita.getPrice(), 0.01, "Il prezzo della Pizza Margherita non è corretto");
        assertEquals(4.3 + 0.69 + 0.99 + 0.79, hawaiian.getPrice(), 0.01, "Il prezzo della Hawaiian Pizza non è corretto");
        assertEquals(4.3 + 0.69 + 0.99, salamiPizza.getPrice(), 0.01, "Il prezzo della Salami Pizza non è corretto");
        assertEquals(4.3 + 0.69 + 0.99, salamiXLPizza.getPrice(), 0.01, "Il prezzo della Salami Pizza XL non è corretto");
    }
}
