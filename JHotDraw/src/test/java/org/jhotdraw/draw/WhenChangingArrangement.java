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
class WhenChangingArrangement extends Stage<WhenChangingArrangement> {
    
    @ExpectedScenarioState
    ArrayList<Figure> figures;
    
    @ProvidedScenarioState
    int pos;
    
    @ProvidedScenarioState
    Figure figure;
    
    @ProvidedScenarioState
    QuadTreeDrawing qtd;
    
    @BeforeStage
    public void before() {
        qtd = new QuadTreeDrawing();
        qtd.setChildren(figures);
    }
    
    public WhenChangingArrangement figure(int pos) {
        assertThat(figures).isNotEmpty();
        this.pos = pos;
        return self();
    }
    
    public WhenChangingArrangement sendToBack() {
        assertThat(qtd).isNotNull();
        qtd.sendToBack(figure);
        return self();
    }
    
    public WhenChangingArrangement bringToFront() {
        assertThat(qtd).isNotNull();
        qtd.bringToFront(figure);
        return self();
    }
}
