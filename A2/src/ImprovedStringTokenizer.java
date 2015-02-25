import java.util.StringTokenizer;

/**
 * Created by odrzy_000 on 2/23/2015.
 */
public class ImprovedStringTokenizer extends StringTokenizer{

    public ImprovedStringTokenizer(String str, String delim, boolean returnDelims) {
        super(str, delim, returnDelims);
    }

    public ImprovedStringTokenizer(String str, String delim) {
        super(str, delim);
    }

    public ImprovedStringTokenizer(String str) {
        super(str);
    }

    public String[] nextArray(){
        String answer[] = new String[this.countTokens()];
        int i = 0;
        while(hasMoreElements()){
            answer[i++] = this.nextToken();
        }
        return answer;
    }
}
