import java.io.*;
import java.util.ArrayList;

public class Main {
    private ArrayList<Empleado> empleados;

    public Main(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Empleado> mostrarEmpleados() {
        return empleados;
    }

    public String mostrarSalarios() {
        StringBuilder result = new StringBuilder();
        for (Empleado empleado : empleados) {
            result.append("Empleado: ").append(empleado.getNombre())
                    .append(", Tipo: ").append(empleado.getTipo())
                    .append(", Salario: ").append(empleado.calcularSalario())
                    .append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Empleado empleadoAsalariado1 = new EmpleadoAsalariado("Alexander", "650000");
        Empleado empleadoAsalariado = new EmpleadoAsalariado("Paulo", "700000");
        Empleado empleadoPorHoras = new EmpleadoPorHoras("Darwin", "386000", 12000,11000);
//agregamos empleados a la lista
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(empleadoAsalariado1);
        empleados.add(empleadoAsalariado);
        empleados.add(empleadoPorHoras);

        //escribimos los datos de los empleados desde un archivo txt
        escribirEmpleadosEnArchivo(empleados, "empleados.txt");
        //leemos los datos de los empleados desde un archivo txt
        ArrayList<Empleado> empleadosLeidos = leerEmpleadosDesdeArchivo("empleados.txt");



        Main empresa = new Main(empleados);

        ArrayList<Empleado> listaEmpleados = empresa.mostrarEmpleados();
        System.out.println("Lista de Empleados:");
        for (Empleado empleado : listaEmpleados) {
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Tipo: " + empleado.getTipo());
            System.out.println("Salario: " + empleado.calcularSalario());
            System.out.println(" ");
        }
    }
    private static void escribirEmpleadosEnArchivo(ArrayList<Empleado> empleados, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Empleado empleado : empleados) {
                writer.println(empleado.getNombre() + "," + empleado.calcularSalario());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Empleado> leerEmpleadosDesdeArchivo(String nombreArchivo) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0];
                    double salario = Double.parseDouble(partes[1]);
                    Empleado empleado = new Empleado(nombre, salario) {
                        public String getTipo() {
                            return null;
                        }

                        public String calcularSalario() {
                            return null;
                        }
                    };
                    empleados.add(empleado);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return empleados;
    }
}