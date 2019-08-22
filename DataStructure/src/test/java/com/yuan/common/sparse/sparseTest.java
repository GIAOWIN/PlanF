package com.yuan.common.sparse;


public class sparseTest {
    public static void main(String[] args) {
        String ID = "49754";
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        array[3][4] = 1;
        array[1][4] = 2;
        array[3][2] = 1;
        array[3][3] = 2;
        array[0][0] = 1;
        array[1][1] = 2;
        showArray(array);

        //转稀疏数组
        int[][] sparse = SparseArrayUtils.ArraytoSparse(array, 11, 11);
        showArray(sparse);

        //写到本地
        SparseArrayUtils.writeArray(sparse,"C:\\Users\\ASUS\\Desktop\\qw\\","快乐的棋盘.txt");
        //读入内存
        int[][] sparse2 = SparseArrayUtils.returnArray("C:\\Users\\ASUS\\Desktop\\qw\\", "快乐的棋盘.txt");
        showArray(sparse2);
        //还原
        int[][] PTArray = SparseArrayUtils.sparseToArray(sparse2);
        showArray(PTArray);
    }


    /**
     * 遍历二维数组并打印出来
     */
    public static void showArray(int[][] arrs) {
        for (int[] arr : arrs) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("==========================");
    }
}
