package 龟兔赛跑;

import javax.swing.*;
import java.awt.*;

public class RaceSimulation extends JFrame {
    private static final int RACE_LENGTH = 100; // 赛道长度
    private static final int FINISH_LINE = 90; // 终点线位置

    private JPanel raceTrack;
    private JLabel turtleLabel, rabbitLabel, cheetahLabel;
    private JLabel resultLabel;

    private int turtlePosition, rabbitPosition, cheetahPosition;
    private boolean isRaceFinished;

    public RaceSimulation() {
        setTitle("龟兔猎豹赛跑");
        setSize(800, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        raceTrack = new JPanel();
        raceTrack.setLayout(null);
        raceTrack.setBackground(Color.WHITE);

        turtleLabel = new JLabel(new ImageIcon(getClass().getResource("C:\\Users\\86134\\IdeaProjects\\guiturun\\src\\龟兔赛跑\\乌龟.webp")));
        rabbitLabel = new JLabel(new ImageIcon(getClass().getResource("C:\\Users\\86134\\IdeaProjects\\guiturun\\src\\龟兔赛跑\\兔子.webp")));
        cheetahLabel = new JLabel(new ImageIcon(getClass().getResource("C:\\Users\\86134\\IdeaProjects\\guiturun\\src\\龟兔赛跑\\猎豹.webp")));

        turtleLabel.setSize(50, 50);
        rabbitLabel.setSize(50, 50);
        cheetahLabel.setSize(50, 50);

        turtlePosition = 0;
        rabbitPosition = 0;
        cheetahPosition = 0;
        isRaceFinished = false;

        raceTrack.add(turtleLabel);
        raceTrack.add(rabbitLabel);
        raceTrack.add(cheetahLabel);

        turtleLabel.setLocation(turtlePosition, 30);
        rabbitLabel.setLocation(rabbitPosition, 80);
        cheetahLabel.setLocation(cheetahPosition, 130);

        add(raceTrack, BorderLayout.CENTER);

        resultLabel = new JLabel();
        add(resultLabel, BorderLayout.SOUTH);
    }

    private void moveTurtle() {
        while (!isRaceFinished) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!isRaceFinished) {
                turtlePosition += 2; // 乌龟每次前进2个单位
                if (turtlePosition >= FINISH_LINE) {
                    turtlePosition = FINISH_LINE;
                    isRaceFinished = true;
                    showWinner("乌龟");
                }
                turtleLabel.setLocation(turtlePosition, 30);
            }
        }
    }

    private void moveRabbit() {
        while (!isRaceFinished) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!isRaceFinished) {
                rabbitPosition += 8; // 兔子每次前进8个单位
                if (rabbitPosition >= FINISH_LINE) {
                    rabbitPosition = FINISH_LINE;
                    isRaceFinished = true;
                    showWinner("兔子");
                }
                rabbitLabel.setLocation(rabbitPosition, 80);
            }
        }
    }

    private void moveCheetah() {
        while (!isRaceFinished) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!isRaceFinished) {
                cheetahPosition += 5; // 猎豹每次前进5个单位
                if (cheetahPosition >= FINISH_LINE) {
                    cheetahPosition = FINISH_LINE;
                    isRaceFinished = true;
                    showWinner("猎豹");
                }
                cheetahLabel.setLocation(cheetahPosition, 130);
            }
        }
    }

    private void showWinner(String winner) {
        resultLabel.setText("比赛结束，胜利者是：" + winner);
    }

    public void startRace() {
        Thread turtleThread = new Thread(this::moveTurtle);
        Thread rabbitThread = new Thread(this::moveRabbit);
        Thread cheetahThread = new Thread(this::moveCheetah);

        turtleThread.start();
        rabbitThread.start();
        cheetahThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RaceSimulation raceSimulation = new RaceSimulation();
            raceSimulation.setVisible(true);
            raceSimulation.startRace();
        });
    }
}
