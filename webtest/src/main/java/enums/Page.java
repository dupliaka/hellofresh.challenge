package enums;

public enum Page {
    HOME;

    @Override
    public String toString() {
        switch (this) {
            case HOME:
                return "";
            default:
                throw new IllegalStateException("No such page implemented yet");
        }
    }


}
