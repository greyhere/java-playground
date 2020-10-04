class Product {
    private int number;
    private String name;
    private int units;
    private double price;

    // default constructor
    Product() {
    }

    // alternative constructor
    Product(int number, String name, int units, double price) {
        this.number = number;
        this.name = name;
        this.units = units;
        this.price = price;
    }

    // getters
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getUnits() {
        return units;
    }

    public double getPrice() {
        return price;
    }

    // setters
    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // calculate value of product
    public double value() {
        return units * price;
    }

    // overriding default toSting() method
    @Override
    public String toString() {
        return (
            "Product Description:" +
            "\n Number: " + this.getNumber() +
            "\n Name: " + this.getName() +
            "\n Total no of units: " + this.getUnits() +
            "\n Price per unit: " + this.getPrice()
        );
    }
}


// tests
public class ProductTester {
    public static void main(String[] args) {
        // create an array of Product objects
        Product[] products = new Product[6];

        // initialize first three Product objects using default constructor
        // and populate objects with setters

        // data set for setters
        String[] pNames = {"Java Book", "Cross Pen", "Chair"};
        int[] pUnits = {9, 14, 2};
        double[] pPrices = {85, 5, 80};

        for (int i=0; i<3; i++) {
            products[i] = new Product();
            products[i].setNumber(i+1);
            products[i].setName(pNames[i]);
            products[i].setUnits(pUnits[i]);
            products[i].setPrice(pPrices[i]);
        }

        // initialize rest of the Product objects with alternative constructor
        products[3] = new Product(4, "Coca-Cola", 18, 20);
        products[4] = new Product(5, "Oats", 16, 30);
        products[5] = new Product(6, "Table", 2, 95);

        // testing getters
        for (int i=0; i<6; i++) {
            System.out.print(
                "\n---Test for Product Number: " + products[i].getNumber() + "---\n" +
                products[i] + "\n\n" +
                "- Testing getters:" + "\n  " +
                products[i].getName() + "\n  " +
                products[i].getUnits() + "\n  " +
                products[i].getPrice() + "\n" +
                "Product Value = " + products[i].value() + "\n"
            );
        }
    }
}
