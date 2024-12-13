package project.design_pattern.services;

import org.springframework.stereotype.Service;
import project.design_pattern.models.Agent;
import project.design_pattern.models.Transaction;

import java.util.HashMap;
import java.util.Map;

@Service
public class AgentService {

    private Map<String, Agent> agents = new HashMap<>();

    public void ajouterAgent(Agent agent) {
        if (agent == null || agents.containsKey(agent.getNom())) {
            System.out.println("L'agent est null ou déjà existant.");
        } else {
            agents.put(agent.getNom(), agent);
            System.out.println("Agent ajouté : " + agent.getNom());
        }
    }


    public Agent getAgentByName(String name) {
        return agents.get(name);
    }

    public void removeAgent(String name) {
        agents.remove(name);
        System.out.println("Agent supprimé : " + name);
    }

    public void afficherAgents() {
        if (agents.isEmpty()) {
            System.out.println("Aucun agent dans le conteneur.");
        } else {
            agents.forEach((nom, agent) -> System.out.println("Agent: " + nom));
        }
    }
}
