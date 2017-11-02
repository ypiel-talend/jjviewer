package samples;

/**
 * This is a simple class
 * with comments on multi-line
 */
public class SimpleClass {

  // And simple line comments
                private    String aVar = ""; // A single comment

    // Another simple line
    public SimpleClass(String    s,      Integer    i){
        this.simpleMethod(s, i.intValue());
    }

    /**
     * First Line of comment
     *
     * @param v The first agument
     * @param n The second one
     * @return String The return value of the method
     */
    public       String            simpleMethod(String v   , int n)      {
        String myString  = v       ;
        for( int i   = 1;    i         <= n  ; i++)  {
            myString        +=  ".";
        }

        return myString;
    }



}
