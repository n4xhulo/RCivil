package cl.iancap.rCivilModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.rCivilModel.dto.Cliente;

@Local
public interface ClientesDaoLocal {
	
	void save (Cliente cliente);
	List<Cliente> getAll();
	void delete(Cliente cliente);
	List<Cliente> filterByName(String tipoSolicitud);

}
