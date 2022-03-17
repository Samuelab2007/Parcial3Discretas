import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private ArrayList<Vertice> vertices = new ArrayList<>();
    private boolean grafoDirigido;

    Grafo(String esDirigido){
        if(esDirigido.equalsIgnoreCase("si")){
            grafoDirigido = true;
        }else{grafoDirigido = false;}
    }

    public void anhadirVertice(Vertice nodo){
        this.vertices.add(nodo);
    }
    public void conectarVertice(Vertice nodoAConectar,Vertice nodoAlCualSeEnlaza){
        if(!this.grafoDirigido) {
            nodoAConectar.setNodosEnlazados(nodoAlCualSeEnlaza);    //Conecto los dos nodos entre sí
            nodoAlCualSeEnlaza.setNodosEnlazados(nodoAConectar);
        }else{
            nodoAConectar.setNodosEnlazados(nodoAlCualSeEnlaza);    //Enlazo hacia el nodoAlCualSeEnlaza
        }
    }


}
