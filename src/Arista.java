
public class Arista {

    private String nodoPartida;
    private String nodoLlegada;
    private String longitud;

    Arista(String nodoPartida,String nodoLlegada,String longitud){
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

    public String getLongitud() {
        return longitud;
    }
}
