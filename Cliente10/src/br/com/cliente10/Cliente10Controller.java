package br.com.cliente10;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.cliente10DAO.Cliente10DAO;
import br.com.cliente10VO.Cliente10VO;
import br.edu.unisep.exception.AppException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Cliente10Controller implements Initializable{

	@FXML private TextField txtId;
	@FXML private TextField txtNome;
	@FXML private TextField txtLogin;
	@FXML private TextField txtSenha;
	@FXML private TextField txtAlmoco;

	@FXML private TableView<Cliente10VO> tabCliente;
	@FXML private TableColumn<Cliente10VO, Integer> colId;
	@FXML private TableColumn<Cliente10VO, String> colNome;
	@FXML private TableColumn<Cliente10VO, String> colEndereco;
	@FXML private TableColumn<Cliente10VO, String> colSabor;

	private ObservableList<Cliente10VO> listaCliente10VO;

	private Cliente10VO Cliente10VO;

	@Override public void initialize(URL location, ResourceBundle resources){

		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		colSabor.setCellValueFactory(new PropertyValueFactory<>("sabor"));

		listaCliente10VO = FXCollections.observableArrayList();

		tabCliente.setItems(listaCliente10VO);

		try {
			listar();
		} catch (AppException e) {
			e.exibirExcecao();
		}
	}

	public void adicionar(ActionEvent event){
		Cliente10VO cliente = new Cliente10VO();

		cliente.setNome( txtNome.getText());
		cliente.setLogin(  txtLogin.getText());
		cliente.setSenha( txtSenha.getText());

	}

	public void listar() throws AppException{
		Cliente10DAO dao = new Cliente10DAO();

			List<Cliente10VO> lista = dao.listar();

			listaCliente10VO.clear();
			listaCliente10VO.addAll(lista);
		}

	public void cancelar(ActionEvent event){
		txtId.setText("");
		txtNome.setText("");
		txtLogin.setText("");
		txtSenha.setText("");
		txtAlmoco.setText("");
	}
}
