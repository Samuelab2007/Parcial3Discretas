import java.util.ArrayList;

public class Grafo {

    private ArrayList<Integer> vertices = new ArrayList<>();
    private ArrayList<Arista> aristas = new ArrayList<>();
    private int[][] matrizAdyacencia;


    Grafo(Integer verticeInicial){       //Cualquier grafo debe tener como mínimo 1 vertice.
        this.vertices.add(verticeInicial);
    }

    public ArrayList<Integer> getVertices() {
        return vertices;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public void conectarVertice(Arista conexion) {   //Anhade la arista a la lista y los vértices que hagan falta
        if (!this.aristas.contains(conexion)) {

            this.aristas.add(conexion);
            if (this.vertices.contains(conexion.getNodoPartida())) {
                if (!this.vertices.contains(conexion.getNodoLlegada())) {
                    this.vertices.add(conexion.getNodoLlegada());
                }
            } else if (!this.vertices.contains(conexion.getNodoPartida())) {
                this.vertices.add(conexion.getNodoPartida());       /*En este caso siempre debe haber un nodo de llegada en el grafo, sino hubiera daría la
                                                                 posibilidad de crear un grafo de dos nodos aparte del resto de la estructura.
                                                                    */
            }
        }
    }

    public boolean noDirigido(){
        for(int i=0;i<aristas.size();i++){
            boolean encuentraParConexiones = false;
            for(int j=0;j < aristas.size();j++){    //Se deja el enhanced for por facilidad para comprensión
                if ((aristas.get(i).getNodoPartida() == aristas.get(j).getNodoLlegada()) && (aristas.get(i).getNodoLlegada()  == aristas.get(j).getNodoPartida())) {
                    encuentraParConexiones = true;      //Si en algun momento no encuentra el par al iterar por el vector, daría false
                    break;
                }           //Las comparaciones arrancan en 0 siempre para tener en cuenta que ya se halla encontrado con anterioridad el par de aristas; si comparaba con int j=i+1 se ignoraban estas, dando un resultado erroneo.
            }
            if(!encuentraParConexiones){
                return false;
            }           //El algoritmo se basa en que si entra al if en algún momento ya se descarta que el grafo no sea dirigido.
        }
        return true;
    }

    public void actualizarMatrizAdyacencia() throws MatrizIncalculableException{       //Actualizo la matriz de adyacencia.
        matrizAdyacencia = new int[vertices.size()][vertices.size()];
        if(noDirigido()) {          //Si el grafo es dirigido la matriz de adyacencia estaría vacía.
            for (int i=0;i< vertices.size();i++){
                for(int j=0;j<aristas.size();j++){
                    if(vertices.get(i) == aristas.get(j).getNodoPartida()){
                        matrizAdyacencia[vertices.get(i)-1][aristas.get(j).getNodoLlegada()-1] = 1;    //1 si existe el lado
                    }
                }
            }
        }else{
            throw new MatrizIncalculableException();
        }
    }
}
