package com.example.proyectoneodatis.Modelo;

public class Articulo {

    private Integer codigo;
    private String denominacion;
    private Double precioDeVentoAlPublico;
    private String categoria;
    private Double precioUnitario; // precio unitario
    private Integer stock;

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

    public Double getPrecioDeVentoAlPublico() {
        return precioDeVentoAlPublico;
    }

    public void setPrecioDeVentoAlPublico(Double precioDeVentoAlPublico) {
        this.precioDeVentoAlPublico = precioDeVentoAlPublico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
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
                ", precioDeVentoAlPublico=" + precioDeVentoAlPublico +
                ", categoria='" + categoria + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", stock=" + stock +
                '}';
    }

}
