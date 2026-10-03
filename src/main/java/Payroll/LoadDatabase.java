package Payroll;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(VehicleRepository repository) {
        return args -> {
            repository.save(new Vehicle("ABC1D23", "Onix", "Carro", 120.0, true));
            repository.save(new Vehicle("XYZ4E56", "CG 160", "Moto", 80.0, true));
        };
    }
}
