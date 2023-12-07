package cursocontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.curso;
import model.cursodao;

/**
 * Servlet implementation class cursocontrole
 */
@WebServlet({"/cursocontrole","/novocurso" , "/relcurso"})
public class cursocontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cursocontroler() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    curso curs = new curso();
    cursodao dao = new cursodao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 String action = request.getServletPath();
	       
	        if(action.equals("/novocurso")) {
	            Salvar(request,response);
	        }    
	        if(action.equals("/relcurso")) {
	            Imprimir(request,response);
	        }    
	}

	private void Salvar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//alu.setIdcurso(Integer.parseInt(request.getParameter("idcurso")));
		curs.setNome(request.getParameter("nome"));
		curs.setCargahoraria(Integer.parseInt(request.getParameter("cargahoraria")));
		curs.setTipocurso(request.getParameter("tipocurso"));
		dao.Salva(curs);
		 PrintWriter pw=response.getWriter();
		 pw.println("curso cadastrado com sucesso");
		
	}

	private void Imprimir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//chamar o dao
		
		ArrayList<curso> lista = dao.listar();
		request.setAttribute("cursos", lista);
		
		RequestDispatcher rd= request.getRequestDispatcher("relacurso.jsp");
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
