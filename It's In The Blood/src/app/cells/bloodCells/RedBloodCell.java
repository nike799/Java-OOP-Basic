package app.cells.bloodCells;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
        super.setEnergy(super.getHealth() + this.velocity);
    }

    public int getVelocity() {
        return this.velocity;
    }

    protected void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(String.format("------Cell %s [%d,%d]%n",super.getId(),super.getPositionRow(),super.getPositionCol()))
               .append(String.format("--------Health: %d | Velocity: %d | Energy: %d%n",
                       super.getHealth(),this.getVelocity(),super.getEnergy()));
       return sb.toString();
    }
}
