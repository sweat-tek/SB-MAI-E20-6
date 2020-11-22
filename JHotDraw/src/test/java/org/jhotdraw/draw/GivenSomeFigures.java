/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.*;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;

/**
 *
 * @author sjoeh
 */
class GivenSomeFigures extends Stage<GivenSomeFigures> {
    
    @ProvidedScenarioState
    ArrayList<Figure> figures = new ArrayList<>();
    
    @ProvidedScenarioState
    ArrayList<Figure> figuresReference = new ArrayList<>();
    
    public GivenSomeFigures figure(){
        Figure f = mock(Figure.class);
        figures.add(f);
        figuresReference.add(f);
        return self();
    }
    
}
