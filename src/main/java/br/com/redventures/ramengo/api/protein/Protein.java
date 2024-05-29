package br.com.redventures.ramengo.api.protein;

public class Protein {
    /*************
     * FIELDS
     *********/
    private String id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private double price;

    /***************
     * BUILDERS
     ***********/
    public Protein(String id, String imageInactive, String imageActive, String name, String description, double price) {
        this.id = id;
        this.imageInactive = imageInactive;
        this.imageActive = imageActive;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /*************
     * METHODS
     **********/

    /*******************
     * GETS AND SETS
     ****************/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageInactive() {
        return imageInactive;
    }

    public void setImageInactive(String imageInactive) {
        this.imageInactive = imageInactive;
    }

    public String getImageActive() {
        return imageActive;
    }

    public void setImageActive(String imageActive) {
        this.imageActive = imageActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
