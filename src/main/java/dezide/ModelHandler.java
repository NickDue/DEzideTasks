package dezide;

public class ModelHandler {

    public Model detemineModel(String name){
        if (name == null){
            return Model.GLOBAL;
        }
        name = name.toLowerCase();
        for (Model m: Model.values()) {
            if (m.name.toLowerCase().equals(name))
                return m;
        }
        return Model.GLOBAL;
    }


}
