public class Properties {

    private int objectId;
    private String name;

    public Properties(int objectId, String name) {
        this.objectId = objectId;
        this.name = name;
    }

    public int getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "objectId=" + objectId +
                ", name='" + name + '\'' +
                '}';
    }
}
