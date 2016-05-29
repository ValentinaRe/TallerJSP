package taller.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import capanegocio.Contacto;

/**
 * Servlet implementation class BusquedaAvanzadaServlet
 */
public class BusquedaAvanzadaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaAvanzadaServlet() {
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
	 * M�todo recibe peticiones post para busqueda avanzada
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
         Contacto contacto = new Contacto();
		
		String run = request.getParameter("run");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String mail = request.getParameter("mail");
		String telefono = request.getParameter("telefono");
		String pais = request.getParameter("pais");
		String region = request.getParameter("region");
		String ciudad = request.getParameter("ciudad");
		
		
		if(run != null){
			contacto.setRun(run);
		}			
		else{
			contacto.setRun("");
		}
		
		if(nombre != null){
			contacto.setNombre(nombre);
		}else{
			contacto.setNombre("");
		}
		
		if(apellido != null){
			contacto.setApellido(apellido);
		}else{
			contacto.setApellido("");
		}
		
		if(mail != null){
			contacto.setMail(mail);
		}else{
			contacto.setMail("");
		}
		
		if(telefono != null){
			contacto.setTelefono(telefono);
		}else{
			contacto.setTelefono("");
		}
		
		if(pais != null){
			contacto.setPais(pais);
		}else{
			contacto.setPais("");
		}
		
		if(region != null){
			contacto.setRegion(region);
		}else{
			contacto.setRegion("");
		}
		if(ciudad != null){
			contacto.setCiudad(ciudad);
		}else{
			contacto.setCiudad("");
		}
		
		try {
			List<Contacto> listaBusquedaAvan = contacto.busquedaAvanzada(contacto);
			if(!listaBusquedaAvan.isEmpty()){
				request.removeAttribute("busqueda");
				request.setAttribute("listaContacto", listaBusquedaAvan);	
				request.getRequestDispatcher("FormularioBusquedaAvanzada.jsp").forward(request, response);
			}else{
				
				request.removeAttribute("busqueda");
				request.setAttribute("listaContacto",listaBusquedaAvan);
				request.getRequestDispatcher( "FormularioBusquedaAvanzada.jsp").forward(request, response);
				
			}
		} catch (PersistentException e) {
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
