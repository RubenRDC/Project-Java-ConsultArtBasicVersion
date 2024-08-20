package com.rubenrdc.consultartbasicversion.models;

import java.util.Objects;

/**
 *
 * @author Ruben
 */
public class ArticuloUbicacion {

    private int id, stockArt;
    private Ubicacion ubicacion;
    private Deposito deposito;

    public ArticuloUbicacion() {
    }

    public ArticuloUbicacion(int id, int stockArt, Ubicacion ubicacion, Deposito deposito) {
        this.id = id;
        this.stockArt = stockArt;
        this.ubicacion = ubicacion;
        this.deposito = deposito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStockArt() {
        return stockArt;
    }

    public void setStockArt(int stockArt) {
        this.stockArt = stockArt;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public ArticuloUbicacion setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        return this;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public ArticuloUbicacion setDeposito(Deposito deposito) {
        this.deposito = deposito;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.stockArt;
        hash = 53 * hash + Objects.hashCode(this.ubicacion);
        hash = 53 * hash + Objects.hashCode(this.deposito);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArticuloUbicacion other = (ArticuloUbicacion) obj;
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        return Objects.equals(this.deposito, other.deposito);
    }

}
