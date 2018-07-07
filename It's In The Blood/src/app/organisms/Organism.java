package app.organisms;

import app.cells.Cell;
import app.clusters.Cluster;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;

public class Organism {
    private String name;
    private Collection<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayDeque<>();
    }

    public String getName() {
        return this.name;
    }

    public Collection<Cluster> getClusters() {
        return Collections.unmodifiableCollection(this.clusters);
    }
    public Collection<Cluster> takeClusters() {
        return this.clusters;
    }
    public void addingCluster(Cluster cluster){
        this.clusters.add(cluster);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int countClusters = this.clusters.size();
        int countCells = 0;

        for (Cluster cluster : this.clusters) {
            countCells += cluster.getCells().size();
        }
        sb.append(String.format("Organism - %s%n", this.name))
                .append(String.format("--Clusters: %d%n", countClusters))
                .append(String.format("--Cells: %d%n", countCells));
        for (Cluster cluster : this.clusters) {
            sb.append(String.format("----Cluster %s%n", cluster.getId()));
            for (Cell cell : cluster.getCells()) {
                sb.append(cell);
            }
        }
        return sb.toString();
    }
}
