package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Anotacion;
import capanegocio.Contacto;
import capanegocio.Empresa;

/**
 * Servlet implementation class AnotacionServlet
 */
public class AnotacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnotacionServlet() {
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
		PrintWriter out = response.getWriter();
		String nombre="";
		String descripcion="";
		String contac="";
		AnotacionServlet anotacion= new AnotacionServlet();
		String mensaje="";
		
		
		try{
			nombre=request.getParameter("nombre");
			System.out.println(nombre);
			descripcion=request.getParameter("descripcion");
			System.out.println(descripcion);
			contac=request.getParameter("idContacto");
			System.out.println(contac);
			int contacto=Integer.parseInt(contac);
			if (nombre.trim().equals("") || descripcion.trim().equals("") ||contacto<0) {
				System.out.println("una variable vacia");

			} else {
				if (nombre.length() <= 50 && descripcion.length() <= 200 ) {
					// instanciar clase contacto
					Contacto con = new Contacto();
					// asignar valor capturado del request
					con.setUid(contacto);
					Anotacion ingresarA = new Anotacion();
					if(nombre != null){
					ingresarA.setNombre(nombre);
					}
					if(descripcion != null){
					ingresarA.setDescripcion(descripcion);
					}
					String respAnot="";
					ingresarA.setContactouid(con);

					try {
						respAnot=Anotacion.ingresar(ingresarA);
						

					} 
						catch (PersistentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					     
				
				}}
					
						
			
		}catch (NullPointerException e) {
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
