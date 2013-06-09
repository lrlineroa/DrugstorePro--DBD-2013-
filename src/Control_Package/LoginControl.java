package Control_Package;

import Entities.Views.ViewPersona;
import DAOS.DAOFactory;
import DAOS.exceptions.DataBaseException;

public class LoginControl {
    
    public static ViewPersona usuarioActivo;

    public LoginControl() {
    }

    public ViewPersona login(String rdbms, String user, String pass) throws DataBaseException {
        DAOFactory.getInstance().newConection(rdbms, user, pass);
        ViewPersona persona = new ViewPersona();
        persona.setNombreDeUsuario(user);
        persona.setPassword(pass);
        ViewPersona login;

        login = DAOFactory.getInstance().getViewPersonaDAO().login(persona);
        usuarioActivo = login;

        return login;

    }
}
