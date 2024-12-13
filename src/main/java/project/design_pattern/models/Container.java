package project.design_pattern.models;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private static Container instance;
    private Map<String, Agent> agents;

    private Container() {
        agents = new HashMap<>();
    }

    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void ajouterAgent(Agent agent) {
        agents.put(agent.getNom(), agent);
    }

    public void supprimerAgent(String nomAgent) {
        agents.remove(nomAgent);
    }

    public Agent rechercherAgent(String nomAgent) {
        return agents.get(nomAgent);
    }

    public void afficherEtat() {
        agents.values().forEach(System.out::println);
    }
}
