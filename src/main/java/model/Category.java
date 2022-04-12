package model;

public class Category {
    private int id;
    private String category;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.category = name;
    }

    public Category(String name) {
        this.category = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
