package test;

public class Test_2 {
    public static void main(String[] args) {
        try{
            doSomeThing(1);
            doSomeThing(0);
            doSomeThing(-1);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("final !!!");
        }
        System.out.println("Continue...");
        System.out.println("Continue...");

    }

    public static void doSomeThing(int input) throws Exception{
        if(input > 0){
            System.out.println("okay");
        }
        else if (input == 0){
            throw new Exception("not okay");
        }
        else {
            System.out.println("okay");
        }
    }
}
