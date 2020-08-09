import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private Scanner scanner = new Scanner(System.in);
    private List<Record> recordList = new ArrayList<>();

    public PhoneBook() {

    }

    private void add() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();

        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();

        System.out.println("Enter the number:");
        String number = scanner.nextLine();
        number = checkNumber(number);

        recordList.add(new Record(name, surname, number));
        System.out.println("A record added.");
    }
    private String checkNumber(String number) {
        if (checkNumnerFormat(number)) {
            return number;
        }
        System.out.println("Wrong number format!");
        return "[no number]";
    }
    private boolean checkNumnerFormat(String number) {
        String numberRegex = "\\+?(\\([0-9a-zA-Z]+\\)([-\\s][0-9a-zA-Z]{2,})*|" +
                "([0-9a-zA-Z]+)([-\\s]\\([0-9a-zA-Z]{2,}\\))?([-\\s][0-9a-zA-Z]{2,})*)";

        return number.matches(numberRegex);
    }

    private void edit() {
        if (recordList.size() == 0) System.out.println("No records to edit!");
        else {
            list();
            int num = readIndex();
            if (checkBoundaries(num)) {
                System.out.println("Select a field (name, surname, number):");
                String field = scanner.nextLine();
                switch (field) {
                    case "name":
                        System.out.println("Enter name: ");
                        recordList.get(num).setName(scanner.nextLine());
                        break;
                    case "surname":
                        System.out.println("Enter surname: ");
                        recordList.get(num).setSurname(scanner.nextLine());
                        break;
                    case "number":
                        System.out.println("Enter number: ");
                        String number = scanner.nextLine();
                        number = checkNumber(number);
                        recordList.get(num).setNumber(number);
                        break;
                    default: System.out.println("Incorrent input: " + field);
                }

                System.out.println("The record updated!");
            }
        }
    }
    private void remove() {
        if (recordList.size() == 0) System.out.println("No records to remove!");
        else {
            list();
            int num = readIndex();
            if (checkBoundaries(num)) {
                recordList.remove(num);
                System.out.println("The record removed!");
            }
        }
    }
    private int readIndex() {
        System.out.println("Select a record:");
        return Integer.parseInt(scanner.nextLine()) - 1;
    }
    private boolean checkBoundaries(int num) {
        if (num < 0 && num >= recordList.size()) {
            System.out.println("Incorrect input: " + (num + 1));
            return false;
        }
        return true;
    }

    private void list() {
        for (int i = 0; i < recordList.size(); i++) {
            Record iRecord = recordList.get(i);
            System.out.println((i+1) + ". " + iRecord.getName() + " " + iRecord.getSurname() + ", " + iRecord.getNumber());
        }
    }

    public void menu() {
        String userAction = null;
        do {
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            userAction = scanner.nextLine();
            switch (userAction) {
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "edit":
                    edit();
                    break;
                case "count":
                    count();
                    break;
                case "list":
                    list();
                    break;
                case "exit":
                    break;
            }
        } while (!userAction.equals("exit"));
    }

    private void count() {
        System.out.println("The Phone Book has " + recordList.size() + " records.");
    }
}
