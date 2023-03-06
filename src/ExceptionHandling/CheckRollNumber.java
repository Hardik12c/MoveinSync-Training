package ExceptionHandling;

import java.util.Scanner;

class InvalidRollNumberException extends Exception{
    public InvalidRollNumberException(String msg){
        System.out.println(msg);
    }
}
public class CheckRollNumber {
    static long check(String roll)throws InvalidRollNumberException{
        if(roll.charAt(0)!='1' && roll.charAt(0)!='2'){
            throw new InvalidRollNumberException("Roll number's first digit must be either 1 or 2");
        }
        if(roll.length()<8){
            throw new InvalidRollNumberException("Roll number must have 8 digits");
        }
        for(int i=0;i<roll.length();i++){
            if(!Character.isDigit(roll.charAt(i))){
                throw new InvalidRollNumberException("Roll number should contain only digits");
            }
        }
        long num=Long.parseLong(roll);
        return num;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        String rollnumber=s.next();

        try {
            System.out.println(check(rollnumber));
        } catch (InvalidRollNumberException e) {

        }
    }
}
