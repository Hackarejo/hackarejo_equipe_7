package br.edu.unisep;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ComversorMmcController {

	@FXML private TextField txtIdade;

	@FXML private TextField txtAltura;

	@FXML private TextField txtPeso;

	@FXML private RadioButton rdMasculino;

	@FXML private RadioButton rdFeminino;

	public void converter(ActionEvent event){

		int Idade = 0;
		try{

    	Idade = Integer.parseInt(txtIdade.getText());
		}catch(NumberFormatException e){

	    		Alert msg = new Alert(AlertType.ERROR);
	    		msg.setHeaderText("Erro ao converter");
	    		msg.setContentText("Valor Invalido para o campo Idade!");
	    		msg.showAndWait();

	    		txtIdade.requestFocus();

	    		return;
		}
		double Altura = 0;

		try{
    	 Altura = Double.parseDouble(txtAltura.getText());
		}catch(NumberFormatException e){
			Alert msg = new Alert(AlertType.ERROR);
    		msg.setHeaderText("Erro ao converter");
    		msg.setContentText("Valor Invalido para o campo Altura!");
    		msg.showAndWait();

    		txtAltura.requestFocus();

    		return;

		}

		double Peso = 0;
		try{
    	 Peso = Double.parseDouble(txtPeso.getText());
		}catch(NumberFormatException e){
			Alert msg = new Alert(AlertType.ERROR);
    		msg.setHeaderText("Erro ao converter");
    		msg.setContentText("Valor Invalido para o campo Peso!");
    		msg.showAndWait();

    		txtPeso.requestFocus();

    		return;
		}
    	double resultado = 0;

    	if(rdMasculino.isSelected()){
    		resultado = 66.5 + (13.7* Peso) + (5 * Altura) + (6.76 * Idade) ;
    	}else{
    		resultado = 655.1 + (9.56 * Peso) + (1.85 * Altura) + (4.68 * Idade);
    	}

    	Alert msg = new Alert(AlertType.INFORMATION);
		msg.setHeaderText("O seu GEB é: " + resultado);

		msg.showAndWait();
    	}

		  public void limparCampos(ActionEvent event){
		    	txtIdade.setText("");
		    	txtPeso.setText("");
		    	txtAltura.setText("");

		    	txtIdade.requestFocus();

	}

}
