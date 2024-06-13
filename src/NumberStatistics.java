import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class NumberStatistics {

    private final Path pathToFile;

    private int maxNumber = Integer.MIN_VALUE;
    private int minNumber = Integer.MAX_VALUE;
    private int numberSum = 0;

    private final List<Integer> fileNumbers = new ArrayList<>();

    public NumberStatistics(String pathToFile) {
        this.pathToFile = Path.of(pathToFile);
        if (!Files.exists(this.pathToFile)) {
            System.out.println("The file was not found for the specified path");
            System.exit(0);
        }
    }

    public void startCollectData() {
        try (Scanner scanner = new Scanner(pathToFile)) {
            while (scanner.hasNext()) {
                int currentNumber = scanner.nextInt();
                if (currentNumber > maxNumber) {
                    maxNumber = currentNumber;
                }
                if (currentNumber < minNumber) {
                    minNumber = currentNumber;
                }
                numberSum += currentNumber;
                fileNumbers.add(currentNumber);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(0);
        }
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public double getMedian() {
        if (!fileNumbers.isEmpty()) {
            List<Integer> sortedNumbers = new ArrayList<>(fileNumbers);
            Collections.sort(sortedNumbers);
            int length = sortedNumbers .size();
            if (length % 2 == 1) {
                return sortedNumbers.get(length / 2);
            } else {
                return (sortedNumbers.get(length / 2 - 1) + sortedNumbers.get(length / 2)) / 2.0;
            }
        }
        return 0.0;
    }

    public double getArithmeticMean() {
        return (double) numberSum / fileNumbers.size();
    }

    public List<Integer> findLongestIncreasingSubsequence() {
        if (!fileNumbers.isEmpty()) {
            List<Integer> longestSubsequence = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < fileNumbers.size(); i++) {
                int current = fileNumbers.get(i);
                int next = Integer.MIN_VALUE;
                if (i + 1 < fileNumbers.size()) next = fileNumbers.get(i + 1);
                if (current > next) {
                    if (longestSubsequence.size() <= temp.size()) {
                        temp.add(current);
                        longestSubsequence = new ArrayList<>(temp);
                    }
                    temp.clear();
                } else {
                    temp.add(current);
                }
            }
            return longestSubsequence;
        }
        return new ArrayList<>();
    }

    public List<Integer> findLongestDecreasingSubsequence() {
        if (!fileNumbers.isEmpty()) {
            List<Integer> longestSubsequence = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < fileNumbers.size(); i++) {
                int current = fileNumbers.get(i);
                int next = Integer.MAX_VALUE;
                if (i + 1 < fileNumbers.size()) next = fileNumbers.get(i + 1);
                if (current < next) {
                    if (longestSubsequence.size() <= temp.size()) {
                        temp.add(current);
                        longestSubsequence = new ArrayList<>(temp);
                    }
                    temp.clear();
                } else {
                    temp.add(current);
                }
            }
            return longestSubsequence;
        }
        return new ArrayList<>();
    }

}
