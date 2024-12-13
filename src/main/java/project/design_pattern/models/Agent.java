package project.design_pattern.models;

import project.design_pattern.annotations.Cachable;
import project.design_pattern.annotations.Log;
import project.design_pattern.annotations.SecuredBy;
import project.design_pattern.annotations.Strategy;
import project.design_pattern.aspects.DefaultStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agent {
    private String nom;
    private List<Transaction> transactions;
    private Set<Agent> observateurs;
    private Strategy strategy;

    public Agent(String nom) {
        this.nom = nom;
        this.transactions = new ArrayList<>();
        this.observateurs = new HashSet<>();
        this.strategy = new DefaultStrategy(); // Stratégie par défaut
    }

    public String getNom() {
        return nom;
    }

    @Log
    @SecuredBy(roles = {"ADMIN"})
    public void ajouterTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifierObservateurs(transaction);
    }


    public void souscrire(Agent agent) {
        observateurs.add(agent);
    }

    public void notifierObservateurs(Transaction transaction) {
        for (Agent observateur : observateurs) {
            observateur.recevoirNotification(this.nom, transaction);
        }
    }

    public void recevoirNotification(String nomAgent, Transaction transaction) {
        strategy.execute(nomAgent, transaction);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Log
    public Transaction getTransactionMaxMontant() {
        return transactions.stream()
                .max((t1, t2) -> Double.compare(t1.getMontant(), t2.getMontant()))
                .orElse(null);
    }

    @Cachable
    public Transaction getCachedTransactionMaxMontant() {
        return getTransactionMaxMontant();
    }


}
