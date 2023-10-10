class MobilePhone extends Product {
    private String memory;
    private String screenSize;
    private int batteryPower;
    private int ram;
    private String color;

    public MobilePhone(String name, String brand, double price, double discount, int stock,
                       String memory, String screenSize, int batteryPower, int ram, String color) {
        super(name, brand, price, discount, stock);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Hafıza: %s, Ekran Boyutu: %s, Pil Gücü: %d mAh, RAM: %d GB, Renk: %s",
                memory, screenSize, batteryPower, ram, color);
    }
}
