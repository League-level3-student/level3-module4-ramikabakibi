package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
	//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
	//dfsfsd
	static Stack<Character> chars=new Stack<Character>();
    public static boolean doBracketsMatch(String b) {
    	for(int i=0; i<b.length(); i++) {
    		if(b.charAt(i)=='{') {
    			chars.push(b.charAt(i));
    			
    		}
    		else if(!chars.isEmpty()) {
    			if(b.charAt(i)=='}') {
    				chars.pop();
    			}
    		}
    		else if(chars.isEmpty()&&b.charAt(i)=='}') {
    			return false;
    		}
    	}
    	if(chars.isEmpty()) {
    		return true;
    	}
    	return false;
    
    	//BASICALLY THE LOGIC FOR THIS IS THAT WE HAVE STRINGS AND NEED TO SEE IF WE HAVING MATCHING LEFT AND RIGHT
    	//CURLY BRACKETS, SO THE FOR LOOP ABOVE SEES IF THERE IS A LEFT CURLY AND IF THERE IS THEN IT PUSHES IT TO
    	//A STACK. NOW I NEED ANOTHER FOR LOOP GOING THROUGH THE STRING B TO SEE IF THERE IS A RIGHT CURLY, AND IF
    	//THERE IS, THEN POP ONE OF THE LEFT CURLYS FROM THE STACK. THE TWO TESTS I NEED IS 1. IF AFTER THE END OF 
    	//THE FOR LOOPS, THE STACK IS EMPTY, THEN EVERYTHING WAS MATCHED,RETURN TRUE AND THEN ALSO, IF THERE IS A RIGHT CURLY 
    	//BRACKET, AND THE STACK IS EMPTY(NOTHING TO POP) THAT MEANS THAT ALL THE BRACKETS WERE NOT MATCHED, RETURN FALSE
    	
      
    }
}