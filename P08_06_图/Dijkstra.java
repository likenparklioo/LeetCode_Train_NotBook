package P08_06_图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;


public class Dijkstra {
    // Dijkstra有堆的优化

    public static HashMap<Node, Integer> dijkstra1(Node head) {
        // 从head出发到所有点的最小距离
        // key: 从head出发到达key
        // value: 从head出发到达key的最小距离
        // 如果在表中，没有T的记录，含义是从head出发到T这个点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);

        // 已经求过距离的节点，存在selectedNodes中，以后再也不碰
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnSelectedNode(distanceMap, selectedNodes); // 初始时minNode为开始节点

        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));

                }
            }

            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnSelectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnSelectedNode (
        HashMap<Node, Integer> distanceMap,
        HashSet<Node> touchedNodes) 
    {
        Node minNode = null;
        
        int minDistance = Integer.MAX_VALUE;
        for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }

        return minNode;
    }

    // 图的结构模板
    public class Node {
        public int value;  // 値
        public int in; // 入度
        public int out; // 出度
        public ArrayList<Node> nexts; // 从该点发散出去的点
        public ArrayList<Edge> edges; // 从该点发散出去的边

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    // 有向边
    // 无向边(有向边*2)
    public class Edge {
        public int weight; // 权值
        public Node from;  // 
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    public class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap();
            edges = new HashSet();
        }
    }
}

