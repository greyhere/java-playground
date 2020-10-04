import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Weather {
    private String location = "";
    private int[] temperatures;


    // Constructor
    public Weather(String line) {
        String[] data = line.trim().split("\\s+");
        int pos = 0;

        while (true) {
            if (!data[pos].matches("^[0-9]*$")) {
                // extract location name
                this.location += String.format(" %s", data[pos]);
                pos++;
            } else {
                // extract temperatures
                int r = data.length-pos;  // remaining items
                int[] buffer = new int[r];
                
                for (int i=0; i<r; i++) {
                    buffer[i] = Integer.parseInt(data[pos]);
                    pos++;
                }
                this.temperatures = buffer;
                break;
            }
        }
    }


    // Calculates average temperature
    public double average() {
        double sum = 0;
        for (int temp: this.temperatures) {
            sum += temp;
        }
        return sum / this.temperatures.length;
    }


    // finds warmest temperature
    public int warmest() {
        int warm = this.temperatures[0];
        for (int temp: this.temperatures) {
            if (warm < temp) {
                warm = temp;
            }
        }
        return warm;
    }


    // finds coldest temperature
    public int coldest() {
        int cold = this.temperatures[0];
        for (int temp: this.temperatures) {
            if (cold > temp) {
                cold = temp;
            }
        }
        return cold;
    }


    // finds average of all excluding max & min temperatures
    public double xaverage() {
        double sum = 0;
        int max = this.temperatures[0];
        int min = this.temperatures[0];
        for (int temp: this.temperatures) {
            sum += temp;
            if (max < temp) {
                max = temp;
            } else if (min > temp) {
                min = temp;
            }
        }
        return (sum-max-min) / (this.temperatures.length-2);
    }

    
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter filename: ");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        Scanner fptr = new Scanner(new File(filename));

        while (fptr.hasNextLine()) {
            String line = fptr.nextLine();
            Weather wd = new Weather(line);
            System.out.println(
                "\nThis is the data of " + wd.location + ":" +
                "\nAverage temperature: " + wd.average() +
                "\nWarmest temperature: " + wd.warmest() +
                "\nColdest temperature: " + wd.coldest() +
                "\nAverage temperature [excluding the two extremes]: " + wd.xaverage()
            );
            System.out.println("\nDo you want weather information of other places [y/n]?");
            String decision;
            while (true) {
                String inp = input.nextLine();
                if (inp.equals("y") || inp.equals("n")) {
                    decision = inp;
                    break;
                } else {
                    System.out.println("Invalid choice! Please re-enter [y/n]:");
                }
            }
            if (decision.equals("n")) {
                fptr.close();
                break;
            }
        }
        fptr.close();
    }
}
