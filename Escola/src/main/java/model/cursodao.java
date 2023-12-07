package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.Conexao;

public class cursodao {
	
	Connection con;
	ResultSet rs;
		public cursodao() {
		
			con = new Conexao().conectar();
			
		}
		
		public void Salva (curso curs) {
			
			try {
				String sql = "insert into curso (nome,cargahoraria,tipocurso) values(?,?,?)";
				PreparedStatement stmt =con.prepareStatement(sql);
				stmt.setString(1,curs.getNome());
				stmt.setInt(2,curs.getCargahoraria());
				stmt.setString(3,curs.getTipocurso());
				stmt.executeUpdate();
				con.close();
				
				
			}
			
			catch (Exception erro){
				
				
			}
			
		}

		
		public ArrayList<curso>listar() {
			try {
				con = new Conexao().conectar();
				ArrayList<curso>cursos = new ArrayList<>();
				String sql = "select * from curso";
				PreparedStatement stmt =con.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					int idcurso = rs.getInt("idcurso");
					String nome = rs.getString("nome");
					int cargahoraria = rs.getInt("cargahoraria");
					String tipocurso = rs.getString("tipocurso");
					cursos.add(new curso(idcurso,nome,cargahoraria,tipocurso));
				}
				return cursos;
				
			}
			catch (Exception erro) {
				System.out.print(erro);
				return null;
			}
			
		}
}
