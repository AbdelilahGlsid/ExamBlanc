package project.design_pattern.aspects;

import project.design_pattern.annotations.Strategy;
import project.design_pattern.models.Transaction;

public class ScoringStrategy implements Strategy {
    private double solde = 0;

    @Override
    public void execute(String nomAgent, Transaction transaction) {
        if ("Vente".equals(transaction.getType())) {
            solde += transaction.getMontant();
        } else if ("Achat".equals(transaction.getType())) {
            solde -= transaction.getMontant();
        }
        System.out.println("Nouveau solde après notification : " + solde);
    }
}
