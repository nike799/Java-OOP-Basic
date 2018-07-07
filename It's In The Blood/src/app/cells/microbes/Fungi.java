package app.cells.microbes;

public class Fungi extends Microbe {
    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
        super.setEnergy((super.getHealth() + super.getVirulence()) / 4);
    }
}
