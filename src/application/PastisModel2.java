package application;

import java.util.Random;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;

public class PastisModel2 {

	private static final int LENGTH_PASSWORD = 12;

	private IntegerProperty lengthPass;
	private BooleanProperty ucLetter;
	private BooleanProperty lcLetter;
	private BooleanProperty digits;
	private BooleanProperty symbole;
	private BooleanProperty pronounceable;
	private BooleanProperty ambigus;

	public PastisModel2() {
		this.lengthPass.set(LENGTH_PASSWORD);
		this.ucLetter.set(false);
	}

	public IntegerProperty getLengthPass() {
		return lengthPass;
	}

	public void setLengthPass(IntegerProperty lengthPass) {
		this.lengthPass = lengthPass;
	}

	public BooleanProperty getUcLetter() {
		return ucLetter;
	}

	public void setUcLetter(BooleanProperty ucLetter) {
		this.ucLetter = ucLetter;
	}

	public BooleanProperty getLcLetter() {
		return lcLetter;
	}

	public void setLcLetter(BooleanProperty lcLetter) {
		this.lcLetter = lcLetter;
	}

	public BooleanProperty getDigits() {
		return digits;
	}

	public void setDigits(BooleanProperty digits) {
		this.digits = digits;
	}

	public BooleanProperty getSymbole() {
		return symbole;
	}

	public void setSymbole(BooleanProperty symbole) {
		this.symbole = symbole;
	}

	public BooleanProperty getPronounceable() {
		return pronounceable;
	}

	public void setPronounceable(BooleanProperty pronounceable) {
		this.pronounceable = pronounceable;
	}

	public BooleanProperty getAmbigus() {
		return ambigus;
	}

	public void setAmbigus(BooleanProperty ambigus) {
		this.ambigus = ambigus;
	}

	public static int getLengthPassword() {
		return LENGTH_PASSWORD;
	}

	public String generateNewPassword() {
		String passwordGen = null;
		// Générer une caractères aléatoire autant de fois pour avoir la longeur
		// voulu:

		return passwordGen;
	}

	public String getRandomFromList(String constant) {
		String result = null;
		Random rdm = new Random();
		int index = rdm.nextInt(constant.length());
		result = String.valueOf(constant.charAt(index));
		return result;
	}

}
