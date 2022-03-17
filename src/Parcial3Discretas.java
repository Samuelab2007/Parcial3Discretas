public class Parcial3Discretas {

    public static void main(String[] args){

        Grafo grafoPrueba = new Grafo("no");
        Vertice verticePrueba = new Vertice("1");
        Vertice paraConectar = new Vertice("2");
        grafoPrueba.anhadirVertice(verticePrueba);
        grafoPrueba.anhadirVertice(paraConectar);
        grafoPrueba.conectarVertice(verticePrueba,paraConectar);

        System.out.println(grafoPrueba);
        System.out.println(verticePrueba);
        System.out.println(paraConectar);
    }



}
