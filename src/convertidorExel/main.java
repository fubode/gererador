/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidorExel;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author GEEK STORE
 */
public class main {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        String rutaArchivoExcel = "D:\\FUBODE\\entidades.xlsx";
        ConvertidorExcel excel = new ConvertidorExcel();
        //excel.sqlEntidades(rutaArchivoExcel);
        //excel.sqlCargo("D:\\FUBODE\\cargos.xlsx");
        System.out.println("");
        System.out.println("");
        excel.sqlFuncionarios("D:\\FUBODE\\info.xlsx");
        //excel.listaCargos("D:\\FUBODE\\info.xlsx");
        System.out.println("\u00d1Ñn");
        //excel.listaSolicitudes("D:\\FUBODE\\info.xlsx");

        /*String decodificado = "m0gSUNePKIajNwE68U4m1g==";
        final String claveEncriptacion = "secreto!";
        EncriptadorAES eS = new EncriptadorAES();
        String deString = eS.desencriptar(decodificado, claveEncriptacion);
        System.out.println(deString);*/
        //Date fechaActual = new Date().fechaActual();
        //Date fecha = fechaActual.fechaActual();
        //Date date = new Date();
        //System.out.println(fecha.fechaActual());

    }
}
