package dezide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ModelTest {

    Model model;

    @Test
    @DisplayName("Able to change the risk value of a model")
    void TestChangeRiskValue(){
        model = Model.MODEL1234;
        String oldRiskValue = model.getRisk();
        model.setRisk("none");
        assertNotEquals(oldRiskValue, model.getRisk());
    }

    @Test
    @DisplayName("Able to change the inconvenience value of a model")
    void TestChangeInconvenienceValue(){
        model = Model.MODEL1234;
        String oldRiskValue = model.getInconvenience();
        model.setInconvenience("none");
        assertNotEquals(oldRiskValue, model.getRisk());
    }

    @Test
    @DisplayName("Each 'Low' value will increase the multiplier by 0.1")
    void TestLowValueIncrease(){
        DecimalFormat df = new DecimalFormat("0.0");
        model = Model.MODEL1234;
        model.setInconvenience("none");
        model.setRisk("none");
        assertEquals(1, model.ConvertCustomValues());

        model.setInconvenience("low");
        assertEquals("1,1", df.format(model.ConvertCustomValues()));

        model.setRisk("low");
        assertEquals("1,2", df.format(model.ConvertCustomValues()));
    }

    @Test
    @DisplayName("Each 'Medium' value will increase the multiplier by 0.3")
    void TestMediumValueIncrease(){
        DecimalFormat df = new DecimalFormat("0.0");
        model = Model.MODEL1234;
        model.setInconvenience("none");
        model.setRisk("none");
        assertEquals(1, model.ConvertCustomValues());

        model.setInconvenience("medium");
        assertEquals("1,3", df.format(model.ConvertCustomValues()));

        model.setRisk("medium");
        assertEquals("1,6", df.format(model.ConvertCustomValues()));
    }

    @Test
    @DisplayName("Each 'High' value will increase the multiplier by 1")
    void TestHighValueIncrease(){
        DecimalFormat df = new DecimalFormat("0.0");
        model = Model.MODEL1234;
        model.setInconvenience("none");
        model.setRisk("none");
        assertEquals(1, model.ConvertCustomValues());

        model.setInconvenience("high");
        assertEquals("2,0", df.format(model.ConvertCustomValues()));

        model.setRisk("high");
        assertEquals("3,0", df.format(model.ConvertCustomValues()));
    }

    @Test
    @DisplayName("Each 'None' value will not increase the multiplier")
    void TestNoneValueIncrease(){
        model = Model.MODEL1234;
        model.setInconvenience("none");
        model.setRisk("none");
        assertEquals(1, model.ConvertCustomValues());

    }

}
