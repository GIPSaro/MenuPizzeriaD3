package giorgiaipsarop.menuPizzeriaD3;



import giorgiaipsarop.menuPizzeriaD3.entities.classes.Pizza;
import giorgiaipsarop.menuPizzeriaD3.entities.classes.Table;
import giorgiaipsarop.menuPizzeriaD3.entities.misc.AppConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
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
    public void testSeatPriceLoadedFromProperties() {
        Table t1 = (Table) ctx.getBean("Tavolo1");
        Table t2 = (Table) ctx.getBean("Tavolo2");
        Table t3 = (Table) ctx.getBean("Tavolo3");

        double expectedSeatPrice = 2.00;
        assertEquals(expectedSeatPrice, t1.getCostoCoperto());
        assertEquals(expectedSeatPrice, t2.getCostoCoperto());
        assertEquals(expectedSeatPrice, t3.getCostoCoperto());
    }

    @Test
    public void testIfPizzaIsXL() {
        Pizza p1 = (Pizza) ctx.getBean("salami_pizza_xl");
        Pizza p2 = (Pizza) ctx.getBean("pizza_margherita");

        assertTrue(p1.isXl());
        assertFalse(p2.isXl());
    }

    @ParameterizedTest
    @CsvSource({
            "pizza_margherita, Pizza Margherita, 4.99",
            "hawaiian_pizza, Hawaiian Pizza, 6.77",
            "salami_pizza, Salami Pizza, 5.97",

    })
    public void testPizzaProperties(String beanName, String name, double price) {
        Pizza p = (Pizza) ctx.getBean(beanName);
        assertEquals(name, p.getName());
        assertEquals(price, p.getPrice(), 0.01); // Usa una tolleranza per i confronti di double
    }
}
