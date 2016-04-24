package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher( "/FormularioActualizarEmpresa.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		PersistentTransaction t = null;
		PrintWriter out = response.getWriter();
		try {

			int id = Integer.parseInt(request.getParameter("id"));
			String rut=request.getParameter( "rut");
			String nombre=request.getParameter( "nombre");
			String ciudad= request.getParameter( "ciudad");
			String direccion= request.getParameter( "direccion");
			String pais=request.getParameter( "pais");
			String telefono=request.getParameter("telefono");
			String razonSocial=request.getParameter( "razonSocial");
			ActualizarEmpresaServlet actual = new ActualizarEmpresaServlet();
			actual.validarId(id);
			
			Empresa actualizar = new Empresa();

			if (id < 0 ||rut.trim().equals("")|| nombre.trim().equals("") || ciudad.trim().equals("") || direccion.trim().equals("")
					||  pais.trim().equals("")){
				System.out.println("una variable vacia");

			} else {

				if (rut.length()<=12 && nombre.length() <= 50 && ciudad.length() <= 20 && direccion.length() <= 20 && pais.length() <= 20 && razonSocial.length()<=50) {
					out.println("Id = " + id);
					actualizar.setUid(id);
					actualizar.setRut(rut);
					actualizar.setNombre(nombre);
					actualizar.setCiudad(ciudad);
					actualizar.setDireccion(direccion);
					actualizar.setPais(pais);
					actualizar.setRazonSocial(razonSocial);
					try {
						Empresa.actualizar(actualizar);
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

	private  boolean validarId(int id) {
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
