package JavaSols;

import java.util.Arrays;

public class CrowPot {
    public static void main(String[] args) {
        System.out.println(ThirstyCrowProblem(new int[]{5,7}, 2, 1));
    }
    public static int ThirstyCrowProblem(int[] input1,int input2,int input3)
    {
        int len = input1.length;
        if((input2 < input3 || input3 < 1)||(input2 !=len))
        {
            return  -1;
        }
        int i = 0;
        int j = 0;
        for(i = 0; i < input2; i++)
        {
            if(input1[i] < 1)
            {
                return   -1;
            }
        }
        Arrays.sort(input1);
//        for(i = 0;i < N;i++)
//        {
//            for(j = 0;j < N - i - 1;j++)
//            {
//                if(input1[j] > input1[j + 1])
//                {
//                    int temp = 0;
//                    temp = input1[j + 1];
//                    input1[j + 1] = input1[j];
//                    input1[j] = temp;
//                }
//            }
//        }

        int Out = 0;
        int Val = input1[input3 -1];
        int ValPrev = 0;
        for(i = 0; i < input3 - 1; i++)
        {
            if(input1[i] < Val)
            {
                Out += (input1[i] - ValPrev)*(input2 - i);
                ValPrev = input1[i];
            }
            else if((input1[i] == Val))
            {
                Out += input1[i] - ValPrev;
            }
        }
        for(i = input3; i < input2; i++)
        {
            if(input1[i] > input1[input3 -1])
            {
                Out += input1[input3 -1] - ValPrev;
            }
        }
        Out += input1[input3 - 1] - ValPrev;

        return Out;
    }
}
