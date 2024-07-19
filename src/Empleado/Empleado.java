package Empleado;

public class Empleado {
    public Empleado(int Id, String name, String apellido, int edad, String departamento, int salario){
        this.Id=Id;
        this.name=name;
        this.edad= edad;
        this.apellido=apellido;
        this.departamento=departamento;
        this.salario=salario;
    }
    public Empleado(){

    }private int Id;
    private String name;
    private String apellido;
    private int edad;
    private String departamento;
    private int salario;
    public int getId(){
        return Id;
    }
    public void setId(int Id){
        this.Id=Id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;

    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad=edad;

    }
    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento =departamento;
    }
    public int getSalario(){
        return salario;
    }
    public void setSalario(int salario){
        this.salario=salario;
    }
    @Override
    public String toString(){
        return Id+"-"+name+ "-"+apellido+ "-" +edad+ "-"+departamento+ "-"+salario;
    }
    public String EmptoString(){
        return Id+"   "+name+ "   "+apellido+ "   " +edad+ "   "+departamento+ "   "+salario;
    }


}
