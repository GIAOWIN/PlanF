package com.yuan.common.sparse;


import java.io.*;
import java.util.Scanner;

/**
 * @author Yuan_9826
 * 这是一个稀疏数组工具类
 *
 * 稀疏数组介绍
 */
public class SparseArrayUtils {

    /**
     * 将二维数组转为稀疏数组 数组 [行][列]
     *
     * @param arrs   传入的二维数组
     * @param row    行
     * @param column 列
     * @return 转换之后的稀疏数组
     */
    public static int[][] ArraytoSparse(int[][] arrs, int row, int column) {
//        1.拿到这个数组的非0数据的个数 count
        int count = effectiveCount(arrs);
//        2.创建稀疏数组:二维数组[count+1][3]，
        int[][] sparseArray = new int[count + 1][3];
//        3.赋值
        sparseArray[0][0] = row;
        sparseArray[0][1] = column;
        sparseArray[0][2] = count;
        int effective = 1;
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length; j++) {
                if (arrs[i][j] != 0) {
                    sparseArray[effective][0] = i;
                    sparseArray[effective][1] = j;
                    sparseArray[effective][2] = arrs[i][j];
                    effective++;
                }
            }
        }

        return sparseArray;
    }


    /**
     * @return 二维数组的有效值个数
     */
    public static int effectiveCount(int[][] arrs) {
        int count = 0;
        for (int[] arr : arrs) {
            for (int i : arr) {
                if (i != 0) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * @param sparse 稀疏数组
     * @param name   文件名
     * @param url    保存路径
     *               将稀疏数组写到本地临时保存
     */
    public static void writeArray(int[][] sparse, String url, String name) {
        try {
            FileWriter out = new FileWriter(url + name);
            for (int i = 0; i < sparse.length; i++) {
                for (int j = 0; j < 3; j++) {
                    out.write(sparse[i][j] + " ");
                }
                out.write("\r\n");
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取本地文件并创建稀疏数组返回,如果返回null表示读取失败
     *
     * @param url  读取路径
     * @param name 文件名
     * @return 返回一个稀疏数组
     */
    public static int[][] returnArray(String url, String name) {
        int initRow = readLine(url, name);
        if (initRow == 0 ) {
            return null;
        }
        int[][] sparse = new int[initRow][3];
        try {
            BufferedReader in = new BufferedReader(new FileReader(url + name));
            String line;
            int rowNumber = 0;
            while ((line = in.readLine()) != null) {
                String[] strLIne = line.split(" ");
                sparse[rowNumber][0] = Integer.parseInt(strLIne[0]);
                sparse[rowNumber][1] = Integer.parseInt(strLIne[1]);
                sparse[rowNumber][2] = Integer.parseInt(strLIne[2]);
                rowNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return sparse;
    }


    /**
     * 读取文件行数
     *
     * @param name 文件位置
     * @return 文件行数
     */
    public static int readLine(String url, String name) {
        int count = 0;
        if ((url + name).length() <= 0) {
            return 0;
        }
        try {
            FileInputStream fis = new FileInputStream(new File(url + name));
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return count;
    }

    /**
     * 利用稀疏数组转为原来的数组
     *
     * @param sparse 稀疏数组
     * @return 原来的数组11X11
     */
    public static int[][] sparseToArray(int[][] sparse) {
        int[][] arr = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            arr[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        return arr;
    }


}
