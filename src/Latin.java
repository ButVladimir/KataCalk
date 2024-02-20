
public enum Latin {
   L1 ("I"), L2("II"), L3("III"),L4("IV"),L5("v"),L6("VI"), L7("VII"),
    L8("VIII"),L9("IX"),L10("X"),L11("XI"),L12("XII"),L13("XIII"),
    L14("XIV"),L15("XV"), L16("XVI"),L17("XVII"),L18("XVIII"),L19("XIX"),L20("XX"),
    L21("XXI"),L22("XXII"),L24("XXIV"),L25("XXV"),L27("XXVII"),
    L28("XXVIII"), LL30("XXX"), L32("XXXII"),
    L35("XXXV"), L36("XXXVI"),  L40("XL"),L42("XLII"),L45("XLV"), L48("XLVIII"),L49("XLIX"),
    L50("L"),L54("LIV"),L56("LVI"),L60("LX"), L63("LXIII"), L64("LXIV"),
    L70("LXX"), L72("LXXII"), L80("LXXX"), L81("LXXXI"), L90("XC"), L100("C");

    private String translation;
     Latin (String translation) {
         this.translation = translation;
     }
public String getTranslation(){
         return translation;
}
}

