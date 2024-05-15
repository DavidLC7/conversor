package com.conversor.modelos;

public class Convertir {

    private double conversion;

    public double getConversion() {
        return conversion;
    }

    public void calcula(Moneda moneda){
        this.conversion = moneda.getRate()* moneda.getCantidad();
    }
}
