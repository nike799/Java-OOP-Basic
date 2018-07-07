package app.factories;

import app.organisms.Organism;

public class OrganismFactory {

    public Organism createOrganism (String name){
        return new Organism(name);
    }
}
