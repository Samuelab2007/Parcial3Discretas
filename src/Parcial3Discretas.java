import java.util.Scanner;

public class Parcial3Discretas {


    public static void escribirMatriz(int[][] matriz,int tipoMatriz,Grafo grafo){

        if(tipoMatriz==1){
            System.out.print("    ");
            for(int i=0;i<grafo.getVertices().size();i++){
                System.out.print(" " + grafo.getVertices().get(i) + " ");
            }
            System.out.println();
        }

        if(tipoMatriz==2){
            System.out.print("    ");
            for(int iterador = 0; iterador<grafo.getIdenficacionesAristas().size();iterador++) {
                System.out.print(" "+grafo.getIdenficacionesAristas().get(iterador)+" ");
            }
            System.out.println();
        }
        for(int i=0;i<matriz.length;i++){
            System.out.print(grafo.getVertices().get(i) + "  ");
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j] + " ");
            }
            System.out.println("|");

        }
    }


    static Scanner lectura = new Scanner(System.in);
    public static void main(String[] args) {
        //Se están tratando cada arista como dirigida, para expresar un grafo no dirigido se necesita construir pares de aristas en direcciones opuestas


        System.out.println("Empezaremos creando un grafo");
        System.out.print("Primer vertice del grafo: ");
        String nodoInicial = lectura.next();
        Grafo grafo = new Grafo(nodoInicial);

        for(;;) {
            System.out.println("Elija la accion a realizar");
            System.out.println("1. Anhadir una arista al grafo");
            System.out.println("2. Matriz de adyacencia");
            System.out.println("3. Matriz de incidencia");
            System.out.println("4. Tipo de grafo");
            System.out.println("0. Salir del programa");
            int opcionMenu = lectura.nextInt();
            switch (opcionMenu) {
                case 1:
                    System.out.print("Nodo de partida: ");
                    String nodoPartida = lectura.next();
                    System.out.print("Nodo de llegada: ");
                    String nodoLlegada = lectura.next();
                    System.out.print("Longitud: ");
                    String longitud = lectura.next();

                    grafo.conectarVertice(new Arista(nodoPartida, nodoLlegada, longitud));
                    break;
                case 2:
                    grafo.actualizarMatrizAdyacencia();
                    escribirMatriz(grafo.getMatrizAdyacencia(), 1, grafo);
                    break;
                case 3:
                        grafo.actualizarMatrizIncidencia();
                        escribirMatriz(grafo.getMatrizIncidencia(), 2, grafo);
                        break;
                case 4:
                    System.out.println("\nEl grafo es: ");
                    if (grafo.noDirigido()) {
                        System.out.println("No dirigido");
                    } else {
                        System.out.println("Dirigido");
                    }
                    if (grafo.esRegular()) {
                        System.out.println("Regular");
                    }
                    if (grafo.esCompleto()) {
                        System.out.println("Completo");
                    }
                    if (grafo.esEuleriano()) {
                        System.out.println("Euleriano");
                    }
                    System.out.println();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }

    }
}
