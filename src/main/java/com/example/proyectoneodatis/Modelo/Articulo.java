package com.example.proyectoneodatis.Modelo;

public class Articulo {

    private Integer codigo;
    private String denominacion;
    private Double precioDeVentaAlPublico;
    private String categoria;
    private Integer unidadesVendidas; // precio unitario
    private Integer stock;



    public Articulo(int i, String string, Double j, String string2, Integer k, int l) {
        this.codigo=i;
        this.denominacion = string;
        this.precioDeVentaAlPublico = j;
        this.categoria = string2;
        this.unidadesVendidas = k;
        this.stock = l;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Double getPrecioDeVentaAlPublico() {
        return precioDeVentaAlPublico;
    }

    public void setPrecioDeVentaAlPublico(Double precioDeVentaAlPublico) {
        this.precioDeVentaAlPublico = precioDeVentaAlPublico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(Integer unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", denominacion='" + denominacion + '\'' +
                ", precioDeVentaAlPublico=" + precioDeVentaAlPublico +
                ", categoria='" + categoria + '\'' +
                ", unidadesVendidas=" + unidadesVendidas +
                ", stock=" + stock +
                '}';
    }

}
