package com.example.dispositivosfx;

import com.example.dispositivosfx.models.Dispositivo;
import com.example.dispositivosfx.models.Inventario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;

public class HelloController {

    @FXML
    private ListView<Dispositivo> listaInventario;

    private Dispositivo dispositivoSeleccionado;

    private Inventario inventario;

    @FXML
    private ChoiceBox<String> tipoDipostivo;

    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtPrecio;

    @FXML
    private DatePicker txtfechaCompra;


    public void initialize() {
        inventario = new Inventario();
        inventario.setRutaImpresionLista("listaDispositivos.txt");
        tipoDipostivo.getItems().addAll("ORDENADOR", "PANTALLA", "IMPRESORA", "PROYECTOR", "PORTATIL", "ROUTER");
        rellenarLista();
        listaInventario.getItems().addAll(inventario.getListaDispositivos());
        listaInventario.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    dispositivoSeleccionado = newValue;
                    mostrarDispositivo();
                }
        );
    }

    private void rellenarLista() {
        Dispositivo dispositivo1 = new Dispositivo(LocalDate.of(2020,2,12), 1000, Dispositivo.TipoDispositivo.ORDENADOR, "HP", "Pavilion");
        Dispositivo dispositivo2 = new Dispositivo(LocalDate.of(2021,2,12), 1000, Dispositivo.TipoDispositivo.ROUTER, "CC", "Pavilion");
        Dispositivo dispositivo3 = new Dispositivo(LocalDate.of(2022,2,12), 1000, Dispositivo.TipoDispositivo.PANTALLA, "Sony", "Pavi");
        inventario.getListaDispositivos().add(dispositivo1);
        inventario.getListaDispositivos().add(dispositivo2);
        inventario.getListaDispositivos().add(dispositivo3);

    }

    private void limpiarCampos() {
        tipoDipostivo.setValue(null);
        txtMarca.clear();
        txtPrecio.clear();
        txtfechaCompra.setValue(null);
        txtModelo.clear();
    }

    private void mostrarDispositivo() {
        tipoDipostivo.setValue(dispositivoSeleccionado.getTipoAtributo().name());
        txtMarca.setText(dispositivoSeleccionado.getMarca());
        txtPrecio.setText(String.valueOf(dispositivoSeleccionado.getPrecio()));
        txtfechaCompra.setValue(dispositivoSeleccionado.getFechaCompra());
        txtModelo.setText(dispositivoSeleccionado.getModelo());
    }

    @FXML
    void altaDispositivo(ActionEvent event) {
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setTipoAtributo(Dispositivo.TipoDispositivo.valueOf(tipoDipostivo.getValue()));
        dispositivo.setMarca(txtMarca.getText());
        dispositivo.setPrecio(Double.parseDouble(txtPrecio.getText()));
        dispositivo.setFechaCompra(txtfechaCompra.getValue());
        dispositivo.setModelo(txtModelo.getText());
        inventario.getListaDispositivos().add(dispositivo);
        listaInventario.getItems().add(dispositivo);
        limpiarCampos();

    }

    @FXML
    void bajaDispositivo(ActionEvent event) {
        inventario.getListaDispositivos().remove(dispositivoSeleccionado);
        listaInventario.getItems().remove(dispositivoSeleccionado);
        limpiarCampos();
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
                writer.write("Modelo: " + dispositivo.getModelo() + ", ");
                writer.write("Fecha de compra: " + dispositivo.getFechaCompra() + "\n");
            }
            System.out.println("La lista de dispositivos se ha impreso en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al imprimir la lista de dispositivos en el archivo: " + e.getMessage());
        }


    }

    @FXML
    void modificarDispositivo(ActionEvent event) {
        dispositivoSeleccionado.setTipoAtributo(Dispositivo.TipoDispositivo.valueOf(tipoDipostivo.getValue()));
        dispositivoSeleccionado.setMarca(txtMarca.getText());
        dispositivoSeleccionado.setPrecio(Double.parseDouble(txtPrecio.getText()));
        dispositivoSeleccionado.setFechaCompra(txtfechaCompra.getValue());
        dispositivoSeleccionado.setModelo(txtModelo.getText());
        listaInventario.refresh();
        limpiarCampos();
    }



}
