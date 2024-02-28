package com.example.dispositivosfx.models;

import java.time.LocalDate;

/**
 * This class represents a device.
 * It has attributes like id, purchase date, price, type, brand, and model.
 */
public class Dispositivo {
    /**
     * This enum represents the type of the device.
     * It can be a computer, screen, printer, projector, laptop, or router.
     */
    public enum TipoDispositivo {
        ORDENADOR, PANTALLA, IMPRESORA, PROYECTOR, PORTATIL, ROUTER;


    }
    //•	Atributos: Identificador, FechaCompra, Precio, Tipo Atributo, Marca, Modelo,

    private int id;
    private LocalDate fechaCompra;
    private double precio;
    private TipoDispositivo tipoAtributo;
    private String marca;
    private String modelo;
    /**
     * This enum represents the type of the device.
     * It can be a computer, screen, printer, projector, laptop, or router.
     */
    public Dispositivo(LocalDate fechaCompra, double precio, TipoDispositivo tipoAtributo, String marca, String modelo) {
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.tipoAtributo = tipoAtributo;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * This constructor initializes a new device with no attributes.
     */
    public Dispositivo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoDispositivo getTipoAtributo() {
        return tipoAtributo;
    }

    public void setTipoAtributo(TipoDispositivo tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * This method returns a string representation of the device.
     * It includes the type, brand, and model of the device.
     */
    @Override
    public String toString() {
        return
                tipoAtributo + " " + marca + " " + modelo;
    }
}
