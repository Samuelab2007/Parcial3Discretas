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

    public static void main(String[] args) {
        //Se están tratando cada arista como dirigida, para expresar un grafo no dirigido se necesita construir pares de aristas en direcciones opuestas
        Grafo grafoPrueba = new Grafo(1);
        Arista aristaPrueba = new Arista(1,2,5);
        grafoPrueba.conectarVertice(aristaPrueba);
        grafoPrueba.conectarVertice(new Arista(2,1,5));
        grafoPrueba.conectarVertice(new Arista(1,3,6));
        grafoPrueba.conectarVertice(new Arista(4,3,3));
        grafoPrueba.conectarVertice(new Arista(3,4,3));
        grafoPrueba.conectarVertice(new Arista(3,1,6));

        System.out.println(grafoPrueba.noDirigido());
        grafoPrueba.actualizarMatrizAdyacencia();
        escribirMatriz(grafoPrueba.getMatrizAdyacencia(),1,grafoPrueba);
        System.out.println();
        try {       //Prueba matriz adyacencia
            grafoPrueba.actualizarMatrizIncidencia();
            escribirMatriz(grafoPrueba.getMatrizIncidencia(),2,grafoPrueba);

        }catch(MatrizIncalculableException e){
            System.out.println(e.getMessage());
        }

        //TODO: Hay que mostrar de que tipo es el grafo, ya está adelantado para grafo dirigido.
        //TODO: Manejo de excepciones

    }
}
