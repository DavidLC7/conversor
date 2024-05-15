package com.conversor.modelos;

public class Moneda {

    private String code;
    private double cantidad;
    private double rate;

    public double getRate() {
        return rate;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getCode() {
        return code;
    }

    public Moneda(MonedaER monedaER, float cantidad) {
        this.code = monedaER.base_code();
        this.rate = monedaER.conversion_rates();
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return code + ", " + cantidad + ", " + rate;
    }
}
