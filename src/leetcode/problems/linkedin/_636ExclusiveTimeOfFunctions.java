package leetcode.problems.linkedin;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/** 636. Exclusive Time of Functions
 * On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.
 * Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the current function being executed. Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.
 * You are given a list logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times, possibly recursively.
 * A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.
 * Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.
 *
 * Example 1:
 * Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * Output: [3,4]
 * Explanation:
 * Function 0 starts at the beginning of time 0, then it executes 2 for units of time and reaches the end of time 1.
 * Function 1 starts at the beginning of time 2, executes for 4 units of time, and ends at the end of time 5.
 * Function 0 resumes execution at the beginning of time 6 and executes for 1 unit of time.
 * So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 *
 * Example 2:
 * Input: n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
 * Output: [8]
 * Explanation:
 * Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
 * Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
 * Function 0 (initial call) resumes execution then immediately calls itself again.
 * Function 0 (2nd recursive call) starts at the beginning of time 6 and executes for 1 unit of time.
 * Function 0 (initial call) resumes execution at the beginning of time 7 and executes for 1 unit of time.
 * So function 0 spends 2 + 4 + 1 + 1 = 8 units of total time executing.
 *
 * Example 3:
 * Input: n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]
 * Output: [7,1]
 * Explanation:
 * Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
 * Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
 * Function 0 (initial call) resumes execution then immediately calls function 1.
 * Function 1 starts at the beginning of time 6, executes 1 unit of time, and ends at the end of time 6.
 * Function 0 resumes execution at the beginning of time 6 and executes for 2 units of time.
 * So function 0 spends 2 + 4 + 1 = 7 units of total time executing, and function 1 spends 1 unit of total time executing.
 */
public class _636ExclusiveTimeOfFunctions {


    /** Using Deque */
    public int[] exclusiveTime(int n, List<String> logs){
        Deque<Integer> stack = new ArrayDeque<>();
        int prev = 0;
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.valueOf(s[0]));
        prev = Integer.valueOf(s[2]);
        for(int i = 1; i < logs.size();i++){
            s = logs.get(i).split(":");
            int func = Integer.valueOf(s[0]);
            int time = Integer.valueOf(s[2]);
            if(s[1].equals("start")) {
                if(!stack.isEmpty()) res[stack.peek()] += time - prev;
                stack.push(func);
                prev = time;
            } else {
                res[stack.pop()] += time - prev + 1;
                prev = time + 1;
            }
        }
        return res;
    }

    // Slow
    public int[] exclusiveTimeV2(int n, List<String> logs) {
        // stack acts just like a recursion stack where it keeps track of the
        // ids
        Stack<Integer> stack = new Stack<>();
        int[] exeTimes = new int[n];
        int lastTimestamp = 0;

        for (String log : logs) {
            // makes it easier to check what the data is
            String[] logData = log.split(":");
            int id = Integer.parseInt(logData[0]);
            int time = Integer.parseInt(logData[2]);
            String type = logData[1];

            if (type.equals("start")) {
                // when there is no calls on the stack
                // obv in a recursion call stack we push when there are
                // multiple calls to functions (recursive or nested)
                if (!stack.isEmpty())
                    exeTimes[stack.peek()] += time - lastTimestamp;
                // after updating the previous execution time, we should also
                // push the new called function to the stack since it has not
                // finish executing
                stack.push(id);
                lastTimestamp = time;
            } else {
                // when we reach a terminating log we should pop but before that
                // we should update the execution time
                // think about it, after starting a program, the execution time
                // will be from start to finish so the final update to the execution
                // time for this call will be here (it is popped from the call
                // stack) the +1 is to make the end time inclusive
                exeTimes[stack.pop()] += time - lastTimestamp + 1;
                // because the end time is inclusive we do not want to start there
                // for the next function call so we go one unit up (check the
                // example where they the start aftere and end is +1)
                lastTimestamp = time + 1;
            }

        }

        return exeTimes;
    }
}
