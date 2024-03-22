
package amigosnumer;
import java.util.Scanner;

public class AmigosNumer {

   
    public static void main(String[] args) {
   
    //Designamos la cantidad de participantes 
    System.out.println("Cantidad de participantes");   
    
    //Scanner para tomar informacion del usuario
    Scanner teclado= new Scanner(System.in);

    //Nombre de los participantes    
    int participantes=teclado.nextInt();
    teclado.nextLine();

    //AGREGAMOS PARTICIPANTES
    String nombres[] = new String [participantes];
    
    for (int i = 0; i < participantes; i++) {
        System.out.println("Ingrese nombre del participante");
        nombres[i]=teclado.nextLine(); 
    }


    //Matriz para los calculos
    int plata[][] =new int [participantes][3];
     
    //CALCULO DEL TOTAL DE LOS GASTOS 
    int gastos=0;
    
    for (int f = 0; f < participantes; f++) {
            System.out.println("Cuanto puso " + nombres[f]);   
            plata[f][0]=teclado.nextInt();
            teclado.nextLine();
    }
    for (int i = 0; i < participantes; i++) {
        gastos += plata[i][0];
    }
     
   System.out.println("El gasto total es: " + gastos);
      
   gastos = gastos / participantes;  
   
   System.out.println("Cada uno debe poner " + gastos);

    //CALCULAMOS CUANTO DEBE O TIENE A FAVOR CADA UNO 

    int saldo; 
    int real;

    for (int f = 0; f < participantes; f++) {

        for (int c = 0; c <1 ; c++) {
            
             if (plata[f][0] < gastos) {
                    
                saldo= gastos - plata[f][0];
                real= plata[f][0] - gastos;
                plata[f][1]=real * -1;  
                System.out.println(nombres[f] + " Debe poner " + saldo);

             } else if(plata[f][0] > gastos) {
                
                saldo=plata[f][0]-gastos;
                real=saldo;

                plata[f][1]=real* -1;
                System.out.println(nombres[f] + " Tiene que recibir " + saldo);

             }else if(plata[f][0] == gastos){
                System.out.println( nombres[f] + " No debe poner nada ");
             }

        }
    }
    
      

   int calculo; 
        for (int f = 0; f < participantes; f++) {
            //filtro los saldos positivos
            if (plata[f][1]<0) {
                
               for (int c = 0; c < participantes; c++) {
               
                   if (plata[c][1]>0) {
                       
                       calculo= plata[f][1]+plata[c][1]; 
                       
                       
                       if (calculo < 0 && calculo!=0) {
                           
                           System.out.println( nombres[c] + " Tiene que darle " + plata[c][1] + "a " + nombres[f]);
                            plata[c][1]=plata[c][1] - plata[c][1]; 
                            plata[f][1]= calculo; 
                            
                       }else if(calculo > 0 && calculo!=0) {
                           plata[f][1]=plata[f][1]*-1;  
                           plata[c][1]=calculo;  
                            System.out.println(nombres[c] + " Tiene que darle " + plata[f][1] + "a " + nombres[f]);
                           plata[f][1]=plata[f][1]-plata[f][1] ;
                       }
                       
                       else{
                           System.out.println(nombres[c] + "Tiene que darle " + plata[c][1] + "a " + nombres[f] );
                       }
 
                       
  
                       
                        } 
                       
                   
                   }
                 }
               }
            }
        
}

    

  


