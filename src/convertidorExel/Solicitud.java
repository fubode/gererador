/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidorExel;

import java.util.ArrayList;

/**
 *
 * @author GEEK STORE
 */
class Solicitud {

    private ArrayList<String> list;

    public Solicitud() {
        this.list = new ArrayList<>();
    }

    public void addItem(String item) {
        this.list.add(item);
    }

    public String senteceSql() {
        String fecha = "2020-10-1";
        String codigo = list.get(0);
        String codigo_solicitud = "SV-"+codigo+"-102022-"+list.get(13);
        String fecha_solicitud = fecha;
        String fecha_salida = fecha;
        String turno_salida = "TARDE";
        String fecha_retorno = fecha;
        String turno_retorno = "TARDE";
        String dias = list.get(12);
        String estado = "ACEPTADO";
        String tipo = "VACACION";
        String detalle_compensacion = "PRIMERA SOLICITUD DE VACACION CREADA";
        String sql = "INSERT INTO public.solicitud_vacaciones("
                + "codigo_solicitud,"
                + "supervisor,"
                + " fecha_solicitud,"
                + " fecha_salida,"
                + " turno_salida,"
                + " fecha_retorno,"
                + " turno_retorno,"
                + " dias,"
                + " estado,"
                + " tipo,"
                + " detalle_compensacion,"
                + " codigo_funcionario) "
                + "VALUES ('"+codigo_solicitud+"',"
                +0+",'"
                +fecha_solicitud+"','"
                +fecha_salida+"','"
                +turno_salida+"','"
                +fecha_retorno+"','"
                +turno_retorno+"',"
                +dias+",'"
                +estado+"','"
                +tipo+"','"
                +detalle_compensacion+"',"
                +codigo+");";
        return sql;
    }

    public ArrayList<String> getList() {
        return list;
    }
}
