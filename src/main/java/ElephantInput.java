import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElephantInput {

    private static final String SPACE = " ";

    private int elephantQty;
    private int[] elephantWeight;
    private int[] currentPositions;
    private int[] expectedPositions;

    public void readInput(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
           elephantQty = Integer.parseInt(br.readLine());
           elephantWeight = splitBySpace(br.readLine());
           currentPositions = splitBySpaceAndSubtractOne(br.readLine());
           expectedPositions = splitBySpaceAndSubtractOne(br.readLine());
        } catch (IOException exception) {

        }
    }

    private int[] splitBySpace(String text) {
        return Arrays.stream(text.split(SPACE))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private int[] splitBySpaceAndSubtractOne(String text) {
        return Arrays.stream(text.split(SPACE))
                .mapToInt(Integer::valueOf)
                .map(i -> i - 1)
                .toArray();
    }

    public int getElephantQty() {
        return elephantQty;
    }

    public int[] getElephantWeight() {
        return elephantWeight;
    }

    public int[] getCurrentPositions() {
        return currentPositions;
    }

    public int[] getExpectedPositions() {
        return expectedPositions;
    }
}
