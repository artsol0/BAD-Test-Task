public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            NumberStatistics numberStatistics = new NumberStatistics(args[0]);
            numberStatistics.startCollectData();

            System.out.println("Max number = " + numberStatistics.getMaxNumber());
            System.out.println("Min number = " + numberStatistics.getMinNumber());
            System.out.println("Median = " + numberStatistics.getMedian());
            System.out.println("Arithmetic mean = " + numberStatistics.getArithmeticMean());

            System.out.println("The largest sequence of increasing numbers: " +
                    numberStatistics.findLongestIncreasingSubsequence());

            System.out.println("The largest sequence of decreasing numbers: " +
                    numberStatistics.findLongestDecreasingSubsequence());
        } else {
            System.out.println("No file path was specified");
            System.exit(0);
        }
    }
}
