
/**
 * Wearable class that retrieves all the information about Wearable object
 *
 * @author      Oyunomin Munkhkhurel
 * @version     2/19/2018
 */
public class Wearable {
    private int rank;
    private String name;
    private double price;
    private String bodyLoc;
    private String category;
    private String companyName;
    private String companyURL;
    private String companyMappingLocation;
    private String companyCity;
    private String companyUSState;
    private String companyCountry;

    /**
     * Full constructor for objects of class Wearable
     * 
     * @param 
     */
    public Wearable(int rank, String name, double price, String bodyLoc, String category, String companyName, 
                    String companyURL, String companyMappingLocation, String companyCity, String companyUSState, String companyCountry) {
        this.rank = rank;
        this.name = name;
        this.price = price;
        this.bodyLoc = bodyLoc;
        this.category = category;
        this.companyName = companyName;
        this.companyURL = companyURL;
        this.companyMappingLocation = companyMappingLocation;
        this.companyCity = companyCity;
        this.companyUSState = companyUSState;
        this.companyCountry = companyCountry;
    }

    /*
     * Retrieves the rank 
     * 
     * @return  rank 
     */
    public int getRank() {
        return rank;
    }
    
    /*
     * Retrieves the name  
     * 
     * @return  name 
     */
    public String getName() {
        return name;
    }
    
    /*
     * Retrieves the price 
     * 
     * @return  price 
     */
    public double getPrice() {
        return price;
    }
    
    /*
     * Retrieves the body location 
     * 
     * @return  body location 
     */
    public String getBodyLoc() {
        return bodyLoc;
    }
    
    /*
     * Retrieves the category 
     * 
     * @return  category 
     */
    public String getCategory() {
        return category;
    }
    
    /*
     * Retrieves the company name
     * 
     * @return  company name
     */
    public String getCompanyName() {
        return companyName;
    }
    
    /*
     * Retrieves the company URL 
     * 
     * @return  company URL
     */
    public String getcompanyURL() {
        return companyURL;
    }
    
    /*
     * Retrieves the company mapping location 
     * 
     * @return  company mapping location
     */
    public String getcompanyMappingLocation() {
        return companyMappingLocation;
    }
    
    /*
     * Retrieves the company city 
     * 
     * @return  company city
     */
    public String getCompanyCity() {
        return companyCity;
    }
    
    /*
     * Retrieves the company US state 
     * 
     * @return  company US state
     */
    public String getcompanyUSState() {
        return companyUSState;
    }
    
    /*
     * Retrieves the company country
     * 
     * @return  company country
     */
    public String getCompanyCountry() {
        return companyCountry;
    }
    
    /*
     * Verbal state of an wearable class
     */
    public String toString() {
        String info = "";
        info += "Rank:                           " + rank                    + "\n";
        info += "Name:                           " + name                    + "\n";
        info += "Price:                          " + price                   + "\n";
        info += "Body Location                   " + bodyLoc                 + "\n";
        info += "Category:                       " + category                + "\n";
        info += "Company Name:                   " + companyName             + "\n";
        info += "Company URL:                    " + companyURL              + "\n";
        info += "Company Mapping Location:       " + companyMappingLocation  + "\n";
        info += "Company City:                   " + companyCity             + "\n";
        info += "Company US state:               " + companyUSState          + "\n";
        info += "Company Country:                " + companyCountry          + "\n";
        info += "\n";
        return info;
    }
}
