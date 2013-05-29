/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.helpers;

/**
 *
 * @author Administrador
 */
public enum RegularExpression {
    // expresiones regulares predefinidas
    ONE_WORD("[\\w]*"),
    WORDS("[\\w\\s]*"),
    EMAIL_HOST("\\w+[\\.\\w+]*"),
    EMAIL_NAME("\\w+[\\.\\w+]*"),
    EMAIL("\\w+(\\.\\w+)*@\\w+(\\.\\w+)*"),
    NATURAL_NUMBERS("\\d*"),
    WORDS_AND_NUMBERS("\\d*+[\\w\\s]*"),
    ADRESS("\\d*+[\\-\\.\\w\\s]*");
    


    private final String value;

    RegularExpression(String v){
        value = v;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
