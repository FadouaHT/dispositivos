package com.example.dispositivosfx;

import com.example.dispositivosfx.models.Dispositivo;
import com.example.dispositivosfx.models.Inventario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

public class HelloController {

    @FXML
    private ListView<Dispositivo> listaInventario;

    private Dispositivo dispositivoSeleccionado;

    private Inventario inventario;

    @FXML
    private TextField txtDispositivo;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtfechaCompra;

    public void initialize() {
        inventario = new Inventario();
        listaInventario.getItems().addAll(inventario.getListaDispositivos());
        listaInventario.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    dispositivoSeleccionado = newValue;
                    mostrarDispositivo();
                }
        );
    }

    private void mostrarDispositivo() {
        txtDispositivo.setText(dispositivoSeleccionado.getTipoAtributo().name());
        txtMarca.setText(dispositivoSeleccionado.getMarca());
        txtPrecio.setText(String.valueOf(dispositivoSeleccionado.getPrecio()));
        txtfechaCompra.setText(dispositivoSeleccionado.getFechaCompra());
    }

    @FXML
    void altaDispositivo(ActionEvent event) {
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setTipoAtributo(Dispositivo.TipoDispositivo.valueOf(txtDispositivo.getText()));
        dispositivo.setMarca(txtMarca.getText());
        dispositivo.setPrecio(Double.parseDouble(txtPrecio.getText()));
        dispositivo.setFechaCompra(txtfechaCompra.getText());
        inventario.getListaDispositivos().add(dispositivo);
        listaInventario.getItems().add(dispositivo);

    }

    @FXML
    void bajaDispositivo(ActionEvent event) {
        inventario.getListaDispositivos().remove(dispositivoSeleccionado);
        listaInventario.getItems().remove(dispositivoSeleccionado);
    }

    @FXML
    void imprimirDispositivo(ActionEvent event) {
        //imprimir la lista de dispositivos en un txt
        // Nombre del archivo donde se imprimirá la lista de dispositivos
        String nombreArchivo = inventario.getRutaImpresionLista();

        // Obtener la ruta absoluta del archivo
        String rutaAbsoluta = new File(nombreArchivo).getAbsolutePath();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaAbsoluta))) {
            // Iterar sobre la lista de dispositivos e imprimir cada uno en una nueva línea
            for (Dispositivo dispositivo : inventario.getListaDispositivos()) {
                writer.write("Tipo: " + dispositivo.getTipoAtributo().name() + ", ");
                writer.write("Marca: " + dispositivo.getMarca() + ", ");
                writer.write("Precio: " + dispositivo.getPrecio() + ", ");
                writer.write("Fecha de compra: " + dispositivo.getFechaCompra() + "\n");
            }
            System.out.println("La lista de dispositivos se ha impreso en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al imprimir la lista de dispositivos en el archivo: " + e.getMessage());
        }


    }

    @FXML
    void modificarDispositivo(ActionEvent event) {
        dispositivoSeleccionado.setTipoAtributo(Dispositivo.TipoDispositivo.valueOf(txtDispositivo.getText()));
        dispositivoSeleccionado.setMarca(txtMarca.getText());
        dispositivoSeleccionado.setPrecio(Double.parseDouble(txtPrecio.getText()));
        dispositivoSeleccionado.setFechaCompra(txtfechaCompra.getText());
        listaInventario.refresh();
    }

    @FXML
    void odenarFecha(ActionEvent event) {
        //ordenar por fecha de compra
        inventario.setOrdenacion("Fecha");
        //ordenar la lista de dispositivos por fecha de compra
        listaInventario.getItems().sort(Comparator.comparing(Dispositivo::getFechaCompra));

    }

}
