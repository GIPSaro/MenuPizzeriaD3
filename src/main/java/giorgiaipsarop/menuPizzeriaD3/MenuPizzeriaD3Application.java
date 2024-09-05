package giorgiaipsarop.menuPizzeriaD3;



import giorgiaipsarop.menuPizzeriaD3.entities.classes.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MenuPizzeriaD3Application {

	public static void main(String[] args) {

		SpringApplication.run(MenuPizzeriaD3Application.class, args);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuPizzeriaD3Application.class);
		Menu m = (Menu) ctx.getBean("menu");

		m.printMenu();
		ctx.close();
	}

}

