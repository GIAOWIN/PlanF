package com.yuan.common.algorithm;

import java.awt.*;
import java.util.ArrayList;

/**
 * 骑士周游案例
 *
 * @author Yuan-9826
 */
public class KnightDemo {
    public static void main(String[] args) {
        //测试骑士周游算法是否正确
        int x = 8;
        int y = 8;
        //马儿初始位置的行，从1开始编号
        int row = 1;
        //马儿初始位置的列，从1开始编号
        int column = 1;
        //创建骑士对象
        Knight knight = new Knight();


        knight.x = x;
        knight.y = y;
        knight.visited = new boolean[x * y];
        int[][] chessboard = new int[x][y];

        knight.traversalChessboard(chessboard, row - 1, column - 1, 1);
        //输出棋盘的最后情况
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }

    }
}

class Knight {
    /**
     * 棋盘的列
     */
    public int x;
    /**
     * 棋盘的行
     */
    public int y;
    /**
     * 表示棋盘各处是否被访问过
     */
    public boolean[] visited;
    /**
     * 标记是否访问了棋盘所有的点
     */
    public boolean finished;

    /**
     * @param chessboard
     * @param row
     * @param column
     * @param step
     */
    public void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        if (row >=8||column>=8){return;}
        chessboard[row][column] = step;
        final int jj = row * x + column;
        visited[jj] = true;
        ArrayList<Point> points = next(new Point(column, row));
        while (!points.isEmpty()) {
            Point point = points.remove(0);
            final int i = point.y * x + point.x;
            if(i>visited.length-1){return;}
            if (!visited[i]) {
                traversalChessboard(chessboard, point.y, point.x, step + 1);
            }
        }
        if (step < x * y && !finished) {
            chessboard[row][column] = 0;
            visited[row * x + column] = false;
        } else {
            finished = true;
        }
    }

    /**
     * @param curPoint
     * @return
     */
    public ArrayList<Point> next(Point curPoint) {
        //创建一个ArrayList
        ArrayList<Point> points = new ArrayList<>();
        //创建一个Point
        Point point = new Point();
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 1) >= 0 && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 2) >= 0 && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 2) >= 0 && (point.y = curPoint.y + 1) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x + 1) >= 0 && (point.y = curPoint.y + 2) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y + 2) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y + 1) >= 0) {
            points.add(new Point(point));
        }
        return points;
    }
}