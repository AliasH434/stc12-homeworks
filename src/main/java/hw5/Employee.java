package hw5;

public class Employee {

    private String name;
    private int age;
    private int salary;
    private String job;

    public Employee(String name, int age, int salary, String job) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.job = job;
    }

    public static boolean save(Employee employee) {
        boolean ifRecordSuccess = false;
        MyOutputStream myOutputStream = new MyOutputStream();
        myOutputStream.outputEmployee(employee);
        ifRecordSuccess = true;
        return ifRecordSuccess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

/*    public static boolean delete(Employee employee) {
        boolean ifRecordSuccess = false;
        ArrayList<Employee> employees;
        if (employees.contains(employee)) {
            employees.remove(employee);
            File tempFile = new File("notes2.txt");
            try (DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(tempFile))) {
                dataOutput.writeUTF(employee.getName());
                dataOutput.writeInt(employee.getAge());
                dataOutput.writeInt(employee.getSalary());
                dataOutput.writeUTF(employee.getJob());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            ifRecordSuccess = true;
        }
        return ifRecordSuccess;
    }

    public static boolean getByName (String name){
        boolean ifRecordSuccess = false;

        return ifRecordSuccess;
    }
*/
}
