package Control_Package;

import Entities.Views.ViewPersona;
import Boundary_Package.MainFrame;
import DAOS.DAOFactory;
import DAOS.ViewPersonaDAO;
import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewCargo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.59969228-2F45-84CB-BA60-B1F0BB6466B2]
// </editor-fold> 
public class RegisterControl {
       
    
    
//    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
//    // #[regen=yes,id=DCE.3E7A0EC2-21C7-7672-EE83-2798CDB23D4E]
//    // </editor-fold> 
    public String makeRegister (ViewPersona persona)  {
        
        if(!verifyIdentification(persona)){
            return "Cédula ya registrada";
        }
//        if(!verifyEmail(persona)){
//            return "Correo ya existente porfavor ingrese otro";
//        }
        if(!verifyNick(persona)){
        
            return "nombre de usuario ya existente";
        }
        
        if(!verifyNameLength(persona.getNombrePersona(),persona.getApellidoPersona())){
            return "Nombre o apellido invalido";
        }
        if(!verifyPassword(persona.getPassword())){
             return "contraseña inválida";    
        }
        try {
            DAOFactory.getInstance().getViewPersonaDAO().create(persona);
        } catch (Exception ex) {
            Logger.getLogger(RegisterControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Registro Hecho";
        
    }

//    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
//    // #[regen=yes,id=DCE.AB477609-AAC7-A4A2-EBE6-519079B0886E]
//    // </editor-fold> 
//    public boolean verifyEmail (ViewPersona p) {
//        for(Persona u:perS.ReadAll(MainFrame.DrugPresent.getIdDrogueria())){
//            if(p.get().equals(u.getMailPersona())){
//             return false;
//            }
//        }
//        
//        return true;
//    }
    
    public boolean verifyIdentification (ViewPersona p) {
        for(ViewPersona u:DAOFactory.getInstance().getViewPersonaDAO().findViewPersonaEntities()){
            if(p.getIdPersona().equals(u.getIdPersona())){
             return false;
            }
        }
        
        return true;
    }
    
     public boolean verifyNick (ViewPersona p) {
        for(ViewPersona u:DAOFactory.getInstance().getViewPersonaDAO().findViewPersonaEntities()){
            if(p.getNombreDeUsuario().equals(u.getNombreDeUsuario())){
             return false;
            }
        }
        
        return true;
    }
    
    
    
    public boolean verifyNameLength(String fN,String lN){
        if(fN.length()>1 && fN.length()<=20 && lN.length()>1 && lN.length()<=20){
          return true;
        }
        return false;
    }

    public boolean verifyPassword(String pass){
        if(pass.length()>5 && pass.length()<=12){
          return true;
        }
        return false;
    }
    
    public int traerCargo(String nombre) {
        
        List<ViewCargo> ListaCargos = DAOFactory.getInstance().getViewCargoDAO().findViewCargoEntities();
        int idCargo = 0;
        for(ViewCargo c: ListaCargos){
            if(c.getTipoCargo().equals(nombre)) return c.getIdCargo();
        }
        
        return idCargo;
        
    }
    
    public List<ViewCargo> ListaCargos(){
        return DAOFactory.getInstance().getViewCargoDAO().findViewCargoEntities();
        
    }
    
    public ViewPersona searchById(int id){
        return DAOFactory.getInstance().getViewPersonaDAO().findViewPersona(id);
    }
    
    public boolean DeletePerson(ViewPersona person) throws NonexistentEntityException{
        if(person != null){
            DAOFactory.getInstance().getViewPersonaDAO().destroy(person.getIdPersona());
            return true;
        }
        return false;
        
        
    }
    
    public boolean UpdatePerson(ViewPersona person) {
        if(person != null){
            try {
                DAOFactory.getInstance().getViewPersonaDAO().edit(person);
                return true;
            } catch (Exception ex) {
                Logger.getLogger(RegisterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return false;
    }
    
//    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
//    // #[regen=yes,id=DCE.97B9D3C4-AA9F-2C28-7413-5224D3D09125]
//    // </editor-fold> 
//    public Boolean UserCorrect (int rol) {
//        return null;
//    }

}

