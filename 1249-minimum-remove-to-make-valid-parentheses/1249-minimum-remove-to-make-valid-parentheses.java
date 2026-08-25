class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();

        int open = 0;

        // First pass: remove invalid ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                result.append(c);
            } 
            else if (c == ')') {
                if (open > 0) {
                    open--;
                    result.append(c);
                }
            } 
            else {
                result.append(c);
            }
        }

        // Second pass: remove extra '('
        StringBuilder answer = new StringBuilder();

        for (int i = result.length() - 1; i >= 0; i--) {
            char c = result.charAt(i);

            if (c == '(' && open > 0) {
                open--;
                continue;
            }

            answer.append(c);
        }

        return answer.reverse().toString();
    }
}