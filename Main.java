import java.io.File;
import java.util.Arrays;
/**
 * Write a description of class Main here.
 *
 * @author  Oyunomin Munkhkhurel
 * @version 2018/02/19
 */
public class Main {
    public static void main(String[] args) {
        System.out.print('\u000C');
        Wearables test = new Wearables();
        System.out.print("When file not found nothing crashes");
        test.readFromFile(new File("wables.txt"));
        test.readFromFile(new File("wearables.txt"));
        System.out.println("/*************************************");
        System.out.print("Sorted by ranking");
        System.out.print("/*************************************");
        System.out.print(test.displayByRanking(test.getPositionByRank()));
        System.out.println("/*************************************");
        System.out.print("Sorted by price");
        System.out.print("/*************************************");
        System.out.print(test.displayByPrice(test.getPositionByPrice()));
        System.out.println("/*************************************");
        System.out.print("Sorted by company name");
        System.out.print("/*************************************");
        System.out.print(test.displayByCompanyName(test.getPositionByCompanyName()));
    }
}
