public class Usuario{
    public String nombre;
    public int identificacion;
    public String email;
    public int edad;
    public String area;
    public boolean jefe;
    
    
    public Usuario(String nombre, int identificacion, String email, 
        int edad,String area,boolean jefe) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.edad = edad;
        this.area = area;
        this.jefe = jefe;
    }
    public static double Salario(String area,boolean jefe) {
    double salario=0;
        if (area=="desarrollo"){
            if(jefe==true){
                salario=7000000;
            } else {
                salario=4500000;
            }
        }else{
            if(jefe==true){
                salario=6500000;
            } else {
                salario=3500000;
            }
        }
        return salario;
    }
    
    public static double[] IBC(String area,boolean jefe) {
        double[] valores;
        valores = new double[5];
        double neto=0;
        double salario=Salario(area,jefe);
        double ibc=salario*0.4;
        valores[0] = ibc; //IBC
        valores[1]  = ibc*0.125; //salud
        valores[2]  = ibc*0.16; //pension
        valores[3]  = ibc*0.005; //ARL
        if (salario/908526>4){
            neto = salario*0.97 - ibc*0.29;
        } else{
            neto = salario -ibc*0.29;
        }
        valores[4] = neto; //salario neto a pagar
        return valores;
    }
    
    public void info(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Identificacion: "+identificacion);
        System.out.println("Edad: "+edad);
        System.out.println("Area: "+area);
        System.out.println("Email: "+email);
        System.out.println("IBC: "+IBC(area,jefe)[0]);
        System.out.println("Aportes salud: "+IBC(area,jefe)[1]);
        System.out.println("Aportes pension: "+IBC(area,jefe)[2]);
        System.out.println("Aportes ARL: "+IBC(area,jefe)[3]);
        System.out.println("Neto a pagar: "+IBC(area,jefe)[4]);
    }
}