package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
    Configuration configuration = new Configuration().addAnnotatedClass(Persona.class).
            addAnnotatedClass(Item.class);

      SessionFactory sessionFactory = configuration.buildSessionFactory();
      Session session = sessionFactory.getCurrentSession();

       try {
            session.beginTransaction();

         /*   Persona persona =session.get(Persona.class,3);
           System.out.println(persona);
           List<Item> items = persona.getItems();
           System.out.println(items);*/

          /* Item item = session.get(Item.class,5);
           System.out.println(item);

           Persona persona = item.getOwner();
           System.out.println(persona);*/
        /* Persona persona = session.get(Persona.class,2);
         Item newItem = new Item ("Item from Hibernate",persona);

         persona.getItems().add(newItem);

         session.save(newItem);

*/
           Persona persona = new Persona("Test persona",30);

          Item newItem = new Item("Item from Hibernate 2",persona);

          persona.setItems(new ArrayList<>(Collections.singletonList(newItem)));

          session.save (persona);
          session.save(newItem);

            session.getTransaction().commit();
       }finally {

         sessionFactory.close();
       }

   }


}
