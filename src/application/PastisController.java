package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PastisController {

	private PastisModel model;

	public PastisController() {
		model = new PastisModel();
	}

	@FXML
	private TextField sizePassword;
	@FXML
	private CheckBox checkMaj;
	@FXML
	private CheckBox checkMin;
	@FXML
	private CheckBox checkNb;
	@FXML
	private CheckBox checkSpecial;
	@FXML
	private CheckBox checkPrononcable;
	@FXML
	private CheckBox checkAmbigus;
	@FXML
	private Button bGenerate;
	@FXML
	private TextField password;

	@FXML
	public void initializer() {

	}

	@FXML
	public void handleGenerateBtnAction(ActionEvent event) {
		checkOption();
		// Change all paramètre
		if(!sizePassword.getText().isEmpty()){
			model.setLength(Integer.valueOf(sizePassword.getText()));
		}
		model.setUcLetters(checkMaj.isSelected());
		model.setLcLetters(checkMin.isSelected());
		model.setDigits(checkNb.isSelected());
		model.setSymbols(checkSpecial.isSelected());
		model.setPronounceable(checkPrononcable.isSelected());
		model.setUnambiguous(checkAmbigus.isSelected());
		String passwordGen =  model.generateNewPassword();
		password.setText(passwordGen);
	}
	//Cette méthode à pour but de vérifier qu'un mot de passe soit générable.
	//Si aucune option n'est sélectionner le mot de passe ne peut être générer.
	private void checkOption(){
		if(!checkMaj.isSelected() && !checkMin.isSelected() && !checkSpecial.isSelected() && !checkNb.isSelected()){
			System.out.println("Génération de mot de passe impossible");
		}else if (checkPrononcable.isSelected() && checkNb.isSelected() && checkSpecial.isSelected()){
			System.out.println("Pour que le mot de passe soit prononcable il ne faut pas cocher Nb et Special");
		}
	}


}
