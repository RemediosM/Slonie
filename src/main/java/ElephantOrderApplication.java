import java.util.Scanner;

public class ElephantOrderApplication {

    public static void main(String[] args) {
        String filePath;
        ElephantInput elephantInput = new ElephantInput();
        ElephantSorter elephantSorter = new ElephantSorter();

        Scanner scanner = new Scanner(System.in);
        filePath = scanner.next();

        elephantInput.readInput(filePath);

        System.out.println(elephantSorter.sortElephants(elephantInput));
    }
}

