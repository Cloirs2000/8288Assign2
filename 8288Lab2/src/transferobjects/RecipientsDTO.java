/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
CST8288 Lab2.  Demonstration of DAO Design Pattern.
*/
package transferobjects;

/**
 * Represents a recipient of an award, 
 * Includes information about the award and the recipient.
 * @author Cloris
 * @since 1.0
 * @version 1.0
 * @see RecipientsDTO
 */
public class RecipientsDTO {
    private Integer awardID;
    private String year;
    private String name;
    private String city;
    private String category;

    
    /**
     * Returns the awardID.
     * @return  awardID
     */
    public Integer getAwardID() {
        return awardID;
    }

    /**
     * Returns the year of a recipient recode.
     * @return  year
     */
    public String getYear() {
        return year;
    }
    /**
     * Returns the Name of a recipient recode.
     * @return  name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the city of a recipient recode.
     * @return  city
     */
    public String getCity() {
        return city;
    }
    /**
     * Returns the Category of a recipient recode.
     * @return  category
     */
    public String getCategory() {
        return category;
    }
    /**
     * set AwardID
     * @param awardID 
     */
    public void setAwardID(Integer awardID) {
        this.awardID = awardID;
    }

    /**
     * set Year
     * @param year 
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * set Name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set City
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * set Category
     * @param category 
     */
    public void setCategory(String category) {
        this.category = category;
    }
    

    
}
