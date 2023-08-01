package problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author TomAndersen
 */
public class Main {
    static class Point {
        int num, x1, y1, x2, y2;

        Point(int num, int x1, int y1, int x2, int y2) {
            this.num = num;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        HashMap<Integer, Point> points = new HashMap<>();

        for (int i = 1; i <= num; i++) {
            String[] strings = bf.readLine().split(" ");
            points.put(
                Integer.parseInt(strings[0]),
                new Point(
                    Integer.parseInt(strings[0]),
                    Integer.parseInt(strings[1]),
                    Integer.parseInt(strings[2]),
                    Integer.parseInt(strings[3]),
                    Integer.parseInt(strings[4])
                ));
        }

        // iteration, using x1 to sort
        TreeSet<Point> row = new TreeSet<>(Comparator.comparingInt(e -> e.x1));
        StringBuilder sb = new StringBuilder();

        while (!points.isEmpty()) {
            // find the top point in the left points, and add it into row
            int topY = Integer.MAX_VALUE;
            int topPointNum = -1;

            for (int p : points.keySet()) {
                Point point = points.get(p);
                if (point.y1 < topY) {
                    topPointNum = p;
                    topY = point.y1;
                }
            }

            Point topPoint = points.remove(topPointNum);
            row.add(topPoint);
            int width = topPoint.y2 - topPoint.y1;

            for (Point point : points.values()) {
                // if point is same line, add into set
                if (Math.abs(point.y1 - topPoint.y1) <= width / 2) {
                    row.add(point);
                }
            }

            // add points in current row into string
            for (Point point : row) {
                points.remove(point.num);
                sb.append(point.num);
                sb.append(' ');
            }
            row.clear();
        }

        // print
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
