package com.example.android.quakereport.dataobject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by joselobm on 19/08/17.
 */

public class Earthquake {

    private Float magnitud;
    private String ubicacion;
    private Date fechaHora;
    private String urlWebsite;

    public Earthquake(Float magnitud, String ubicacion, Date fechaHora, String urlWebsite) {
        this.magnitud = magnitud;
        this.ubicacion = ubicacion;
        this.fechaHora = fechaHora;
        this.urlWebsite = urlWebsite;
    }

    public Float getMagnitud() {
        return magnitud;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setMagnitud(Float magnitud) {
        this.magnitud = magnitud;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUrlWebsite() {
        return urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        this.urlWebsite = urlWebsite;
    }

    public String getFechaComoString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(getFechaHora());
    }

    public String getHoraComoString() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(getFechaHora());
    }

    public String[] obtenerUbicacionSeparada() {
        String[] arrayUbicacion = new String[2];
        if (getUbicacion().contains(" of ")) {
            arrayUbicacion = getUbicacion().split(" of ");
            arrayUbicacion[0] = arrayUbicacion[0]+" of ";
        } else {
            arrayUbicacion[0] = "Near the";
            arrayUbicacion[1] = getUbicacion();
        }
        return arrayUbicacion;
    }
}
