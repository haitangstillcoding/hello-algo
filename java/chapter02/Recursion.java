package chapter02;

import java.util.Stack;

/**
 * @author: haitang
 * @description: 递归
 * <p>「递归 recursion」是一种算法策略，通过函数调用自身来解决问题。它主要包含两个阶段。
 * 1. 递：程序不断深入地调用自身，通常传入更小或更简化的参数，直到达到“终止条件”。
 * 2. 归：触发“终止条件”后，程序从最深层的递归函数开始逐层返回，汇聚每一层的结果。
 * 而从实现的角度看，递归代码主要包含三个要素。
 * 1. 终止条件：用于决定什么时候由“递”转“归”。
 * 2. 递归调用：对应“递”，函数调用自身，通常输入更小或更简化的参数。
 * 3. 返回结果：对应“归”，将当前递归层级的结果返回至上一层。</p>
 */
public class Recursion {
    /**
     * 递归
     * <p>观察以下代码，我们只需调用函数 recur(n) ，就可以完成 1 + 2 + ⋯ + 𝑛 的计算：</p>
     */
    int recur(int n) {
        // 终止条件
        if (n == 1) {
            return 1;
        }
        // 递：递归调用
        int res = recur(n - 1);
        // 归：返回结果
        return n + res;
    }

    /**
     * 尾递归
     * <p>有趣的是，如果函数在返回前的最后一步才进行递归调用，则该函数可以被编译器或解释器优化，使其在空
     * 间效率上与迭代相当。这种情况被称为「尾递归 tail recursion」。
     * ‧ 普通递归：当函数返回到上一层级的函数后，需要继续执行代码，因此系统需要保存上一层调用的上下
     * 文。
     * ‧ 尾递归：递归调用是函数返回前的最后一个操作，这意味着函数返回到上一层级后，无需继续执行其他
     * 操作，因此系统无需保存上一层函数的上下文。以计算 1 + 2 + ⋯ + 𝑛 为例，我们可以将结果变量 res 设为函数参数，从而实现尾递归。</p>
     */
    int tailRecur(int n, int res) {
        // 终止条件
        if (n == 0) {
            return res;
        }
        return tailRecur(n - 1, n + res);
    }

    /**
     * 斐波那契数列：递归
     * <p>设斐波那契数列的第 𝑛 个数字为 𝑓(𝑛) ，易得两个结论。
     * ‧ 数列的前两个数字为 𝑓(1) = 0 和 𝑓(2) = 1 。
     * ‧ 数列中的每个数字是前两个数字的和，即 𝑓(𝑛) = 𝑓(𝑛 − 1) + 𝑓(𝑛 − 2) 。
     * 按照递推关系进行递归调用，将前两个数字作为终止条件，便可写出递归代码。调用 fib(n) 即可得到斐波那
     * 契数列的第 𝑛 个数字。</p>
     */
    int fib(int n) {
        // 终止条件f(1) = 0、f(2) = 1
        if (n == 1 || n == 2) {
            return n - 1;
        }
        // 递：递归调用
        int res = fib(n - 1) + fib(n - 2);
        // 归：返回结果
        return res;
    }

    /**
     * 使用迭代模拟递归
     * <p>那么，迭代和递归具有什么内在联系呢？以上述的递归函数为例，求和操作在递归的“归”阶段进行。这意
     * 味着最初被调用的函数实际上是最后完成其求和操作的，这种工作机制与栈的“先入后出”原则是异曲同工
     * 的。</p>
     * <p>事实上，“调用栈”和“栈帧空间”这类递归术语已经暗示了递归与栈之间的密切关系。
     * 1. 递：当函数被调用时，系统会在“调用栈”上为该函数分配新的栈帧，用于存储函数的局部变量、参数、
     * 返回地址等数据。
     * 2. 归：当函数完成执行并返回时，对应的栈帧会从“调用栈”上被移除，恢复之前函数的执行环境。
     * 因此，我们可以使用一个显式的栈来模拟调用栈的行为，从而将递归转化为迭代形式：</p>
     */
    int forLoopRecur(int n) {
        // 使用一个显示的栈来模拟系统调用栈
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        // 递：递归调用
        for (int i = n; i > 0; i--) {
            stack.push(i);
        }
        // 归：返回结果
        while (!stack.isEmpty()) {
            // 通过“出栈操作”模拟“归”
            res += stack.pop();
        }
        return res;

    }

}
