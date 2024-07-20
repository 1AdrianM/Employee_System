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
        StringBuilder sb = new StringBuilder();
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
            sb.append(emp.toString()).append(System.lineSeparator());
            System.out.println("Desea continuar agregando? \n Presiona 1 para contirunar  \n Presiona 2 para ir menu principal");
            respuesta = teclado.nextInt();

            if (respuesta == 2) {
                looping = false;
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("lista_empleado.txt", true)))
            {
                bw.write(emp.toString());
                bw.newLine();

                bw.close();
                System.out.println("Written to file");
            } catch (IOException e) {
                System.out.println("nor found" + e.getMessage());
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

        try (BufferedReader reader = new BufferedReader(new FileReader(new File("lista_empleado.txt"))))
        {
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
        File TempFile = new File("tempFile.txt");
        File originalFile = new File("lista_empleado.txt");

        String line;
         System.out.println("Introduzca el id del empleado que desea eliminar");
        int id = teclado.nextInt();
        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile))) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("-");
                emp.setId(parseInt(data[0]));
                int empId = emp.getId();
                if (id != empId) {
                    writer.write(line + System.lineSeparator());
                }

            }

            writer.close();
            reader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (originalFile.delete()) {
            if (TempFile.renameTo(originalFile)) {
                System.out.println("Archivo actualizado correctamente");
            } else {
                System.out.println("Error al renombrar el archivo temporal");
            }
        } else {
            System.out.println("Error al eliminar el archivo original");
        }
    }

    //Calcular el salario promedio de todos los empleados.
    public static void calcularSalarioEmpleado() {
        int sum = 0;
                int avg = 0;
                int count=0;
                String line;
        try(BufferedReader reader = new BufferedReader(new FileReader("lista_empleado.txt"))) {
            while ((line = reader.readLine()) != null) {
               String[]data  = line.split("-");
               int salario1 = parseInt(data[5]);
                 sum =+ salario1;
                 count++;
            }
            if(count > 0){
                avg = sum/count;
            }else{
                System.out.println("theres no salaries to count");
            }
            System.out.println("el salario promedio de los empleados es : "+avg);
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
