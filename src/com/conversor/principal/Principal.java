package com.conversor.principal;
import com.conversor.modelos.ConsultarApi;
import com.conversor.modelos.Convertir;
import com.conversor.modelos.Moneda;
import com.conversor.modelos.MonedaER;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {

        String codigo = "";
        String codigo1 = "";
        var cantidad = 0;
        Scanner teclado = new Scanner(System.in);
        var opcion = 0;
        String menu = """
                ++++++++++++++++++++++++++++++++++++++++
                Bienvenido al conversor de monedas
                
                Por favor, ingrese la opción deseada:
                
                [1] Peso mexicano -> Dólar
                [2] Dólar -> Peso mexicano
                [3] Peso mexicano -> Euro
                [4] Euro -> Peso mexicano
                [5] Peso mexicano -> Real brasileño
                [6] Real brasileño -> Peso mexicano
                
                Si desea salir, presione [7]
                ++++++++++++++++++++++++++++++++++++++++
                """;

        while (opcion != 7) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            if (opcion == 1){
                codigo = "MXN";
                codigo1 = "USD";
            } else if (opcion == 2) {
                codigo = "USD";
                codigo1 = "MXN";
            } else if (opcion == 3){
                codigo = "MXN";
                codigo1 = "EUR";
            } else if (opcion == 4) {
                codigo = "EUR";
                codigo1 = "MXN";
            } else if (opcion == 5){
                codigo = "MXN";
                codigo1 = "BRL";
            } else if (opcion == 6) {
                codigo = "BRL";
                codigo1 = "MXN";
            } else if (opcion == 7) {
                System.out.println("¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción inválida");
                continue;
            }

            System.out.println("Ingrese el valor a convertir: ");
            cantidad = teclado.nextInt();
            ConsultarApi consultarApi = new ConsultarApi();
            MonedaER monedaER = consultarApi.buscarMoneda(codigo, codigo1);
            Moneda moneda = new Moneda(monedaER, cantidad);
            Convertir convertir = new Convertir();
            convertir.calcula(moneda); // Se llama al método calcula del objeto convertir de la clase Convertir
            System.out.println(moneda.getCantidad() + " "+moneda.getCode()+" equivale a: "+convertir.getConversion()+" "+ codigo1);
        }
    }
}
