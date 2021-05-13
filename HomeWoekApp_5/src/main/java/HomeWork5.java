public class HomeWork5 {

    public static void main(String[] args) {

        Employee[] arrayEmpl = new Employee[5];

        arrayEmpl[0] = new Employee("Max", "chief", "qwery@tr.ru@",
                123456780, 150000, 53);

        arrayEmpl[1] = new Employee("Anna", "office-manager", "qwery@tr.ru@",
                123456781, 50000, 23);

        arrayEmpl[2] = new Employee("Petr", "IT-specialist", "qwery@tr.ru@",
                123456782, 120000, 23);

        arrayEmpl[3] = new Employee("Oleg", "IT-specialist", "qwery@tr.ru@",
                123456783, 135000, 41);

        arrayEmpl[4] = new Employee("Maria", "IT-specialist", "qwery@tr.ru@",
                123456784, 110000, 22);

        for (int i = 0; i < 5; i++) {
            if (arrayEmpl[i].age > 40 )
            arrayEmpl[i].printDataEmployee();
        }

    }
}
