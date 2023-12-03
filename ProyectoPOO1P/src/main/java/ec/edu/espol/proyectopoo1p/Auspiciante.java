/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author GENERATION 10
 */
public class Auspiciante extends Participante {
    private SectorCubierto sector;

    
    private ArrayList<Stand> standsAsignados;

    

    private ArrayList<Auspiciante> auspiciantes;
    private String nombre;
    public Auspiciante(String c, String t, String e, String d, String s, String n,String nom,SectorCubierto se){

      super(c,t,e,d,s,n);
      nombre =nom;
      sector=se;
    }
    public void editar(){ //metodo de editar
      Scanner sc=new Scanner(System.in);
      System.out.println("1. Nombre responsable: " + getNombre_responsable());
      System.out.println("2. Nombre: "+ nombre);
      System.out.println("3. Direccion: "+ getDireccion());
      System.out.println("4. Email: "+ getEmail());
      System.out.println("5. Sitio web: "+ getSitio_web());
      System.out.println("6. Telefono: "+getTelefono());
      System.out.println("7. Sector: "+sector);
      System.out.print("8. Redes Sociales: ");//cambiar print
      int co=0;
      for(CuentaRedSocial c: getListaRedesSociales()){
              System.out.print(co + "." + c.getRedSocial() + ":" + c.getCuenta()+"  ");
              co++;
            }
      System.out.println();
      int num;
      String respuesta;
      System.out.println("Ingrese el numero que desea editar ");
      num=sc.nextInt();
      sc.nextLine();
      switch (num) {
        case 1:
          System.out.println("Ingrese el nuevo nombre responsable");
          String nom_r=sc.nextLine();
          setNombre_responsable(nom_r);
          break;
        case 2:
          System.out.println("Ingrese el nuevo nombre");
          String nom=sc.nextLine();
          nombre=nom;
          break;
        case 3:
          System.out.println("Ingrese la nueva direccion");
          String dic=sc.nextLine();
          setDireccion(dic);
          break;
        
        case 4:
          System.out.println("Ingrese el nuevo email");
          String e=sc.nextLine();
          setEmail(e);
          break;
        
        case 5:
          System.out.println("Ingrese el nuevo sitio web");
          String siti=sc.nextLine();
          setSitio_web(siti);
          break;

        case 6:
          System.out.println("Ingrese el nuevo telefono");
          String te=sc.nextLine();
          setTelefono(te);
          break;

        case 7:
          System.out.println("Ingrese el nuevo sector");
          String s=sc.nextLine().toUpperCase();
          sector=SectorCubierto.valueOf(s);
          break;
          
        case 8:
                    System.out.println("Escribe borrar para eliminar una cuenta o agregar para ingresar una nueva cuenta");//cuidado las ñ
          String cambio = sc.nextLine().toUpperCase();
          int contador = 0;
          if(cambio.equals("AGREGAR")){
            do{                
            System.out.println("Ingrese su red social: Twitter, Facebook, Instagram, YouTube, TikTok, LinkedIn y Pinterest");
            String redSocial = sc.nextLine().toUpperCase();
            try {
            RedSocial r = RedSocial.valueOf(redSocial);
            System.out.println("Ingrese el nombre de la cuenta");
            String usuario = sc.nextLine();
            CuentaRedSocial cuentaRedSocial = new CuentaRedSocial(usuario,r);
            getListaRedesSociales().add(cuentaRedSocial);
            } catch (IllegalArgumentException except) {
            System.out.println("Opción no válida");
            }
            System.out.println("Si quiere agregar otra red social, escriba Y");
            respuesta = sc.nextLine().toUpperCase();
            }while(respuesta.equals("Y"));
          }
          if(cambio.equals("BORRAR")){
            for(CuentaRedSocial c: getListaRedesSociales()){
              System.out.println(contador + ". " + c.getRedSocial() + ":" + c.getCuenta());
            }
            System.out.println("Ingresar el número de la cuenta a borrar");
            int numCuenta = sc.nextInt();
            sc.nextLine();
            getListaRedesSociales().remove(numCuenta);
          }   
          break;
        default:
          break;
      }
    }

    public SectorCubierto getSector() {
        return sector;
    }

    public void setSector(SectorCubierto sector) {
        this.sector = sector;
    }

    public ArrayList<Stand> getStandsAsignados() {
        return standsAsignados;
    }

    public void setStandsAsignados(ArrayList<Stand> standsAsignados) {
        this.standsAsignados = standsAsignados;
    }
    
    
    
}
