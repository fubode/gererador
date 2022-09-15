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
class Entidad {

    
    ArrayList<String> list;

    public Entidad() {
       
        this.list = new ArrayList<>();
    }

    public void addItem(String item) {
        this.list.add(item);
    }

    public String senteceSql() {

        return "INSERT INTO public.entidad("
                + "codigo_entidad, nombre_entidad, tipo_entidad, entidad_supervisor) "
                + "VALUES ("+Integer.parseInt(list.get(0))+", '"+list.get(1)+"', '"+list.get(2)+"', "+Integer.parseInt(list.get(3))+");";
    }
}
