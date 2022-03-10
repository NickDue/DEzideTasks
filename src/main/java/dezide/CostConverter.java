package dezide;

public class CostConverter {
    private final double time;
    private final double money;
    private final Model model;

    public CostConverter(String[] args){
        this.time = Double.parseDouble(args[0]);
        this.money = Double.parseDouble(args[1]);
        ModelHandler m = new ModelHandler();
        this.model = m.detemineModel(args[2]);
        if (args.length > 3){
            ProcessCustomParameters(args);
        }
    }

    public double ConvertCost(boolean custom){
        double increase = model.ConvertCustomValues();
        double timeInHours = time / 60;
        return (timeInHours * model.getValue() + money) * (custom? increase: 1);
    }

    private void ProcessCustomParameters(String[] args){
        for (int i = 3; i < args.length; i++) {
            String[] splittedArg = args[i].split(":");
            HandleCustomParameters(splittedArg);
        }
    }

    private void HandleCustomParameters(String[] arg){
        String identifier = arg[0].toLowerCase();
        String value = arg[1];
        switch (identifier) {
            case "inconvenience" -> this.model.setInconvenience(value);
            case "risk" -> this.model.setRisk(value);
            default -> System.out.printf("Invalid custom parameter %s \n", identifier);
        }
    }

    public Model getModel() {
        return model;
    }

    public double getMoney() {
        return money;
    }

    public double getTime() {
        return time;
    }
}
