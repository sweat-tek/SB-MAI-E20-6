/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import junit.framework.Assert;
import org.junit.Before;
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
    ToolBarAxis axis = mock(ToolBarAxis.class);
    ToolBarLayout layout = mock(ToolBarLayout.class);
    
    
    @Test
    public void TestToolBarAxis(){
        // Add the behavior of getXAxis
        Mockito.when(axis.getXAxis()).thenReturn(0); 
       
        // Test the behaviour of getXAxis
        Assert.assertEquals(0, axis.getXAxis());
        
        // Check if the getXAxis was called
        Mockito.verify(axis).getXAxis();
        
        // Add behaviour of getY
        Mockito.when(axis.getYAxis()).thenReturn(1);
        
        // Test the getY functionality
        Assert.assertEquals(1, axis.getYAxis());
        
        // Check if the getYAxis was called
        Mockito.verify(axis).getYAxis();
    }
    
    @Test
    public void TestToolBarLayout(){
        Mockito.when(layout.preferredLayoutSize(parent)).thenReturn(new Dimension());
        Assert.assertEquals(new Dimension(), layout.preferredLayoutSize(parent));  
    }

}
