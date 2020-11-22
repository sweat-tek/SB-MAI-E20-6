/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.gui;

import com.tngtech.jgiven.Stage;
import junit.framework.Assert;


/**
 *
 * @author benja
 */
public class WhenToolBarPalette extends Stage<WhenToolBarPalette> {
    
    ToolBarLayout layout = new ToolBarLayout();
    public WhenToolBarPalette LayoutIsSetToYAxis() {
     layout.setAlignmentY();       
     return self();   
    }
    
    public void AlignmentIsY(){
        Assert.assertEquals(layout.axis, layout.Axis.getYAxis());
        
    }
    
}