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

import capanegocio.Empresa;

/**
 * Servlet implementation class ActualizarEmpresaServlet
 */
public class ActualizarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarEmpresaServlet() {
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
	 * M�todo recibe peticiones post para actualizar empresa
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersistentTransaction t = null;
		PrintWriter out = response.getWriter();
		String rut="";
		String nombre="";
		String ciudad="";
		String direccion="";
		String pais="";
		String telefono="";
		String razonSocial="";
		String mensaje="";
		
		try {

			int id = Integer.parseInt(request.getParameter("id"));
			 rut=request.getParameter( "rut");
			 nombre=request.getParameter( "nombre");
			 ciudad= request.getParameter( "ciudad");
			 direccion= request.getParameter( "direccion");
			 pais=request.getParameter( "pais");
			 telefono=request.getParameter("telefono");
			 razonSocial=request.getParameter( "razonSocial");
			ActualizarEmpresaServlet actual = new ActualizarEmpresaServlet();
			actual.validarId(id);
			actual.validarRut(rut);
			actual.esEntero(telefono);
			
			Empresa actualizar = new Empresa();
			if((actual.validarRut(rut)==true) && (actual.esEntero(telefono)==true) ){

			if (id < 0 ||rut.trim().equals("")|| nombre.trim().equals("") || ciudad.trim().equals("") || direccion.trim().equals("")
					||  pais.trim().equals("")){
				System.out.println("una variable vacia");

			} else {

				if (rut.length()<=12 && nombre.length() <= 50 && ciudad.length() <= 20 && direccion.length() <= 20 && pais.length() <= 20 && razonSocial.length()<=50) {
					out.println("Id = " + id);
			
					try {
						actualizar.setRut(rut);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
					try {
						actualizar.setNombre(nombre);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
					try {
						actualizar.setCiudad(ciudad);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
					try {
						actualizar.setDireccion(direccion);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
					try {
						actualizar.setPais(pais);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
					try {
						actualizar.setTelefono(telefono);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
					
					try {
						actualizar.setRazonSocial(razonSocial);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
					
					
					try {
						Empresa.actualizar(actualizar);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}


			}
			else {
				mensaje="Datos mal ingresados";
				
				
			}	
		
		
		
	}catch (NullPointerException e) {
		e.printStackTrace();
	}
		request.getRequestDispatcher( "/FormularioActualizarEmpresa.jsp").forward(request, response);
	}

	private  boolean validarId(int id) {
		String cadena = String.valueOf(id);
		for (int i = 0; i < cadena.length(); i++)
			if (!Character.isDigit(cadena.charAt(i))) {
				return false;
			}
		return true;
	}
	private boolean esEntero(String cadena) {
		for (int i = 0; i < cadena.length(); i++)
			if (!Character.isDigit(cadena.charAt(i))) {
				return false;
			}
		return true;
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
