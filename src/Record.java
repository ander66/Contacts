public class Record {
    private String name;
    private String surname;
    private String number;

    Record(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumber (String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    public boolean hasNumber () {
        return !number.equals("[no number]");
    }
}
