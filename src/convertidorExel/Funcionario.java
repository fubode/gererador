/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidorExel;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author GEEK STORE
 */
class Funcionario {

    private ArrayList<String> list;

    public Funcionario() {
        this.list = new ArrayList<>();
    }

    public void addItem(String item) {
        this.list.add(item);
    }

    public String senteceSql() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        String ci = list.get(7);
        String correo = list.get(6);
        EncriptadorAES encriptadorAES = new EncriptadorAES();
        final String claveEncriptacion = "secreto!";
        String passEncriptado = encriptadorAES.encriptar(ci, claveEncriptacion);
        
        return "INSERT INTO public.funcionario("
                + " codigo_sai, apellido, nombre, fecha_ingreso, ci, correo, fecha_salida, supervisor, entidad, cargo,expedido)"
                + " VALUES (" + list.get(0) + ", '" + list.get(2) + "', '" + list.get(3) + "', '" + list.get(9) + "', " + ci + ", '" + correo + "', '1750-1-1', " + list.get(11) + ", " + list.get(1) + ", " + list.get(4) + ",'" + list.get(8) + "');"
                + "\n"
                + "INSERT INTO public.cuenta("
                + "usuario, pass, codigo_funcionario )"
                + "VALUES ('"+correo+"', '"+passEncriptado+"', "+list.get(0)+");";
    }

    public ArrayList<String> getList() {
        return list;
    }
}
