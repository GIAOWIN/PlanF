package com.yuan.common.huffman;

import java.io.*;
import java.util.*;

/**
 * @author Yuan-9826
 */
public class HuffmanCodeDemo {
    public static void main(String[] args) {
        final HuffmanCode hfm = new HuffmanCode();

//        //测试压缩文件
//		String srcFile = "C:\\Users\\ASUS\\Desktop\\SKL改eyes.jpg";
//		String dstFile1 = "C:\\Users\\ASUS\\Desktop\\SKL改eyes.zip";
//
//        hfm.zipFile(srcFile, dstFile1);
//		System.out.println("压缩文件ok~~");

        //测试解压文件
        String zipFile = "C:\\Users\\ASUS\\Desktop\\SKL改eyes.zip";
        String dstFile2 = "C:\\Users\\ASUS\\Desktop\\SKL改eyes2.jpg";
        hfm.unZipFile(zipFile, dstFile2);
        System.out.println("解压成功!");
    }
}

class HuffmanCode {

    /**
     * 1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
     */
    public Map<Byte, String> huffmanCodes = new HashMap<>(1024);
    /**
     * 2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
     */
    private StringBuilder stringBuilder = new StringBuilder();




    /**
     * 完成对压缩文件的解压
     * @param zipFile 准备解压的文件
     * @param dstFile 将文件解压到哪个路径
     */
    public void unZipFile(String zipFile, String dstFile) {

        try (
                //创建文件输入流
                InputStream is = new FileInputStream(zipFile);
                //将bytes 数组写入到目标文件
                OutputStream os = new FileOutputStream(dstFile);
                //创建一个和  is关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(is);
        ) {
            //读取byte数组  huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼编码表
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            //解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);

            //写数据到 dstFile 文件
            os.write(bytes);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }


    /**
     * 将一个文件进行压缩
     * @param srcFile 你传入的希望压缩的文件的全路径
     * @param dstFile 我们压缩后将压缩文件放到哪个目录
     */
    public void zipFile(String srcFile, String dstFile) {


        try (
                //创建文件的输入流
                FileInputStream is = new FileInputStream(srcFile);
                OutputStream os = new FileOutputStream(dstFile);
                //创建一个和文件输出流关联的ObjectOutputStream
                ObjectOutputStream oos = new ObjectOutputStream(os);
        ) {
            //创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流, 存放压缩文件
            //把 赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //这里我们以对象流的方式写入 赫夫曼编码，是为了以后我们恢复源文件时使用
            //注意一定要把赫夫曼编码 写入压缩文件
            oos.writeObject(huffmanCodes);


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

    }


    /**
     * 将给定的字符串压缩成byte数组并返回
     *
     * @param bytes  要压缩的字符串
     * @param root 赫夫曼树
     * @return 压缩好的byte数组
     */
    public byte[] zip(byte[] bytes, Node root) {

        //2.将字节数组中赫夫曼集合包含的值都取出拼接成一个字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes 数组
        for (byte value : bytes) {
            //关键步骤
            stringBuilder.append(getCodes(root).get(value));
        }


        //3.创建 存储压缩后的 byte数组
        byte[] huffmanCodeBytes = new byte[(stringBuilder.length() + 7) / 8];

        //记录是第几个byte
        int index = 0;
        //4.将 字符串 每八个一位 填充到huffmanCodeBytes数组当中
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            //因为是每8位对应一个byte,所以步长 +8
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                //不够8位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte 转成一个byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return huffmanCodeBytes;
    }


    public Map<Byte, Integer> getNodes(byte[] bytes) {
        //统计 buye数组中 编码出现的次数 装进Map集合中
        Map<Byte, Integer> codeeMap = new HashMap<>();
        for (byte b : bytes) {
            Integer count = codeeMap.get(b);
            if (count == null) {
                codeeMap.put(b, 1);
            } else {
                codeeMap.put(b, count + 1);
            }
        }

        return codeeMap;
    }

    /**
     * 对字符串进行压缩
     * @param str
     * @return
     */
    public byte[] huffmanZip(String str) {
        Map<Byte, Integer> nodes = getNodes(str);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        getCodes(huffmanTreeRoot);
        byte[] zip = zip(str, huffmanTreeRoot);
        return zip;
    }
    /**
     * 对文件进行压缩
     * @param b
     * @return
     */
    private byte[] huffmanZip(byte[] b) {
        Map<Byte, Integer> nodes = getNodes(b);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        getCodes(huffmanTreeRoot);
        byte[] zip = zip(b, huffmanTreeRoot);
        return zip;
    }

    public byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {

        //1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建要给集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引,扫描 stringBuilder
        for (int i = 0; i < stringBuilder.length(); ) {
            // 小的计数器
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //递增的取出 key 1
                //i 不动，让count移动，指定匹配到一个字符
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                //说明没有匹配到
                if (b == null) {
                    count++;
                } else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        //当for循环结束后，我们list中就存放了所有的字符  "i like like like java do you like a java"
        //把list 中的数据放入到byte[] 并返回
        byte b[] = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;

    }


    /**
     * 将一个byte 转成一个二进制的字符串
     *
     * @param b    传入的 byte
     * @param flag 标志是否需要补高位如果是true ，表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @return 是该b 对应的二进制的字符串，（注意是按补码返回）
     */
    public String byteToBitString(boolean flag, byte b) {
        //使用变量保存 b //将 b 转成 int
        int temp = b;
        //如果是正数我们还存在补高位
        if (flag) {
            //按位与 256  1 0000 0000  | 0000 0001 => 1 0000 0001
            temp |= 256;
        }
        //返回的是temp对应的二进制的补码
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }


    /**
     * 将给定的字符串压缩成byte数组并返回
     *
     * @param str  要压缩的字符串
     * @param root 赫夫曼树
     * @return 压缩好的byte数组
     */
    public byte[] zip(String str, Node root) {

        //1.利用 huffmanCodes 将  bytes 转成  赫夫曼编码对应的字符串
        byte[] bytes = str.getBytes();

        //2.将字节数组中赫夫曼集合包含的值都取出拼接成一个字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes 数组
        for (byte value : bytes) {
            //关键步骤
            stringBuilder.append(getCodes(root).get(value));
        }


        //3.创建 存储压缩后的 byte数组
        byte[] huffmanCodeBytes = new byte[(stringBuilder.length() + 7) / 8];

        //记录是第几个byte
        int index = 0;
        //4.将 字符串 每八个一位 填充到huffmanCodeBytes数组当中
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            //因为是每8位对应一个byte,所以步长 +8
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                //不够8位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte 转成一个byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return huffmanCodeBytes;
    }


    /**
     * 为了调用方便，我们重载 getCodes
     */
    public Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        //处理root的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 功能：将传入的node结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCodes集合
     *
     * @param node          传入结点
     * @param code          路径： 左子结点是 0, 右子结点 1
     * @param stringBuilder 用于拼接路径
     */
    public void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code 加入到 stringBuilder2
        stringBuilder2.append(code);
        //如果node == null不处理
        if (node != null) {
            //判断当前node 是叶子结点还是非叶子结点
            if (node.data == null) {
                //非叶子结点递归处理

                //向左递归
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else { //说明是一个叶子结点
                //就表示找到某个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }


    /**
     * 将赫夫曼树转换成 byte字节+出现次数 的Map 并加入到List集合中
     *
     * @param str 接收转码字符串
     * @return 返回的就是 List 形式
     */
    public Map<Byte, Integer> getNodes(String str) {
        byte[] bytes = str.getBytes();
        //统计 buye数组中 编码出现的次数 装进Map集合中
        Map<Byte, Integer> codeeMap = new HashMap<>();
        for (byte b : bytes) {
            Integer count = codeeMap.get(b);
            if (count == null) {
                codeeMap.put(b, 1);
            } else {
                codeeMap.put(b, count + 1);
            }
        }

        return codeeMap;
    }

    /**
     * 将节点集合转化成赫夫曼树
     *
     * @param codeeMap
     * @return
     */
    public Node createHuffmanTree(Map<Byte, Integer> codeeMap) {

        //遍历map集合每个值 转换成节点对象并放到List集合中
        ArrayList<Node> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> codeEntry : codeeMap.entrySet()) {
            nodes.add(new Node(codeEntry.getKey(), codeEntry.getValue()));
        }
        while (nodes.size() > 1) {
            //排序, 从小到大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node left = nodes.get(0);
            //取出第二颗最小的二叉树
            Node right = nodes.get(1);
            //创建一颗新的二叉树,它的根节点 没有data, 只有权值
            Node root = new Node(null, left.weight + right.weight);
            root.left = left;
            root.right = right;
            //将已经处理的两颗二叉树从nodes删除
            nodes.remove(left);
            nodes.remove(right);
            //将新的二叉树，加入到nodes
            nodes.add(root);

        }
        //nodes 最后的结点，就是赫夫曼树的根结点
        return nodes.get(0);
    }


}

class Node implements Comparable<Node> {
    /**
     * 存放数据(字符)本身，比如'a' => 97 ' ' => 32
     */
    Byte data;
    /**
     * 权值, 表示字符出现的次数
     */
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {

        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node [data = " + data + " weight=" + weight + "]";
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
