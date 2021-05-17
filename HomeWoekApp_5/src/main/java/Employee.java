public class Employee {

    String name;
    String position;
    String email;
    Integer tel;
    Integer salary;
    Integer age;

    Employee(String _name, String _position, String _email, Integer _tel,
                    Integer _salary, Integer _age) {
        name = _name;
        position = _position;
        email = _email;
        tel = _tel;
        salary = _salary;
        age = _age;
    }

    void printDataEmployee() {

        System.out.println("Имя сотрудника: " + name + "\n" +
                "Должность: " + position + "\n"+
                "Email: " + email + "\n"+
                "Тел.: " + tel + "\n");
    }



}
