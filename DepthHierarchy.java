package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DepthHierarchy {

    private HashMap<Integer, ArrayList<Integer>> graph;
    private boolean[] visited;
    private int numVertexes;
    private StringBuilder output;

    private String repeatStr(String str, int times) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < times; i++)  {
            sb.append(str);
        }

        return sb.toString();
    }

    private boolean dfs_(int v, int depth) {
        visited[v] = true;
        boolean in = false;

        for (int neighbour : graph.get(v)) {
            in = true;
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                output.append(repeatStr(" ", 2 * depth))
                        .append(v)
                        .append("-")
                        .append(neighbour)
                        .append(" pathR(G,")
                        .append(neighbour)
                        .append(")\n");
                dfs_(neighbour, depth + 1);
            } else {
                output.append(repeatStr(" ", 2 * depth))
                        .append(v)
                        .append("-")
                        .append(neighbour)
                        .append("\n");
            }
        }

        return in;
    }

    private void dfs() {
        for (int v = 0; v < numVertexes; v++) {
            if (!visited[v]) {
                if (dfs_(v, 1)) {
                    output.append("\n");
                }
            }
        }
    }

    public DepthHierarchy() throws IOException {
        int numCases;
        String line;
        BufferedReader in;
        StringTokenizer st;

        in = new BufferedReader(new InputStreamReader(System.in));
        line = in.readLine();
        numCases = Integer.parseInt(line);

        for (int i = 0; i < numCases; i++) {
            int numEdges;
            int v1;
            int v2;

            output = new StringBuilder("");
            graph = new HashMap<Integer, ArrayList<Integer>>();

            line = in.readLine();
            st = new StringTokenizer(line);
            numVertexes = Integer.parseInt(st.nextToken());
            numEdges = Integer.parseInt(st.nextToken());

            for (int j = 0; j < numVertexes; j++) {
               graph.put(j, new ArrayList<>());
            }

            visited = new boolean[numVertexes];

            for (int j = 0; j < numEdges; j++) {
                line = in.readLine();
                st = new StringTokenizer(line);

                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());

                graph.get(v1).add(v2);
            }

            for (int j = 0; j < numVertexes; j++) {
                graph.get(j).sort(null);
            }

            output.append("Caso ")
                    .append(i + 1)
                    .append(":\n");
            dfs();
            System.out.print(output);
        }

    }

    public static void main(String[] args) throws IOException {
        new DepthHierarchy();
    }
}
