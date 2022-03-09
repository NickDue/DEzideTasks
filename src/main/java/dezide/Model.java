package dezide;

public enum Model {
        GLOBAL("Global", 300, "low", "high"),
        MODEL1234("model1234", 500, "high", "medium");

        Model(String modelName, int value, String risk, String inconvenience){
            this.name = modelName;
            this.value = value;
            this.risk = risk;
            this.inconvenience = inconvenience;
        }

        public final String name;
        public final int value;
        public String risk;
        public String inconvenience;

        public double ConvertCustomValues(){
            double increase = 1;
            switch (risk) {
                case "low" -> increase += 0.1;
                case "medium" -> increase += 0.3;
                case "high" -> increase += 1;
                case "none" -> increase += 0;
            }
            switch (inconvenience) {
                case "low" -> increase += 0.1;
                case "medium" -> increase += 0.3;
                case "high" -> increase += 1;
                case "none" -> increase += 0;
            }
            return increase;
        }

    public void setInconvenience(String inconvenience) {
        this.inconvenience = inconvenience;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getRisk() {
        return risk;
    }

    public String getInconvenience() {
        return inconvenience;
    }
}

