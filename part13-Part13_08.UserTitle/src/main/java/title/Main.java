package title;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter title: ");

        Scanner scanner = new Scanner(System.in);

        String title = scanner.next();

        Application.launch(UserTitle.class,
                "--title=" + title);

    }

}
