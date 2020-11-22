/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author sjoeh
 */
public class JGivenTest extends ScenarioTest<GivenSomeFigures, WhenChangingArrangement, ThenFiguresRearranged> {
    
    @Test
    public void SendToBackTest() {
        given().figure()
                .and().figure()
                .and().figure();
        when().figure(1).and().sendToBack();
        then().figure(1).isSentToBack();
    }
    
    @Test
    public void BringToFrontTest() {
        given().figure()
                .and().figure()
                .and().figure();
        when().figure(1).and().bringToFront();
        then().figure(1).isBroughtToFront();
    }
}
