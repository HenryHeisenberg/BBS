/**
 * GennerateCodeTest
 */
public class GennerateCodeTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(gennerateCode());
        }
    }

    private static String gennerateCode(){
        int tmp =(int)((Math.random()*9+1)*100000);
        String code = String.valueOf(tmp);
        return code;
    }
}