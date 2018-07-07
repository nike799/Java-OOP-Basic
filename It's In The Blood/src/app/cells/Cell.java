package app.cells;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;
    private int energy;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public int getEnergy() {
        return this.energy;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getId() {
        return this.id;
    }

    public int getHealth() {
        return this.health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    protected void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

}
