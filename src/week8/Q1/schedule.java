package week8.Q1;

import java.util.Arrays;

public class schedule {
/*
1235. Maximum Profit in Job Scheduling
Hard
https://leetcode.com/problems/maximum-profit-in-job-scheduling/

Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job.
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
*/

public static void main(String[] args) {
    int[] startTime = {1, 2, 3, 4, 6}, endTime = {3, 5, 10, 6, 9}, profit = {20, 20, 100, 70, 60};
    Task[] tasks = new Task[startTime.length];
    for (int i = 0; i < startTime.length; i++) {
        tasks[i] = new Task(startTime[i], endTime[i], profit[i]);
    }
    
    Arrays.sort(tasks);
    
    int[] dp = new int[startTime.length];
    dp[0] = tasks[0].profit;
    int result = Recursive(tasks, dp, startTime.length);
    System.out.println(result);
    
}

public static int Recursive(Task[] tasks, int[] dp, int n) {
    //index i, represent the n-th task.
    int i = n - 1;
    
    if (dp[i] != 0)
        return dp[i];
    
    // get maximum not including current item, (n-1)-th tasks
    int result_n = Recursive(tasks, dp, i);
    
    // get maximum include current
    int result = tasks[i].profit;
    int startLimit = tasks[i].start;
    
    //directly add the compound if it end earlier than current
    for (int j = i - 1; j >= 0; j--) {
        if (startLimit >= tasks[j].end) { // ensure adding tasks ended
            result += dp[j];
            break;
        }
    }
//    Naive Recursive
//    for (int j = i - 1; j >= 0; j--) {
//        if (startLimit >= tasks[j].end) { // ensure adding tasks ended
//            result += tasks[j].profit;
//            startLimit = tasks[j].start;
//        }
//    }
    
    return dp[i] = Math.max(result, result_n);
}


}

class Task implements Comparable<Task> {
int start, end, profit;

public Task(int start, int end, int profit) {
    this.start = start;
    this.end = end;
    this.profit = profit;
}


@Override
public int compareTo(Task other) {
    return this.end - other.end;
}
}
