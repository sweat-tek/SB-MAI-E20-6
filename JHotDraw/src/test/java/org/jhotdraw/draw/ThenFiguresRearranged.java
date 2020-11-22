/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.*;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author sjoeh
 */
class ThenFiguresRearranged extends Stage<ThenFiguresRearranged> {
    
    @ExpectedScenarioState
    ArrayList<Figure> figures;
    
    @ExpectedScenarioState
    ArrayList<Figure> figuresReference;
    
    @ExpectedScenarioState
    QuadTreeDrawing qtd;
    
    @ExpectedScenarioState
    int pos;
    
    Figure figure;
    
    public ThenFiguresRearranged isSentToBack(){
        Figure result = qtd.getChild(pos);
        assertThat(figure).isEqualTo(result);
        return self();
    }
    
    public ThenFiguresRearranged isBroughtToFront() {
        Figure result = qtd.getChild(pos);
        assertThat(figure).isEqualTo(result);
        return self();
    }
    
    public ThenFiguresRearranged figure(int pos) {
       figure = figuresReference.get(pos);
       return self();
    }
}
