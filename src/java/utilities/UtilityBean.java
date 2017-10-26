package utilities;

import connections.DBConnection;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import static java.sql.Types.VARCHAR;
import java.text.DecimalFormat;
import java.util.Date;
import javax.faces.bean.*;

@ManagedBean
@SessionScoped
public class UtilityBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String combineTwoStr(String aStr1, String aStr2, int aBracket) {
        String CombStr = "";
        if (null == aStr1) {
            aStr1 = "";
        }
        if (null == aStr2) {
            aStr2 = "";
        }
        if (aBracket == 1) {
            if (aStr1.length() > 0) {
                CombStr = "(" + aStr1 + ") " + aStr2;
            } else {
                CombStr = aStr2;
            }
        } else if (aBracket == 2) {
            if (aStr2.length() > 0) {
                CombStr = aStr1 + " (" + aStr2 + ")";
            } else {
                CombStr = aStr1;
            }
        } else {
            CombStr = "";
        }
        return CombStr;
    }

    public String returnYesNoString(int aYesNo) {
        switch (aYesNo) {
            case 0:
                return "Yes";
            case 1:
                return "No";
            default:
                return "";
        }
    }

    public Date getCURRENT_SERVER_DATE() {
        Date aDate = null;
        String sql = "{call sp_get_current_system_datetime(?)}";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                CallableStatement cs = conn.prepareCall(sql);) {
            cs.registerOutParameter("out_current_system_datetime", VARCHAR);
            cs.executeQuery();
            aDate = new Date(cs.getTimestamp("out_current_system_datetime").getTime());
        } catch (SQLException sqe) {
            aDate = null;
        }
        return aDate;
    }

}
