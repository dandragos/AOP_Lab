package task3;

import java.util.*;


interface PaymentMethod {
    void pay(double amount);
}


class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Plată cash efectuată pentru suma de " + amount + " lei.");
    }
}


class BankTransferPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Plată prin transfer bancar efectuată pentru suma de " + amount + " lei.");
    }
}


class CardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Plată cu cardul efectuată pentru suma de " + amount + " lei.");
    }
}


class Client {
    private String name;
    private PaymentMethod preferredPaymentMethod;

    public Client(String name, PaymentMethod preferredPaymentMethod) {
        this.name = name;
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public PaymentMethod getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public String getName() {
        return name;
    }
}


class Transaction {
    private Client client;
    private double amount;
    private PaymentMethod paymentMethod;

    public Transaction(Client client, double amount) {
        this.client = client;
        this.amount = amount;
        this.paymentMethod = client.getPreferredPaymentMethod();
    }

    public void execute() {
        if (clientHasSufficientFunds()) {
            paymentMethod.pay(amount);
        } else {
            System.out.println("Fonduri insuficiente pentru clientul " + client.getName());
        }
    }

    private boolean clientHasSufficientFunds() {
        // Simulam verificarea daca clientul are suficiente fonduri

        return true;
    }
}


class Store {
    private List<Transaction> transactions;

    public Store() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void processTransactions() {
        for (Transaction transaction : transactions) {
            transaction.execute();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        PaymentMethod cashPayment = new CashPayment();
        PaymentMethod bankTransferPayment = new BankTransferPayment();
        PaymentMethod cardPayment = new CardPayment();


        Client client1 = new Client("Client 1", cashPayment);
        Client client2 = new Client("Client 2", bankTransferPayment);
        Client client3 = new Client("Client 3", cardPayment);


        Transaction transaction1 = new Transaction(client1, 100);
        Transaction transaction2 = new Transaction(client2, 200);
        Transaction transaction3 = new Transaction(client3, 300);


        Store store = new Store();


        store.addTransaction(transaction1);
        store.addTransaction(transaction2);
        store.addTransaction(transaction3);


        store.processTransactions();
    }
}

//Design pattern-ul folosit este Strategy pentru a gestiona diferitele metode de plată
// (cash, transfer bancar, card) si le-am reprezentat sub forma interfeței
// PaymentMethod.
// De asemenea, am folosit clasa Transaction pentru a reprezenta o tranzacție,
// care conține informații despre client, suma si metoda de plata.
// Magazinul (Store) este responsabil pentru colectarea și procesarea tranzacțiilor.