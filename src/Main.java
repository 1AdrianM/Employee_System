import Empresa.Empresa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean keepRunning = true;
        String pathFile = "~/Escritorio/ProjectFiles/Java/Sistema_empleado$/lista_empleado.txt";



        Scanner teclado = new Scanner(System.in);
        Empresa empresa= new Empresa();

        System.out.println("--------BIENVENIDO AL SISTEMA DE GESTION DE EMPLEADOS");
        do{

            System.out.println(" 1- Añadir Empleados \n 2- Buscar Emplead por su Id \n 3- Actualizar empleado \n 4- Eliminar Empleado.Empleado \n 5- Calcular Salarios de Empleados \n 6- mostrar Lista de Empleados \n 7- mostrar Listado organizado \n 8- Cerrar");
            int respuesta = teclado.nextInt();


            switch(respuesta){

                case 1:
                    empresa.añadirEmpleado();
                    break;

                case 2:
                    empresa.buscarEmpleadoPorId();
                    break;
                case 3:
                    empresa.actualizarEmpleado();
                    break;
                case 4:
                    empresa.eliminarEmpleado();
                    break;
                case 5:
                    empresa.calcularSalarioEmpleado();
                    break;
                case 6:
                    empresa.mostrarEmpleado();
                    break;
                case 7:
                    empresa.mostrarListaEmpleado();
                    break;
                default:
                    keepRunning = false;
                    break;



            }

        }while (keepRunning!=false);


    }
}

/*Prueba Técnica de Nivel Medio: Sistema de Gestión de Empleados
Descripción:
Crea una aplicación Java avanzada que gestione la información de empleados en una empresa. La aplicación debe permitir:

Añadir un nuevo empleado con los atributos: nombre, apellido, edad, departamento, y salario.
Mostrar una lista de todos los empleados.
Buscar un empleado por su ID.
Actualizar la información de un empleado (nombre, apellido, edad, departamento, y salario).
Eliminar un empleado por su ID.
Calcular el salario promedio de todos los empleados.
Mostrar la lista de empleados ordenada por nombre, edad, o salario (ascendente y descendente).
Requisitos:

    [X]*Utiliza una clase Empleado.Empleado con los atributos mencionados y métodos para obtener y establecer los valores de estos atributos.

   [X]*Crea una clase Empresa.Empresa que gestione una lista de empleados y contenga los métodos para añadir, mostrar, buscar, actualizar, eliminar empleados, calcular el salario promedio, y ordenar la lista de empleados.

   [X]*Implementa una interfaz de usuario basada en consola para interactuar con el usuario, que permita seleccionar las diferentes funcionalidades de la aplicación.

    [X]*Utiliza excepciones para manejar posibles errores (por ejemplo, buscar o actualizar un empleado que no existe).

[X]*Implementa comparadores para ordenar la lista de empleados por nombre, edad, o salario.

  [X]*Asegúrate de que el sistema permita la persistencia de datos, es decir, los datos de los empleados deben guardarse en un archivo y ser recuperados al iniciar la aplicación.

    []*Utiliza buenas prácticas de programación, incluyendo encapsulación, modularidad, y comentarios en el código.

   []*Este sistema de gestión de empleados debe ser robusto y permitir una fácil expansión en el futuro, como agregar nuevos atributos o funcionalidades.*/