package patron;

import java.util.List;

public class DemoDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Implementacion i1 = new Implementacion();
		List<Clientes> listaClientes =i1.todosLosClientes();

 		if (listaClientes != null) {
 			for (Clientes stu : listaClientes) {
 				System.out.println(" DNI--> "+stu.getId()+" nombre--> "+stu.getNombre());
 			}
 		}

	}

}
