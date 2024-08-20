package com.rubenrdc.consultartbasicversion.models;

import com.rubenrdc.consultartbasicversion.models.interfaces.Exportable;


/**
 *
 * @author Ruben
 */
public class Deposito implements Exportable{

    private int id, numDireccion;
    private String nombre, provincia, localidad, direccion;
    private final Object[] row = new Object[3];

    public Deposito() {
    }

    public Deposito(int idDep, String nameDep) {
        this.id = idDep;
        this.nombre = nameDep;
    }

    public Deposito(int id, String nombre, String provincia, String localidad, String direccion, int numDireccion) {
        this.id = id;
        this.numDireccion = numDireccion;
        this.nombre = nombre;
        this.provincia = provincia;
        this.localidad = localidad;
        this.direccion = direccion;
    }

    public Deposito(String nombre, String provincia, String localidad, String direccion, int numDireccion) {
        this.numDireccion = numDireccion;
        this.nombre = nombre;
        this.provincia = provincia;
        this.localidad = localidad;
        this.direccion = direccion;
    }

    @Override
    public Object[] getRow() {
        row[0] = id;
        row[1] = nombre;
        row[2] = provincia;
        return row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumDireccion() {
        return numDireccion;
    }

    public void setNumDireccion(int numDireccion) {
        this.numDireccion = numDireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
