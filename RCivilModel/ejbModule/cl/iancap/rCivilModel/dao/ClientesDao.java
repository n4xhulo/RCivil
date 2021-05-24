package cl.iancap.rCivilModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.rCivilModel.dto.Cliente;

/**
 * Session Bean implementation class ClientesDao
 */
@Stateless
@LocalBean
public class ClientesDao implements ClientesDaoLocal {

	private static List<Cliente> clientes = new ArrayList<>();
    
	@Override
	public void save(Cliente cliente) {
		clientes.add(cliente);
		
	}

	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return clientes;
	}

	@Override
	public void delete(Cliente cliente) {
		// TODO Auto-generated method stub
		clientes.remove(cliente);
	}

	@Override
	public List<Cliente> filterByName(String tipoSolicitud) {
		// TODO Auto-generated method stub
		return clientes.stream().filter(c->c.getNombre().contains(tipoSolicitud)).collect(Collectors.toList());
	}

}
