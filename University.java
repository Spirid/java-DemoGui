
public class University {
     private PersonData[] personArray;
    public int quantity;

    University() {
        personArray = new PersonData[10];
        quantity = 0;
    }

    public void addPerson(String status, String name, int age) {
        if (quantity < 10) {
            personArray[quantity] = new PersonData(status, name, age);
            quantity++;
        }
    }

    public void addPerson(String status, String name, String degree) {
        if (quantity < 10) {
            personArray[quantity] = new PersonData(status, name, degree);
            quantity++;
        }
    }

    public void printAll() {
        for (int i = 0; i < quantity; i++)
        {
            personArray[i].print();
        }
    }

}
