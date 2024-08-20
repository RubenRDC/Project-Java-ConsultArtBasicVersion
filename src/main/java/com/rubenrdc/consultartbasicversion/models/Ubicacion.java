package com.rubenrdc.consultartbasicversion.models;

import com.rubenrdc.consultartbasicversion.models.abstracts.Ubicaciones;
import com.rubenrdc.consultartbasicversion.models.interfaces.Exportable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ruben
 */
public class Ubicacion extends Ubicaciones implements Exportable{

    private int id;
    private List<Articulo> listArt;
    private String ubic;
    private final Object[] row = new Object[2];

    public Ubicacion() {
    }


    public Ubicacion(int id, String concatUbic) {//Para Update
        this.id = id;
        this.ubic = concatUbic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUbic() {
        return ubic;
    }

    public void setConcatUbic(char sector, int pasillo, int estante, int cajon, int altura) {
        String p = Integer.toString(pasillo), e = Integer.toString(estante), c = Integer.toString(cajon), a = Integer.toString(altura);
        if (pasillo < 10) {
            p = "0" + pasillo;
        }
        if (estante < 10) {
            e = "0" + estante;
        }
        if (cajon < 10) {
            c = "0" + cajon;
        }
        if (altura < 10) {
            a = "0" + altura;
        }

        this.ubic = sector + p + "-" + e + c + "-" + a;
    }

    @Override
    public void setUbic(String ConcatUbic) {
        this.ubic = ConcatUbic;
    }

    @Override
    public Object[] getRow() {
        row[0] = id;
        row[1] = ubic;
        return row;
    }

    public List<Articulo> getListArt() {
        return listArt;
    }

    public void setListArt(List<Articulo> listArt) {
        this.listArt = listArt;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.listArt);
        hash = 67 * hash + Objects.hashCode(this.ubic);
        hash = 67 * hash + Arrays.deepHashCode(this.row);
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
        final Ubicacion other = (Ubicacion) obj;
        return Objects.equals(this.ubic, other.ubic);
    }
    
}
