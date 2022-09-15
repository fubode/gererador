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
class Cargo {

    private ArrayList<String> list;

    public Cargo() {
        this.list = new ArrayList<>();
    }

    public void addItem(String item) {
        this.list.add(item);
    }

    public String senteceSql() {

        return "INSERT INTO public.cargo("
                + " codigo_cargo, nombre_cargo)"
                + " VALUES ("+list.get(0)+", '"+list.get(1)+"');";
    }

    public ArrayList<String> getList() {
        return list;
    }
}
