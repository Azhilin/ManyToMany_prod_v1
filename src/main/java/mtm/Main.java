package mtm;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by azhilin on 31.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        client1.setName("Igor");
        client2.setName("Ilya");
        client3.setName("Misha");
        client1.setSurname("Petrov");
        client2.setSurname("Ivanov");
        client3.setSurname("Grigoryev");

        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.persist(client3);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

        Bank bank1 = new Bank();
        bank1.setName("Deutsche_Bank");
        Bank bank2 = new Bank();
        bank2.setName("Privat");

        entityManager.persist(bank1);
        entityManager.persist(bank2);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

        ClientBank cb1 = new ClientBank();
        cb1.setBank(bank1);
        cb1.setClient(client1);
        client1.setClientBanks(cb1);
        bank1.setClientBanks(cb1);

        ClientBank cb2 = new ClientBank();
        cb2.setBank(bank2);
        cb2.setClient(client3);
        client1.setClientBanks(cb2);
        bank1.setClientBanks(cb2);

        entityManager.getTransaction().commit();
        entityManager.close();
        sessionFactory.close();
    }
}
