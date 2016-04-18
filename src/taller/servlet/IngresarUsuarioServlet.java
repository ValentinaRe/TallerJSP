package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersistentTransaction t = null;
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String user = "";
		String pass ="";
		
		IngresarUsuarioServlet ingresa= new IngresarUsuarioServlet();
		try{
			user=request.getParameter( "user");
			pass= request.getParameter( "password");
			
			
			if(user.trim().equals("")|| pass.trim().equals("")){
				System.out.println("una variable vacia");
				
			}else{
				if(user.length()<=20 && pass.length()<=20){
					Usuario ingresar = new Usuario();
					ingresar.setUser(user);
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
