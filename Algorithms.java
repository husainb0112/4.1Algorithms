import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Algorithms {
    private static File f;
    private static Scanner s;

    public static void main(String[] args) throws FileNotFoundException {
        f = new File("Numbers.txt");

        int odds = odds();
        int evens = evens();
        int twoDigitCount = countTwoDigitNumbers();
        int greaterThan500Count = countGreaterThan500();
        int maxNumber = findMaxNumber();
        int minNumber = findMinNumber();
        int sum = calculateSum();
        double mean = calculateMean();
        int mode = findMode();

        System.out.println("Odds: " + odds);
        System.out.println("Evens: " + evens);
        System.out.println("Two-digit numbers: " + twoDigitCount);
        System.out.println("Numbers greater than 500: " + greaterThan500Count);
        System.out.println("Greatest number: " + maxNumber);
        System.out.println("Least number: " + minNumber);
        System.out.println("Sum of numbers: " + sum);
        System.out.printf("Arithmetic mean (rounded): %.3f%n", mean);
        System.out.println("Mode: " + mode);

        s.close();
    }

    public static int odds() throws FileNotFoundException {
        s = new Scanner(f);
        int odds = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 != 0)
                odds++;
        }
        return odds;
    }

    public static int evens() throws FileNotFoundException {
        s = new Scanner(f);
        int evens = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 == 0)
                evens++;
        }
        return evens;
    }

    public static int countTwoDigitNumbers() throws FileNotFoundException {
        s = new Scanner(f);
        int count = 0;
        while (s.hasNext()) {
            int num = s.nextInt();
            if (num >= 10 && num <= 99) {
                count++;
            }
        }
        return count;
    }

    public static int countGreaterThan500() throws FileNotFoundException {
        s = new Scanner(f);
        int count = 0;
        while (s.hasNext()) {
            if (s.nextInt() > 500) {
                count++;
            }
        }
        return count;
    }

    public static int findMaxNumber() throws FileNotFoundException {
        s = new Scanner(f);
        int max = Integer.MIN_VALUE;
        while (s.hasNext()) {
            int num = s.nextInt();
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int findMinNumber() throws FileNotFoundException {
        s = new Scanner(f);
        int min = Integer.MAX_VALUE;
        while (s.hasNext()) {
            int num = s.nextInt();
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int calculateSum() throws FileNotFoundException {
        s = new Scanner(f);
        int sum = 0;
        while (s.hasNext()) {
            sum += s.nextInt();
        }
        return sum;
    }

    public static double calculateMean() throws FileNotFoundException {
        s = new Scanner(f);
        int sum = 0;
        int count = 0;
        while (s.hasNext()) {
            sum += s.nextInt();
            count++;
        }
        if (count > 0) {
            return (double) sum / count;
        } else {
            return 0;
        }
        
    }

    public static int findMode() throws FileNotFoundException {
        s = new Scanner(f);
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        while (s.hasNext()) {
            int num = s.nextInt();
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int mode = 0;
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }
}
