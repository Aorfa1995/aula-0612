
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

import model.Aluno;
import model.AlunoDao;


/**
 * Servlet implementation class AlunoController
 */
@WebServlet({"/AlunoController","/novoaluno", "/relaluno", "/bteditar", "/editar","/btexcluir"})

public class AlunoController extends HttpServlet {
    private static final long serialVersionUID = 1L;      
   
    public AlunoController() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    Aluno alu = new Aluno();
    AlunoDao dao = new AlunoDao();
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
       
        String action = request.getServletPath();
       
        if(action.equals("/novoaluno")) {
            Salvar(request,response);
        }    
        if(action.equals("/relaluno")) {
            Imprimir(request,response);
        }   
        
        if (action.equals("/bteditar")) {
        	exibir(request,response);
        }
        
        if (action.equals("/editar")) {
        	editar(request,response);
        }
        if (action.equals("/btexcluir")) {
        	excluir(request,response);
        }
   
    }
   

   

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
   
protected void Salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
   
    
    alu.setNome(request.getParameter("nome"));
    alu.setTelefone(request.getParameter("telefone"));
    alu.setEmail(request.getParameter("email"));
    alu.setDatanasc(request.getParameter("datanasc"));
    alu.setRg(request.getParameter("rg"));
    alu.setCpf(request.getParameter("cpf"));
    alu.setCep(request.getParameter("cep"));
    alu.setNumero(Integer.parseInt(request.getParameter("numero")));
    alu.setComplemento(request.getParameter("complemento"));    
    
    dao.Salva(alu);
   
   
    PrintWriter pw=response.getWriter();
    pw.println("Aluno cadastrado com sucesso");
    /*
    pw.println("Código: "+alu.getIdaluno());
    pw.println("Nome: "+alu.getNome());
    pw.println("Telefone: "+alu.getTelefone());
    pw.println("Data Nascimento: "+alu.getDatanasc());
    pw.println("Rg: "+alu.getRg());
    pw.println("Cpf: "+alu.getCpf());
    pw.println("Cep: "+alu.getCep());
    pw.println("Número: "+alu.getNumero());
    pw.println("Complemento: "+alu.getComplemento());    */
   
}

protected void Imprimir (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	//chamar o dao
	
	ArrayList<Aluno> lista = dao.listar();
	request.setAttribute("alunos", lista);
	
	RequestDispatcher rd= request.getRequestDispatcher("relatorio.jsp");
	rd.forward(request, response);
	
	
}

protected void exibir (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	//chamar o dao
	
	
	alu.setIdaluno(Integer.parseInt(request.getParameter("idaluno")));
	dao.consulta(alu);
	request.setAttribute("idaluno", alu.getIdaluno());
	request.setAttribute("nome",alu.getNome());
	request.setAttribute("telefone",alu.getTelefone());
	request.setAttribute("email",alu.getEmail());
	request.setAttribute("datanasc", alu.getDatanasc());
	request.setAttribute("rg",alu.getRg());
	request.setAttribute("cpf",alu.getCpf());
	request.setAttribute("cep",alu.getCep());
	request.setAttribute("numero",alu.getNumero());
	request.setAttribute("complemento",alu.getComplemento());
	
	RequestDispatcher rd= request.getRequestDispatcher("editaluno.jsp");
	rd.forward(request, response);

}

protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
   
	alu.setIdaluno(Integer.parseInt(request.getParameter("idaluno")));
    alu.setNome(request.getParameter("nome"));
    alu.setTelefone(request.getParameter("telefone"));
    alu.setEmail(request.getParameter("email"));
    alu.setDatanasc(request.getParameter("datanasc"));
    alu.setRg(request.getParameter("rg"));
    alu.setCpf(request.getParameter("cpf"));
    alu.setCep(request.getParameter("cep"));
    alu.setNumero(Integer.parseInt(request.getParameter("numero")));
    alu.setComplemento(request.getParameter("complemento"));    
    
    dao.editar(alu);
    PrintWriter pw=response.getWriter();
    pw.println("Aluno alterado com sucesso");
}
   

protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
   
	alu.setIdaluno(Integer.parseInt(request.getParameter("idaluno")));
     
    dao.excluir(alu);
    Imprimir(request,response);
    response.sendRedirect("relatorio.jsp");
    //pw.println("Aluno excluido com sucesso");
}
   

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
