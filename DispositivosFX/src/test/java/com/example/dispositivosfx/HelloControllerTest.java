package com.example.dispositivosfx;

import com.example.dispositivosfx.models.Dispositivo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {
    //comprobar que el dispositivo se ha dado de alta correctamente
    //todos los atributos son correstos
    @Test
    void altaDispositivo() {
        Dispositivo dispositivo = new Dispositivo(LocalDate.now(), 100, Dispositivo.TipoDispositivo.ORDENADOR, "HP", "Pavilion");
        assertEquals(100, dispositivo.getPrecio());
        assertEquals(Dispositivo.TipoDispositivo.ORDENADOR, dispositivo.getTipoAtributo());
        assertEquals("HP", dispositivo.getMarca());
        assertEquals("Pavilion", dispositivo.getModelo());
    }

}