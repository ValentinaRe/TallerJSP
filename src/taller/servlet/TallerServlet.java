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
import capanegocio.Empresa;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet implementation class TallerServlet
 */
// @WebServlet("/TallerServlet")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Método que recibe petición post para ingresar contacto
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersistentTransaction t = null;
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String run = "";
		String nombre = "";
		String apellido = "";
		String mail = "";
		String telefono = "";
		String pais = "";
		String region = "";
		String ciudad = "";
		String empresa = "";
		
		TallerServlet ingresa = new TallerServlet();
		String mensaje="";
		try {
			run = request.getParameter("run");
			nombre = request.getParameter("nombre");
			apellido = request.getParameter("apellido");
			mail = request.getParameter("mail");
			telefono = request.getParameter("telefono");
			pais = request.getParameter("pais");
			region = request.getParameter("region");
			ciudad = request.getParameter("ciudad");
			// obtener request de la empresa
			empresa = request.getParameter("idEmpresa");
			int idempr=Integer.parseInt(empresa);
			ingresa.validateMail(mail);
			ingresa.esEntero(telefono);
			ingresa.validarRun(run);
			
			if((ingresa.validarRun(run)==true)&&(ingresa.validateMail(mail)==true) && (ingresa.esEntero(telefono)==true) ){
				
			if (run.trim().equals("") || nombre.trim().equals("") || apellido.trim().equals("")
					|| mail.trim().equals("") || telefono.trim().equals("") || pais.trim().equals("")
					|| region.trim().equals("") || ciudad.trim().equals("")||idempr<0) {
				System.out.println("una variable vacia");

			} else {
				if (nombre.length() <= 100 && apellido.length() <= 100 && mail.length() <= 50 && telefono.length() <= 20
						&& pais.length() <= 100 && region.length() <= 100 && ciudad.length() <= 50) {
					// instanciar clase empresa
					Empresa empresas = new Empresa();
					// asignar valor capturado del request
					empresas.setUid(idempr);
					Contacto ingresarContacto = new Contacto();
					ingresarContacto.setRun(run);
					ingresarContacto.setNombre(nombre);
					ingresarContacto.setApellido(apellido);
					ingresarContacto.setMail(mail);
					ingresarContacto.setTelefono(telefono);
					ingresarContacto.setPais(pais);
					ingresarContacto.setRegion(region);
					ingresarContacto.setCiudad(ciudad);
					ingresarContacto.setEmpresaUid(empresas);
					String respCon="";
					// asignar contacto el objeto de la empresa
					// instanciar una variable que almacene la respuesta de la
					// capa de negocio

					try {
						respCon=Contacto.ingresar(ingresarContacto);
						// asignar a la variable creada la respuesta del
						// ingresar
						//Contacto.ingresar(ingresarContacto);

					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     
			
			}}
				
			}
			else {
				mensaje="Datos mal ingresados";
				System.out.println("cantidad de caracteres superior a los aceptados");
				request.getRequestDispatcher( "/FormularioIngreso.jsp").forward(request, response);
			}	
		
		
		
	}catch (NullPointerException e) {
		e.printStackTrace();
	}
	}
	/**
	 * Metodo validacion mail
	 * 
	 * @param email
	 *            de tipo String
	 * @return boolean
	 */
	public static boolean validateMail(String mail) {

		// Compiles the given regular expression into a pattern.
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);

		// Match the given input against this pattern
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();

	}

	/**
	 * Metodo validacion telefono
	 * 
	 * @param cadena de tipo String
	 * @return boolean
	 */
	public boolean esEntero(String cadena) {
		for (int i = 0; i < cadena.length(); i++)
			if (!Character.isDigit(cadena.charAt(i))) {
				return false;
			}
		return true;
	}

	// Initialize the properties of the persistent object here
	public static boolean validarRun(String run) {

		boolean validacion = false;
		try {
			run = run.toUpperCase();
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
