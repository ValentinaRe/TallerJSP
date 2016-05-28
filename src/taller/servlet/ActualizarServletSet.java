package taller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import capanegocio.Empresa;

/**
 * Servlet implementation class ActualizarServletSet
 */
public class ActualizarServletSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarServletSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List <Empresa> listar=new  ArrayList<>();
		

		
		try{
			listar=Empresa.listar();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("lista",listar);
		request.getRequestDispatcher( "/FormularioActualizar.jsp").forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String id = request.getParameter("id");
		 String run = request.getParameter("run");
		 String nombre = request.getParameter("nombre");
		 String apellido = request.getParameter("apellido");
		 String mail = request.getParameter("mail");
		 String telefono = request.getParameter("telefono");
		 String pais = request.getParameter("pais");
		 String region = request.getParameter("region");
		 String ciudad = request.getParameter("ciudad");
		 String fotoCont = request.getParameter("textArea"); 
		 String empresa = request.getParameter("idEmpresa");
		 

		RequestDispatcher req = request.getRequestDispatcher("/FormularioActualizar.jsp");
		request.setAttribute("id", id);
		request.setAttribute("run", run);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		request.setAttribute("mail", mail);
		request.setAttribute("telefono", telefono);
		request.setAttribute("pais", pais);
		request.setAttribute("region", region);
		request.setAttribute("ciudad", ciudad);
		request.setAttribute("fotoCont", fotoCont);
		request.setAttribute("idEmpresa", empresa);
		req.forward(request, response);
	
	
	List <Empresa> listar=new  ArrayList<>();
	Empresa emp = new Empresa();

	try {
		
		listar = emp.listarEmpre();
		request.setAttribute("listarEmpresa", listar);
		request.getRequestDispatcher("/FormularioActualizar.jsp").forward(request, response);
		
	} catch (PersistentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	req.forward(request, response);

}
	}
