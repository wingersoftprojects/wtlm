package utilities;

import java.io.Serializable;
import java.text.DecimalFormat;
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
        if (aYesNo == 0) {
            return "N";
        } else if (aYesNo == 1) {
            return "Y";
        } else {
            return "";
        }
    }

}
