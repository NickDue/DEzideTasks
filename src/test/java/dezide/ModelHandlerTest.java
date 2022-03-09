package dezide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelHandlerTest {

    ModelHandler handler;

    @BeforeEach
    void setup(){
        handler = new ModelHandler();
    }

    @Test
    @DisplayName("Unknown or null model returns the global model")
    void testUnknownModel(){
        assertEquals(Model.GLOBAL, handler.detemineModel("model1"),
                "Should return the global model when an unknown model tries to be chosen.");
        assertEquals(Model.GLOBAL, handler.detemineModel(null),
                "Should return the global model when a null model tries to be chosen.");
    }

    @Test
    @DisplayName("Known model \"Model1234\" should return Model1234")
    void testModel1234(){
        assertEquals(Model.MODEL1234, handler.detemineModel("model1234"), "Should return model1234, since it is known");
    }

    @Test
    @DisplayName("The model input should not be case sensitive")
    void testNoCaseSenstivity(){
        assertEquals(Model.MODEL1234, handler.detemineModel("MoDeL1234"), "Should return model1234, by not being case sensitive");
        assertEquals(Model.MODEL1234, handler.detemineModel("MODEL1234"), "Should return model1234, by not being case sensitive");
        assertEquals(Model.MODEL1234, handler.detemineModel("mOdEl1234"), "Should return model1234, by not being case sensitive");
    }

}
