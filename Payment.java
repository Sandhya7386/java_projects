package com.gqt_java.java_gqt.project2;
import java.util.Scanner;

public class Payment {

    Scanner sc = new Scanner(System.in);

    public void makePayment(int totalAmount) {

        System.out.println("\nTotal Amount to Pay: " + totalAmount);
        System.out.println(Ecommerce.YELLOW + "Select Payment Method");
        System.out.println(Ecommerce.CYAN + "1. UPI" + Ecommerce.RESET);
        System.out.println(Ecommerce.BLUE + "2. Banking" + Ecommerce.RESET);
        System.out.println(Ecommerce.PURPLE + "3. Net Banking" + Ecommerce.RESET);

        System.out.print("Enter option: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                payThroughUPI();
                break;

            case 2:
                payThroughBanking();
                break;

            case 3:
                payThroughNetBanking();
                break;

            default:
                System.out.println(Ecommerce.RED + "Invalid payment option!" + Ecommerce.RESET);
        }
    }

    // ===== UPI PAYMENT =====
    private void payThroughUPI() {
        System.out.print("Enter UPI ID (example@upi): ");
        String upiId = sc.next();

        System.out.println(Ecommerce.GREEN + "Processing UPI payment..." + Ecommerce.RESET);
        System.out.println(Ecommerce.GREEN + "Payment successful via UPI!" + Ecommerce.RESET);
        System.out.println(Ecommerce.GREEN + "Product Purchased Successfully!" + Ecommerce.RESET);
    }

    // ===== BANKING PAYMENT =====
    private void payThroughBanking() {
        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();

        System.out.print("Enter IFSC Code: ");
        String ifsc = sc.next();

        System.out.println(Ecommerce.GREEN + "Processing Banking payment..." + Ecommerce.RESET);
        System.out.println(Ecommerce.GREEN + "Payment successful via Banking!" + Ecommerce.RESET);
        System.out.println(Ecommerce.GREEN + "Product Purchased Successfully!" + Ecommerce.RESET);
    }

    // ===== NET BANKING PAYMENT =====
    private void payThroughNetBanking() {
        System.out.print("Enter User ID: ");
        String userId = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        System.out.println(Ecommerce.GREEN + "Processing Net Banking payment..." + Ecommerce.RESET);
        System.out.println(Ecommerce.GREEN + "Payment successful via Net Banking!" + Ecommerce.RESET);
        System.out.println(Ecommerce.GREEN + "Product Purchased Successfully!" + Ecommerce.RESET);
    }
}


