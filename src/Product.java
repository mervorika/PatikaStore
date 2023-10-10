class Product {
    private static int idCounter = 1;

    private int id;
    private String name;
    private String brand;
    private double price;
    private double discount;
    private int stock;

    public Product(String name, String brand, double price, double discount, int stock) {
        this.id = idCounter++;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Ürün Adı: %s, Marka: %s, Fiyat: %.2f TL, İndirim: %.2f, Stok: %d",
                id, name, brand, price, discount, stock);
    }
}
