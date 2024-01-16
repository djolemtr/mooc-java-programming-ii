import java.util.Scanner;

public class UserInterface {
    private TodoList list;
    private Scanner scan;

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scan = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = scan.nextLine();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("add")) {
                System.out.print("To add: ");
                String input = scan.nextLine();
                this.list.add(input);
            }
            if (command.equals("list")) {
                list.print();
            }
            if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int input = Integer.valueOf(scan.nextLine());
                list.remove(input);
            }

        }
    }
}