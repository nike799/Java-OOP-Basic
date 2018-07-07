package app.clusters;

import app.cells.Cell;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Cluster {
    private String id;
    private  int rows;
    private int cols;
    private Collection<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new LinkedList<>();
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public Collection<Cell> getCells() {
        return Collections.unmodifiableCollection(this.cells);
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected void setRows(int rows) {
        this.rows = rows;
    }

    protected void setCols(int cols) {
        this.cols = cols;
    }

    protected void setCells(Collection<Cell> cells) {
        this.cells = cells;
    }
    public void addCell (Cell cell){
        this.cells.add(cell);
    }

    @Override
    public String toString() {
        return "Cluster{}";
    }
}
