import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class EscriturayLectura {

    public static void main(String[] args) {

        String directorio;
        String archivo;
        String texto;

        // Ingreso de datos

        System.out.println("Ingrese el nombre de la carpeta que desea crear");
        Scanner ingreso = new Scanner(System.in);
        directorio= ingreso.next();
        System.out.println("Ingrese el nombre del archivo que desea crear");
        archivo = ingreso.next();

        // Array entregado por desafio

        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Juan");
        lista.add("Daniel");
        lista.add("Juan");
        lista.add("Gato");
        lista.add("Perro");
        lista.add("Camila");
        lista.add("Daniel");
        lista.add("Camila");


        // METODOS
        crearArchivo("src/directorio", "archivo.txt", lista);
        buscarTexto("src/directorio/archivo.txt", "Perro");

    }

    // METODO CREACION DE ARCHIVO Y CARPETA

    public static void crearArchivo(String carpeta , String archivo, ArrayList<String> lista) {

        // Creación de carpeta
        try {
            File directorio = new File("src/"+carpeta);
            if (directorio.exists() == false) {
                directorio.mkdir();
                System.out.println("Carpeta Creada Satisfactoriamente");
            }else {
                System.out.println("La Carpeta ya existe");

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear directorio");
        }

        // Creación de archivo
        try {
            File nuevoarchivo = new File("src/"+carpeta+"/"+"archivo.txt");
            if(nuevoarchivo.exists()== true) {
                System.out.println("Archivo ya existe");
            }else {
                nuevoarchivo.createNewFile();
                System.out.println("Archivo fue creado Satisfactoriamente");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hubo problemas en la creacion del archivo");
        }

    }
    // Carga de informacion en el archivo

    public static void cargarTexto(String carpeta , String archivo , ArrayList<String> numeros) {

        try {
            File nuevoarchivo = new File("src/"+carpeta+"/"+archivo+".txt");
            if(nuevoarchivo.exists()== true) {
                System.out.println("El Archivo Si Existe");
                System.out.println("Cargando Datos");

                FileWriter escritor = new FileWriter(nuevoarchivo);
                BufferedWriter escritorbuffer = new BufferedWriter(escritor);
                for (String e : numeros) {
                    escritorbuffer.write(e + System.lineSeparator());
                    System.out.print(".");
                }
                escritorbuffer.close();
                System.out.println(" ");
                System.out.println("Carga Completa");

            }else {
                System.out.println("El Archivo no Existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hubo problemas en la escritura del archivo");
        }

    }


    public static void buscarTexto(String nombre , String texto ) {
        String directorio = "src/"+nombre;
        FileReader fr = null;
        BufferedReader br = null;
        String data = "";
        ArrayList<String> nombres = new ArrayList<String>();

        try {
            fr = new FileReader(directorio);
            br=new BufferedReader(fr);
            data = br.readLine();
            while (data != null) {
                nombres.add(data);
                data = br.readLine();
            }
            br.close();
            fr.close();
            int contador = 0;
            for (int i=0 ; i< nombres.size(); i++){
                if ( nombres.get(i).equals(texto)) {
                    contador++;
                }

            }
            System.out.print("cantidad de repeticiones del texto -> "+contador);
        }
        catch (Exception e){
            System.out.println("Excepcion leyendo fichero "+ nombre + ": " + e);
        }
    }



}