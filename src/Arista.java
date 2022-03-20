
public class Arista {

    private int nodoPartida;
    private int nodoLlegada;
    private int longitud;

    Arista(int nodoPartida,int nodoLlegada,int longitud){
        this.nodoPartida = nodoPartida;
        this.nodoLlegada = nodoLlegada;
        this.longitud = longitud;
    }

    public int getNodoPartida() {
        return nodoPartida;
    }

    public int getNodoLlegada() {
        return nodoLlegada;
    }

    public int getLongitud() {
        return longitud;
    }
}
