package taller2;
//Nicolás Lucero - 22.221.136-0 - ICCI
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {

	static String[] participantes = new String[200];
	static int cantParticipantes =0;
	
	static Consumo[] consumos = new Consumo[20];
	static int cantConsumos =0;
	
	
	public static void main(String[] args) {
		
		leerParticipantes();
        leerConsumos();
				
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        
        
        do {
            System.out.println("========================================");
            System.out.println("            LA FONDA DEL PAPU");
            System.out.println("========================================");
            System.out.println("Registros cargados: " + cantConsumos);
            System.out.println("----------------------------------------");
            System.out.println("[1] Ver registros");
            System.out.println("[2] Actualizar registros");
            System.out.println("[3] Calcular metricas");
            System.out.println("[4] Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opcion: ");
            
            String entrada = teclado.nextLine();
            
            try {
                opcion = Integer.parseInt(entrada);
                
               
                switch (opcion) {
                    case 1:
                    	submenuVerRegistros(teclado);
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    default:
                        
                        System.out.println(">> Error: opcion fuera de rango. Intente nuevamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                if (entrada.trim().isEmpty()) {
                    System.out.println(">> Error: no ingreso ninguna opcion. Intente nuevamente.");
                } else {
                    System.out.println(">> Error: la opcion debe ser un numero entre 1 y 4. Intente nuevamente.");
                }
            }
        } while (opcion != 4);
	}
	
	public static void submenuVerRegistros(Scanner teclado) {
        int opcion = -1;
        do {
            System.out.println("\n============= VER REGISTROS =============");
            System.out.println("[1] Choripanes");
            System.out.println("[2] Terremotos");
            System.out.println("[3] Volver al menu principal");
            System.out.println("=========================================");
            System.out.print("Seleccione una opcion: ");
            
            String entrada = teclado.nextLine();
            try {
                opcion = Integer.parseInt(entrada);
                switch (opcion) {
                    case 1:
                        mostrarChoripanes();
                        
                        break;
                    case 2:
                        mostrarTerremotos();
                        
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Error: opcion fuera de rango. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: la opcion debe ser un numero valido. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    public static void mostrarChoripanes() {
        System.out.println("\n================ CHORIPANES ================");
        
        System.out.println("# \t Consumidor \t Largo \t Ancho \t Fecha \t\t KCal");
        
        int contador = 0;
        for (int i = 0; i < cantConsumos; i++) {
            if (consumos[i].getTipo().equals("Choripan")) {
                contador++;
                Choripan c = (Choripan) consumos[i];
                
             
                double caloriasRedondeadas = Math.round(c.calcularCalorias() * 100.0) / 100.0;
                
                System.out.println(contador + " \t " + c.getConsumidor() + " \t " + c.getLargo() + " cm \t " + c.getAncho() + " cm \t " + c.getFecha() + " \t " + caloriasRedondeadas);
            }
        }
        System.out.println("--------------------------------------------");
        System.out.println("Total: " + contador + " choripanes registrados");
        System.out.println("============================================");
    }

    public static void mostrarTerremotos() {
        System.out.println("\n================ TERREMOTOS ================");
        System.out.println("# \t Consumidor \t Litros \t Fecha \t\t KCal");
        
        int contador = 0;
        double totalLitros = 0;
        
        for (int i = 0; i < cantConsumos; i++) {
            if (consumos[i].getTipo().equals("Terremoto") ) {
                contador++;
                Terremoto t = (Terremoto) consumos[i];
                
                totalLitros = totalLitros + t.getLitros();
                double caloriasRedondeadas = Math.round(t.calcularCalorias() * 100.0) / 100.0;
                
                System.out.println(contador + " \t " + t.getConsumidor() + " \t " + t.getLitros() + " L \t " + t.getFecha() + " \t " + caloriasRedondeadas);
            }
        }
        System.out.println("--------------------------------------------");
        System.out.println("Total: " + contador + " terremotos registrados (" + totalLitros + " L)");
        System.out.println("============================================");
    }

   

    public static void leerConsumos() {
        try {
            File archivo = new File("Consumido.txt");
            if (!archivo.exists()) {
                System.out.println(">> ADVERTENCIA: no se encontro el archivo \"Consumido.txt\".");
                System.out.println("   Se iniciara el programa sin registros previos.");
                return;
            }
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine() && cantConsumos < 200) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(";");
                
                if (partes[0].equals("Choripan")) {
                   
                
                    consumos[cantConsumos] = new Choripan(partes[1], partes[4], Integer.parseInt(partes[2]), Integer.parseInt(partes[3]));
                    cantConsumos++;
                } else if (partes[0].equals("Terremoto")) {
                   
                   
                    consumos[cantConsumos] = new Terremoto(partes[1], partes[3], Double.parseDouble(partes[2]));
                    cantConsumos++;
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error al leer Consumido.txt");
        }
    }


	public static void leerParticipantes() {
        try {
            File archivo = new File("Participantes.txt");
            if (archivo.exists()) {
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine() && cantParticipantes < 200) {
                    participantes[cantParticipantes] = scanner.nextLine().trim();
                    cantParticipantes++;
                }
                scanner.close();
            }
        } catch (Exception e) {
            System.out.println("Error al leer Participantes.txt");
        }
    }
	
	
}