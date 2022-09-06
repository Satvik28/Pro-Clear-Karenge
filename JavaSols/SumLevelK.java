package JavaSols;

/*
https://www.geeksforgeeks.org/sum-nodes-k-th-level-tree-represented-string/
 */

public class SumLevelK {
    static int sumAtKthLevel(String tree, int k)
    {
        int level = -1;
        int sum = 0; // Initialize result
        int n = tree.length();

        for (int i=0; i<n; i++)
        {
            // increasing level number
            if (tree.charAt(i) == '(')
                level++;

                // decreasing level number
            else if (tree.charAt(i) == ')')
                level--;

            else
            {
                // check if current level is
                // the desired level or not
                if (level == k)
                    sum += (tree.charAt(i)-'0');
            }
        }

        // required sum
        return sum;
    }

    // Driver program to test above
    public static void main(String[] args)
    {
        String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
        int k = 2;
        System.out.println(sumAtKthLevel(tree, k));
    }
}
