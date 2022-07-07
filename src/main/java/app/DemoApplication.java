package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/** Springboot main class. */
@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

  /**
   * Springboot main method.
   *
   * @param args CLI arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}
