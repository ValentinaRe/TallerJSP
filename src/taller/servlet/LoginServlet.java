package taller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import capanegocio.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 
		//me llega la url "proyecto/login/out"
        
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        RequestDispatcher rec= request.getRequestDispatcher("FormularioLogin.jsp");
    	request.setAttribute("Status", "Sesión finalizada");
    	rec.forward(request, response);
              
	}

	/**
	 * M�todo que recibe peticiones post para loguearse
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("password");
        Usuario usuario=new Usuario();
        usuario.setUsuario(usu);
        usuario.setPass(pass);
      
        try {
			//usuario=Usuario.busquedaUsuario(usuario);
			if(usuario.validacionUsuario(usuario)){
				RequestDispatcher rec= request.getRequestDispatcher("MenuFormularios.jsp");
	        	sesion.setAttribute("usu",usuario);
	        	rec.forward(request, response);
	           
			}else{
				
			    RequestDispatcher rec= request.getRequestDispatcher("FormularioLogin.jsp");
	        	request.setAttribute("Status", "Datos incorrectos");
	        	rec.forward(request, response);
			
			
		}} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        
        
        //deber�amos buscar el usuario en la base de datos, pero dado que se escapa de este tema, ponemos un ejemplo en el mismo c�digo
       /* if(usu.equals("admin") && pass.equals("admin")) /*&& sesion.getAttribute("usuario") == null){
            //si coincide usuario y password y adem�s no hay sesi�n iniciada
            //sesion.setAttribute("usuario", usu);
            //redirijo a p�gina con informaci�n de login exitoso
          //  response.sendRedirect("LoginExito.jsp");
      //  }else{
            //l�gica para login inv�lido
        	//response.sendRedirect("LoginFallido.jsp");
        
      //  }*/
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
