package com.example.dispositivosfx.models;

public class Inventario {
    //    Lista[Dispositivos], Ordenación, RutaImpresiónLista[Dispositivos], Ordenación, RutaImpresión
    private Dispositivo[] listaDispositivos;
    private String ordenacion;

    private String rutaImpresionLista;

    public Inventario(Dispositivo[] listaDispositivos, String ordenacion, String rutaImpresionLista) {
        this.listaDispositivos = listaDispositivos;
        this.ordenacion = ordenacion;
        this.rutaImpresionLista = rutaImpresionLista;
    }

    public Dispositivo[] getListaDispositivos() {
        return listaDispositivos;
    }

    public void setListaDispositivos(Dispositivo[] listaDispositivos) {
        this.listaDispositivos = listaDispositivos;
    }

    public String getOrdenacion() {
        return ordenacion;
    }

    public void setOrdenacion(String ordenacion) {
        this.ordenacion = ordenacion;
    }

    public String getRutaImpresionLista() {
        return rutaImpresionLista;
    }

    public void setRutaImpresionLista(String rutaImpresionLista) {
        this.rutaImpresionLista = rutaImpresionLista;
    }
}
