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
	 * Método post que recibe peticiones post para ingresar una empresa
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersistentTransaction t = null;
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String rut="";
		String nombre = "";
		String ciudad ="";
		String direccion ="";
		String pais = "";
		String telefono="";
		String razonSocial="";
		IngresarEmpresaServlet ingresa= new IngresarEmpresaServlet();
		ingresa.esEntero(telefono);
		ingresa.validarRut(rut);
		String mensaje="";
		
		
		try{
			rut=request.getParameter( "rut");
			nombre=request.getParameter( "nombre");
			ciudad= request.getParameter( "ciudad");
			direccion= request.getParameter( "direccion");
			pais=request.getParameter( "pais");
			telefono=request.getParameter( "telefono");
			razonSocial=request.getParameter( "razonSocial");
			if((ingresa.validarRut(rut)==true) && (ingresa.esEntero(telefono)==true) ){
			if(rut.trim().equals("")||nombre.trim().equals("")|| ciudad.trim().equals("")||direccion.trim().equals("")||pais.trim().equals("")||telefono.trim().equals("")||razonSocial.trim().equals("")){
				System.out.println("una variable vacia");
				
			}else{
				if(rut.length()<=12 && nombre.length()<=50 && ciudad.length()<=50 && direccion.length()<=50 && pais.length()<=50 && telefono.length()<=20 && razonSocial.length()<=50){
					Empresa ingresar = new Empresa();
					ingresar.setRut(rut);
					ingresar.setNombre(nombre);
					ingresar.setCiudad(ciudad);
					ingresar.setDireccion(direccion);
					ingresar.setPais(pais);
					ingresar.setTelefono(telefono);
					ingresar.setRazonSocial(razonSocial);
					
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
			
		
			}
			else {
				mensaje="Datos mal ingresados";
				System.out.println("cantidad de caracteres superior a los aceptados");
			
			}	
		
		
		
	}catch (NullPointerException e) {
		e.printStackTrace();
	}
		request.getRequestDispatcher( "/FormularioIngresoEmpresa.jsp").forward(request, response);
	}
	public static boolean validarRut(String rut) {

		boolean validacion = false;
		try {
			rut = rut.toUpperCase();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

			char dv = rut.charAt(rut.length() - 1);

			int m = 0, s = 1;
			for (; rutAux != 0; rutAux /= 10) {
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
				validacion = true;
			}

		} catch (java.lang.NumberFormatException e) {
		} catch (Exception e) {
		}
		return validacion;
	}
	public boolean esEntero(String cadena) {
		for (int i = 0; i < cadena.length(); i++)
			if (!Character.isDigit(cadena.charAt(i))) {
				return false;
			}
		return true;
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
