package project.design_pattern.aspects;


import project.design_pattern.annotations.Strategy;
import project.design_pattern.models.Transaction;

public class DefaultStrategy implements Strategy {
    @Override
    public void execute(String nomAgent, Transaction transaction) {
        System.out.println("Notification reçue de l'agent " + nomAgent + " : " + transaction);
    }
}