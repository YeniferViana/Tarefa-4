package Payroll;

class VehicleNotFoundException extends RuntimeException {

    VehicleNotFoundException(Long id) {
        super("Veículo não encontrado: " + id);
    }
}
