class Notebook extends Product {
    private int ram;
    private String storage;
    private String screenSize;

    public Notebook(String name, String brand, double price, double discount, int stock,
                    int ram, String storage, String screenSize) {
        super(name, brand, price, discount, stock);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", RAM: %d GB, Depolama: %s, Ekran Boyutu: %s",
                ram, storage, screenSize);
    }
}
