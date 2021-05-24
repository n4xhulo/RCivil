package cl.inacap.RCivilWeb.controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.iancap.rCivilModel.dao.ClientesDaoLocal;
import cl.inacap.rCivilModel.dto.Cliente;

/**
 * Servlet implementation class AgregarClienteController
 */
@WebServlet("/AgregarClienteController.do")



public class AgregarClienteController extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClientesDaoLocal ClientesDao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/agregarCliente.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		List<String> errores = new ArrayList<>();
	
		
		
		String nombre = request.getParameter("nombre-txt").trim();
			if(nombre.isEmpty()) {
				errores.add("Ingrese un nombre y apellido porfavor ");
			}
		String rut = request.getParameter("rut-txt").trim();
		
			if(rut.isEmpty()) {
				errores.add("Ingrese un rut valido porfavor ");
				} else if(rutVali.validaRut(rut)== false){
					errores.add("Ingrese un Rut Chileno valido, sin puntos y con guion");
				}
		String atencion = request.getParameter("atencion-select").trim();
			if(atencion.isEmpty()) {
				errores.add("Marque el tipo de atencion que desea ");
			}
			
		int numAt = (int) (Math.random()*99+1);
			
		if(errores.isEmpty()) {
			Cliente cliente = new Cliente();
			cliente.setNombre(nombre);
		
			cliente.setRut(rut);

			cliente.setTipoSolicitud(atencion);
				
			cliente.setNumSolicitud(numAt);
				
			ClientesDao.save(cliente);
			request.setAttribute("mensaje", " Cliente registrado con exito");
		} else {
			request.setAttribute("errores", errores);
		}
		
		
		doGet(request, response);
		
		
		
		
	}

	public static class rutVali {

		public static Boolean validaRut ( String rut ) {
			Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
			Matcher matcher = pattern.matcher(rut);
			if ( matcher.matches() == false ) 
				return false;
			String[] stringRut = rut.split("-");
			return stringRut[1].toLowerCase().equals(rutVali.dv(stringRut[0]));

		}
		public static String dv ( String rut ) {
			Integer M=0,S=1,T=Integer.parseInt(rut);
			for (;T!=0;T=(int) Math.floor(T/=10))
				S=(S+T%10*(9-M++%6))%11;
			return ( S > 0 ) ? String.valueOf(S-1) : "k";		
		}

	} 

}
