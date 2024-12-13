package project.design_pattern.annotations;


import project.design_pattern.models.Transaction;

public interface Strategy {
    void execute(String nomAgent, Transaction transaction);
}