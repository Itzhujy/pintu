package main.java.unit03.advanced.tsp;

import java.util.*;
/**
 * 旅行商问题（TSP）是指给定一组城市和每对城市之间的距离，求解访问每个城市恰好一次并回到起始城市的最短路径。
 * TSP是一个NP难问题，没有已知的多项式时间算法来解决它。因此，通常使用启发式算法来找到接近最优解的解。
 * 一种常用的启发式算法是遗传算法。遗传算法模拟自然选择和遗传机制来搜索解空间。
 * 遗传算法的基本思想是：将每个可行解表示为染色体，并使用交叉和变异等遗传操作来产生新的解。这些解被评估并选择出最好的解作为下一代的起点。
 */


/*public class TSPGeneticAlgorithm {

    // 城市坐标
    private static final int[][] CITIES = {
            {60, 200}, {180, 200}, {80, 180}, {140, 180}, {20, 160},
            {100, 160}, {200, 160}, {140, 140}, {40, 120}, {100, 120},
            {180, 100}, {60, 80}, {120, 80}, {180, 60}, {20, 40},
            {100, 40}, {200, 40}, {20, 20}, {60, 20}, {160, 20}
    };
    private static final int NUM_CITIES = CITIES.length;

    private static final int POPULATION_SIZE = 50; // 种群大小
    private static final int MAX_GENERATIONS = 500; // 最大迭代次数
    private static final double MUTATION_RATE = 0.015; // 变异概率

    // 计算两个城市之间的距离
    private static double distance(int city1, int city2) {
        int[] city1Coord = CITIES[city1];
        int[] city2Coord = CITIES[city2];
        int xDiff = city1Coord[0] - city2Coord[0];
        int yDiff = city1Coord[1] - city2Coord[1];
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    // 计算路径的总长度
    private static double calculateFitness(List<Integer> path) {
        double totalDistance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            totalDistance += distance(path.get(i), path.get(i + 1));
        }
        totalDistance += distance(path.get(path.size() - 1), path.get(0));
        return totalDistance;
    }

    // 生成初始种群
    private static List<List<Integer>> generatePopulation(int size) {
        List<List<Integer>> population = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j < NUM_CITIES; j++) {
                path.add(j);
            }
            Collections.shuffle(path);
            population.add(path);
        }
        return population;
    }

    // 选择父代
    private static List<List<Integer>> selectParents(List<List<Integer>> population) {
        List<List<Integer>> parents = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int index1 = (int) (Math.random() * population.size());
            int index2 = (int) (Math.random() * population.size());
            List<Integer> parent1 = population.get(index1);
            List<Integer> parent2 = population.get(index2);
            if (calculateFitness(parent1) < calculateFitness(parent2)) {
                parents.add(parent1);
            } else {
                parents.add(parent2);
            }
        }
        return parents;
    }

    // 进行交叉操作
    private static List<Integer> crossover(List<Integer> parent1, List<Integer> parent2) {
        int size = parent1.size();
        int startPos = new Random().nextInt(size);
        int endPos = new Random().nextInt(size - startPos) + startPos;
        List<Integer> offspring = new ArrayList<>(Collections.nCopies(size, -1));
        for (int i = startPos; i <= endPos; i++) {
            offspring.set(i, parent1.get(i));
        }
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (!offspring.contains(parent2.get(i))) {
                while (offspring.get(j) != -1) {
                    j++;
                }
                offspring.set(j, parent2.get(i));
            }
        }
        return offspring;
    }

    // 进行变异操作
    private static void mutate(List<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            if (Math.random() < MUTATION_RATE) {
                int j = (int) (Math.random() * path.size());
                int temp = path.get(i);
                path.set(i, path.get(j));
                path.set(j, temp);
            }
        }
    }

// 对两个父代进行交叉和变异操作，产生新的子代
private static List<List<Integer>> crossoverAndMutate(List<Integer> parent1, List<Integer> parent2) {
    List<List<Integer>> offspringPopulation = new ArrayList<>();
    List<Integer> offspring1 = new ArrayList<>(parent1);
    List<Integer> offspring2 = new ArrayList<>(parent2);
    int size = parent1.size();
    int startPos = new Random().nextInt(size);
    int endPos = new Random().nextInt(size - startPos) + startPos;
    for (int i = startPos; i <= endPos; i++) {
        int temp = offspring1.get(i);
        offspring1.set(i, offspring2.get(i));
        offspring2.set(i, temp);
    }
    mutate(offspring1);
    mutate(offspring2);
    offspringPopulation.add(offspring1);
    offspringPopulation.add(offspring2);
    return offspringPopulation;
}

    // 对种群进行进化
    private static List<List<Integer>> evolve(List<List<Integer>> population) {
        List<List<Integer>> offspringPopulation = new ArrayList<>();
        while (offspringPopulation.size() < POPULATION_SIZE) {
            List<List<Integer>> parents = selectParents(population);
            List<List<Integer>> offspring = crossoverAndMutate(parents.get(0), parents.get(1));
            offspringPopulation.addAll(offspring);
        }
        return offspringPopulation;
    }

    public static void main(String[] args) {
        List<List<Integer>> population = generatePopulation(POPULATION_SIZE);
        for (int i = 0; i < MAX_GENERATIONS; i++) {
            population = evolve(population);
        }
        List<Integer> bestSolution = findBestSolution(population);
        System.out.println("最优解：" + bestSolution);
        System.out.println("路径长度：" + calculateFitness(bestSolution));
    }
}*/
//import java.util.*;

public class TSPGeneticAlgorithm {

    /*// 城市坐标
    private static final int[][] CITIES = {
            {60, 200}, {180, 200}, {80, 180}, {140, 180}, {20, 160},
            {100, 160}, {200, 160}, {140, 140}, {40, 120}, {100, 120},
            {180, 100}, {60, 80}, {120, 80}, {180, 60}, {20, 40},
            {100, 40}, {200, 40}, {20, 20}, {60, 20}, {160, 20}
    };
    private static final int NUM_CITIES = CITIES.length;

    private static final int POPULATION_SIZE = 50; // 种群大小
    private static final int MAX_GENERATIONS = 500; // 最大迭代次数
    private static final double MUTATION_RATE = 0.015; // 变异概率

    // 计算两个城市之间的距离
    private static double distance(int city1, int city2) {
        int[] city1Coord = CITIES[city1];
        int[] city2Coord = CITIES[city2];
        int xDiff = city1Coord[0] - city2Coord[0];
        int yDiff = city1Coord[1] - city2Coord[1];
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    // 计算路径的总长度
    private static double calculateFitness(List<Integer> path) {
        double totalDistance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            totalDistance += distance(path.get(i), path.get(i + 1));
        }
        totalDistance += distance(path.get(path.size() - 1), path.get(0));
        return totalDistance;
    }

    // 生成初始种群
    private static List<List<Integer>> generatePopulation(int size) {
        List<List<Integer>> population = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j < NUM_CITIES; j++) {
                path.add(j);
            }
            Collections.shuffle(path);
            population.add(path);
        }
        return population;
    }

    // 选择父代
    private static List<List<Integer>> selectParents(List<List<Integer>> population) {
        List<List<Integer>> parents = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int index1 = (int) (Math.random() * population.size());
            int index2 = (int) (Math.random() * population.size());
            List<Integer> parent1 = population.get(index1);
            List<Integer> parent2 = population.get(index2);
            if (calculateFitness(parent1) < calculateFitness(parent2)) {
                parents.add(parent1);
            } else {
                parents.add(parent2);
            }
        }
        return parents;
    }

    // 进行交叉操作
    private static List<Integer> crossover(List<Integer> parent1, List<Integer> parent2) {
        int size = parent1.size();
        int startPos = new Random().nextInt(size);
        int endPos = new Random().nextInt(size - startPos) + startPos;
        List<Integer> offspring = new ArrayList<>(Collections.nCopies(size, -1));
        for (int i = startPos; i <= endPos; i++) {
            offspring.set(i, parent1.get(i));
        }
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (!offspring.contains(parent2.get(i))) {
                while (offspring.get(j) != -1) {
                    j++;
                }
                offspring.set(j, parent2.get(i));
            }
        }
        return offspring;
    }

    // 进行变异操作
    private static void mutate(List<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            if (Math.random() < MUTATION_RATE) {
                int j = (int) (Math.random() * path.size());
                int temp = path.get(i);
                path.set(i, path.get(j));
                path.set(j, temp);
            }
        }
    }
// 对两个父代进行交叉和变异，生成新一代种群
private static List<List<Integer>> createOffspring(List<List<Integer>> parents) {
    List<List<Integer>> offspring = new ArrayList<>();
    for (int i = 0; i < POPULATION_SIZE / 2; i++) {
        List<Integer> parent1 = parents.get(0);
        List<Integer> parent2 = parents.get(1);
        List<Integer> child1 = crossover(parent1, parent2);
        List<Integer> child2 = crossover(parent2, parent1);
        mutate(child1);
        mutate(child2);
        offspring.add(child1);
        offspring.add(child2);
    }
    return offspring;
}

    // 找到种群中适应度最好的路径
    private static List<Integer> findBestSolution(List<List<Integer>> population) {
        List<Integer> bestPath = population.get(0);
        double bestFitness = calculateFitness(bestPath);
        for (int i = 1; i < population.size(); i++) {
            List<Integer> path = population.get(i);
            double fitness = calculateFitness(path);
            if (fitness < bestFitness) {
                bestPath = path;
                bestFitness = fitness;
            }
        }
        return bestPath;
    }

    // 主函数
    public static void main(String[] args) {
        List<List<Integer>> population = generatePopulation(POPULATION_SIZE);
        for (int i = 0; i < MAX_GENERATIONS; i++) {
            List<List<Integer>> parents = selectParents(population);
            List<List<Integer>> offspring = createOffspring(parents);
            population = offspring;
        }
        List<Integer> bestPath = findBestSolution(population);
        double bestFitness = calculateFitness(bestPath);
        System.out.println("Best path found: " + bestPath);
        System.out.println("Length of best path: " + bestFitness);
    }*/
}
