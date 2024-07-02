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
/**
 * This class is a controller for the Hello view.
 * It manages the interactions between the user and the UI.
 */
public class HelloController {

    @FXML
    private ListView<Dispositivo> listaInventario;

    private Dispositivo dispositivoSeleccionado;

    private Inventario inventario;
    private String hola;

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

    /**
     * This method initializes the controller.
     * It sets up the ListView and the ChoiceBox, and populates the ListView with the devices in the inventory.
     */
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
    /**
     * This method populates the inventory with some sample devices.
     */
    private void rellenarLista() {
        Dispositivo dispositivo1 = new Dispositivo(LocalDate.of(2020,2,12), 1000, Dispositivo.TipoDispositivo.ORDENADOR, "HP", "Pavilion");
        Dispositivo dispositivo2 = new Dispositivo(LocalDate.of(2021,2,12), 1000, Dispositivo.TipoDispositivo.ROUTER, "CC", "Pavilion");
        Dispositivo dispositivo3 = new Dispositivo(LocalDate.of(2022,2,12), 1000, Dispositivo.TipoDispositivo.PANTALLA, "Sony", "Pavi");
        inventario.getListaDispositivos().add(dispositivo1);
        inventario.getListaDispositivos().add(dispositivo2);
        inventario.getListaDispositivos().add(dispositivo3);

    }

    /**
     * This method clears all the input fields.
     */
    private void limpiarCampos() {
        tipoDipostivo.setValue(null);
        txtMarca.clear();
        txtPrecio.clear();
        txtfechaCompra.setValue(null);
        txtModelo.clear();
    }
    /**
     * This method displays the details of the currently selected device in the input fields.
     */
    private void mostrarDispositivo() {
        tipoDipostivo.setValue(dispositivoSeleccionado.getTipoAtributo().name());
        txtMarca.setText(dispositivoSeleccionado.getMarca());
        txtPrecio.setText(String.valueOf(dispositivoSeleccionado.getPrecio()));
        txtfechaCompra.setValue(dispositivoSeleccionado.getFechaCompra());
        txtModelo.setText(dispositivoSeleccionado.getModelo());
    }
    /**
     * This method is called when the user clicks the "Alta" button.
     * It creates a new device with the details from the input fields, adds it to the inventory and the ListView, and clears the input fields.
     * @param event The ActionEvent object representing the button click event.
     */
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
    /**
     * This method is called when the user clicks the "Baja" button.
     * It removes the currently selected device from the inventory and the ListView, and clears the input fields.
     * @param event The ActionEvent object representing the button click event.
     */
    @FXML
    void bajaDispositivo(ActionEvent event) {
        inventario.getListaDispositivos().remove(dispositivoSeleccionado);
        listaInventario.getItems().remove(dispositivoSeleccionado);
        limpiarCampos();
    }
    /**
     * This method is called when the user clicks the "Imprimir" button.
     * It prints the list of devices in the inventory to a text file.
     * @param event The ActionEvent object representing the button click event.
     */
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
    /**
     * This method is called when the user clicks the "Imprimir" button.
     * It prints the list of devices in the inventory to a text file.
     * @param event The ActionEvent object representing the button click event.
     */
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
