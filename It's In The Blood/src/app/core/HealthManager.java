package app.core;

import app.cells.Cell;
import app.clusters.Cluster;
import app.factories.CellFactory;
import app.factories.ClusterFactory;
import app.factories.OrganismFactory;
import app.organisms.Organism;
import app.utilities.Constants;

import java.util.HashMap;
import java.util.Map;

public class HealthManager {
    Map<String, Organism> organisms;
    private OrganismFactory organismFactory;
    private ClusterFactory clusterFactory;
    private CellFactory cellFactory;

    public HealthManager() {
        this.organisms = new HashMap<>();
        this.organismFactory = new OrganismFactory();
        this.clusterFactory = new ClusterFactory();
        this.cellFactory = new CellFactory();
    }

    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return String.valueOf(this.organisms.get(organismName));
        } else {
            return Constants.EMPTY;
        }
    }

    public String createOrganism(String organismName) {
        if (!this.organisms.containsKey(organismName)) {
            Organism organism = this.organismFactory.createOrganism(organismName);
            this.organisms.put(organismName, organism);
            return String.format("Created organism %s%n", organismName);
        } else {
            return String.format("Organism %s already exists%n", organismName);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        Cluster cluster = clusterFactory.createCluster(id, rows, cols);
        if (this.organisms.containsKey(organismName)) {
            boolean hasCluster = this.organisms.get(organismName).getClusters().stream().anyMatch(c -> c.getId().equals(id));
            if (!hasCluster) {
                this.organisms.get(organismName).addingCluster(cluster);
                return String.format("Organism %s: Created cluster %s%n", organismName, cluster.getId());
            } else {
                return Constants.EMPTY;
            }
        } else {
            return Constants.EMPTY;
        }
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId,
                          int health, int positionRow, int positionCol, int additionalProperty) {
        Cell cell = cellFactory.createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);
        StringBuilder sb = new StringBuilder();
        if (this.organisms.containsKey(organismName)) {
            for (Cluster cluster : this.organisms.get(organismName).getClusters()) {
                if (cluster.getId().equals(clusterId)) {
                    cluster.addCell(cell);
                }
            }
            sb.append(String.format("Organism %s: Created cell %s in cluster %s%n", organismName, cellId, clusterId));
        }

        return sb.toString();
    }
}
