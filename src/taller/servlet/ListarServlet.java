package taller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import capanegocio.Contacto;

/**
 * Servlet implementation class ListarServlet
 */
public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Método que recibe peticiones get para  listar contactos
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <Contacto> lista = new ArrayList<>();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			lista=Contacto.listar();
			PrintWriter out=response.getWriter();
			
			for(Contacto contacto: lista){
				out.println("");
				out.println("el id es: "+contacto.getUid());
				out.println("el run es: "+contacto.getRun());
				out.println("el nombre es: "+contacto.getNombre());
				out.println("el apellido es: "+contacto.getApellido());
				out.println("el mail es: "+contacto.getMail());
				out.println("el telefono es: "+contacto.getTelefono());
				out.println("el pais es: "+contacto.getPais());
				out.println("el region es: "+contacto.getRegion());
				out.println("el ciudad es: "+contacto.getCiudad());
				out.println("empresa: "+ contacto.getEmpresaUid());
				//out.println("--------------");
				
				
			}
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaContacto",lista);
		request.getRequestDispatcher("FormularioListar.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
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
