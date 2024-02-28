package com.example.dispositivosfx.models;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    //    Lista[Dispositivos], Ordenación, RutaImpresiónLista[Dispositivos], Ordenación, RutaImpresión
    private List<Dispositivo> listaDispositivos = new ArrayList<>();
    private String ordenacion;

    private String rutaImpresionLista;

    public Inventario() {
    }

    public Inventario(ArrayList<Dispositivo> listaDispositivos, String ordenacion, String rutaImpresionLista) {
        this.listaDispositivos = listaDispositivos;
        this.ordenacion = ordenacion;
        this.rutaImpresionLista = rutaImpresionLista;
    }

    public List<Dispositivo> getListaDispositivos() {
        return listaDispositivos;
    }

    public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
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
