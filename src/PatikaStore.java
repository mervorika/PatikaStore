import java.util.*;
import java.util.stream.Collectors;

public class PatikaStore {
    private List<Product> products;
    private List<Brand> brands;

    public PatikaStore() {
        products = new ArrayList<>();
        brands = new ArrayList<>();

        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));

        //2023 de çıkan ürünleri ekledim.

        products.add(new MobilePhone("Samsung Galaxy S23", "Samsung", 5999.99, 0.12, 100,
                "256 GB", "6.3 Inch", 4500, 8, "Phantom Black"));
        products.add(new MobilePhone("iPhone 14 Pro", "Apple", 7499.99, 0.15, 50,
                "256 GB", "6.1 Inch", 4100, 8, "Graphite"));
        products.add(new MobilePhone("Xiaomi Mi 12", "Xiaomi", 5499.99, 0.1, 80,
                "128 GB", "6.4 Inch", 4200, 12, "Blue"));
        products.add(new MobilePhone("Huawei P50 Pro", "Huawei", 6999.99, 0.12, 60,
                "256 GB", "6.2 Inch", 4100, 8, "Mystic Silver"));
        products.add(new MobilePhone("Asus ROG Phone 6", "Asus", 7999.99, 0.15, 70,
                "512 GB", "6.7 Inch", 6000, 16, "Black"));
        products.add(new MobilePhone("Casper VIA X20", "Casper", 4299.99, 0.08, 90,
                "128 GB", "6.1 Inch", 3800, 6, "White"));
        products.add(new MobilePhone("Lenovo Legion Duel 2", "Lenovo", 6799.99, 0.1, 50,
                "256 GB", "6.5 Inch", 4500, 12, "Red"));
        products.add(new Notebook("Lenovo ThinkPad X1 Carbon (2023)", "Lenovo", 7999.99, 0.1, 30,
                16, "1 TB SSD", "14 Inch"));
        products.add(new Notebook("HP Spectre x360 2023", "HP", 8999.99, 0.08, 25,
                32, "2 TB SSD", "15.6 Inch"));
        products.add(new Notebook("Apple MacBook Air 2023", "Apple", 8999.99, 0.1, 40,
                16, "512 GB SSD", "13.3 Inch"));
        products.add(new Notebook("Samsung Galaxy Book Pro 2023", "Samsung", 7999.99, 0.08, 30,
                16, "1 TB SSD", "15.6 Inch"));
        products.add(new Notebook("Lenovo Yoga 9i 2023", "Lenovo", 8499.99, 0.12, 35,
                32, "2 TB SSD", "14 Inch"));
        products.add(new Notebook("Asus ZenBook Pro 2023", "Asus", 7999.99, 0.1, 28,
                16, "512 GB SSD", "15.6 Inch"));
        products.add(new Notebook("HP Envy x360 2023", "HP", 7699.99, 0.15, 20,
                16, "1 TB SSD", "13.3 Inch"));
    }

    public void listProducts() {
        System.out.println("Ürünler:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " ürünü eklendi.");
    }
    public void listProductsInTable() {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-4s | %-20s | %-10s | %-6s | %-6s | %-5s%n",
                "ID", "Ürün Adı", "Marka", "Fiyat", "İndirim", "Stok");
        System.out.println("------------------------------------------------------------");

        for (Product product : products) {
            System.out.printf("%-4d | %-20s | %-10s | %-6.2f | %-6.2f | %-5d%n",
                    product.getId(), product.getName(), product.getBrand(),
                    product.getPrice(), product.getDiscount(), product.getStock());
        }

        System.out.println("------------------------------------------------------------");
    }

    public void removeProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                products.remove(product);
                System.out.println(product.getName() + " ürünü silindi.");
                return;
            }
        }
        System.out.println("Ürün bulunamadı.");
    }

    public void filterProductsByBrand(String brandName) {
        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getBrand().equals(brandName))
                .collect(Collectors.toList());

        System.out.println("Marka (" + brandName + ") Ürünleri:");
        for (Product product : filteredProducts) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        PatikaStore store = new PatikaStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPatikaStore Ana Menü");
            System.out.println("1. Ürünleri Listele");
            System.out.println("2. Ürün Ekle");
            System.out.println("3. Ürün Sil");
            System.out.println("4. Markalara Göre Ürünleri Listele");
            System.out.println("5. Çıkış");
            System.out.println("6. Ürünleri Tablo Görünümünde Listele");
            System.out.print("Seçiminizi yapın (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Dummy read

            switch (choice) {
                case 1:
                    store.listProducts();
                    break;
                case 2:
                    System.out.print("Ürün Adı: ");
                    String productName = scanner.nextLine();
                    System.out.print("Marka: ");
                    String productBrand = scanner.nextLine();
                    System.out.print("Fiyat: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("İndirim Oranı: ");
                    double productDiscount = scanner.nextDouble();
                    System.out.print("Stok Miktarı: ");
                    int productStock = scanner.nextInt();

                    System.out.print("Ürün Türü (MobilePhone/Notebook): ");
                    String productType = scanner.next();

                    if (productType.equals("MobilePhone")) {
                        System.out.print("Hafıza: ");
                        String memory = scanner.next();
                        System.out.print("Ekran Boyutu: ");
                        String screenSize = scanner.next();
                        System.out.print("Pil Gücü: ");
                        int batteryPower = scanner.nextInt();
                        System.out.print("RAM: ");
                        int ram = scanner.nextInt();
                        System.out.print("Renk: ");
                        String color = scanner.next();

                        MobilePhone newPhone = new MobilePhone(productName, productBrand, productPrice,
                                productDiscount, productStock, memory, screenSize, batteryPower, ram, color);
                        store.addProduct(newPhone);
                    } else if (productType.equals("Notebook")) {
                        System.out.print("RAM: ");
                        int ram = scanner.nextInt();
                        System.out.print("Depolama: ");
                        String storage = scanner.next();
                        System.out.print("Ekran Boyutu: ");
                        String productScreenSize = scanner.next();

                        Notebook newNotebook = new Notebook(productName, productBrand, productPrice,
                                productDiscount, productStock, ram, storage, productScreenSize);
                        store.addProduct(newNotebook);
                    } else {
                        System.out.println("Geçersiz ürün türü.");
                    }
                    break;
                case 3:
                    System.out.print("Silmek istediğiniz ürünün ID'sini girin: ");
                    int productId = scanner.nextInt();
                    store.removeProduct(productId);
                    break;
                case 4:
                    System.out.print("Filtrelemek istediğiniz markanın adını girin: ");
                    String brandName = scanner.next();
                    store.filterProductsByBrand(brandName);
                    break;
                case 5:
                    System.out.println("PatikaStore'dan çıkılıyor.");
                    scanner.close();
                    System.exit(0);
                    break;
                case 6:
                    store.listProductsInTable();
                    break;
                default:
                    System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
            }
        }
    }
}
