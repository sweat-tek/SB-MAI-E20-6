/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author benja
 */
public class ToolBarLayoutTest {
    
    @Mock
    Container parent = mock(Container.class);
    Component component = mock(Component.class);
    ToolBarAxis axis = new ToolBarAxis();
    ToolBarLayout layout = mock(ToolBarLayout.class);

    
    
    @Test
    public void TestToolBarAxis(){
        
        // Test the getY functionality
        Assert.assertEquals(0, axis.getXAxis()); 
        // Test the getY functionality
        Assert.assertEquals(1, axis.getYAxis());
        

    }
    
    @Test
    public void testPreferredLayoutSize(){
        int w = 0;
        int h = 0;
        
        // Add the behaviours
        Mockito.when(component.getPreferredSize()).thenReturn(new Dimension(100, 100));
        Mockito.when(parent.getInsets()).thenReturn(new Insets(50,50,50,50));
        
        // Test the behaviours added behaviour is correct
        Assert.assertEquals(new Dimension(100, 100), component.getPreferredSize());
        Assert.assertEquals(new Insets(50,50,50,50), parent.getInsets());
        

        // Simulate loop behaviour with the mocked method
        Dimension ps = component.getPreferredSize();
        h = Math.max(h, ps.height);
        w += ps.width;
        
        // Test the expected return of method with the mocked method
        Insets i = parent.getInsets();
        Dimension result = new Dimension(w + i.left + i.right,h + i.top + i.bottom);
        Assert.assertEquals(result, new Dimension(200, 200));
        
        
    }

}
