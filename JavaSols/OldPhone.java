package JavaSols;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OldPhone {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int o = sc.nextInt();
            ArrayList<Integer> workingNumber = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                workingNumber.add(num);
            }
            int[] signs = new int[4];
            for (int i = 0; i < m; i++) {
                int num = sc.nextInt();
                signs[num-1] = 1;
            }
            int target = sc.nextInt();
            getMinSteps(target, new HashMap<Integer, Integer>(), 1, workingNumber, o, signs);
            System.out.println(ans);
        }
        sc.close();
    }

    static void getMinSteps(int target, HashMap<Integer, Integer> output, int cur_level, ArrayList<Integer> workingNumber, int o, int[] signs) {
        if (workingNumber.size() == 0){
            return;
        }

        for (int i = 0; i < workingNumber.size(); i++) {
            int cur_ele = workingNumber.get(i);
            workingNumber.remove(i);
            HashMap<Integer, Integer> new_op = new HashMap<>();
            new_op.put(cur_ele, 1);
            for (Map.Entry<Integer, Integer> entry : output.entrySet()) {
                int val = entry.getKey();
                int level = entry.getValue();
                //add
                if (signs[0] == 1){
                    int newAdd = cur_ele + val;
                    int newFreq = level+3;
                    if (!new_op.containsKey(newAdd)){
                        new_op.put(newAdd, newFreq);
                    } else if (new_op.get(newAdd)>newFreq){
                        new_op.put(newAdd, newFreq);
                    }
                    if (newAdd == target && newFreq <=0){
                        ans = Math.min(ans, newFreq);
                    }
                }
                //subtract
                if (signs[1] == 1){
                    int newAdd = Math.abs(cur_ele - val);
                    int newFreq = level+3;
                    if (!new_op.containsKey(newAdd)){
                        new_op.put(newAdd, newFreq);
                    } else if (new_op.get(newAdd)>newFreq){
                        new_op.put(newAdd, newFreq);
                    }
                    if (newAdd == target && newFreq <=0){
                        ans = Math.min(ans, newFreq);
                    }
                }
                //multiply
                if (signs[2] == 1) {
                    int newAdd = cur_ele*val;
                    int newFreq = level+3;
                    if (!new_op.containsKey(newAdd)){
                        new_op.put(newAdd, newFreq);
                    } else if (new_op.get(newAdd)>newFreq){
                        new_op.put(newAdd, newFreq);
                    }
                    if (newAdd == target && newFreq <=0) ans = Math.min(ans, newFreq);
                }
                //divide
                if (signs[3] == 1) {
                    if (val!=0 && cur_ele!=0){
                        if (cur_ele%val == 0){
                            int newAdd = cur_ele/val;
                            int newFreq = level + 3;
                            if (!new_op.containsKey(newAdd))
                                new_op.put(newAdd, newFreq);
                            else if (new_op.get(newAdd)>newFreq){
                                new_op.put(newAdd, newFreq);
                            }
                            if (newAdd == target && newFreq<=o){
                                ans = Math.min(ans, newFreq);
                            }
                        } else {
                            if (cur_ele !=0 && val%cur_ele == 0) {
                                int newAdd = val/cur_ele;
                                int newFreq = level + 3;
                                if (!new_op.containsKey(newAdd))
                                    new_op.put(newAdd, newFreq);
                                else if (new_op.get(newAdd)>newFreq){
                                    new_op.put(newAdd, newFreq);
                                }
                                if (newAdd == target && newFreq<=o){
                                    ans = Math.min(ans, newFreq);
                                }
                            }
                        }
                    }
                }
                String one = Integer.toString(cur_ele);
                String two = Integer.toString(val);
                int newAdd = Integer.parseInt(one.concat(two));
                int newFreq = level + 1;
                if (!new_op.containsKey(newAdd)){
                    new_op.put(newAdd, newFreq);
                } else if (new_op.get(newAdd)>newFreq){
                    new_op.put(newAdd, newFreq);
                }
                if (newAdd == target && newFreq <= o){
                    ans = Math.min(ans, newFreq);
                }
                newAdd = Integer.parseInt(two.concat(one));
                if (!new_op.containsKey(newAdd)){
                    new_op.put(newAdd, newFreq);
                } else if (new_op.get(newAdd)>newFreq){
                    new_op.put(newAdd, newFreq);
                }
                if (newAdd == target && newFreq <= o){
                    ans = Math.min(ans, newFreq);
                }
            }
            getMinSteps(target, new_op, cur_level+1, workingNumber, o, signs);
            workingNumber.add(i, cur_ele);
        }
    }
}


