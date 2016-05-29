package taller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * Método para verificar sesión
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
    	
	
	}
	

	/**Método post intermedio que recibe peticiones post para que al actualizar un contacto este tenga daos precargados
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
		
	
	
	List <Empresa> listar=null;
	Empresa emp = new Empresa();

	try {
		
		listar = emp.listarEmpre();
		
		if(listar.isEmpty()){
			System.out.println("lista vacia");
			req.forward(request, response);
			
			
		}else{
			request.setAttribute("listar", listar);
			String salida = "<div class='form-group'><label class='col-lg-3 control-label'>Seleccione Empresa</label>"
					+ "<div class='col-lg-3'><select class='form-control' name='idEmpresa'>'";
			for (Empresa empr: listar){
				if (empr.getNombre().equals(empresa)){
					salida += "<option value='"+empr.getUid()+"' selected>" + empr.getNombre()+"</option>";
					System.out.println("mesaje if "+empr.getNombre());
				}else{
					salida += "<option value='"+empr.getUid()+"'>"
							+empr.getNombre()+"</option>";
					System.out.println("mesaje else "+empr.getNombre());
				}
			}
			salida += "</select><br></div></div>";
			request.setAttribute("listaEmpresa", salida);
			request.getRequestDispatcher("/FormularioActualizar.jsp").forward(request, response);
			
		}
	} catch (PersistentException e) {
		// TODO Auto-generated catch block
		req.forward(request, response);
	}
	
	req.forward(request, response);

 }
	}
