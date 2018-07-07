package app.cells.microbes;

public class Virus extends Microbe {
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
        super.setEnergy(super.getHealth() + super.getVirulence());
    }
}
