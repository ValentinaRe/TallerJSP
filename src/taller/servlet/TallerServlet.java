package taller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Contacto;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet implementation class TallerServlet
 */
//@WebServlet("/TallerServlet")
public class TallerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TallerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("FormularioIngreso.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersistentTransaction t = null;
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String run="";
		String nombre = "";
		String apellido ="";
		String mail ="";
		String telefono ="";
		String pais = "";
		String region ="";
		String ciudad ="";
		int id=1;
		TallerServlet ingresa= new TallerServlet();
		try{
			run=request.getParameter( "run");		
			nombre=request.getParameter( "nombre");		
			apellido= request.getParameter( "apellido");
			mail= request.getParameter( "mail");
			telefono=request.getParameter( "telefono");
			pais=request.getParameter( "pais");
			region=request.getParameter( "region");
			ciudad=request.getParameter( "ciudad");
			ingresa.validateEmail(mail);
			ingresa.esEntero(telefono);
			ingresa.validarRun(run);
			if(run.trim().equals("")||nombre.trim().equals("")|| apellido.trim().equals("")||mail.trim().equals("")||telefono.trim().equals("")||pais.trim().equals("")||region.trim().equals("")||ciudad.trim().equals("")){
				System.out.println("una variable vacia");
				
			}else{
				if(nombre.length()<=100 && apellido.length()<=100 && mail.length()<=50 && telefono.length()<=20 && pais.length()<=100 && region.length()<=100 && ciudad.length()<=50 ){
					Contacto ingresar = new Contacto();
					ingresar.setRun(run);
					ingresar.setNombre(nombre);
					ingresar.setApellido(apellido);
					ingresar.setMail(mail);
					ingresar.setTelefono(telefono);
					ingresar.setPais(pais);
					ingresar.setRegion(region);
					ingresar.setCiudad(ciudad);
					
					try {
						Contacto.ingresar(ingresar);
						
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
		//System.out.println("datos ingresados con exito");
	}

	/**
	 * Metodo validacion mail 
	 * @param email de tipo String
	 * @return boolean
	 */
	public static boolean validateEmail(String email) {
			 
	        // Compiles the given regular expression into a pattern.
	        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
	 
	        // Match the given input against this pattern
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	 
	    }
		/**
		 * Metodo validacion telefono 
		 * @param cadena de tipo String
		 * @return boolean
		 */
		public boolean esEntero(String cadena){
			 for(int i = 0; i<cadena.length(); i++)
			 if( !Character.isDigit(cadena.charAt(i)) ){
				 return false;
			 }
			 return true;
		 }
		// Initialize the properties of the persistent object here
		public static boolean validarRun(String run) {
			 
			boolean validacion = false;
			try {
			run =  run.toUpperCase();
			run = run.replace(".", "");
			run = run.replace("-", "");
			int runAux = Integer.parseInt(run.substring(0, run.length() - 1));
			 
			char dv = run.charAt(run.length() - 1);
			 
			int m = 0, s = 1;
			for (; runAux != 0; runAux /= 10) {
			s = (s + runAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
			validacion = true;
			}
			 
			} catch (java.lang.NumberFormatException e) {
			} catch (Exception e) {
			}
			return validacion;
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

