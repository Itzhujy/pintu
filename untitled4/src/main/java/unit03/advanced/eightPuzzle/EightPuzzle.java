package main.java.unit03.advanced.eightPuzzle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
八数码问题是一种经典的玩具问题，也是人工智能领域中的经典问题之一。
该问题要求将一个3x3的九宫格中的数字1-8和一个空格按照规定的移动方式进行移动，
最终使得九宫格呈现出目标状态。

解题思路：

定义初始状态和目标状态的九宫格矩阵。
使用A*搜索算法进行搜索。
定义状态节点和搜索队列，将初始状态节点加入搜索队列。
不断从搜索队列中取出状态节点，计算其状态评价函数的值。
根据状态评价函数的值，选择一个最优的状态节点进行扩展。
对扩展出的子节点进行判断，如果是目标状态则输出结果，否则将其加入搜索队列并继续搜索。
 */

public class EightPuzzle {

    // 初始状态
    private static int[][] startState = {
        {2, 8, 3},
        {1, 6, 4},
        {7, 0, 5}
    };

    // 目标状态
    private static int[][] goalState = {
        {1, 2, 3},
        {8, 0, 4},
        {7, 6, 5}
    };

    // 定义状态节点类
    private static class Node {
        int[][] state; // 九宫格状态
        int g; // 到达该状态的步数
        int h; // 启发式评估函数的值
        Node parent; // 父节点

        Node(int[][] state, int g, int h, Node parent) {
            this.state = state;
            this.g = g;
            this.h = h;
            this.parent = parent;
        }

        // 计算启发式评估函数的值
        int f() {
            return g + h;
        }
    }

    public static void main(String[] args) {
        // 使用优先队列实现搜索队列
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::f));
        pq.offer(new Node(startState, 0, h(startState), null));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (isGoalState(node.state)) { // 判断是否是目标状态
                printSolution(node);
                return;
            }
            for (int[][] successor : successorStates(node.state)) { // 扩展子节点
                Node successorNode = new Node(successor, node.g + 1, h(successor), node);
                pq.offer(successorNode);
            }
        }
        System.out.println("无解！");
    }

    // 判断是否是目标状态
    private static boolean isGoalState(int[][] state) {
        return Arrays.deepEquals(state, goalState);
    }

    // 计算状态的启发式评估函数的值
    private static int h(int[][] state) {
        int count = 0;
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] != 0 && state[i][j] != goalState[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // 扩展子节点
    private static int[][][] successorStates(int[][] state) {
        int[][][] successors = new int[4][3][3];
        int x = 0, y = 0;
        // 找到空格的位置
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        // 上移
        if (x > 0) {
            int[][] nextState = cloneState(state);
            nextState[x][y] = nextState[x - 1][y];
            nextState[x - 1][y] = 0;
            successors[0] = nextState;
        }
        // 下移
        if (x < 2) {
            int[][] nextState = cloneState(state);
            nextState[x][y] = nextState[x + 1][y];
            nextState[x + 1][y] = 0;
            successors[1] = nextState;
        }
        // 左移
        if (y > 0) {
            int[][] nextState = cloneState(state);
            nextState[x][y] = nextState[x][y - 1];
            nextState[x][y - 1] = 0;
            successors[2] = nextState;
        }
        // 右移
        if (y < 2) {
            int[][] nextState = cloneState(state);
            nextState[x][y] = nextState[x][y + 1];
            nextState[x][y + 1] = 0;
            successors[3] = nextState;
        }
        return successors;
    }

    // 拷贝状态
    private static int[][] cloneState(int[][] state) {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                newState[i][j] = state[i][j];
            }
        }
        return newState;
    }

    // 打印解
    private static void printSolution(Node node) {
        System.out.println("步数为：" + node.g);
        while (node != null) {
            printState(node.state);
            node = node.parent;
        }
    }

    // 打印状态
    private static void printState(int[][] state) {
        System.out.println("------------------");
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }
}