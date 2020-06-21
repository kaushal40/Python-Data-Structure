public static int evaluate(char[] expression){
    if (expression == null || expression.length == 0){
        return 0;
    }

    Stack<Integer> operand = new Stack<Integer>();
    Stack<Integer> operator = new Stack<Integer>();

    for (char c : expression){
        // If it is number add it to list
        if(isOperand(c)){
            operand.push(ch-'0');
        }
        // if operator add it to operators and if the operator precedence is lower or equal to one below process available operator deom the stack
        else if (isOperator(ch)) {
            while(!operator.isEmpty() && precedence(operator.peek()) >= precedence(ch)){
                process(opeartor, operand)
            }
            operator.push(ch);
        } // add below code if perentheses needs to be processed opening bracket add and closing bracket process
        else if (ch == '(') {            
            operator.push(ch);        
        } 
        else if (ch == ')') 
        {            
            while (operator.peek() != '(') {                
                process(operator, operand);            
            }            
            operator.pop();
        }
    }

    while (!operator.isEmpty()) {        
        process(operator, operand);    
    }
    return operand.pop();
}

//helper method

private static boolean isOperand(char ch) {
    return (ch >= '0') && (ch <= '9');
}

private static boo​lean isOperator(char ch) {    
    return ch == '+' || ch == '-' || ch == '*' || ch == '/';
}

private static int precedence(char ch) {    
    switch(ch) {        
        case '/':        
        case '*': 
            return 2;        
        case '+':        
        case '-': 
            return 1;        
        default: 
            throw new IllegalArgumentException("Invalid operator: " + ch);    
        }
}


private static void process(Stack<Character> operator, Stack<Integer> operand) {    
    int num2 = operand.pop();    
    int num1 = operand.pop();    
    char op = operator.pop();    
    int result = 0;    
    switch(op) {        
        case '/': r
            esult = num1 / num2;            
            break;        
        case '*': 
            result = num1 * num2;            
            break;        
        case '+': 
            result = num1 + num2;            
            break;        
        case '-': 
            result = num1 - num2;            
            break;    
        }    
        operand.push(result);
}
