package Control_Package;

import Entities.ViewPersona;
import Boundary_Package.MainFrame;
import DAOS.ViewPersonaDAO;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.6BF8A883-1DC7-0938-E8DA-15344946C22B]
// </editor-fold> 
public class LoginControl {
    private ViewPersonaDAO perS=new ViewPersonaDAO(MainFrame.emf);
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B63A264E-9846-31BC-3BE0-97D6ECEC4EBA]
    // </editor-fold> 


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6B0EE2F7-2A6F-4401-BEF4-7C5041422DD9]
    // </editor-fold> 
    public LoginControl () {
       
    }


//
    public ViewPersona getLooged(ViewPersona persona){
        for(ViewPersona p:perS.findViewPersonaByDrogueria(MainFrame.DrugPresent.getIdDrogueria())){
            if(persona.getIdPersona().equals(p.getIdPersona())&& persona.getPassword().equals(p.getPassword())){
                return p;
            }
            
        }
    return null;
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CC522298-B3B1-BBAE-BFD6-C6C3C231F14D]
    // </editor-fold> 
    public String verifyLogin (ViewPersona persona) {

        for(ViewPersona p:perS.findViewPersonaByDrogueria(MainFrame.DrugPresent.getIdDrogueria())){
            
            if(persona.getIdPersona().equals(p.getIdPersona())&& persona.getPassword().equals(p.getPassword())){
                return "Login Hecho";
            }
            
        }
        return "login Errado";
    }

   
//
//    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
//    // #[regen=yes,id=DCE.7DE01318-5DE0-3CFF-832B-3E01206AB0B6]
//    // </editor-fold> 
    public boolean VerifyRol (ViewPersona p) {
        if(p.getIdCargo().intValue()==1){
             return true;
        }
        return false;
    }

}

