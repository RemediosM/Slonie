import java.util.*;

public class ElephantSorter {

    private static final int INF = 6500;

    public long sortElephants(ElephantInput elephantInput) {
        int elephantQty = elephantInput.getElephantQty();
        int[] permutation = getPermutation(elephantQty, elephantInput.getCurrentPositions(), elephantInput.getExpectedPositions());
        Map<Integer, List<Integer>> cycles = getSimpleCycles(elephantQty, permutation);
        return getCycleParameters(cycles, elephantInput.getElephantWeight());
    }

    private int[] getPermutation(int size, int[] a, int[] b) {
        int[] permutation = new int[size];
        for (int i = 0; i < size; i++) {
            permutation[b[i]] = a[i];
        }
        return permutation;
    }

    private Map<Integer, List<Integer>> getSimpleCycles(int size, int[] permutation) {
        Map<Integer, List<Integer>> cycles = new HashMap<>();
        boolean[] correctPosition = new boolean[size];
        int c = -1;

        for (int i = 0; i < size; i++) {
            if (!correctPosition[i]) {
                List<Integer> cycle = new ArrayList<>();
                c++;
                int x = i;
                while (!correctPosition[x]) {
                    correctPosition[x] = true;
                    cycle.add(x);
                    x = permutation[x];
                }
                cycles.put(c, cycle);
            }
        }
        return cycles;
    }

    private long getCycleParameters(Map<Integer, List<Integer>> simpleCycles, int[] weights) {
        long result = 0;
        int min = Arrays.stream(weights).min().getAsInt();
        for (int i = 0; i < simpleCycles.size(); i++) {
            long cycleSum = 0;
            int cycleMin = INF;
            for (Integer cycle: simpleCycles.get(i)) {
                int currentElephantWeight = weights[cycle];
                cycleSum = cycleSum + currentElephantWeight;
                cycleMin = Math.min(cycleMin, currentElephantWeight);
            }

            long method1 = cycleSum + (long) (simpleCycles.get(i).size() - 2) * cycleMin;
            long method2 = cycleSum + cycleMin + (long) (simpleCycles.get(i).size() + 1) * min;
            result += Math.min(method1, method2);
        }

        return result;
    }
}
