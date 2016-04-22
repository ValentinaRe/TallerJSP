package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capanegocio.Contacto;

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
		response.sendRedirect("FormularioActualizar.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PersistentTransaction t = null;
		PrintWriter out = response.getWriter();
		try {
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (NullPointerException e) {
				id = 0;
			}
			String run = request.getParameter("run");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String mail = request.getParameter("mail");
			String telefono = request.getParameter("telefono");
			String pais = request.getParameter("pais");
			String region = request.getParameter("region");
			String ciudad = request.getParameter("ciudad");
			ActualizarServlet actual = new ActualizarServlet();
			actual.validarId(id);
			actual.validateEmail(mail);
			actual.esEntero(telefono);
			Contacto actualizar = new Contacto();

			if (id < 0||run.trim().equals("") || nombre.trim().equals("") || apellido.trim().equals("") || mail.trim().equals("")
					|| telefono.trim().equals("") || pais.trim().equals("") || region.trim().equals("")
					|| ciudad.trim().equals("")) {
				System.out.println("una variable vacia");

			} else {

				if (run.length()<=12 && nombre.length() <= 50 && apellido.length() <=50 && mail.length() <= 50 && telefono.length() <= 20
						&& pais.length() <= 50 && region.length() <= 50 && ciudad.length() <= 50) {
					out.println("Id = " + id);
					actualizar.setUid(id);
					actualizar.setRun(run);
					actualizar.setNombre(nombre);
					actualizar.setApellido(apellido);
					actualizar.setMail(mail);
					actualizar.setTelefono(telefono);
					actualizar.setPais(pais);
					actualizar.setRegion(region);
					actualizar.setCiudad(ciudad);
					try {
						Contacto.actualizar(actualizar);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		} catch (NullPointerException e) {
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
	private boolean validateEmail(String email) {
		// Compiles the given regular expression into a pattern.
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);

		// Match the given input against this pattern
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();

	}

	/**
	 * Metodo validacion telefono
	 * 
	 * @param cadena
	 *            de tipo String
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
	 * @param id
	 *            de tipo int
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
