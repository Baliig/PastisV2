package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PastisController {

	private PastisModel model;

	public PastisController() {
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
	private ProgressBar progressBar;

	public void initializer() {
		model.getLengthPass().bindBidirectional(sizePassword.textProperty());
		model.getLcLetter().bind(checkMaj.selectedProperty());
		model.getUcLetter().bind(checkMin.selectedProperty());
		model.getDigits().bind(checkNb.selectedProperty());
		model.getSymbole().bind(checkSpecial.selectedProperty());
		model.getPronounceable().bind(checkPrononcable.selectedProperty());
		model.getAmbigus().bind(checkAmbigus.selectedProperty());
	}

	@FXML
	public void handleClicOnCheckBox(ActionEvent event) {
		double security = 0;
		if (checkMaj.isSelected())
			security += 20;
		if (checkMin.isSelected())
			security += 20;
		if (checkNb.isSelected())
			security += 20;
		if (checkPrononcable.isSelected())
			security -= 20;
		if (checkSpecial.isSelected())
			security += 20;
		if (checkAmbigus.isSelected())
			security -= 20;
		System.out.println(security);
		if (security < 0)
			security = 0;
		if (security > 100)
			security = 100;
		progressBar.setProgress(security / 100);
	}

	@FXML
	public void handleGenerateBtnAction(ActionEvent event) {
		initializer();
		checkOption();
		String mdp = model.generateNewPassword();
		password.setText(mdp);
	}

	// Cette méthode à pour but de vérifier qu'un mot de passe soit
	// générable.
	// Si aucune option n'est sélectionner le mot de passe ne peut être
	// générer.
	private void checkOption() {
		if (!checkMaj.isSelected() && !checkMin.isSelected() && !checkSpecial.isSelected() && !checkNb.isSelected()) {
			System.out.println("Génération de mot de passe impossible");
		} else if (checkPrononcable.isSelected() && !checkNb.isSelected() && !checkSpecial.isSelected()) {
			System.out.println("Pour que le mot de passe soit prononcable il ne faut pas cocher Nb et Special");
		}
	}

	public PastisModel getModel() {
		return model;
	}

	public void setModel(PastisModel model) {
		this.model = model;
	}

}
