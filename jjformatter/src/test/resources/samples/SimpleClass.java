package samples;

public class SimpleClass {


                private    String aVar = "";

    public SimpleClass(String    s,      Integer    i){
        this.simpleMethod(s, i.intValue());
    }

    public       String            simpleMethod(String v   , int n)      {
        String myString  = v       ;
        for( int i   = 1;    i         <= n  ; i++)  {
            myString        +=  ".";
        }

        return myString;
    }



}
