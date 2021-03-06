package taller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import capanegocio.Empresa;

/**
 * Servlet implementation class EliminarEmpresaServlet
 */
public class EliminarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Método para verificar sesión
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
        sesion.invalidate();
        RequestDispatcher rec= request.getRequestDispatcher("FormularioLogin.jsp");
    	request.setAttribute("Status", "No logueado");
		
		
	}

	/**
	 * M�todo recibe peticiones post para eliminar una empresa
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		//String rut=request.getParameter("rut");
		EliminarEmpresaServlet delete = new EliminarEmpresaServlet();
		delete.validarId(id);
		 Empresa eliminar = new Empresa();
		//if(rut.trim().equals("")){
			//System.out.println("una variable vacia");
		//}else{
			//eliminar.setRut("rut");
			//try {
				//Empresa.eliminar(eliminar);
			//} catch (PersistentException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
		//}
		
		if (id<0){
		System.out.println(" variable vacia");
		}else{
			eliminar.setUid(id);
			try {
				Empresa.eliminar(eliminar);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
		}
		request.getRequestDispatcher( "/FormularioEliminarEmpresa.jsp").forward(request, response);

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
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
