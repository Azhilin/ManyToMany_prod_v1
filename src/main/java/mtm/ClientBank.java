package mtm;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

/**
 * Created by azhilin on 31.01.2017.
 */
@Entity(name = "client_bank")
public class ClientBank implements Serializable {
    @Id
    @ManyToOne
    Bank bank;
    @Id
    @ManyToOne
    Client client;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
