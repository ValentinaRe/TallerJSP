package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Contacto;
import capanegocio.Empresa;

/**
 * Servlet implementation class ActualizarServlet
 */
// @WebServlet("/ActualizarServlet")
public class ActualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActualizarServlet() {
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
	 * M�todo recibe peticiones post para  actualizar contacto
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PersistentTransaction t = null;
		PrintWriter out = response.getWriter();
		int id;
		String run ="";
		String nombre ="";
		String apellido="";
		String mail ="";
		String telefono ="";
		String pais ="";
		String region ="";
		String ciudad ="";
		String empresa = "";
		String mensaje="";
		String fotoCont="";
	
		
		try {
			
			 id = Integer.parseInt(request.getParameter("id"));
			 run = request.getParameter("run");
			 nombre = request.getParameter("nombre");
			 apellido = request.getParameter("apellido");
			 mail = request.getParameter("mail");
			 telefono = request.getParameter("telefono");
			 pais = request.getParameter("pais");
			 region = request.getParameter("region");
			 ciudad = request.getParameter("ciudad");
			 fotoCont = request.getParameter("textArea");
			 empresa = request.getParameter("idEmpresa");
			
			 int idempr=Integer.parseInt(empresa);
			 ActualizarServlet actual = new ActualizarServlet();
			actual.validarId(id);
			actual.validarRun(run);
			actual.validateMail(mail);
			actual.esEntero(telefono);
			Contacto actualizar = new Contacto();
			Empresa empresas = new Empresa();
			
			if((actual.validarId(id)==false)||(actual.validarRun(run)==false)||(actual.validateMail(mail)==false) || (actual.esEntero(telefono))==false) {
				mensaje="Datos mal ingresados";
				
				
				System.out.println("Datos mal ingresados");}
			else {if (id < 0 || run.trim().equals("") || nombre.trim().equals("") || apellido.trim().equals("")
					|| mail.trim().equals("") || telefono.trim().equals("") || pais.trim().equals("")
					|| region.trim().equals("") || ciudad.trim().equals("")) {
				
				

			} else {
				
				if (run.length() <= 12 && nombre.length() <= 50 && apellido.length() <= 50 && mail.length() <= 50
						&& telefono.length() <= 20 && pais.length() <= 50 && region.length() <= 50
						&& ciudad.length() <= 50) {
					out.println("Id = " + id);
					
						
						actualizar.setUid(id);
					
					}
					
						if(run !=null){
						actualizar.setRun(run);
						}
					
					
						if(nombre != null){
						actualizar.setNombre(nombre);
						
						if(apellido != null){
						actualizar.setApellido(apellido);
						}
					
						if(mail != null){
						actualizar.setMail(mail);
						}
					
						if(telefono != null){
						actualizar.setTelefono(telefono);
						
						if(pais != null){
						actualizar.setPais(pais);
						}
					
						if(region != null){
						actualizar.setRegion(region);
						}
					
						if(ciudad != null){
						actualizar.setCiudad(ciudad);
						}
					
					actualizar.setFotoCont(fotoCont);
					
					empresas.setUid(idempr);					
					actualizar.setEmpresaUid(empresas);					
					String respCon="";
					try {
						respCon=Contacto.actualizar(actualizar);
						
						
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}//catch persistence
					mensaje="Actualizacion guardada";
					RequestDispatcher rs = request.getRequestDispatcher("FormularioActualizar.jsp");
					request.setAttribute("mensaje", mensaje);
					rs.forward(request, response);
					
				}//fin ifvalidacion cant caracteres

			}	//fin else 	trim		
	  }	//fin else validacion de funciones
				
			mensaje="Actualizacion no guardada";
			RequestDispatcher rs = request.getRequestDispatcher("FormularioActualizar.jsp");
			request.setAttribute("mensaje", mensaje);
			rs.forward(request, response);			
	}
	}catch (NullPointerException e) {
		e.printStackTrace();
	}
		
	}
	/**
	 * Metodo validacion mail
	 * 
	 * @param email de tipo String
	 * @return boolean
	 */
	private boolean validateMail(String mail) {
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
	private boolean esEntero(String cadena) {
		for (int i = 0; i < cadena.length(); i++)
			if (!Character.isDigit(cadena.charAt(i))) {
				return false;
			}
		return true;
	}

	/**
	 * Metodo de validacion de id
	 * 
	 * @param id de tipo int
	 * @return boolean
	 */
	private boolean validarId(int id) {
		String cadena = String.valueOf(id);
		for (int i = 0; i < cadena.length(); i++)
			if (!Character.isDigit(cadena.charAt(i))) {
				return false;
			}
		return true;
	}
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

		// Initialize the properties of the persistent object here

	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
