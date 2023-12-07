package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.Conexao;

public class AlunoDao {
Connection con;
ResultSet rs;
	public AlunoDao() {
	
		con = new Conexao().conectar();
		
		
	}
	
	public void Salva(Aluno alu) {
		try {
			
			String sql = "insert into aluno (nome,telefone,email,datanasc,cpf,rg,cep,numero,complemento) values(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt =con.prepareStatement(sql);
			stmt.setString(1,alu.getNome());
			stmt.setString(2,alu.getTelefone() );
			stmt.setString(3,alu.getEmail());
			stmt.setString(4,alu.getDatanasc());
			stmt.setString(5,alu.getCpf());
			stmt.setString(6,alu.getRg());
			stmt.setString(7,alu.getCep());
			stmt.setInt(8,alu.getNumero());
			stmt.setString(9,alu.getComplemento());
			stmt.executeUpdate();
			con.close();
			
			
			
			
		}
		
		
		catch (Exception erro) {
			
		}
		
		
		
	}
	
	
	public ArrayList<Aluno>listar() {
		
		try {
			con = new Conexao().conectar(); 
			ArrayList<Aluno> alunos = new ArrayList<>();
			String sql = "select * from aluno";
			PreparedStatement stmt =con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int idaluno = rs.getInt("idaluno");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");
				String datanasc = rs.getString("datanasc");
				String cpf = rs.getString("cpf");
				String rg = rs.getString("rg");
				String cep = rs.getString("cep");
				int numero = rs.getInt("numero");
				String complemento = rs.getString("complemento");
				alunos.add(new Aluno(idaluno,nome,telefone,email,datanasc,cpf,rg,cep,numero,complemento));
				
				
				
			}
			return alunos;
			
		}
		catch(Exception erro) {
			System.out.print(erro);
			return null;
		}
		
		
	}
public void consulta(Aluno alu) {
	try {
		con = new Conexao().conectar();
		ArrayList<Aluno> alunos = new ArrayList<>();
		String sql = "select * from aluno where idaluno= ?";
		PreparedStatement stmt =con.prepareStatement(sql);
		stmt.setInt(1, alu.getIdaluno());
		rs = stmt.executeQuery();
		while (rs.next()) {
			alu.setIdaluno(rs.getInt("idaluno"));
			alu.setNome(rs.getString("nome"));
			alu.setTelefone(rs.getString("telefone"));
			alu.setEmail(rs.getString("email"));
			alu.setDatanasc(rs.getString("datanasc"));
			alu.setCpf(rs.getString("cpf"));
			alu.setRg(rs.getString("rg"));
			alu.setCep(rs.getString("cep"));
			alu.setNumero(rs.getInt("numero"));
			alu.setComplemento(rs.getString("complemento"));
		}
		
	}
	catch (Exception erro) {
		System.out.println(erro);
	}
}

public void editar(Aluno alu) {
	try {
		con = new Conexao().conectar();
		String sql = "update aluno set nome=?,telefone=?,email=?,datanasc=?,cpf=?,rg=?,cep=?,numero=?,complemento=? where idaluno=?";
		PreparedStatement stmt =con.prepareStatement(sql);
		stmt.setString(1,alu.getNome());
		stmt.setString(2,alu.getTelefone() );
		stmt.setString(3,alu.getEmail());
		stmt.setString(4,alu.getDatanasc());
		stmt.setString(5,alu.getCpf());
		stmt.setString(6,alu.getRg());
		stmt.setString(7,alu.getCep());
		stmt.setInt(8,alu.getNumero());
		stmt.setString(9,alu.getComplemento());
		stmt.setInt(10, alu.getIdaluno());
		stmt.executeUpdate();
		
		
		
	}
	catch (Exception erro) {
		System.out.println(erro);
	}
}

public void excluir(Aluno alu) {
	try {
		con = new Conexao().conectar();
		String sql = "delete from aluno where idaluno=?";
		PreparedStatement stmt =con.prepareStatement(sql);
		stmt.setInt(1, alu.getIdaluno());
		stmt.executeUpdate();
		
		
		
	}
	catch (Exception erro) {
		System.out.println(erro);
	}
}

}
