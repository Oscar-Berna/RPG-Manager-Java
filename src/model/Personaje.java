package model;

public class Personaje {

    private int    id;
    private String nombre;
    private String clase;
    private int    nivel;
    private double vida;
    private double vidaMaxima;
    private int    ataque;
    private int    defensa;

    public Personaje(String nombre, String clase, int nivel,
                     double vida, double vidaMaxima,
                     int ataque, int defensa, int id) {
        this.id        = id;
        this.nombre    = nombre;
        this.clase     = clase;
        this.nivel     = nivel;
        this.vida      = vida;
        this.vidaMaxima= vidaMaxima;
        this.ataque    = ataque;
        this.defensa   = defensa;
    }

    public Personaje(String nombre, String clase,
                     double vidaMaxima, int ataque, int defensa) {
        this(nombre, clase, 1, vidaMaxima, vidaMaxima, ataque, defensa, 0);
    }

    public int    getId()        { return id; }
    public String getNombre()    { return nombre; }
    public String getClase()     { return clase; }
    public int    getNivel()     { return nivel; }
    public double getVida()      { return vida; }
    public double getVidaMaxima(){ return vidaMaxima; }
    public int    getAtaque()    { return ataque; }
    public int    getDefensa()   { return defensa; }

    public void setNivel(int n) {
        if      (n < 1)  this.nivel = 1;
        else if (n > 50) this.nivel = 50;
        else             this.nivel = n;
    }

    public String habilidadEspecial() {
        return nombre + " usa una habilidad basica";
    }

    @Override
    public String toString() {
        return String.format("[%s] %s Nv%d | HP:%.0f/%.0f | ATK:%d DEF:%d",
                clase, nombre, nivel, vida, vidaMaxima, ataque, defensa);
    }
}