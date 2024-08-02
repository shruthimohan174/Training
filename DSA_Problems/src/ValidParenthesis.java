//https://leetcode.com/problems/valid-parentheses/description/
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String args[]){
        String expr = "([{}]])";

        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }

    private static boolean areBracketsBalanced(String expr) {
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<expr.length();i++){
            char ch= expr.charAt(i);
            if(ch=='{' || ch=='[' || ch=='('){
                stack.push(ch);
            }
            else{
                if(!stack.isEmpty()){
                    char top=stack.peek();
                    if(top=='{' && ch=='}' || top=='[' && ch==']' || top=='(' && ch==')')
                        stack.pop();
                    else
                        return false;

                }else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
