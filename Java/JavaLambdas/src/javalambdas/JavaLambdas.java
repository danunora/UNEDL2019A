/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author root
 */
public class JavaLambdas {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado daniel = new Empleado("Daniel",25);
        Empleado alejandro = new Empleado("Alejandro",35);
        Empleado juan = new Empleado("Juan",40);
        Empleado jose = new Empleado("Jose",39);
        //List<Empleado> empleados = new ArrayList();
        List<Empleado> empleados = new SortedList();
        empleados.add(daniel);
        empleados.add(alejandro);
        empleados.add(juan);
        empleados.add(jose);     

                    /*
                    Collections.sort(empleados, new Comparator<Empleado>(){
                    @Override
                    public int compare(Empleado empleadoX, Empleado empleadoY) {
                    return empleadoX.getNombre().compareTo(empleadoY.getNombre());
                    }
                    */
                    //Collections.sort(empleados, (empleadoX, empleadoY) ->
                    //empleadoX.getNombre().compareTo(empleadoY.getNombre()));
               
       
    for (Empleado empleado: empleados){
        System.out.println("Nombre: " + empleado.getNombre());
        System.out.println("Edad: " + empleado.getEdad());
    }
  }
}

class Empleado {
    private String nombre;
    private int edad;

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }    
}