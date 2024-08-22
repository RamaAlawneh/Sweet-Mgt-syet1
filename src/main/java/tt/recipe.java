package tt;

public class recipe {
    private String reid;
    private String rename;
    private String description;
    private String ownerOfRecipe;
    private String type;
    private String dietaryNeeds; // New field for dietary needs

    public recipe(String reid, String rename, String description, String ownerOfRecipe, String type, String dietaryNeeds) {
        this.reid = reid;
        this.rename = rename;
        this.description = description;
        this.ownerOfRecipe = ownerOfRecipe;
        this.type = type;
        this.dietaryNeeds = dietaryNeeds;
    }

    public String getrename() {
        return rename;
    }

    public String  getreid() {
        return reid;
    }

    public String getDescreption() {
        return description;
    }

    public  String getowner_of_recipe() {
        return  ownerOfRecipe;
    }



    public void setrename(String rename ) {
        this.rename= rename;
    }

    public void setreid(String reid) {
        this.reid = reid;
    }

    public void setDescreption(String Descreption) {
        this.description = Descreption;
    }

    public void setowner_of_recipe(String owner_of_recipe) {
        this.ownerOfRecipe= owner_of_recipe;

    }
    public String getDietaryNeeds() {
        return dietaryNeeds;
    }

    public void setDietaryNeeds(String dietaryNeeds) {
        this.dietaryNeeds = dietaryNeeds;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = dietaryNeeds;
    }

}
