package project.design_pattern.aspects;

import project.design_pattern.annotations.Strategy;
import project.design_pattern.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HistoryStrategy implements Strategy {
    private List<Transaction> historique = new ArrayList<>();

    @Override
    public void execute(String nomAgent, Transaction transaction) {
        historique.add(transaction);
        System.out.println("Historique mis à jour : " + historique);
    }
}