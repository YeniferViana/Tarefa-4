package Payroll;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private String placa;
    private String modelo;
    private String tipo;
    private Double valorDiaria;
    private Boolean disponivel;

    public Vehicle() {}

    public Vehicle(String placa, String modelo, String tipo, Double valorDiaria, Boolean disponivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }

    public Long getId() { return id; }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public String getTipo() { return tipo; }
    public Double getValorDiaria() { return valorDiaria; }
    public Boolean getDisponivel() { return disponivel; }

    public void setId(Long id) { this.id = id; }
    public void setPlaca(String placa) { this.placa = placa; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setValorDiaria(Double valorDiaria) { this.valorDiaria = valorDiaria; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}
