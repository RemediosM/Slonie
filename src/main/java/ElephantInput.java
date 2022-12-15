public class ElephantInput {

    private int elephantQty;
    private int[] elephantWeight;
    private int[] currentPositions;
    private int[] expectedPositions;

    public void readInput(String[] args) {
        elephantQty = Integer.parseInt(args[0]);
        int[] tab = new int[elephantQty];
        int[] tab2 = new int[elephantQty];
        int[] tab3 = new int[elephantQty];
        for(int i = 0; i < elephantQty; i++){
            tab[i] = Integer.parseInt(args[i+1]);
            tab2[i] = Integer.parseInt(args[elephantQty + i + 1]) - 1;
            tab3[i] = Integer.parseInt(args[2 * elephantQty + i + 1]) - 1;
        }
        elephantWeight = tab;
        currentPositions = tab2;
        expectedPositions = tab3;
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
