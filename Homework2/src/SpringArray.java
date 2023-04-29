import java.util.Stack;

public class SpringArray {

    public static Spring equivalentSpring(String springExpr) {
        Stack<Spring> stack = new Stack<>();

        for (char c : springExpr.toCharArray()) {
            if (c == '[') {
                stack.push(new Spring());
            } else if (c == '{') {
                stack.push(new Spring(1));
            } else if (c == '}') {
                Spring s = stack.pop();
                if (stack.isEmpty()) {
                    return s;
                }
                stack.peek().inSeries(s);
            } else if (c == ']') {
                Spring s = stack.pop();
                if (stack.isEmpty()) {
                    return s;
                }
                stack.peek().inParallel(s);
            }
        }

        return stack.pop();
    }

    public static Spring equivalentSpring(String springExpr, Spring[] springs) {
        Stack<Spring> stack = new Stack<>();

        for (char c : springExpr.toCharArray()) {
            if (c == '[') {
                stack.push(springs[0]);
            } else if (c == '{') {
                stack.push(new Spring(1));
            } else if (c == '}') {
                Spring s = stack.pop();
                if (stack.isEmpty()) {
                    return s;
                }
                stack.peek().inSeries(s);
            } else if (c == ']') {
                Spring s = stack.pop();
                if (stack.isEmpty()) {
                    return s;
                }
                stack.peek().inParallel(s);
            }
        }

        return stack.pop();
    }

    // I used chatGPT in some places

}