package mtm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by azhilin on 31.01.2017.
 */
@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "bank_name")
    String name;
    @OneToMany(mappedBy = "bank",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<ClientBank> clientBanks = new ArrayList<ClientBank>();

    public List<ClientBank> getClientBanks() {
        return clientBanks;
    }

    public void setClientBanks(ClientBank clientBank) {
        this.clientBanks.add(clientBank);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank() {
    }
}
