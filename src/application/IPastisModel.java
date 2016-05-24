//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package application;

public interface IPastisModel {
  
  String  UC_CONSONANTS = "BCDFGHJKLMNPQRSTVWXZ";
  String  LC_CONSONANTS = "bcdfghjklmnpqrstvwxz";
  String  UC_VOWELS     = "AEIOUY";
  String  LC_VOWELS     = "aeiouy";
  String  SYMBOLS       = "@$#%-.!&,:?<>[]/(){}+_^~";

  //----------------------------------------------------------------------------
  // Password generation constraints
  //----------------------------------------------------------------------------
  int     getLength();
  void    setLength(int length);
  
  boolean hasUcLetters();
  void    setUcLetters(boolean ucLetters);
  
  boolean hasLcLetters();
  void    setLcLetters(boolean lcLetters);
  
  boolean hasDigits();
  void    setDigits(boolean digits);

  boolean hasSymbols();
  void    setSymbols(boolean symbols);
  
  boolean isPronounceable();
  void    setPronounceable(boolean pronounceable);
  
  boolean isUnambiguous();
  void    setUnambiguous(boolean unambiguous);
  
  //----------------------------------------------------------------------------
  // Generate a new password (compliant with constraints)
  //----------------------------------------------------------------------------
  String generateNewPassword();
  
  //============================================================================
  // Utilities
  //============================================================================
  default String getUcLetters() {
    return fromCharRange('A', 'Z');
  }
  
  //----------------------------------------------------------------------------
  default String getLcLetters() {
    return fromCharRange('a', 'z');
  }
  
  default String getUcConsonants() {
    return UC_CONSONANTS;
  }
  
  //----------------------------------------------------------------------------
  default String getLcConsonants() {
    return LC_CONSONANTS;
  }
  
  //----------------------------------------------------------------------------
  default String getDigits() {
    return fromCharRange('0', '9');
  }
  
  //----------------------------------------------------------------------------
  default String getLcVowels() {
    return LC_VOWELS;
  }
  
  //----------------------------------------------------------------------------
  default String getUcVowels() {
    return UC_VOWELS;
  }
  
  //----------------------------------------------------------------------------
  default String getSymbols() {
    return SYMBOLS;
  }
  
  //----------------------------------------------------------------------------
  // Generate a String containing all characters in the range 'from' ... 'to'
  //----------------------------------------------------------------------------
  default String fromCharRange(char from, char to) {
    String r = "";
    
    for (char c=from; c<=to; c++) {
      r = r + c;
    }
    return r;
  }
}