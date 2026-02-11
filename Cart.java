package com.gqt_java.java_gqt.project2;
class Cart {

    Product cartProducts[] = new Product[50];
    int count = 0;

    void addProduct(Product p) {
        cartProducts[count] = p;
        count++;
    }

    int showBill() {
        int total = 0;
        System.out.println("\n===== BILL RECEIPT =====");
        for (int i = 0; i < count; i++) {
            System.out.println(cartProducts[i].name + " - ₹" + cartProducts[i].price);
            total += cartProducts[i].price;
        }
        System.out.println("Total Amount: ₹" + total);
        return total;
    }

    boolean isEmpty() {
        return count == 0;
    }

    void clearCart() {
        count = 0;
    }
}

