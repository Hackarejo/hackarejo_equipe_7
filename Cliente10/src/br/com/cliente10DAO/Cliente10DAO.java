package br.com.cliente10DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cliente10VO.Cliente10VO;
import br.edu.unisep.dao.DAOGenerico;
import br.edu.unisep.exception.AppException;
import javafx.event.ActionEvent;
import br.com.cliente10.*;

public class Cliente10DAO extends DAOGenerico {

	public Cliente10DAO(){
		super("cliente10");
	}

	public List<Cliente10VO> listar() throws AppException{

		List<Cliente10VO> lista = new ArrayList<>();

		try{

			Connection con = abrirConexao();

			PreparedStatement ps = con.prepareStatement("select * from cliente10");
			ResultSet rs = ps.executeQuery();



			while(rs.next()){

				Cliente10VO cliente = new Cliente10VO();

				Integer id = rs.getInt("id_cliente");
				cliente.setId(id);

				String nome = rs.getString("nome");
				cliente.setNome(nome);

				String login = rs.getString("login");
				cliente.setLogin(login);

				String senha = rs.getString("senha");
				cliente.setSenha(senha);

				String email = rs.getString("email");
				cliente.setEmail(email);

				lista.add(cliente);

			}

			rs.close();
			ps.close();
			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
			return lista;
	}



		public void adicionar(Cliente10VO cliente) throws AppException{

			try{
				Connection con = abrirConexao();

				PreparedStatement ps = con.prepareStatement("insert into cliente "
						+ "( id_cliente, nome, login, senha, email)"
						+"VALUES (?, ?, ?, ?, ?)");

				ps.setInt(1, cliente.getId());
				ps.setString(2, cliente.getNome());
				ps.setString(3, cliente.getLogin());
				ps.setString(4, cliente.getSenha());
				ps.setString(5, cliente.getEmail());

				ps.execute();

				ps.close();
				con.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
