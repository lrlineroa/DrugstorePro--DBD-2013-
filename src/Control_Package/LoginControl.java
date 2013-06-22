package Control_Package;

import Entities.Views.ViewPersona;
import DAOS.DAOFactory;
import DAOS.exceptions.DataBaseException;
import utilities.helpers.Hash;

public class LoginControl {
    
    public static ViewPersona usuarioActivo;

    public LoginControl() {
    }

    public ViewPersona login(String rdbms, String user, String pass) throws DataBaseException {
        DAOFactory.getInstance().newConection(rdbms, user, pass);
        ViewPersona persona = new ViewPersona();
        persona.setNombreDeUsuario(user);
        persona.setPassword(Hash.hashMD5(pass));
        ViewPersona login;

        login = DAOFactory.getInstance().getViewPersonaDAO().login(persona);
        usuarioActivo = login;

        return login;

    }

    public ViewPersona login(String rdbms, String userBD, String passBD, String userAPP, String passAPP) throws DataBaseException {
        DAOFactory.getInstance().newConection(rdbms, userBD, passBD);
        ViewPersona persona = new ViewPersona();
        persona.setNombreDeUsuario(userAPP);
        persona.setPassword(Hash.hashMD5(passAPP));
        ViewPersona login;

        login = DAOFactory.getInstance().getViewPersonaDAO().login(persona);
        usuarioActivo = login;

        return login;
    }
}
