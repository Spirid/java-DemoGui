
public class PersonData {
    String status;
    String name;
    int age;
    String degree;

    PersonData(String s, String n, int a) {
        status = s;
        name = n;
        age = a;
        degree = "";
    }

    PersonData(String s, String n, String d) {
        status = s;
        name = n;
        age = 0;
        degree = d;
    }

    public void print() {
        if (status.equals("STUDENT")) {
            System.out.println(status+": "+name+", "+age+" years");
        } else if (status.equals("FECULTY")) {
            System.out.println(status+": "+name+", "+degree+" degree");
        }
    }
}
