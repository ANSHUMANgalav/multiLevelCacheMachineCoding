import model.Cache;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int maxCacheDeapth ;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter max cache lavels : "); // Assuming a max level of cache and taking input.
        maxCacheDeapth = in.nextInt();
        int[] capacities = new int[maxCacheDeapth];

        for (int i = 0; i < maxCacheDeapth; i++) { // differnt lavel amy have diff capacity
            System.out.println("Enter capcity for lavel: " + i+1);
            capacities[i] = in.nextInt();
        }

        Cache cache = new Cache(capacities, maxCacheDeapth);

        cache.write("Anshuman", "Galav");
        cache.write("ABC", "XYZ");

        System.out.println("for key : Anshuman value is : " + cache.readFromCache("Anshuman") );
        System.out.println("for key : ABC value is : " + cache.readFromCache("ABC") );
    }
}