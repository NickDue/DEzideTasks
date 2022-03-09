package dezide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CostConverterTest {
    CostConverter converter;

    @Test
    @DisplayName("Does return cost return the right result, without custom parameters, no matter the model")
    void TestConvertCost(){
        // test a known model, in this case Model1234
        String[] args = {"0.5", "275.50", "model1234"};
        converter = new CostConverter(args);
        ModelHandler handler = new ModelHandler();
        Model model = handler.detemineModel(args[2]);


        double expectedModel1234 = ((Double.parseDouble(args[0]))/60) * model.getValue() + Double.parseDouble(args[1]);
        double actualModel1234 = converter.ConvertCost(false);

        assertEquals(expectedModel1234, actualModel1234);


        // do the same test, but this time with the global model
        args = new String[]{"0.5", "275.50", "default"};
        converter = new CostConverter(args);
        model = handler.detemineModel(args[2]);


        double expectedGlobal = ((Double.parseDouble(args[0]))/60) * model.getValue() + Double.parseDouble(args[1]);
        double actualGlobal = converter.ConvertCost(false);

        assertEquals(expectedGlobal, actualGlobal);
    }

    @Test
    @DisplayName("CostConverter can handle custom parameters")
    void TestCustomParameterHandling(){
        String defaultInconValue = Model.MODEL1234.getInconvenience();
        String defaultRiskValue = Model.MODEL1234.getRisk();
        String[] args = {"0.5", "275.50", "model1234", "Inconvenience:none", "Risk:none"};
        converter = new CostConverter(args);

        assertNotEquals(defaultInconValue, converter.getModel().getInconvenience());
        assertNotEquals(defaultRiskValue, converter.getModel().getRisk());
    }
}
