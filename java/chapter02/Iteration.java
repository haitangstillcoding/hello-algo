package chapter02;

/**
 * @author: haitang
 * @description: 「迭代 iteration」是一种重复执行某个任务的控制结构。在迭代中，程序会在满足一定的条件下重复执行某
 * 段代码，直到这个条件不再满足。
 */
public class Iteration {

    /**
     * for循环
     * <p>for 循环是最常见的迭代形式之一，适合预先知道迭代次数时使用。
     * 以下函数基于 for 循环实现了求和 1 + 2 + ⋯ + 𝑛 ，求和结果使用变量 res 记录。需要注意的是，Python
     * 中 range(a, b) 对应的区间是“左闭右开”的，对应的遍历范围为 𝑎, 𝑎 + 1, … , 𝑏 − 1 。</p>
     */
    int forLoop(int n) {
        int res = 0;
        // 循环求和 1, 2, ..., n-1, n
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res;
    }

    /**
     * while循环
     * <p>与 for 循环类似，while 循环也是一种实现迭代的方法。在 while 循环中，程序每轮都会先检查条件，如果条
     * 件为真则继续执行，否则就结束循环。
     * 下面，我们用 while 循环来实现求和 1 + 2 + ⋯ + 𝑛 。</p>
     */
    int whileLoop(int n) {
        int res = 0;
        int i = 1;
        while (i <= n) {
            res += i;
            i++;
        }
        return res;
    }

    /**
     * while循环（两次更新）
     * <p>在 while 循环中，由于初始化和更新条件变量的步骤是独立在循环结构之外的，因此它比 for 循环的自由度
     * 更高。例如在以下代码中，条件变量 𝑖 每轮进行了两次更新，这种情况就不太方便用 for 循环实现。</p>
     */
    int whileLoopII(int n) {
        int res = 0;
        int i = 1;
        while (i <= n) {
            res += i;
            i++;
            i *= 2;
        }
        return res;
    }

    /**
     * 嵌套循环
     * <p>我们可以在一个循环结构内嵌套另一个循环结构，以 for 循环为例：</p>
     */
    String nestedForLoop(int n) {
        StringBuilder res = new StringBuilder();
        // 循环 i = 1, 2, ..., n-1, n
        for (int i = 1; i <= n; i++) {
            // 循环 j = 1, 2, ..., n-1, n
            for (int j = 1; j <= n; j++) {
                res.append("(" + i + ", " + j + "), ");
            }
        }
        return res.toString();
    }
}
