/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;



/**
 *
 * @author sjoeh
 */

public class QuadTreeDrawingTest {
    
    @Mock
    private Figure f1 = mock(Figure.class);
    private Figure f2 = mock(Figure.class);
    private Figure f3 = mock(Figure.class);
    
    private QuadTreeDrawing qtd = new QuadTreeDrawing();
    
    public QuadTreeDrawingTest() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ArrayList<Figure> figures = new ArrayList<>();
        figures.add(f1);
        figures.add(f2);
        figures.add(f3);
        qtd.setChildren(figures);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void sendToBackTest() {
        qtd.sendToBack(f2);
        Figure result = qtd.getChild(0);
        assertEquals(f2, result);
    }
    
    @Test
    public void bringToFrontTest() {
        qtd.bringToFront(f1);
        Figure result = qtd.getChild(2);
        assertEquals(f1, result);
    }
    
}
