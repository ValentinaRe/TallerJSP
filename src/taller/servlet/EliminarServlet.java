package taller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Contacto;
import capanegocio.Empresa;

/**
 * Servlet implementation class EliminarServlet
 */
public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * Método recibe peticiones post para eliminar contacto
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		//String run=request.getParameter("run");
		EliminarServlet delete = new EliminarServlet();
		delete.validarId(id);
		
		Contacto eliminar = new Contacto();
		//if(run.trim().equals("")){
	//		System.out.println("una variable vacia");
		//}else{
		//	eliminar.setRun("run");
		//	try {
		//	Contacto.eliminar(eliminar);
				
		//} catch (PersistentException e) {
				// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
		//}
		if (id<0){
			System.out.println("una variable vacia");
	}else{
			eliminar.setUid(id);
			try {
				Contacto.eliminar(eliminar);
		} catch (PersistentException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
	}
		request.getRequestDispatcher( "/FormularioEliminar.jsp").forward(request, response);

	}
/**
 * Metodo de validacion id 
 * @param id de tipo int
 * @return boolean
 */
	boolean validarId(int id) {
		String cadena = String.valueOf(id);
		for (int i = 0; i < cadena.length(); i++)
			if (!Character.isDigit(cadena.charAt(i))) {
				return false;
			}
		return true;
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
