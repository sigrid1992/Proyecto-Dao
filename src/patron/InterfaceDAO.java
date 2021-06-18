package patron;

import java.util.List;

public interface InterfaceDAO {

	public Clientes obtenerCliente(String dni);
	public List<Clientes> todosLosClientes();
}
