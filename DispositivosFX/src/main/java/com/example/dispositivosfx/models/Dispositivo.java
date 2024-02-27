package com.example.dispositivosfx.models;

public class Dispositivo {
    enum TipoDispositivo {
        ORDENADOR, PANTALLA, IMPRESORA, PROYECTOR, PORTATIL, ROUTER;
    }
    //•	Atributos: Identificador, FechaCompra, Precio, Tipo Atributo, Marca, Modelo,

    private int id;
    private String fechaCompra;
    private double precio;
    private TipoDispositivo tipoAtributo;
    private String marca;
    private String modelo;

    public Dispositivo(String fechaCompra, double precio, TipoDispositivo tipoAtributo, String marca, String modelo) {
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.tipoAtributo = tipoAtributo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
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
}
