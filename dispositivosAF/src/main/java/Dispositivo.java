import java.time.LocalDate;
import java.util.ArrayList;

public class Dispositivo {

    enum TipoDispositivo {
        ORDENADOR, PANTALLA, IMPRESORA, PROYECTOR, PORTATIL, ROUTER;
    }
    //Atributos: Identificador, FechaCompra, Precio, Tipo Atributo, Marca, Modelo,
    private String id;
    private LocalDate fechaCompra;
    private double precio;
    private TipoDispositivo tipoAtributo;
    private String marca;
    private String modelo;
    private static ArrayList<TipoDispositivo> tiposDispositivos = new ArrayList<>();

    public Dispositivo(String id, LocalDate fechaCompra, double precio, TipoDispositivo tipoAtributo, String marca, String modelo) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.tipoAtributo = tipoAtributo;
        this.marca = marca;
        this.modelo = modelo;
    }
    //Métodos : AltaDispositivo(), BajaDispositivo(), ModificarDispositivo().
    public static void altaDispositivo(TipoDispositivo nuevoTipoDispositivo) {
        if (!tiposDispositivos.contains(nuevoTipoDispositivo)) {
            tiposDispositivos.add(nuevoTipoDispositivo);
        }
    }

    public static void bajaDispositivo(TipoDispositivo tipoDispositivoAEliminar) {
        tiposDispositivos.remove(tipoDispositivoAEliminar);
    }

    public static void modificarDispositivo(TipoDispositivo tipoDispositivoAnterior, TipoDispositivo tipoDispositivoNuevo) {
        if (tiposDispositivos.contains(tipoDispositivoAnterior)) {
            tiposDispositivos.remove(tipoDispositivoAnterior);
            tiposDispositivos.add(tipoDispositivoNuevo);
        }
    }
    // Pantalla: De tipo modal para Alta/Modificación dispositivos.

    public String getId() {
        return id;
    }

    public void setId(String id) {
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





}
