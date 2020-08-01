public class Record {
    private String name;
    private String surname;
    private String number;

    Record(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        System.out.println("A record created!");
    }
}