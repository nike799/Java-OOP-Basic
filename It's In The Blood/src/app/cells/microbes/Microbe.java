package app.cells.microbes;

import app.cells.Cell;

public abstract class Microbe extends Cell {
    private int	virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }

    protected void setVirulence(int virulence) {
        this.virulence = virulence;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("------Cell %s [%d,%d]%n",super.getId(),super.getPositionRow(),super.getPositionCol()))
                .append(String.format("--------Health: %d | Virulence: %d | Energy: %d%n",
                        super.getHealth(),this.getVirulence(),super.getEnergy()));
        return sb.toString();
    }
}
