package mtm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by azhilin on 31.01.2017.
 */
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
    @OneToMany(mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<ClientBank> clientBanks = new ArrayList<ClientBank>();


    public Client() {
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    @Override
    public String toString() {
        return name + " " + surname;
    }
}
