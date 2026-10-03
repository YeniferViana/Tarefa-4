package Payroll;

import java.util.List;
import org.springframework.http.HttpStatus; // <-- IMPORTANTE: Esta línea faltaba
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "*")
class VehicleController {  

    private final VehicleRepository repository;

    VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Vehicle> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Vehicle one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(id));
    }

    @PostMapping
    Vehicle newVehicle(@RequestBody Vehicle newVehicle) {
        return repository.save(newVehicle);
    }

    @PutMapping("/{id}")
    Vehicle replaceVehicle(@RequestBody Vehicle newVehicle, @PathVariable Long id) {
        return repository.findById(id)
                .map(vehicle -> {
                    vehicle.setPlaca(newVehicle.getPlaca());
                    vehicle.setModelo(newVehicle.getModelo());
                    vehicle.setTipo(newVehicle.getTipo());
                    vehicle.setValorDiaria(newVehicle.getValorDiaria());
                    vehicle.setDisponivel(newVehicle.getDisponivel());
                    return repository.save(vehicle);
                })
                .orElseThrow(() -> new VehicleNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteVehicle(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new VehicleNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
