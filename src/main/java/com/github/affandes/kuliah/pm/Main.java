package com.github.affandes.kuliah.pm;

import java.util.LinkedList;
import java.util.Scanner;
public class Main {

    private LinkedList<String> history;

    public Main() {
        history = new LinkedList<>();
    }
    public void browse(String website) {
        history.addFirst(website);
        System.out.println("www.google.com: " + website);
    }

    public void back() {
        if (history.size() > 1) {
            history.removeFirst();
            System.out.println("Kembali ke: " + history.getFirst());
        } else if (history.size() == 1) {
            System.out.println("Hanya ada satu halaman dalam history, tidak bisa kembali.");
        } else {
            System.out.println("History kosong, tidak ada halaman untuk kembali.");
        }
    }
    public void view() {
        if (history.isEmpty()) {
            System.out.println("\nBelum ada history Browser.");
        } else {
            System.out.println("\nHistory Browser : " + history.size());
            for (String site : history) {
                System.out.println(site);
            }
        }
    }

    public static void main(String[] args) {
        Main browser = new Main();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Simulasi Browser History dimulai. Masukkan perintah:");

        while (true) {
            System.out.print("\nPerintah (browse/view/back/exit): ");
            command = scanner.nextLine();

            switch (command) {
                case "browse":
                    System.out.print("goggle: ");
                    String website = scanner.nextLine();
                    browser.browse(website);
                    break;
                case "view":
                    browser.view();
                    break;
                case "back":
                    browser.back();
                    break;
                case "exit":
                    System.out.println("Keluar dari browser history.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Perintah tidak valid. Gunakan browse/view/back/exit.");
            }
        }
    }
}