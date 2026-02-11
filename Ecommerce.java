package com.gqt_java.java_gqt.project2;
import java.util.Scanner;
public class Ecommerce {
    	static Scanner sc = new Scanner(System.in);
    static Cart cart = new Cart();
    static Payment payment = new Payment();
    // ===== ANSI COLORS =====
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";                                     
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CYAN = "\u001B[36m";

    //  Product color cycle (used for ALL categories)
    static final String[] PRODUCT_COLORS = {
            YELLOW, BLUE, PURPLE, CYAN, RED,
            GREEN, YELLOW, BLUE, PURPLE, CYAN
    };
   public static void main(String[] args) {
        while (true) {
            System.out.println(BLUE + "\n===== E-COMMERCE APPLICATION =====" + RESET);
            System.out.println(YELLOW + "1. Home Bakers" + RESET);
            System.out.println(BLUE + "2. Electronics" + RESET);
            System.out.println(PURPLE + "3. Fashion" + RESET);
            System.out.println(CYAN + "4. Households" + RESET);
            System.out.println(RED + "5. Cosmetics" + RESET);
            System.out.println(GREEN + "6. Checkout" + RESET);
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: showProducts(homeBakers(), "HOME BAKERS"); break;
                case 2: showProducts(electronics(), "ELECTRONICS"); break;
                case 3: showProducts(fashion(), "FASHION"); break;
                case 4: showProducts(households(), "HOUSEHOLDS"); break;
                case 5: showProducts(cosmetics(), "COSMETICS"); break;
                case 6: checkout(); break;
                case 7:
                    System.out.println(GREEN + "Thank you for shopping!" + RESET);
                    System.exit(0);
                default:
                    System.out.println(RED + "Invalid choice!" + RESET);
            }
        }
    }

    // ===== DISPLAY PRODUCTS (ALL COLORED) =====
    static void showProducts(Product[] products, String title) {

        System.out.println("\n===== " + title + " =====");

        for (int i = 0; i < products.length; i++) {
            String color = PRODUCT_COLORS[i % PRODUCT_COLORS.length];
            System.out.print(color);
            products[i].display(i + 1);
            System.out.print(RESET);
        }

        System.out.print("\nSelect product number: ");
        int index = sc.nextInt() - 1;

        System.out.println();
        System.out.println(GREEN + "1. Add to Cart" + RESET);
        System.out.println(BLUE + "2. Buy Now" + RESET);
        System.out.println(RED + "3. Back" + RESET);

        System.out.print("Enter option: ");
        int option = sc.nextInt();

        if (option == 1) {
            cart.addProduct(products[index]);
            System.out.println(GREEN + "Product added to cart!" + RESET);
            return;   // ✅ STOP HERE (prevents duplicate message)
        } else if (option == 2) {
            System.out.println(GREEN + "Purchased: " + products[index].name + RESET);
            return;
        }

    }

    // ===== CHECKOUT =====
    static void checkout() {
        if (cart.isEmpty()) {
            System.out.println(RED + "Cart is empty!" + RESET);
            return;
        }
        System.out.println(GREEN + "\n===== CHECKOUT =====" + RESET);
        int total = cart.showBill();
        payment.makePayment(total);
        cart.clearCart();
    }

    // ===== CATEGORIES =====
    static Product[] homeBakers() {
        return new Product[]{
                new Product("Chocolate Cake","Home Bakers","1kg",800),
                new Product("Red Velvet Cake","Home Bakers","1kg",900),
                new Product("Cup Cakes","Home Bakers","Box of 6",400),
                new Product("Brownies","Home Bakers","Box",500),
                new Product("Cookies","Home Bakers","500g",300),
                new Product("Plum Cake","Home Bakers","1kg",700),
                new Product("Cheese Cake","Home Bakers","1kg",1000),
                new Product("Donuts","Home Bakers","Pack",350),
                new Product("Banana Bread","Home Bakers","500g",450),
                new Product("Pastries","Home Bakers","Pack",600)
        };
    }

    static Product[] electronics() {
        return new Product[]{
                new Product("Samsung S23 Ultra","Samsung","12GB RAM",124999),
                new Product("iPhone 14","Apple","128GB",79999),
                new Product("OnePlus 11","OnePlus","8GB RAM",61999),
                new Product("Vivo X90","Vivo","12GB RAM",58999),
                new Product("Redmi Note 12","Redmi","6GB RAM",17999),
                new Product("Realme GT","Realme","8GB RAM",25999),
                new Product("Pixel 7","Google","8GB RAM",59999),
                new Product("Motorola Edge","Motorola","8GB RAM",29999),
                new Product("IQOO Neo","IQOO","8GB RAM",36999),
                new Product("Oppo Reno","Oppo","8GB RAM",34999)
        };
    }

    static Product[] fashion() {
        return new Product[]{
                new Product("Men T-Shirt","Puma","Cotton",999),
                new Product("Women Kurti","Biba","Silk",1999),
                new Product("Jeans","Levis","Slim Fit",2499),
                new Product("Saree","Kalyan","Silk",5999),
                new Product("Jacket","Roadster","Winter Wear",2999),
                new Product("Dress","Zara","Party Wear",3499),
                new Product("Shirt","Allen Solly","Formal",2199),
                new Product("Track Pants","Nike","Sports",1899),
                new Product("Sweater","H&M","Wool",1999),
                new Product("Skirt","Forever21","Casual",1599)
        };
    }

    static Product[] households() {
        return new Product[]{
                new Product("Mixer Grinder","Philips","750W",4999),
                new Product("Iron Box","Bajaj","Steam",2999),
                new Product("Vacuum Cleaner","LG","1200W",8999),
                new Product("Gas Stove","Prestige","3 Burner",5999),
                new Product("Pressure Cooker","Hawkins","5L",3499),
                new Product("Water Purifier","Kent","RO+UV",12999),
                new Product("Electric Kettle","Prestige","1.5L",1999),
                new Product("Toaster","Morphy","2 Slice",2499),
                new Product("Ceiling Fan","Usha","1200mm",3999),
                new Product("Table Lamp","Philips","LED",1499)
        };
    }
    static Product[] cosmetics() {
        return new Product[]{
                new Product("Face Cream","Lakme","50g",399),
                new Product("Lipstick","Maybelline","Matte",599),
                new Product("Foundation","MAC","Liquid",2499),
                new Product("Perfume","Fogg","100ml",699),
                new Product("Eyeliner","Lakme","Black",299),
                new Product("Compact Powder","Swiss Beauty","30g",349),
                new Product("Nail Polish","Colorbar","Red",199),
                new Product("Face Wash","Nivea","Men",299),
                new Product("Serum","Minimalist","Vitamin C",699),
                new Product("Sunscreen","Neutrogena","SPF 50",599)
        };
    }
}

