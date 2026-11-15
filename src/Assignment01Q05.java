public class Assignment01Q05 {

    private static class Queue {
        private final int[] q;
        private int head;
        private int tail;
        private int capacity;

        public Queue(int maxCapacity) {
            this.q = new int[maxCapacity];
            this.tail = -1;
        }

        public boolean isEmpty() {
            return capacity <= 0;
        }

        public int pop() {
            if (this.isEmpty())
                return 0;
            int value = this.q[this.head++];
            this.head %= this.q.length;
            --this.capacity;
            return value;
        }

        public void push(int value) {
            this.tail = (this.tail + 1) % q.length;
            this.q[this.tail] = value;
            this.capacity = Math.min(this.capacity + 1, this.q.length);
        }
    }


    public static int findShortestPath(int[][] m, int i, int j) {
        char[] colors = new char[m.length];
        int[] distances = new int[m.length];
        for (int k = 0; k < colors.length; colors[k++] = 'w') ;
        for (int k = 0; k < distances.length; distances[k++] = -1) ;
        Assignment01Q05.Queue queue = new Assignment01Q05.Queue(m.length);
        queue.push(i);
        colors[i] = 'g';
        distances[i] = 0;
        while (!queue.isEmpty()) {
            int v = queue.pop();
            final int[] edges = m[v];
            for (int u = 0; u < edges.length; u++) {
                if (edges[u] == 1 && colors[u] == 'w') {
                    distances[u] = distances[v] + 1;
                    colors[u] = 'g';
                    queue.push(u);
                }
            }
            colors[v] = 'b';
        }
        return distances[j];
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][]{{0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {1, 0, 0, 0}}, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][]{{0, 1, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 1, 0}}, 0, 2)); // 2
    }
}