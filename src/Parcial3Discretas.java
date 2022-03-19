public class Parcial3Discretas {


    public static void escribirMatrizAdyacencia(int[][] matriz){
        for(int i=0;i<matriz.length;i++){
            System.out.print("|");
            for(int j=0;j< matriz.length;j++){
                System.out.print(" "+matriz[i][j]+" ");
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
        grafoPrueba.conectarVertice(new Arista(1,3,4));
        grafoPrueba.conectarVertice(new Arista(4,3,4));
        grafoPrueba.conectarVertice(new Arista(3,4,4));
        grafoPrueba.conectarVertice(new Arista(3,1,6));
        System.out.println(grafoPrueba.noDirigido());
        try {       //Prueba matriz adyacencia
            grafoPrueba.actualizarMatrizAdyacencia();
            escribirMatrizAdyacencia(grafoPrueba.getMatrizAdyacencia());

        }catch(MatrizIncalculableException e){
            System.out.println(e.getMessage());
        }
    }
}
