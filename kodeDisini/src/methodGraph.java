public class methodGraph {
    nodeGraph head;

    public void UI() {
        System.out.println("\n====================================");
        System.out.println("   Sistem Informasi Kebakaran      ");
        System.out.println("====================================");
        System.out.println("1. Tambah Laporan Kebakaran         ");
        System.out.println("2. Lihat Daftar Laporan (Queue)     ");
        System.out.println("0. Keluar                           ");
        System.out.println("====================================");
    }

    public methodGraph(nodeGraph headNode) {
        this.head = headNode;
    }

    public nodeGraph findNode(String nomorBangunan) {
        nodeGraph current = head;
        while (current != null) {
            if (current.nomorBangunan.equals(nomorBangunan)) {
                return current;
            }
            current = current.next;
        }
        return null; 
    }

    public void addNode(String nomorBangunan, String jenisBangunan) {
        if (findNode(nomorBangunan) != null) return; 

        nodeGraph newNode = new nodeGraph(nomorBangunan, jenisBangunan);
        if (head == null) {
            head = newNode;
        } else {
            nodeGraph current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void doubleaddEdge(String source, String destination, String namaJalan, int weight) {
        addEdge(source, destination, namaJalan, weight);
        addEdge(destination, source, namaJalan, weight);
    }

    public void addEdge(String source, String destination, String namaJalan, int weight) {
        nodeGraph sourceNode = findNode(source);
        if (sourceNode == null) {
            System.out.println("Node " + source + " tidak ditemukan!");
            return;
        }

        nodeEdge newEdge = new nodeEdge(destination, namaJalan, weight);

        if (sourceNode.headEdge == null) {
            sourceNode.headEdge = newEdge;
        } else {
            nodeEdge current = sourceNode.headEdge;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEdge;
        }
    }


    public int dijkstra(String startNodeID, String targetNodeID) {
        if (findNode(startNodeID) == null || findNode(targetNodeID) == null) {
            return Integer.MAX_VALUE;
        }

        resetVisited();

        NodeDistance distanceList = null;
        nodeGraph current = head;
        while (current != null) {
            distanceList = addToDistanceList(distanceList, current.nomorBangunan, Integer.MAX_VALUE);
            current = current.next;
        }

        updateDistance(distanceList, startNodeID, 0);

        NodeQueue queue = null;
        queue = enqueueByPriority(queue, startNodeID, 0);

        while (queue != null) {
            String currentNodeID = queue.nodeID;
            int currentDist = queue.priority;
            queue = queue.next;

            nodeGraph currentNode = findNode(currentNodeID);

            if (currentNode.isVisited) {
                continue;
            }

            if (currentNodeID.equals(targetNodeID)) {
                return currentDist;
            }

            currentNode.isVisited = true;

            nodeEdge edge = currentNode.headEdge;
            while (edge != null) {
                nodeGraph neighborNode = findNode(edge.destination);

                if (neighborNode != null && !neighborNode.isVisited) {
                    int newDist = currentDist + edge.weight;
                    int oldDist = getDistance(distanceList, neighborNode.nomorBangunan);

                    if (newDist < oldDist) {
                        updateDistance(distanceList, neighborNode.nomorBangunan, newDist);
                        queue = enqueueByPriority(queue, neighborNode.nomorBangunan, newDist);
                    }
                }

                edge = edge.next;
            }
        }

        return Integer.MAX_VALUE;
    }


    private void resetVisited() {
        nodeGraph current = head;
        while (current != null) {
            current.isVisited = false;
            current = current.next;
        }
    }

    private NodeDistance addToDistanceList(NodeDistance head, String nodeID, int distance) {
        NodeDistance newNode = new NodeDistance(nodeID, distance);
        newNode.next = head;
        return newNode;
    }

    private int getDistance(NodeDistance list, String nodeID) {
        NodeDistance current = list;
        while (current != null) {
            if (current.nodeID.equals(nodeID)) {
                return current.distance;
            }
            current = current.next;
        }
        return Integer.MAX_VALUE;
    }

    private void updateDistance(NodeDistance list, String nodeID, int newDistance) {
        NodeDistance current = list;
        while (current != null) {
            if (current.nodeID.equals(nodeID)) {
                current.distance = newDistance;
                return;
            }
            current = current.next;
        }
    }

    private NodeQueue enqueueByPriority(NodeQueue head, String nodeID, int priority) {
        NodeQueue newNode = new NodeQueue(nodeID, priority);

        if (head == null || priority < head.priority) {
            newNode.next = head;
            return newNode;
        }

        NodeQueue current = head;
        while (current.next != null && current.next.priority < priority) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    public int lokasiPoin(int jarak) {
        if (jarak == Integer.MAX_VALUE) {
            System.out.println("Tidak dapat dijangkau dari P1!");
            return 0; 
        } else if (jarak > 50000) {
            return 20;
        } else if (jarak >= 30000) {
            return 15;
        } else if (jarak >= 15000) {
            return 10;
        } else {
            return 5;
        }
    }

}
