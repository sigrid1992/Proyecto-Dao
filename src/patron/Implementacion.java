package patron;

import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Implementacion implements InterfaceDAO {
	static SessionFactory SESSION_FACTORY;
	
	@Override
	public Clientes obtenerCliente(String dni) {
		configurarContexto();
 		List<Clientes> clientes = readAll("");
 		return (Clientes) clientes;
	}

	@Override
	public List<Clientes> todosLosClientes() {
		configurarContexto();
 		List<Clientes> clientes = readAll("");
 		return clientes;
	}
	
	   public static List<Clientes> readAll(String cadena) {

	        List<Clientes> students = null;
	        // Create a session
	        Session session = SESSION_FACTORY.openSession();
	        Transaction transaction = null;
	        try {
	            // Begin a transaction
	            transaction = session.beginTransaction();
	            students = session.createQuery("FROM Clientes"+cadena).list();
	            // Commit the transaction
	     		if (students != null) {
	     			for (Clientes stu : students) {
	     				System.out.println(" DNI--> "+stu.getId()+" nombre--> "+stu.getNombre());
	     			}
	     		}
	            transaction.commit();
	        } catch (HibernateException ex) {
	            // If there are any exceptions, roll back the changes
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            // Print the Exception
	            ex.printStackTrace();
	        } finally {
	            // Close the session
	            session.close();
	        }
	        return students;
	    }
	   private void configurarContexto() {
		    Configuration config = new Configuration();
		    config.configure();
		    Properties prop = config.getProperties();
		    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		    builder.applySettings(prop);
		    StandardServiceRegistry registry = builder.build();
		    SESSION_FACTORY = config.buildSessionFactory(registry);
			}

}
