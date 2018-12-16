import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/**
 * Wearable class that manages wearable objects using Binary Trees
 *
 * @author      Oyunomin Munkhkhurel
 * @version     2/19/2018
 */
public class Wearables {
    private UniqueTree<Integer> ranks = new UniqueTree<Integer>();
    private NonUniqueTree<Double> prices = new NonUniqueTree<Double>();
    private NonUniqueTree<String> companyNames = new NonUniqueTree<String>();
    private Wearable[] wearsArray = null;
    
    /**
     * Constructor for objects of class Wearables
     */
    public Wearables() {
        //
    }

    /*
     * Reads from the text file, creates objects and assigns data
     * 
     * @param   File file simple file consisting datas
     */
    public Wearable[] readFromFile(File file) {
        try {
            Scanner scan = new Scanner(file);
            int countWears = scan.nextInt();
            String initialInfo = scan.nextLine();
            scan.nextLine(); // increments scanner by one
            wearsArray = new Wearable[countWears];
            int index = 0;
            while (scan.hasNextLine()) {
                String tempLine = scan.nextLine();
                String[] datas = tempLine.split("@");
                wearsArray[index] = new Wearable(Integer.valueOf(datas[0]), datas[1], Double.valueOf(datas[2]), datas[3], 
                                                   datas[4], datas[5], datas[6], datas[7], datas[8], datas[9], datas[10]);
                ranks.add((Integer)wearsArray[index].getRank(), index);
                prices.add((Double)wearsArray[index].getPrice(), index);
                companyNames.add((String)wearsArray[index].getCompanyName(), index);
                index++;
            }
            return wearsArray;
        } catch (FileNotFoundException e) {
            return wearsArray;
        }
    }
    
    /*
     * Get positions array by their sorted rankings
     * 
     * @return      array of positions(index in the array of wearables)
     */
    public int[] getPositionByRank() {
        return ranks.getPosition();
    }
    
    /*
     * Get positions array by their sorted rankings
     * 
     * @return      array of positions(index in the array of wearables)
     */
    public int[] getPositionByPrice() {
        return prices.getPosition();
    }
    
    /*
     * Get positions array by their sorted rankings
     * 
     * @return      array of positions(index in the array of wearables)
     */
    public int[] getPositionByCompanyName() {
        return companyNames.getPosition();
    }
    
    /*
     * Displays the wearable objects sorted by their rank
     * 
     * @param     Integer[] ranks array of positions sorted by their rank
     * @return    states of wearables
     */
    public String displayByRanking(int[] ranks) {
        String info = "";
        for (int index = 0; index < ranks.length; index++) {
            info += wearsArray[ranks[index]];
        }
        return info;
    }
    
    /*
     * Displays the wearable objects sorted by their rank
     * 
     * @param     Integer[] ranks array of positions sorted by their rank
     * @return    states of wearables
     */
    public String displayByPrice(int[] prices) {
        String info = "";
        for (int index = 0; index < prices.length; index++) {
            info += wearsArray[prices[index]];
        }
        return info;
    }
    
    /*
     * Displays the wearable objects sorted by their rank
     * 
     * @param     Integer[] ranks array of positions sorted by their rank
     * @return    states of wearables
     */
    public String displayByCompanyName(int[] companyNames) {
        String info = "";
        for (int index = 0; index < companyNames.length; index++) {
            info += wearsArray[companyNames[index]];
        }
        return info;
    }
}
