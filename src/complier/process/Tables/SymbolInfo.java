package complier.process.Tables;

/**
 * @author 余
 */
public class SymbolInfo {

    private Type type;

    public enum Type {
        INT, REAL, BOOLEAN, CHAR, ARRAY, ARRAY_REF, FUNCTION, VOID
//      public static Type from
    }
}
