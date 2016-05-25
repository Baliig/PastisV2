package application;

import java.util.Random;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PastisModel {

	private static final int LENGTH_PASSWORD = 12;

	private StringProperty lengthPass = new SimpleStringProperty();
	private final BooleanProperty ucLetter = new SimpleBooleanProperty();
	private final BooleanProperty lcLetter = new SimpleBooleanProperty();
	private final BooleanProperty digits = new SimpleBooleanProperty();
	private final BooleanProperty symbole = new SimpleBooleanProperty();
	private final BooleanProperty pronounceable = new SimpleBooleanProperty();
	private final BooleanProperty ambigus = new SimpleBooleanProperty();

	public PastisModel() {
		this.lengthPass.set(String.valueOf(LENGTH_PASSWORD));
		this.ucLetter.set(false);
		this.lcLetter.set(false);
		this.digits.set(false);
		this.symbole.set(false);
		this.pronounceable.set(false);
		this.ambigus.set(false);
	}

	public String generateNewPassword() {
		String passwordGen = null;
		// Générer une caractères aléatoire autant de fois pour avoir la longeur
		// voulu:
		System.out.println(ambigus.getValue());
		return passwordGen;
	}

	public String getRandomFromList(String constant) {
		String result = null;
		Random rdm = new Random();
		int index = rdm.nextInt(constant.length());
		result = String.valueOf(constant.charAt(index));
		return result;
	}

	public StringProperty getLengthPass() {
		return lengthPass;
	}

	public void setLengthPass(StringProperty lengthPass) {
		this.lengthPass = lengthPass;
	}

	public BooleanProperty getUcLetter() {
		return ucLetter;
	}

	public BooleanProperty getLcLetter() {
		return lcLetter;
	}

	public BooleanProperty getDigits() {
		return digits;
	}

	public BooleanProperty getSymbole() {
		return symbole;
	}

	public BooleanProperty getPronounceable() {
		return pronounceable;
	}

	public BooleanProperty getAmbigus() {
		return ambigus;
	}

}
