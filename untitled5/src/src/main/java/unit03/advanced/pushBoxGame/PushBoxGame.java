package src.main.java.unit03.advanced.pushBoxGame;

import java.util.Scanner;

/***
 * 简单的推箱子游戏示例。推箱子游戏是一种益智类游戏，玩家需要通过操作角色推动箱子到指定位置，完成关卡目标。
 * 推箱子游戏的解题思路：
 * （1）定义地图和角色的位置，以及箱子的位置和目标位置。
 * （2）监听键盘事件，根据按键移动角色的位置。
 * （3）判断角色是否推动箱子，如果推动，则移动箱子的位置。
 * （4）判断箱子是否到达目标位置，如果到达则判断是否完成关卡目标。
 * 根据自己的需求对代码进行修改和扩展，增加更多的关卡和难度等级。
 */
public class PushBoxGame {

    // 地图数组，0表示空地，1表示墙，2表示箱子，3表示目标位置，4表示角色
    private static int[][] map = {
        {1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 2, 0, 0, 1},
        {1, 0, 3, 4, 2, 0, 1},
        {1, 0, 0, 2, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1}
    };

    // 角色的位置
    private static int roleX = 3;
    private static int roleY = 3;

    // 箱子的位置
    private static int boxX = 3;
    private static int boxY = 4;

    // 目标位置的数量
    private static int targetCount = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMap();

            System.out.println("请输入移动方向（上：w，下：s，左：a，右：d）：");
            String direction = scanner.next();

            // 根据键盘输入移动角色
            int dx = 0, dy = 0;
            switch (direction) {
                case "w":
                    dy = -1;
                    break;
                case "s":
                    dy = 1;
                    break;
                case "a":
                    dx = -1;
                    break;
                case "d":
                    dx = 1;
                    break;
            }

            // 判断角色是否推动箱子
            if (boxX == roleX + dx && boxY == roleY + dy) {
                if (map[boxY + dy][boxX + dx] == 0 || map[boxY + dy][boxX + dx] == 3) {
                    boxX += dx;
                    boxY += dy;
                }
            }

            // 移动角色的位置
            if (map[roleY + dy][roleX + dx] == 0 || map[roleY + dy][roleX + dx] == 3) {
                roleX += dx;
                roleY += dy;
            }

            // 判断箱子是否到达目标位置
            if (map[boxY][boxX] == 3) {
                targetCount--;
                if (targetCount == 0) {
                    System.out.println("恭喜你通关了！");
                    break;
                }
            }
        }
    }

    // 打印地图
    private static void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == roleY && j == roleX) {
                    System.out.print("4"); // 角色
                } else if (i == boxY && j == boxX) {
                    System.out.print("2"); // 箱子
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }
}