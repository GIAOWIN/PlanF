package com.yuan.common.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphDemo {
    public static void main(String[] args) {
        //结点的个数
        int n = 8;
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }

        //添加边
        //A=>B A=>C B=>C B=>D B=>E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
//显示一把邻结矩阵
        graph.showGraph();


    }
}

class Graph {
    /**
     * 存储图的顶点列表
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
    /**
     * 定义给数组boolean[], 记录某个结点是否被访问
     */
    private boolean[] isVisited;

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
     * 插入边 v1=>v2   v1<=v1  边+1
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numberOfEdges++;
    }

    /**
     * 返回边的数目
     *
     * @return 当前边的数目
     */
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    /**
     * 返回顶点的数目
     *
     * @return 当前顶点的数目
     */
    public int getNumberOfVertex() {
        return vertexList.size();
    }

    /**
     * 返回下标对应的数据
     *
     * @return 下标对应的数据
     */
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 返回v1 v1 的权值
     *
     * @return 下标对应的数据
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 显示邻接矩阵
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    /**
     * 得到第一个邻接结点的下标 value
     *
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     */
    private void dfs(boolean[] isVisited, int i) {
        //首先我们访问该结点,输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }

    }

    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    /**
     * 对dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
     */
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行dfs[回溯]
        for (int i = 0; i < getNumberOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }
}
