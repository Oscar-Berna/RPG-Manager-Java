package model;

public class Arquero extends Personaje {

    public Arquero(String nombre) {
        super(nombre, "Arquero", 85, 22, 8);
    }

    public Arquero(String nombre, int nivel, double vida,
                   double vidaMaxima, int ataque, int defensa, int id) {
        super(nombre, "Arquero", nivel, vida, vidaMaxima, ataque, defensa, id);
    }

    @Override
    public String habilidadEspecial() {
        return getNombre() + " dispara FLECHA CERTERA y causa " + (int)(getAtaque() * 2.5) + " de dano!";
    }
}