package application;

import java.util.Random;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PastisModel {
	
	String  UC_CONSONANTS = "BCDFGHJKLMNPQRSTVWXZ";
	String  LC_CONSONANTS = "bcdfghjklmnpqrstvwxz";
	String  UC_VOWELS     = "AEIOUY";
	String  LC_VOWELS     = "aeiouy";
	String  NUMBER		  = "0123456789";
	String  SYMBOLS       = "@$#%-.!&,:?<>[]/(){}+_^~";

	private static final int LENGTH_PASSWORD = 12;

	private StringProperty lengthPass = new SimpleStringProperty();
	private final BooleanProperty ucLetter = new SimpleBooleanProperty();
	private final BooleanProperty lcLetter = new SimpleBooleanProperty();
	private final BooleanProperty digits = new SimpleBooleanProperty();
	private final BooleanProperty symbole = new SimpleBooleanProperty();
	private final BooleanProperty pronounceable = new SimpleBooleanProperty();
	private final BooleanProperty ambigus = new SimpleBooleanProperty();

	public PastisModel() {
		this.ucLetter.set(false);
		this.lcLetter.set(false);
		this.digits.set(false);
		this.symbole.set(false);
		this.pronounceable.set(false);
		this.ambigus.set(false);
	}

	public String generateNewPassword() {
		String passwordGen = "";
		String list = null;
		if(lengthPass.get().isEmpty()){
			lengthPass.set("12");
		}
		int passwordLength = Integer.valueOf(lengthPass.get());
		
		if(pronounceable.get()){
			
		}
		
		if(ambigus.get()){
			
		}
		if(ucLetter.get() || lcLetter.get() || digits.get() || symbole.get()){
			if(ucLetter.get() == true){
				list += UC_CONSONANTS;
				list += UC_VOWELS;
			}
			if(lcLetter.get()){
				list += LC_CONSONANTS;
				list += LC_VOWELS;
			}
			if(digits.get()){
				list += NUMBER;
			}
			if(symbole.get()){
				list += SYMBOLS;
			}
			for (int i = 0; i < passwordLength; i++) {
				Random rdm = new Random();
				int nb = rdm.nextInt(list.length());
				passwordGen += list.charAt(nb); 
			}
		}
		
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
