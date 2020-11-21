/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.gui;

import com.tngtech.jgiven.Stage;

/**
 *
 * @author benja
 */
public class GivenToolBarPalette extends Stage<GivenToolBarPalette> {
    
    public GivenToolBarPalette AxisIsX() {
        ToolBarLayout layout = new ToolBarLayout();
        layout.axis = layout.Axis.getXAxis();
        return self();
    }
}