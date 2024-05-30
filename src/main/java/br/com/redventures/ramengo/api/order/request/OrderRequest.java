package br.com.redventures.ramengo.api.order.request;

public class OrderRequest {
    String id;
    String description;
    String image;

    public OrderRequest() {
    }

    public String buildDescription (String nameBroth, String nameProtein) {

        return String.format("%s and %s Ramen", nameBroth, nameProtein);

    }

    public String buildImage(String externalUrl, String nameProtein){
        String ramen = "ramen";
        String imageType = ".png";

        return String.format("%s %s %s %s", externalUrl, ramen, nameProtein, imageType).replace(" ", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
