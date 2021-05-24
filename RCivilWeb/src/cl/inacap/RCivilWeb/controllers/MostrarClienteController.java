package cl.inacap.RCivilWeb.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.iancap.rCivilModel.dao.ClientesDaoLocal;
import cl.inacap.rCivilModel.dto.Cliente;

/**
 * Servlet implementation class MostrarClienteController
 */
@WebServlet("/MostrarClienteController.do")
public class MostrarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClientesDaoLocal ClientesDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Cliente> cliente = ClientesDao.getAll();
		
		if(request.getParameter("nombreEliminar") != null) {
			String nombre = request.getParameter("nombreEliminar").trim();
			List<Cliente> busqueda = ClientesDao.filterByName(nombre);
			Cliente clienteAEliminar = busqueda.isEmpty()? null:busqueda.get(0);
			
			if(clienteAEliminar != null) {
				ClientesDao.delete(clienteAEliminar);
			}
		}
		
		request.setAttribute("clientes", cliente);
		
		request.getRequestDispatcher("WEB-INF/vistas/mostrarCliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
