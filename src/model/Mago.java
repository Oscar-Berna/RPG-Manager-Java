package model;

public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre, "Mago", 70, 28, 5);
    }

    public Mago(String nombre, int nivel, double vida,
                double vidaMaxima, int ataque, int defensa, int id) {
        super(nombre, "Mago", nivel, vida, vidaMaxima, ataque, defensa, id);
    }

    @Override
    public String habilidadEspecial() {
        return getNombre() + " lanza BOLA DE FUEGO y causa " + (getAtaque() * 3) + " de dano!";
    }
}