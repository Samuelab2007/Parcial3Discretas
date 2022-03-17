import java.util.ArrayList;


public class Vertice {

    private String id;
    private ArrayList<Vertice> nodosEnlazados = new ArrayList<>();

    Vertice(String id){
        this.id = id;
    }

    public void setNodosEnlazados(Vertice nodoAEnlazar) {
        this.nodosEnlazados.add(nodoAEnlazar);
    }
    public String getId() {
        return id;
    }


}
