package org.jhotdraw.gui;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author benja
 */
public class JGivenTest extends ScenarioTest<GivenToolBarPalette, WhenToolBarPalette, ThenToolBarPalette> {
    
    @Test
    public void test(){
        given().AxisIsX();
        when().LayoutIsSetToYAxis();
        then().LayoutChangesAccordingly(); 
    }
    
    
}



