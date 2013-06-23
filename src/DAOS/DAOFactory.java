package DAOS;

import DAOS.exceptions.DataBaseException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edward
 */
public class DAOFactory {

    private EntityManagerFactory emf;
    private final String SYBASE = "SyBase";
    private final String SQL_SERVER = "MS SQL Server";
    private final String ORACLE = "Oracle";
    private final String DRIVER_SYBASE = "net.sourceforge.jtds.jdbc.Driver";
    private final String DRIVER_SQL_SERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String DRIVER_ORACLE = "oracle.jdbc.OracleDriver";
    private final String URL_SYBASE = "jdbc:jtds:sybase://168.176.36.25:8101/dbd_3";
    private final String URL_SQL_SERVER = "jdbc:sqlserver://168.176.36.26:1433;databaseName=dbd_3";
    private final String URL_ORACLE = "jdbc:oracle:thin:@168.176.36.14:1521:UNBDS7";

    private DAOFactory() {
    }

    public ViewPersonaDAO getViewPersonaDAO() {
        return new ViewPersonaDAO(emf);
    }

    public ViewDrogueriaDAO getViewDrogueriaDAO() {
        return new ViewDrogueriaDAO(emf);
    }

    public ViewFabricanteDAO getViewFabricanteDAO() {
        return new ViewFabricanteDAO(emf);
    }

    public ViewFacturaDAO getViewFacturaDAO() {
        return new ViewFacturaDAO(emf);
    }

    public ViewInventariorptDAO getViewInventariorptDAO() {
        return new ViewInventariorptDAO(emf);
    }

    public ViewMedicamentoDAO getViewMedicamentoDAO() {
        return new ViewMedicamentoDAO(emf);
    }
    
    public ViewPedidoDAO getViewPedidoDAO() {
        return new ViewPedidoDAO(emf);
    }
    
    public ViewPresentacionDAO getViewPresentacionDAO() {
        return new ViewPresentacionDAO(emf);
    }
    
    public ViewProductosDrogueriaDAO getViewProductosDrogueriaDAO() {
        return new ViewProductosDrogueriaDAO(emf);
    }
    
    public ViewProveedorDAO getViewProveedorDAO() {
        return new ViewProveedorDAO(emf);
    }
    
    public ViewTipoProductoDAO getViewTipoProductoDAO() {
        return new ViewTipoProductoDAO(emf);
    }
    
    public ViewUsoMedicDAO getViewUsoMedicDAO() {
        return new ViewUsoMedicDAO(emf);
    }

    public void newConection(String rdbms, String user, String pass) throws DataBaseException {
        String PU = "DrugstorePro--DBD-2013-PU";
        Map properties = new HashMap();

        switch (rdbms) {
            case SYBASE:
                properties.put("javax.persistence.jdbc.driver", DRIVER_SYBASE);
                properties.put("javax.persistence.jdbc.url", URL_SYBASE);
                break;
            case SQL_SERVER:
                properties.put("javax.persistence.jdbc.driver", DRIVER_SQL_SERVER);
                properties.put("javax.persistence.jdbc.url", URL_SQL_SERVER);
                break;
            case ORACLE:
                properties.put("javax.persistence.jdbc.driver", DRIVER_ORACLE);
                properties.put("javax.persistence.jdbc.url", URL_ORACLE);
                break;
        }
        properties.put("javax.persistence.jdbc.password", pass);
        properties.put("javax.persistence.jdbc.user", user);
        emf = Persistence.createEntityManagerFactory(PU, properties);
        try {
            emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error al conectarse a la Base de Datos\n\n" + e.getMessage(), e);
        }
    }
    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }
}
