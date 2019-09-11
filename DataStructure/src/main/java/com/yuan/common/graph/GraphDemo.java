package com.yuan.common.graph;

import java.util.ArrayList;

public class GraphDemo {
    public static void main(String[] args) {

    }
}

class Graph {
    /**
     * 存储定点列表
     */
    private ArrayList<String> vertexList;
    /**
     * 存储对应的邻结矩阵[行][列]
     */
    private int[][] edges;
    /**
     * 边的数目
     */
    private int numberOfEdges;

    public Graph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.edges = new int[n][n];
        this.numberOfEdges = 0;
    }

    /**
     * 插入顶点
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 插入边
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numberOfEdges++;
    }
}
