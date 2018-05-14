package steps;

/**
 * Transform a raw javajet source code in a single one line unformatted.
 */
public class Normalizer implements IFormatStep {

    private String JMP_LINE_CARS = "\n\r\f";
    private String BLANK_CARS = " \t";

    // The raw source code to normalize.
    private String jjsrc;

    public Normalizer(String jjsrc) {
        this.jjsrc = jjsrc;
    }

    @Override
    public String format() {
        jjsrc = jjsrc.replaceAll("\\r\\n", "\n");
        jjsrc = jjsrc.replaceAll("[ \t]+\n", "\n");

        int nChar = jjsrc.length();

        char prev = ' ';
        char cur;
        boolean inString = false;
        boolean inDoc = false;
        boolean inMultiDoc = false;
        boolean isBlank = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nChar; i++) {
            cur = jjsrc.charAt(i);

            if (cur == '/' && prev == '/' && !inString) {
                inDoc = true;
            }
            if (cur == '*' && prev == '/' && !inString) {
                inMultiDoc = true;
            }

            if (cur == '"' && prev != '\\' && !inDoc && !inMultiDoc) {
                inString = !inString;
            }

            if (cur == '\n' && (inString || inDoc || inMultiDoc)) {
                // Keep \n in comments and Strings
                sb.append('\n');
            } else {
                if(JMP_LINE_CARS.indexOf(cur) >= 0 && !inDoc && !inMultiDoc){
                    if(prev != ';' && prev != '>' && !inDoc){
                        sb.append('X');
                        isBlank = true && !inString;
                    }
                }
                else if (BLANK_CARS.indexOf(cur) >= 0) {
                    if (!isBlank) { // Let remove extra spaces and transform \t by space
                        sb.append(' ');
                        isBlank = true && !inString;
                    }
                }
                else if (cur == ' ' && prev == '\n' && !inDoc && !inMultiDoc && !inString){
                    // remove space if first char of the line
                    isBlank = true && !inString;
                }
                else {
                    sb.append(cur);
                    isBlank = false;
                }
            }
            if (inDoc && cur == '\n') {
                inDoc = false;
            }
            if (inMultiDoc && cur == '/' && prev == '*') {
                inMultiDoc = false;
                sb.append('\n');
            }

            prev = cur;
        }

        String str = sb.toString();
        str = str.replaceAll(" *; *", ";");
        str = str.replaceAll(" *, *", ",");
        str = str.replaceAll(" *\\{ *", "{");
        str = str.replaceAll(" *\\} *", "}");
        str = str.replaceAll(" *\\( *", "(");
        str = str.replaceAll(" *\\) *", ")");
        //str = str.replaceAll("\n ", "\n");
        return str;
    }
}
