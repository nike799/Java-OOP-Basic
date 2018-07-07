package app.factories;

import app.clusters.Cluster;

public class ClusterFactory {
    public Cluster createCluster(String id, int rows, int cols){
        return new Cluster(id,rows,cols);
    }
}
