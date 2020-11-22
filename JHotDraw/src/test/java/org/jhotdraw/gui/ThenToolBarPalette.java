/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.gui;

import com.tngtech.jgiven.Stage;
import java.awt.Container;

/**
 *
 * @author benja
 */

public class ThenToolBarPalette extends Stage<ThenToolBarPalette> {
    
    ToolBarLayout layout;
    Container container;
    public ThenToolBarPalette LayoutChangesAccordingly() {
     layout.preferredLayoutSize(container);
     return self();   
    }
    
}
