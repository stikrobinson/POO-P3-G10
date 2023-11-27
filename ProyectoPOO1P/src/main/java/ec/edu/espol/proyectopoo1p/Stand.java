/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;

import java.time.LocalDate;

/**
 *
 * @author GENERATION 10
 */
public class Stand {
    private String codigoStand;
    private SectorCubierto seccion;
    private LocalDate fechaAsignacion;
    private Participante ocupadoPor;

    public String getCodigoStand() {
        return codigoStand;
    }

    public void setCodigoStand(String codigoStand) {
        this.codigoStand = codigoStand;
    }

    public SectorCubierto getSeccion() {
        return seccion;
    }

    public void setSeccion(SectorCubierto seccion) {
        this.seccion = seccion;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Participante getOcupadoPor() {
        return ocupadoPor;
    }

    public void setOcupadoPor(Participante ocupadoPor) {
        this.ocupadoPor = ocupadoPor;
    }
    
    
}