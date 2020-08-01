import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private Scanner scanner = new Scanner(System.in);
    private List<Record> recordList = new ArrayList<>();

    public PhoneBook() {

    }

    public void add() {
        System.out.println("Enter the name of the person:");
        String name = scanner.nextLine();

        System.out.println("Enter the surname of the person:");
        String surname = scanner.nextLine();

        System.out.println("Enter the number");
        String number = scanner.nextLine();
        recordList.add(new Record(name, surname, number));
    }
}