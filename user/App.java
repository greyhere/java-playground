import java.io.*;
import java.util.*;


class User {
    private String name;
    private int age;
    private String location;

    User(String name, int age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return (name + "(" + age + ") from " + location);
    }
}


public class App {
    static User[] users;

    public static User getYoungest(User[] users) {
        User tmp = users[0];
        for (int i=1; i<users.length; i++) {
            if (users[i].getAge() < tmp.getAge()) {
                tmp = users[i];
            }
        }
        return tmp;
    }

    // add oldest Teenager method

    // add no. of people from specific location method


    public static void main(String[] args) throws Exception {
        System.out.println("Enter filename: ");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        ArrayList<String> lines = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        User[] users = new User[lines.size()];
        for (int i=0; i<lines.size(); i++) {
            String[] data = lines.get(i).trim().split(", ");
            users[i] = new User(data[0], Integer.parseInt(data[1]), data[2]);
        }

        System.out.println("Youngest person: " + getYoungest(users));

        // ask user to input a filename to be created
        // create a txt file and write all results to the file
        // the output should be readable and understandale for everyone
    }
}
