/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertidorExel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
public class ConvertidorExcel {

    private FileInputStream inputStream;
    private Workbook workbook;
    private Sheet firstSheet;
    private Iterator iterator;
    private DataFormatter formatter;

    public ConvertidorExcel() {
        this.formatter = new DataFormatter();
    }

    private Iterator getIterator(String ruta) {
        try {
            this.inputStream = new FileInputStream(new File(ruta));
            this.workbook = new XSSFWorkbook(inputStream);
            this.firstSheet = workbook.getSheetAt(0);
            this.iterator = firstSheet.iterator();
            return iterator;
        } catch (Exception e) {

            return null;
        }
    }

    public void sqlEntidades(String ruta) {
        try {
            Iterator iterator = getIterator(ruta);
            ArrayList<Entidad> list = new ArrayList<>();
            while (iterator.hasNext()) {
                Entidad entidad = new Entidad();
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    entidad.addItem(contenidoCelda);
                }
                list.add(entidad);
                entidad = null;
            }
            for (Entidad entidad : list) {
                System.out.println(entidad.senteceSql());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sqlCargo(String ruta) {
        try {
            Iterator iterator = getIterator(ruta);
            ArrayList<Cargo> list = new ArrayList<>();
            while (iterator.hasNext()) {
                Cargo cargo = new Cargo();
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    cargo.addItem(contenidoCelda);
                }
                list.add(cargo);
                cargo = null;
            }
            for (Cargo cargo : list) {
                System.out.println(cargo.senteceSql());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Cargo> cargos(String ruta) {
        ArrayList<Cargo> list = new ArrayList<>();
        try {
            Iterator iterator = getIterator(ruta);
            while (iterator.hasNext()) {
                Cargo cargo = new Cargo();
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    cargo.addItem(contenidoCelda);
                }
                list.add(cargo);
                cargo = null;
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public void listaCargos(String ruta) {
        try {
            Iterator iterator = getIterator(ruta);
            ArrayList<ArrayList<String>> list = new ArrayList<>();
            while (iterator.hasNext()) {
                ArrayList<String> cargo = new ArrayList<>();
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    cargo.add(contenidoCelda);
                }
                list.add(cargo);
                cargo = null;
            }
            ArrayList<Cargo> arrayList = cargos("D:\\FUBODE\\cargos.xlsx");

            int cont = 1;
            for (ArrayList<String> l : list) {
                HashMap<String, String> existe = existe(arrayList, l.get(5));
                if (existe.get("existe").equals("V")) {
                    //System.out.println(cont+" " +existe.get("valor")+" "+existe.get("nombre"));
                    System.out.println(existe.get("valor"));
                }
                String nombreCargo = l.get(4);
                cont++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public HashMap<String, String> existe(ArrayList<Cargo> arrayList, String cargo) {
        HashMap<String, String> existe = new HashMap<>();
        existe.put("existe", "F");
        for (Cargo c : arrayList) {
            String nombreCargo = c.getList().get(1);
            if (cargo.equals(nombreCargo)) {
                existe.replace("existe", "V");
                existe.put("valor", c.getList().get(0));
                existe.put("nombre", c.getList().get(1));
                break;
            }
        }
        return existe;
    }

    void sqlFuncionarios(String ruta) {
        try {
            File file = new File("D:\\FUBODE\\funcionarios.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            Iterator iterator = getIterator(ruta);
            ArrayList<Funcionario> list = new ArrayList<>();
            while (iterator.hasNext()) {
                Funcionario funcionario = new Funcionario();
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    funcionario.addItem(contenidoCelda);
                }
                list.add(funcionario);
                funcionario = null;
            }
            for (Funcionario funcionario : list) {
                writer.write(funcionario.senteceSql()+"\n");
                System.out.println(funcionario.senteceSql());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void listaSolicitudes(String ruta) {
        try {
            Iterator iterator = getIterator(ruta);
            ArrayList<Solicitud> list = new ArrayList<>();
            while (iterator.hasNext()) {
                Solicitud solicitud = new Solicitud();
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    solicitud.addItem(contenidoCelda);
                }
                list.add(solicitud);
                solicitud = null;
            }
            for (Solicitud solicitud : list) {
                System.out.println(solicitud.senteceSql());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
