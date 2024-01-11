package ch09_class.fashion;

public class Fashion {
    private String name;
    private String capColor;
    private String topColor;
    private String bottomColor;
    private String shoesColor;

    public Fashion() {
    }

    public Fashion(String name, String capColor, String topColor, String bottomColor, String shoesColor) {
        this.name = name;
        this.capColor = capColor;
        this.topColor = topColor;
        this.bottomColor = bottomColor;
        this.shoesColor = shoesColor;
    }

    @Override
    public String toString() {
        return "Fashion{" +
                "name='" + name + '\'' +
                ", capColor='" + capColor + '\'' +
                ", topColor='" + topColor + '\'' +
                ", bottomColor='" + bottomColor + '\'' +
                ", shoesColor='" + shoesColor + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Fashion setName(String name) {
        this.name = name;
        return this;
    }

    public String getCapColor() {
        return capColor;
    }

    public Fashion setCapColor(String capColor) {
        this.capColor = capColor;
        return this;
    }

    public String getTopColor() {
        return topColor;
    }

    public Fashion setTopColor(String topColor) {
        this.topColor = topColor;
        return this;
    }

    public String getBottomColor() {
        return bottomColor;
    }

    public Fashion setBottomColor(String bottomColor) {
        this.bottomColor = bottomColor;
        return this;
    }

    public String getShoesColor() {
        return shoesColor;
    }

    public Fashion setShoesColor(String shoesColor) {
        this.shoesColor = shoesColor;
        return this;
    }
}
