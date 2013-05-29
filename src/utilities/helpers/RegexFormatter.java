/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.helpers;

import java.text.ParseException;
import javax.swing.text.DefaultFormatter;

/**
 *
 * @author Administrador
 */
public class RegexFormatter extends DefaultFormatter{
    
    private RegularExpression regex;

    public RegexFormatter(RegularExpression regex){
        setOverwriteMode(false);
        this.setAllowsInvalid(false);
        this.regex = regex;
    }

  

    @Override
    public Object stringToValue(String input) throws ParseException{
        if(input == null)
            return null;

        if(!esValido(input,regex))// Does 'input' match the regular expression?
            throw new ParseException("does not match regex or rules", 0);

        // If we get this far, then it did match.
        return super.stringToValue(input); // will honor the 'valueClass' property

    }
    public static boolean esValido(String input, RegularExpression regex) {
        if(input.length()==0)
            return true;
        
        boolean esUnaOracion = regex.equals(RegularExpression.WORDS);

        if (!input.matches(regex.getValue())){
            return false;
        }
        else if(input.startsWith(" ") || input.startsWith("_")){
            return false;
        }
        else if(input.contains("_") && regex.equals(RegularExpression.EMAIL_HOST)){
            return false;
        }
        else if(input.contains("__") || input.contains("..")){
            return false;
        }
        else if(input.contains("._") || input.contains("_.")){
            return false;
        }
        else if(input.contains("  ") && esUnaOracion){
            return false;
        }
        else
            return true;
    }

    public static boolean esValido(char[] input, RegularExpression regex) {
        return esValido(new String(input), regex);
    }
}
