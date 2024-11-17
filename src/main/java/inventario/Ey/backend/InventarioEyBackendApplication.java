package inventario.Ey.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class InventarioEyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioEyBackendApplication.class, args);
    }

}
