package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class BusquedaSimpleServlet
 */
public class BusquedaSimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaSimpleServlet() {
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
	 * M�todo recibe peticiones post para realizar una búsqueda simple 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String buscar;
		try{
		 buscar = request.getParameter("buscar");
		}catch(NullPointerException e){
			buscar="";
		}
		
	
		Contacto contacto = new Contacto();
		List<Contacto> lista = new ArrayList<Contacto>();
		try {
			
			lista = contacto.busquedaSimple(buscar);
		    if(lista.isEmpty()){
		    	request.setAttribute("Status", "no se encontraron datos");
		    }else{
				request.setAttribute("Status", "se encontraron los siguientes datos");
		    }
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
		request.removeAttribute("busqueda");
		request.setAttribute("listaContacto", lista);
		
		request.getRequestDispatcher( "/FormularioBusquedaSimple.jsp").forward(request, response);
		
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
