package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Empresa;

/**
 * Servlet implementation class IngresarEmpresaServlet
 */
public class IngresarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarEmpresaServlet() {
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
		String nombre = "";
		String ciudad ="";
		String direccion ="";
		String pais = "";
		
		
		IngresarEmpresaServlet ingresa= new IngresarEmpresaServlet();
		try{
			nombre=request.getParameter( "nombre");
			ciudad= request.getParameter( "ciudad");
			direccion= request.getParameter( "direccion");
			pais=request.getParameter( "pais");
			
			
			if(nombre.trim().equals("")|| ciudad.trim().equals("")||direccion.trim().equals("")||pais.trim().equals("")){
				System.out.println("una variable vacia");
				
			}else{
				if(nombre.length()<=100 && ciudad.length()<=20 && direccion.length()<=20 && pais.length()<=20 ){
					Empresa ingresar = new Empresa();
					ingresar.setNombre(nombre);
					ingresar.setCiudad(ciudad);
					ingresar.setDireccion(direccion);
					ingresar.setPais(pais);
					
					try {
						Empresa.ingresar(ingresar);
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

	
	
		// Initialize the properties of the persistent object here
	

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
