package com.example.dispositivosfx.models;

import java.time.LocalDate;

public class Dispositivo {
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

    public Dispositivo(LocalDate fechaCompra, double precio, TipoDispositivo tipoAtributo, String marca, String modelo) {
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.tipoAtributo = tipoAtributo;
        this.marca = marca;
        this.modelo = modelo;
    }

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

    @Override
    public String toString() {
        return
                tipoAtributo + " " + marca + " " + modelo;
    }
}
