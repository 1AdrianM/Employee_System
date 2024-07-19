package Empresa;

import Empleado.Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Empresa {

    private static Scanner teclado = new Scanner(System.in);
    private static ArrayList<Empleado> lista_empleado = new ArrayList<>();

    //Añadir un nuevo empleado con los atributos: nombre, apellido, edad, departamento, y salario.
    public static void añadirEmpleado() {
        boolean looping = true;
        int respuesta = 0;
        while (looping != false) {
            System.out.println("AÑADIR \n");
            int id = generarID();
            System.out.println("Introduce el nombre del empleado");
            String name = teclado.next();
            System.out.println("introduce el apellido");
            String apellido = teclado.next();
            System.out.println("introduce la edad");
            int edad = teclado.nextInt();
            System.out.println("introduce el departamento");
            String dept = teclado.next();
            System.out.println("introduce el salario");
            int salario = teclado.nextInt();
            Empleado emp = new Empleado(id, name, apellido, edad, dept, salario);
            lista_empleado.add(emp);
            System.out.println("Desea continuar agregando? \n Presiona 1 para contirunar  \n Presiona 2 para ir menu principal");
            respuesta = teclado.nextInt();

            if (respuesta == 2) {
                looping = false;
            }
            try {
                FileWriter file = new FileWriter("lista_empleado.txt", true);
                BufferedWriter bw = new BufferedWriter(file);

                bw.write(emp.toString());
                bw.newLine();

                bw.close();

                System.out.println("Written to file");
            } catch (IOException E) {
                System.out.println("nor found" + E);
            }
        }
    }
    public static void buscarEmpleadoPorId() {
        Empleado empleado = new Empleado();
        System.out.println("Digite el id del empleado que necesita buscar:");
        String line;
        boolean encontrado = false;
        int id = teclado.nextInt();
        try (BufferedReader reader = new BufferedReader(new FileReader("lista_empleado.txt"))) {
            while((line = reader.readLine())!= null){
                String[] data = line.split("-");

                empleado.setId(parseInt(data[0]));
                int empId  = empleado.getId();
                if(id== empId) {
                    empleado.setName(data[1]);
                    empleado.setApellido(data[2]);
                    empleado.setEdad(parseInt(data[3]));
                    empleado.setDepartamento(data[4]);
                    empleado.setSalario(parseInt(data[5]));

                    System.out.println(empleado);
                    encontrado=true;
                    break;
                }


            }
            if (!encontrado) {
                System.out.println("Empleado con ID " + id + " no encontrado.");
            }
        }
        catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
    public static void mostrarEmpleado() {

        try {
            File fr = new File("lista_empleado.txt");
            BufferedReader reader = new BufferedReader(new FileReader(fr));

            String line;
            while ((line = reader.readLine()) != null) {
                String[]data = line.split("-");
                Empleado emp = new Empleado(parseInt(data[0]), data[1], data[2],parseInt(data[3]), data[4],  parseInt(data[5]));
                System.out.println(emp.EmptoString());
            }
        } catch (IOException e) {
            System.out.println("no encontrado" + e);
        }
    }

    //Actualizar la información de un empleado (nombre, apellido, edad, departamento, y salario).
    public static void actualizarEmpleado() {

    }

    //Eliminar un empleado por su ID.
    public static void eliminarEmpleado() {
        Empleado emp = new Empleado();
   ArrayList<Empleado> rewrite = new ArrayList<>();
        String line;
        System.out.println("Introduzca el id del empleado que desea eliminar");
        int id = teclado.nextInt();
        try(BufferedReader reader = new BufferedReader(new FileReader("lista_empleado.txt"))){
            while((line = reader.readLine())!=null){
                String[] data = line.split("-");
                emp.setId(parseInt(data[0]));
                int empId  = emp.getId();
                if(id == empId){

                    rewrite.remove();
                    break;
                }
             }

            try(BufferedWriter writer = new BufferedWriter(new FileWriter("lista_empleado.txt"))){

                writer.write(emp.toString());
                System.out.println("Empleado Eliminado exitosamente");


            }catch(IOException e){
                System.out.println(e.getMessage());
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    //Calcular el salario promedio de todos los empleados.
    public static void calcularSalarioEmpleado() {
        int sum = 0;
                int avg = 0;
Empleado empleado = new Empleado();
ArrayList<Integer> salario =  new ArrayList<>();
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader("lista_empleado.txt"))) {
            while ((line = reader.readLine()) != null) {
               String[]data  = line.split("-");
               int salario1 = parseInt(data[5]);
               empleado.setSalario(salario1);
               int EmpSalario = empleado.getSalario();

                 for(int i= 0; i<data.length; i++){
                     salario.add(EmpSalario);
                 }

            }
            for(int i= 0; i< salario.size(); i++){
                sum = sum + salario.get(i);
            for(int j = 1; j < salario.size();j++){
                avg= sum/j;
            }
            }
            System.out.println(avg);
        }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }


    //Mostrar la lista de empleados ordenada por nombre, edad, o salario (ascendente y descendente).
    public static void mostrarListaEmpleado() {

        String line;
        System.out.println("ID - Nombre - Apdo - Edad  - Dpt - Salario");
        try(BufferedReader reader = new BufferedReader(new FileReader("lista_empleado.txt"))){
          while((line = reader.readLine())!=null){
              String[] data = line.split("-");
              Empleado emp = new Empleado(parseInt(data[0]), data[1], data[2],parseInt(data[3]), data[4],  parseInt(data[5]));

              System.out.println(emp.EmptoString());
          }

      }catch(IOException e){
          System.out.println(e.getMessage());
      }
    }

    public static int generarID() {
        int max = 9999;
        int min = 1;
        int range = max - min + 1;
        return (int)(Math.random()*range) + min;

    }


}
