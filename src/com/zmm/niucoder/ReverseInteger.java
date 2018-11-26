import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int reverse(int x) {
        Queue<Integer> queue = new LinkedList<>();
        do {
            int mod = x % 10;
            queue.offer(mod);
        } while ((x /= 10) != 0);
        double i =  Math.pow(10, queue.size() - 1);
        int result = 0;
        boolean isStartWithZero = queue.peek().equals(0);
        while (!queue.isEmpty()) {
            if (isStartWithZero && queue.size() > 1) {
                queue.poll();
                isStartWithZero = queue.peek().equals(0);
                i /= 10;
                continue;
            }
            int currInt = queue.poll();
            if (Integer.MAX_VALUE - Math.abs(result) < Math.abs(currInt * i) || Math.abs(currInt * i) > Integer.MAX_VALUE) {
                return 0;
            }
            result += currInt * i;
            i = i / 10;
        }
        return result;
    }
	
	public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}