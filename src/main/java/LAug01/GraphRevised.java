package LAug01;

import AugNewBatch.Oct1_Subseq.D;

import java.util.*;

public class GraphRevised {
    static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int vtces = 7;
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        constructGraph(graph, vtces);

        boolean[] visited = new boolean[vtces];
        System.out.println("======HasPath======");
        System.out.println(hasPath(graph, 0, 6, visited));
        Arrays.fill(visited, false);

        System.out.println("======Print All Paths======");
        printAllPaths(graph, 0, 6, visited, 0 + "");

        System.out.println("======Multi-solver======");
        Arrays.fill(visited, false);
        multiSolver(graph, 0, 6, visited, 40, 3);

        System.out.println("======Connected Components======");
        ArrayList<Edge>[] disconnectedGraph = new ArrayList[vtces];
        Arrays.fill(visited, false);
        constructGraphForConnectedComp(disconnectedGraph, vtces);
        System.out.println(getConnectedComponents(disconnectedGraph, visited));

        System.out.println("======Is Graph Connected======");
        Arrays.fill(visited, false);
        System.out.println(isConnectedGraph(disconnectedGraph, visited));

        System.out.println("======Island Count======");
        int[][] arr = {
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        boolean[][] visitedIslands = new boolean[arr.length][arr[0].length];
        System.out.println(countNumberOfIslands(arr, visitedIslands));

        System.out.println("======Hamiltonian Path & Cycle======");
        HashSet<Integer> hamiltonianVisited = new HashSet<>();
        //Add for creating cycle
        //graph[2].add(new Edge(2,5,10));
        //graph[5].add(new Edge(5,2,10));
        hamiltonianPathAndCycle(graph, 0, hamiltonianVisited, 0 + "", 0);

        System.out.println("======Print Path from src - BFT======");
        Arrays.fill(visited, false);
        breadthFirstTraversal(graph, visited);

        System.out.println("\n======Is Cyclic======");
        Arrays.fill(visited, false);
        System.out.println(isCyclic(graph, visited));

        System.out.println("\n======Is Bipartite======");
        int[] bipartiteVisited = new int[vtces];
        Arrays.fill(bipartiteVisited, -1);
        System.out.println(isBipartite(graph, bipartiteVisited));

        System.out.println("\n======Spread Of Infection======");
        Arrays.fill(bipartiteVisited, -1);
        System.out.println(spreadOfInfection(graph, 6, bipartiteVisited, 3));

        System.out.println("\n======Dijkstra======");
        Arrays.fill(visited, false);
        shortestPathInWeights(graph, 0, visited);

        System.out.println("\n======Prims======");
        Arrays.fill(visited, false);
        minSpanningTree(graph, 3, visited);

        System.out.println("\n======Topological Sort======");
        ArrayList<Edge>[] directedGraph = new ArrayList[vtces];
        Arrays.fill(visited, false);
        constructDirectedGraph(directedGraph, vtces);
        orderOfCompilation(directedGraph, visited);
    }

    private static void constructGraph(ArrayList<Edge>[] graph, int vtces) {
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
        Edge e1 = new Edge(0, 1, 10);
        Edge e2 = new Edge(0, 3, 40);
        Edge e3 = new Edge(1, 0, 10);
        Edge e4 = new Edge(1, 2, 10);
        Edge e5 = new Edge(2, 1, 10);
        Edge e6 = new Edge(2, 3, 10);
        Edge e7 = new Edge(3, 0, 40);
        Edge e8 = new Edge(3, 2, 10);
        Edge e9 = new Edge(3, 4, 2);
        Edge e10 = new Edge(4, 3, 2);
        Edge e11 = new Edge(4, 5, 3);
        Edge e12 = new Edge(4, 6, 8);
        Edge e13 = new Edge(5, 4, 3);
        Edge e14 = new Edge(5, 6, 3);
        Edge e15 = new Edge(6, 4, 8);
        Edge e16 = new Edge(6, 5, 3);
        graph[0].add(e1);
        graph[0].add(e2);
        graph[1].add(e3);
        graph[1].add(e4);
        graph[2].add(e5);
        graph[2].add(e6);
        graph[3].add(e7);
        graph[3].add(e8);
        graph[3].add(e9);
        graph[4].add(e10);
        graph[4].add(e11);
        graph[4].add(e12);
        graph[5].add(e13);
        graph[5].add(e14);
        graph[6].add(e15);
        graph[6].add(e16);
    }

    private static void constructGraphForConnectedComp(ArrayList<Edge>[] graph, int vtces) {
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
        Edge e1 = new Edge(0, 1, 10);
        Edge e3 = new Edge(1, 0, 10);
        Edge e6 = new Edge(2, 3, 10);
        Edge e8 = new Edge(3, 2, 10);
        Edge e11 = new Edge(4, 5, 10);
        Edge e12 = new Edge(4, 6, 10);
        Edge e13 = new Edge(5, 4, 10);
        Edge e14 = new Edge(5, 6, 10);
        Edge e15 = new Edge(6, 4, 10);
        Edge e16 = new Edge(6, 5, 10);
        graph[0].add(e1);
        graph[1].add(e3);
        graph[2].add(e6);
        graph[3].add(e8);
        graph[4].add(e11);
        graph[4].add(e12);
        graph[5].add(e13);
        graph[5].add(e14);
        graph[6].add(e15);
        graph[6].add(e16);
    }

    private static void constructDirectedGraph(ArrayList<Edge>[] graph, int vtces) {
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
        Edge e1 = new Edge(0, 1, 10);
        Edge e2 = new Edge(0, 3, 40);
        Edge e4 = new Edge(1, 2, 10);
        Edge e6 = new Edge(2, 3, 10);
        Edge e10 = new Edge(4, 3, 2);
        Edge e11 = new Edge(4, 5, 3);
        Edge e12 = new Edge(4, 6, 8);
        Edge e14 = new Edge(5, 6, 3);
        graph[0].add(e1);
        graph[0].add(e2);
        graph[1].add(e4);
        graph[2].add(e6);
        graph[4].add(e10);
        graph[4].add(e11);
        graph[4].add(e12);
        graph[5].add(e14);
    }


    //DFS

    //Time ->O(v^e)
    //Space->O(v)
    private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;
        ArrayList<Edge> edges = graph[src];
        for (Edge edge : edges) {
            if (visited[edge.nbr] == false) {
                boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
                if (hasNbrPath) {
                    return true;
                }
            }
        }
        return false;
    }

    //Print paths in lexicographic order
    //O(v^e)
    private static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if (src == dest) {
            System.out.println(psf);
            return;
        }

        visited[src] = true;
        ArrayList<Edge> edges = graph[src];
        for (Edge edge : edges) {
            if (visited[edge.nbr] == false) {
                printAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
            }
        }
        visited[src] = false;
    }

    private static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int data, int k) {
        multiSolverHelper(graph, src, dest, visited, data, k, src + "", 0);
        System.out.println("Smallest Path = " + smallestPath + "@" + smallestPathWt);
        System.out.println("Largest Path = " + largestPath + "@" + largestPathWt);
        System.out.println("Just Larger Path than " + data + " = " + justLargerPathThanData + "@" + ceilPathWt);
        System.out.println("Just Smaller Path than " + data + " = " + justSmallerPathThanData + "@" + floorPathWt);
        System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
    }

    static String smallestPath;
    static int smallestPathWt = Integer.MAX_VALUE;
    static String largestPath;
    static int largestPathWt = Integer.MIN_VALUE;
    static String justSmallerPathThanData;//floor
    static int floorPathWt = Integer.MIN_VALUE;
    static String justLargerPathThanData;//ceil
    static int ceilPathWt = Integer.MAX_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    private static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        public Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    private static void multiSolverHelper(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int data, int k, String psf, int wsf) {
        if (src == dest) {
            if (wsf > largestPathWt) {
                largestPathWt = wsf;
                largestPath = psf;
            }

            if (wsf < smallestPathWt) {
                smallestPathWt = wsf;
                smallestPath = psf;
            }

            if (data < wsf && wsf < ceilPathWt) {
                ceilPathWt = wsf;
                justLargerPathThanData = psf;
            }

            if (floorPathWt < wsf && wsf < data) {
                floorPathWt = wsf;
                justSmallerPathThanData = psf;
            }

            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if (wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }
        }

        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                multiSolverHelper(graph, edge.nbr, dest, visited, data, k, psf + edge.nbr, wsf + edge.wt);
            }
        }
        visited[src] = false;
    }

    private static ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph, boolean[] visited) {
        ArrayList<ArrayList<Integer>> connectedComp = new ArrayList<>();
        for (int vtx = 0; vtx < graph.length; vtx++) {
            if (visited[vtx] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                getConnectedComponentsHelper(graph, vtx, visited, comp);
                connectedComp.add(comp);
            }

        }
        return connectedComp;
    }

    private static void getConnectedComponentsHelper(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> connectedComp) {
        visited[src] = true;
        connectedComp.add(src);
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                getConnectedComponentsHelper(graph, edge.nbr, visited, connectedComp);
            }
        }
    }

    private static boolean isConnectedGraph(ArrayList<Edge>[] graph, boolean[] visited) {
        ArrayList<ArrayList<Integer>> components = getConnectedComponents(graph, visited);
        return components.size() == 1;
    }

    //Given a 2d array where 0's represent land and 1's represent water.
    //Assume every cell is linked to it's north, east, west and south cell.
    private static int countNumberOfIslands(int[][] arr, boolean[][] visited) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && visited[i][j] == false) {
                    visitAllConnectedComponents(arr, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void visitAllConnectedComponents(int[][] arr, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j] == true) {
            return;
        }

        visited[i][j] = true;

        visitAllConnectedComponents(arr, i - 1, j, visited);//t
        visitAllConnectedComponents(arr, i, j - 1, visited);//l
        visitAllConnectedComponents(arr, i + 1, j, visited);//d
        visitAllConnectedComponents(arr, i, j + 1, visited);//r
    }

    //A hamiltonian path is such which visits all vertices without visiting any twice.
    // A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
    private static void hamiltonianPathAndCycle(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int originalSrc) {
        if (visited.size() == graph.length - 1) {
            System.out.print(psf);
            boolean isHamiltonianCycle = false;
            for (Edge edge : graph[src]) {
                if (edge.nbr == originalSrc) {
                    isHamiltonianCycle = true;
                    break;
                }
            }
            if (isHamiltonianCycle) {
                System.out.print("()");
            } else {
                System.out.print(".");
            }
            System.out.println();
            return;
        }

        visited.add(src);
        for (Edge edge : graph[src]) {
            if (visited.contains(edge.nbr) == false) {
                hamiltonianPathAndCycle(graph, edge.nbr, visited, psf + edge.nbr, originalSrc);
            }
        }
        visited.remove(src);
    }

    //BFT
    private static void breadthFirstTraversal(ArrayList<Edge>[] graph, boolean[] visited) {
        for (int v = 0; v < graph.length; v++) {
            if (visited[v] == false) {
                breadthFirstTraversalHelper(graph, v, visited);
            }
        }
    }

    //Remove - Mark* - Work - Add*
    private static void breadthFirstTraversalHelper(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(src);
        while (queue.size() > 0) {
            int rem = queue.removeFirst();

            if (visited[rem] == true) { //Best place to detect cycles
                continue;
            }

            visited[rem] = true;
            System.out.print(rem);
            for (Edge edge : graph[rem]) {
                if (visited[edge.nbr] == false) {
                    queue.addLast(edge.nbr);
                }
            }
        }
    }

    private static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] visited) {
        for (int v = 0; v < graph.length; v++) {
            if (visited[v] == false) {
                boolean cyclic = isCyclicHelper(graph, v, visited);
                if (cyclic) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclicHelper(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(src);
        while (queue.size() > 0) {
            int rem = queue.removeFirst();
            if (visited[rem] == true) {//Cycle
                return true;
            }

            visited[rem] = true;
            for (Edge edge : graph[rem]) {
                if (visited[edge.nbr] == false) {
                    queue.addLast(edge.nbr);
                }
            }
        }
        return false;
    }

    //A graph is called bipartite if it is possible to split it's vertices
    // in two sets of mutually exclusive and exhaustive vertices
    // such that All Edges Are Across Sets.
    //Cycle should be even / a-cyclic for it to be bipartite
    //Eg: Cycle has 4 elts => bipartite
    //Cycle has 3 elts => non bipartite
    private static boolean isBipartite(ArrayList<Edge>[] graph, int[] visited) {
        for (int v = 0; v < graph.length; v++) {
            if (visited[v] == -1) {
                boolean bipartite = isBipartiteHelper(graph, v, visited);
                if (bipartite) {
                    return true;
                }
            }
        }
        return false;
    }

    static class BipartitePair {
        int val;
        int level;

        BipartitePair(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    private static boolean isBipartiteHelper(ArrayList<Edge>[] graph, int src, int[] visited) {
        LinkedList<BipartitePair> queue = new LinkedList<>();
        queue.addLast(new BipartitePair(src, 0));
        while (queue.size() > 0) {
            BipartitePair rem = queue.removeFirst();

            //Visited is storing Level of src
            if (visited[rem.val] != -1) {
                if (visited[rem.val] != rem.level) { // previously visited at level 2  != again visited at level 3
                    return false;
                }
            }

            visited[rem.val] = rem.level;

            for (Edge edge : graph[rem.val]) {
                if (visited[rem.val] == -1) {
                    queue.addLast(new BipartitePair(edge.nbr, rem.level + 1));
                }
            }
        }
        return true;
    }

    //Given a graph, representing people and their connectivity.
    //Given a src person (who got infected) and time t.
    //Find how many people will get infected in time t,
    // if the infection spreads to neighbors of infected person in 1 unit of time.
    //BFS till level 't'
    private static int spreadOfInfection(ArrayList<Edge>[] graph, int src, int[] visited, int t) {
        LinkedList<BipartitePair> queue = new LinkedList<>();
        queue.addLast(new BipartitePair(src, 1));
        int count = 0;
        while (queue.size() > 0) {
            BipartitePair rem = queue.removeFirst();

            if (visited[rem.val] != -1) {
                continue;
            }

            visited[rem.val] = rem.level;
            if (rem.level > t) {
                break;
            }
            count++;
            for (Edge edge : graph[rem.val]) {
                queue.addLast(new BipartitePair(edge.nbr, rem.level + 1));
            }
        }
        return count;
    }

    static class DijkstraPair implements Comparable<DijkstraPair> {
        int vtx;
        String psf;
        int wsf;

        DijkstraPair(int vtx, String psf, int wsf) {
            this.vtx = vtx;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(DijkstraPair o) {
            return this.wsf - o.wsf;
        }
    }

    //Dijkstra
    //Shortest Path to each vtx
    //O(v+e)logv
    //BFS with PriorityQueue
    private static void shortestPathInWeights(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        PriorityQueue<DijkstraPair> queue = new PriorityQueue<>();
        queue.add(new DijkstraPair(src, src + "", 0));
        while (queue.size() > 0) {
            DijkstraPair rem = queue.remove();

            if (visited[rem.vtx] == true) {
                continue;
            }
            visited[rem.vtx] = true;

            System.out.println(rem.vtx + " via path: " + rem.psf + " @ " + rem.wsf);
            for (Edge edge : graph[rem.vtx]) {
                if (visited[edge.nbr] == false) {
                    queue.add(new DijkstraPair(edge.nbr, rem.psf + edge.nbr, rem.wsf + edge.wt));
                }
            }
        }
    }

    static class PrimsPair implements Comparable<PrimsPair> {
        int vtx;
        int parent;
        int cost;

        PrimsPair(int vtx, int parent, int cost) {
            this.vtx = vtx;
            this.parent = parent;
            this.cost = cost;
        }

        @Override
        public int compareTo(PrimsPair o) {
            return this.cost - o.cost;
        }
    }

    //Prims
    //Minimum length of wire required to connect all PCs over a network
    private static void minSpanningTree(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        PriorityQueue<PrimsPair> queue = new PriorityQueue<>();
        queue.add(new PrimsPair(src, -1, 0));

        while (queue.size() > 0) {
            PrimsPair rem = queue.remove();

            if (visited[rem.vtx] == true) {
                continue;
            }

            visited[rem.vtx] = true;
            if (rem.parent != -1) {
                System.out.println(rem.vtx + " from " + rem.parent + " @ " + rem.cost);
            }

            for (Edge edge : graph[rem.vtx]) {
                if (visited[edge.nbr] == false) {
                    queue.add(new PrimsPair(edge.nbr, rem.vtx, edge.wt));
                }
            }
        }
    }

    //Topological Sort
    //-> A permutation of vertices for a directed acyclic graph is called topological sort
    // if for all directed edges uv, u appears before v in the graph
    //print the order in which tasks could be done
    //The task that should be done at last should be printed first and
    //the task which should be done first should be printed last.
    private static void orderOfCompilation(ArrayList<Edge>[] graph, boolean[] visited) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int v = 0; v < graph.length; v++) {
            if (visited[v] == false) {
                topologicalSort(graph, v, visited, stack);
            }
        }
        System.out.println(stack);
    }

    //DFS- Add to Stack in Post Order
    private static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, LinkedList<Integer> stack) {
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                topologicalSort(graph, edge.nbr, visited, stack);
            }
        }
        stack.addFirst(src);
    }

    //Iterative DFT => BFT with Stack
}
