import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeCRUD dao = new EmployeeCRUD();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add\n2. View\n3. Update\n4. Delete\n5. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter salary: ");
                    double sal = sc.nextDouble();
                    dao.addEmployee(new Employee(0, name, sal));
                    break;

                case 2:
                    List<Employee> list = dao.getAllEmployees();
                    for (Employee e : list)
                        System.out.println(e);
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    System.out.print("New name: ");
                    String uname = sc.next();
                    System.out.print("New salary: ");
                    double usal = sc.nextDouble();
                    dao.updateEmployee(new Employee(uid, uname, usal));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteEmployee(did);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }
}
