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
 * Servlet implementation class IngresarUsuarioServlet
 */
public class IngresarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarUsuarioServlet() {
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
	 * M�todo que recibe peticiones post para ingresar un usuario
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersistentTransaction t = null;
		
		PrintWriter out = response.getWriter();
		String usuario = "";
		String pass ="";
		
		IngresarUsuarioServlet ingresa= new IngresarUsuarioServlet();
		try{
			usuario=request.getParameter( "user");
			pass= request.getParameter( "password");
			
			
			if(usuario.trim().equals("")|| pass.trim().equals("")){
				System.out.println("una variable vacia");
				
			}else{
				if(usuario.length()<=20 && pass.length()<=20){
					Usuario ingresar = new Usuario();
					ingresar.setUsuario(usuario);
					ingresar.setPass(pass);
					
					try {
						Usuario.ingresar(ingresar);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					System.out.println("cantidad de caracteres superior a los aceptados");
				}
			}
			
		}catch (NullPointerException e){
			e.printStackTrace();
		}
		request.getRequestDispatcher( "/FormularioIngresarUsuario.jsp").forward(request, response);
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
