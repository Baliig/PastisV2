package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Text;

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
	@FXML
	private Button copy;
	@FXML
	private Label lSpecial;
	@FXML
	private Label lPrononcable;
	@FXML
	private Label lAmbigus;

	public void initializer() {
		model.getLengthPass().bindBidirectional(sizePassword.textProperty());
		model.getLcLetter().bind(checkMaj.selectedProperty());
		model.getUcLetter().bind(checkMin.selectedProperty());
		model.getDigits().bind(checkNb.selectedProperty());
		model.getSymbole().bind(checkSpecial.selectedProperty());
		model.getPronounceable().bind(checkPrononcable.selectedProperty());
		model.getAmbigus().bind(checkAmbigus.selectedProperty());
		lSpecial.setTooltip(new Tooltip("Exemple: @$#%-.!&"));
		lPrononcable.setTooltip(new Tooltip("Il faut avoir cocher majuscule et/ou minuscule et ne pas cocher les caractères spéciaux et nombres"));
		lAmbigus.setTooltip(new Tooltip("Exclu les: Il1 et 0O"));
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
	
	@FXML
	public void handleCopyBtnAction(ActionEvent event) {
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent cbContent = new ClipboardContent();
		cbContent.putString(password.getText());
		clipboard.setContent(cbContent);
	}
	

	public PastisModel getModel() {
		return model;
	}

	public void setModel(PastisModel model) {
		this.model = model;
	}

}
