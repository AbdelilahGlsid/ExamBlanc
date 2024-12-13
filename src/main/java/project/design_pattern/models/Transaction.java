package project.design_pattern.models;

public class Transaction {
    private final String id;
    private final String date;
    private final double montant;
    private final String type; // "Vente" ou "Achat"

    private Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.montant = builder.montant;
        this.type = builder.type;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public String getType() {
        return type;
    }

    // Builder pattern
    public static class Builder {
        private String id;
        private String date;
        private double montant;
        private String type;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder montant(double montant) {
            this.montant = montant;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', date='" + date + "', montant=" + montant + ", type='" + type + "'}";
    }
}

