package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de empleados
        List<Empleado> empleados = new ArrayList<>();

        // Crear instancias de EmpleadoAsalariado y EmpleadoPorHoras
        Empleado empleado1 = new EmpleadoAsalariado("Juan", 3000);
        Empleado empleado2 = new EmpleadoPorHoras("Maria", 10, 40);

        // Agregar empleados a la lista
        empleados.add(empleado1);
        empleados.add(empleado2);

        // Calcular y mostrar salarios
        for (Empleado empleado : empleados) {
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Salario: " + empleado.calcularSalario());
            System.out.println("-----------");
        }
    }
}