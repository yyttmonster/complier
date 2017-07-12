package complier.process.Tables;

/**
 * @author 余
 */
public class SymbolInfo {

    private Type type;

    public enum Type {
        INT, REAL, BOOLEAN, CHAR, ARRAY, ARRAY_REF, FUNCTION, VOID;

      public static Type fromString (String string) {
            switch (string) {
                case "int" :return INT;
                case "real" :return REAL;
                case "boolean" :return BOOLEAN;
                case "char":return CHAR;
                case "void" :return VOID;
                default:return null;
            }
      }
    }

}
