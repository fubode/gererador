/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorExel;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author optiplex3000
 */
public class SabadosNoLaborales {
    private int anio;

    public SabadosNoLaborales(int anio) {
        this.anio = anio;
    }
    public void imprimirSabadosNoLaborales(){
        String sqlFechas = "";
        for (int mes = 1; mes <= 12; mes++) {
            LocalDate fecha = LocalDate.of(anio, mes, 1); // Primer día del mes
            int sabadosImpresos = 0; // Contador de sábados impresos

            while (sabadosImpresos < 2) {
                String sabado = (sabadosImpresos==0)?"PRIMER SABADO DEL MES":"SEGUNDO SABADO DEL MES";
                if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    sqlFechas = "INSERT INTO public.fechas("
                + " fecha, descripcion_estado, tipo)"
                + " VALUES ('"
                +fecha+"','"+sabado+"','NO_LABORAL');";
                    System.out.println(sqlFechas);
                    sabadosImpresos++;
                }
                fecha = fecha.plusDays(1);
            }
        }
    }
}
