public class ElephantOrderApplication {

    public static void main(String[] args) {
        ElephantInput elephantInput = new ElephantInput();
        ElephantSorter elephantSorter = new ElephantSorter();

        elephantInput.readInput(args);

        System.out.println(elephantSorter.sortElephants(elephantInput));
    }

}

