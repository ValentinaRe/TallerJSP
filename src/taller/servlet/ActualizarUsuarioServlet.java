package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Usuario;

/**
 * Servlet implementation class ActualizarUsuarioServlet
 */
public class ActualizarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Método para verificar sesión
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession sesion = request.getSession();
        sesion.invalidate();
        RequestDispatcher rec= request.getRequestDispatcher("FormularioLogin.jsp");
    	request.setAttribute("Status", "No logueado");
		
	}

	/**
	 * M�todo recibe peticiones post para actualizar un usuario
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		PersistentTransaction t = null;
		PrintWriter out = response.getWriter();
		
		try {

			int id = Integer.parseInt(request.getParameter("id"));
			String usuario = request.getParameter("user");
			String pass = request.getParameter("password");
			
			ActualizarUsuarioServlet actual = new ActualizarUsuarioServlet();
			actual.validarId(id);
			
			Usuario actualizar = new Usuario();

			if (id < 0 ||usuario.trim().equals("") || pass.trim().equals("")) {
				System.out.println("una variable vacia");

			} else {

				if (usuario.length() <= 20 && pass.length() <= 20 ) {
					out.println("Id = " + id);
					actualizar.setUid(id);
					actualizar.setUsuario(usuario);
					actualizar.setPass(pass);
					
					try {
						Usuario.actualizar(actualizar);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher( "/FormularioActualizarUsuario.jsp").forward(request, response);
	}
	private  boolean validarId(int id) {
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
