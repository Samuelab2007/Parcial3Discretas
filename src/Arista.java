
public class Arista {

    private String nodoPartida;
    private String nodoLlegada;
    private int longitud;

    Arista(String nodoPartida,String nodoLlegada,int longitud){
        this.nodoPartida = nodoPartida;
        this.nodoLlegada = nodoLlegada;
        this.longitud = longitud;
    }

    public String getNodoPartida() {
        return nodoPartida;
    }

    public String getNodoLlegada() {
        return nodoLlegada;
    }

    public int getLongitud() {
        return longitud;
    }
}
