package AdventOfCode2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int getPosition(List<String> directions) {
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;
        for (int i = 0; i < directions.size(); i++) {
            String[] entry = directions.get(i).split(" ");
            String orientation = entry[0];
            int value = Integer.parseInt(entry[1]);
            if (orientation.equals("forward")) {
                horizontalPosition += value;
                depth += (aim * value);
            }
            else if (orientation.equals("down")) {
//                depth += value;
                aim += value;
            }
            else if (orientation.equals("up")) {
//                depth -= value;
                aim -= value;
            }
        }
        return horizontalPosition*depth;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> directions = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            directions.add(line);
        }
        br.close();
        int position = getPosition(directions);
        System.out.println(position);
    }
}
