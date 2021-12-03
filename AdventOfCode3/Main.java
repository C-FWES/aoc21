package AdventOfCode3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int mostCommonBit(String[][] binaries) {
        StringBuilder gammaBuilder = new StringBuilder();
        StringBuilder epsilonBuilder = new StringBuilder();
        int zeroCount = 0;
        int oneCount = 0;
        char[] counts = new char[12];
        char[] counts_e = new char[12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < binaries.length; j++) {
                if (binaries[j][i].equals("0")) {
                    zeroCount+=1;
                }
                else {
                    oneCount+=1;
                }
            }//2595824
            if (zeroCount > oneCount) {
                gammaBuilder.append('0');
                epsilonBuilder.append('1');
            }
            else {
                gammaBuilder.append('1');
                epsilonBuilder.append('0');
            }
            zeroCount = 0;oneCount = 0;
        }
        int gamma = Integer.parseInt(gammaBuilder.toString(), 2);
        int epsilon = Integer.parseInt(epsilonBuilder.toString(), 2);
        System.out.println(gamma);
        System.out.println(epsilon);
        return gamma*epsilon;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String> binaries = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            binaries.add(line);
        }
        br.close();
        String[][] digits = new String[binaries.size()][12];
        for (int i = 0; i < binaries.size(); i++) {
            String[] entry = binaries.get(i).split("");
            digits[i] = entry;
        }
        int value = mostCommonBit(digits);
        System.out.println(value);
    }
}
