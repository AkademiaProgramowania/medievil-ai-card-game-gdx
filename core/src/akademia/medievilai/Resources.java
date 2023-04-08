package akademia.medievilai;

public enum Resources {
    WOOD("Wood"),
    STONE("Stone"),
    CLAY("Clay");

    final private String name;

    Resources(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
