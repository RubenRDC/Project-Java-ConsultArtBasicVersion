package com.rubenrdc.consultartbasicversion.models;

import com.rubenrdc.consultartbasicversion.models.interfaces.Exportable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Ruben
 */
public class Articulo implements Exportable {

    private final int limitUbicExtra = 10, limitUbicP = 1;
    private int id;
    private String codigo, desc, foto;
    private final Object[] row = new Object[4];

    private List<ArticuloUbicacion> listCantsFromUbics;

    public Articulo(int idArt, String code, String desc, String foto) {
        this.id = idArt;
        this.codigo = code;
        this.desc = desc;
        this.foto = foto;
    }

    public Articulo() {
    }

    @Override
    public Object[] getRow() {
        row[0] = id;
        row[1] = codigo;
        row[2] = desc;
        row[3] = foto;
        return row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getUbicsConcat(String DepName) {
        if (listCantsFromUbics != null) {
            if (!listCantsFromUbics.isEmpty()) {
                String ubicConcat = listCantsFromUbics.stream()
                        .filter(art -> art.getDeposito().getNombre().equals(DepName))//Filtro el stream y devuelve uno con el filtro aplicado
                        .map(art -> art.getUbicacion().getUbic())//Devuelvo un stream con las ubicaciones filtradas
                        .collect(Collectors.joining(" | "));//Realizo una coleccion con los valores del anterior Stream y genero una concatenacion devolviendo un String
                return ubicConcat;
            }
        }
        return null;
    }

    public List<Ubicacion> getListUbicByDepName(String DepName) {
        if (listCantsFromUbics != null) {
            if (!listCantsFromUbics.isEmpty()) {
                List<Ubicacion> collect = listCantsFromUbics.stream().filter(ubi -> ubi.getDeposito().getNombre().equals(DepName)).map(art -> art.getUbicacion()).collect(Collectors.toList());
                return collect;
            }
        }
        return null;
    }

    public Map<String, Integer> getStockByDeps() {
        if (listCantsFromUbics != null) {
            if (!listCantsFromUbics.isEmpty()) {
                Map<String, Integer> collect = listCantsFromUbics.stream().collect(Collectors.groupingBy(art -> art.getDeposito().getNombre(), Collectors.summingInt(ArticuloUbicacion::getStockArt)));
                return collect;
            }
        }
        return null;
    }

    public int getLimitUbicExtra() {
        return limitUbicExtra;
    }

    public int getLimitUbicP() {
        return limitUbicP;
    }

    public List<ArticuloUbicacion> getListCantsFromUbics() {
        return listCantsFromUbics;
    }

    public void setListCantsFromUbics(List<ArticuloUbicacion> listCantsFromUbics) {
        this.listCantsFromUbics = listCantsFromUbics;
    }
}
