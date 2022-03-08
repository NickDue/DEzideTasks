package dezide;
public class Run {
    private static double time, money;
    private static Model model;

    public static void main(String[] args) {
        if(args.length < 3){
            System.out.println("""
                    Not enough arguments, need at least three\s
                    1st Argument: Time measures in minutes\s
                    2nd Argument: Money cost\s
                    3rd Argument: Model identifier""");
            return;
        }
        CostConverter converter = new CostConverter(args);
        if (args.length == 3)
            System.out.println((int)Math.ceil(converter.ConvertCost(false)));
        else
            System.out.println((int)Math.ceil(converter.ConvertCost(true)));
    }
}
