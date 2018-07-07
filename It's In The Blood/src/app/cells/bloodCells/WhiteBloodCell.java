package app.cells.bloodCells;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
        super.setEnergy((super.getHealth() + this.size) * 2);
    }

    public int getSize() {
        return this.size;
    }

    protected void setSize(int size) {
        this.size = size;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("------Cell %s [%d,%d]%n",super.getId(),super.getPositionRow(),super.getPositionCol()))
                .append(String.format("--------Health: %d | Size: %d | Energy: %d%n",
                        super.getHealth(),this.getSize(),super.getEnergy()));
        return sb.toString();
    }
}
