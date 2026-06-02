package model;

public class Guerrero extends Personaje {

    public Guerrero(String nombre) {
        super(nombre, "Guerrero", 100, 18, 12);
    }

    public Guerrero(String nombre, int nivel, double vida,
                    double vidaMaxima, int ataque, int defensa, int id) {
        super(nombre, "Guerrero", nivel, vida, vidaMaxima, ataque, defensa, id);
    }

    @Override
    public String habilidadEspecial() {
        return getNombre() + " usa GOLPE DEVASTADOR y causa " + (getAtaque() * 2) + " de dano!";
    }
}