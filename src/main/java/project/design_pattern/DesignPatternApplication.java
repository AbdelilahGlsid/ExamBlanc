package project.design_pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.design_pattern.aspects.HistoryStrategy;
import project.design_pattern.aspects.ScoringStrategy;
import project.design_pattern.models.Agent;
import project.design_pattern.models.Transaction;
import project.design_pattern.services.AgentService;

@SpringBootApplication
public class DesignPatternApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplication.class, args);
    }

    @Autowired
    private AgentService agentService;


    @Override
    public void run(String... args) throws Exception {

        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");


        agentService.ajouterAgent(agent1);
        agentService.ajouterAgent(agent2);


        Transaction transaction1 = new Transaction.Builder()
                .id("T1")
                .date("2024-12-13")
                .type("Vente")
                .build();

        Transaction transaction2 = new Transaction.Builder()
                .id("T2")
                .date("2024-12-14")
                .type("Achat")
                .build();

        agent1.souscrire(agent2);
        agent2.souscrire(agent1);

        agent1.notifierObservateurs(transaction1);
        agent2.notifierObservateurs(transaction2);


        agent1.setStrategy(new ScoringStrategy());
        agent2.setStrategy(new HistoryStrategy());

        }
}
