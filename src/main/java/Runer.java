import utils.Encrypt;
import utils.Generator;

public class Runer {


    public static void main(String[] args) {

         Generator generator = new Generator();
         Encrypt encrypt = new Encrypt();

        String testStr = "Endava";
        System.out.println(testStr);

        String encryptTestStr = encrypt.encryptString(testStr);
        System.out.println(encryptTestStr);

        Integer firtsNum = 1;
        Integer secondNum = 30;
        Integer GenNum = generator.getRandomNumberUsingInts(firtsNum,secondNum);
        System.out.println(GenNum);

    }

}
