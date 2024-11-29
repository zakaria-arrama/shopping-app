package ma.formation.productmanagement.dao.inheritancetypedata;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ma.formation.productmanagement.domain.Bike;
import ma.formation.productmanagement.domain.Car;
import ma.formation.productmanagement.domain.Vehicle;

@WebListener
public class InsertData implements ServletContextListener{

    private EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        emf = Persistence.createEntityManagerFactory("shoppingAppPersistenceUnit");
        System.out.println("JPA Initialized with Persistence Unit: shoppingAppPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        
        em.persist(new Vehicle("SuperVehicle", "S"));
        em.persist(new Vehicle("ReliableVehicle", "R"));


        // Adding 5 Cars
        em.persist(new Car("Toyota", "Camry", 5));
        em.persist(new Car("Honda", "Accord", 5));
        em.persist(new Car("Tesla", "Model S", 4));
        em.persist(new Car("BMW", "X5", 5));
        em.persist(new Car("Audi", "A6", 5));

        // Adding 5 Bikes
        em.persist(new Bike("Yamaha", "R15", "Sports"));
        em.persist(new Bike("Harley-Davidson", "Street 750", "Cruiser"));
        em.persist(new Bike("Ducati", "Monster", "Naked"));
        em.persist(new Bike("Kawasaki", "Ninja 400", "Sports"));
        em.persist(new Bike("Royal Enfield", "Classic 350", "Cruiser"));

        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (emf != null) {
            emf.close();
        }
    }
}