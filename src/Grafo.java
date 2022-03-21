import java.util.ArrayList;

public class Grafo {

    private ArrayList<String> vertices = new ArrayList<>();
    private ArrayList<Arista> aristas = new ArrayList<>();
    private ArrayList<Integer> idenficacionesAristas = new ArrayList<>();
    private int[][] matrizAdyacencia;
    private int[][] matrizIncidencia;


    Grafo(String verticeInicial){       //Cualquier grafo debe tener como mínimo 1 vertice.
        this.vertices.add(verticeInicial);
    }

    public ArrayList<String> getVertices() {
        return vertices;
    }

    public ArrayList<Integer> getIdenficacionesAristas() {
        return idenficacionesAristas;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public int[][] getMatrizIncidencia() {
        return matrizIncidencia;
    }

    public void conectarVertice(Arista conexion) {   //Anhade la arista a la lista y los vértices que hagan falta
        if (!this.aristas.contains(conexion)) {
            boolean coincidencia = false;           //Este pedazo está para que las aristas al NO ser dirigidas, sean identificadas por un solo número, el de su longitud
                                                    //Esto con el fin de evitar un IndexOutOfBoundsException
            for (Arista arista : aristas) {
                if ((arista.getNodoLlegada().equals(conexion.getNodoPartida())) && (arista.getNodoPartida().equals(conexion.getNodoLlegada()))) {
                    coincidencia = true;
                    break;
                }
            }
            if(!coincidencia){this.idenficacionesAristas.add(conexion.getLongitud());}
            this.aristas.add(conexion);
            if (this.vertices.contains(conexion.getNodoPartida())) {
                if (!this.vertices.contains(conexion.getNodoLlegada())) {
                    this.vertices.add(conexion.getNodoLlegada());
                }
            } else if (!this.vertices.contains(conexion.getNodoPartida())) {
                this.vertices.add(conexion.getNodoPartida());       /*En este caso siempre debe haber un nodo de llegada en el grafo, si no hubiera daría la
                                                                 posibilidad de crear un grafo de dos nodos aparte del resto de la estructura.
                                                                    */
            }
        }
    }

    public boolean noDirigido(){
        for(int i=0;i<aristas.size();i++){
            boolean encuentraParConexiones = false;
            for (Arista arista : aristas) {    //Se deja el enhanced for por facilidad para comprensión
                if ((aristas.get(i).getNodoPartida().equals(arista.getNodoLlegada())) && (aristas.get(i).getNodoLlegada().equals(arista.getNodoPartida()))) {
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

    public void actualizarMatrizAdyacencia(){       //Actualizo la matriz de adyacencia.
        matrizAdyacencia = new int[vertices.size()][vertices.size()];
                //Si el grafo es dirigido la matriz no sería simétrica
        for (String vertex : vertices) {
            for (Arista arista : aristas) {
                if (vertex.equals(arista.getNodoPartida())) {
                    matrizAdyacencia[vertices.indexOf(vertex)][vertices.indexOf(arista.getNodoLlegada())] = 1;    //1 si existe el lado
                }
            }
        }
    }

    public void actualizarMatrizIncidencia() throws MatrizIncalculableException{       //Solo se calcula para grafo NO dirigido
        if(noDirigido()){
            matrizIncidencia = new int[vertices.size()][aristas.size()/2];
            for (String vertice : vertices) {
                for (Arista arista : aristas) {
                    if (vertice.equals(arista.getNodoPartida())) {
                        matrizIncidencia[vertices.indexOf(vertice)][idenficacionesAristas.indexOf(arista.getLongitud())] = 1;
                    }
                }
            }
        }else{
            throw new MatrizIncalculableException();
        }
    }

    public int gradoDelVertice(String vertice){
        int gradoEntrante=0;
        int gradoSaliente=0;
        for (Arista arista : aristas) {
            if (vertice.equals(arista.getNodoPartida())) {
                gradoSaliente++;
            }
        }
        for (Arista arista:aristas) {
            if(vertice.equals(arista.getNodoLlegada())) {
                gradoEntrante++;
            }
        }
        if(noDirigido()) {
            return gradoSaliente;
        }
        else{   //Cuando el grado es dirigido
            return gradoSaliente+gradoEntrante;
        }
    }

    public boolean esRegular(){
        int i=0;
        while(i < vertices.size()-1){
            if(gradoDelVertice(vertices.get(i)) != gradoDelVertice(vertices.get(i+1))){     //Compruebo que todos tengan el mismo grado
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean esCompleto(){
        //Ya que utilizo todas mis aristas como dirigidas, uso n*(n-1) == numero aristas
        return vertices.size() * (vertices.size() - 1) == aristas.size();
    }

    public boolean esEuleriano(){
        int i=0;
        while(i<vertices.size()-1){
            if(gradoDelVertice(vertices.get(i))%2 != 0){
                return false;
            }
            i++;
        }
        return true;
    }
}