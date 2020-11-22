/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.Connector;
import org.jhotdraw.draw.Handle;
import org.jhotdraw.draw.TextHolderFigure;
import org.jhotdraw.draw.Tool;
import org.jhotdraw.geom.Dimension2DDouble;
import org.jhotdraw.geom.Insets2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adooz
 */
public class SVGTextAreaFigureTest {
    
    public SVGTextAreaFigureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetFont() {
        System.out.println("getFont");
        SVGTextAreaFigure instance = new SVGTextAreaFigure();
        Font expResult = new Font("VERDANA", Font.PLAIN, 12);
        Font result = instance.getFont();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetFontSize() {
        System.out.println("setFontSize");
        float size = 6;
        SVGTextAreaFigure instance = new SVGTextAreaFigure();
        instance.setFontSize(size);
    }

    @Test
    public void testGetFontSize() {
        System.out.println("getFontSize");
        SVGTextAreaFigure instance = new SVGTextAreaFigure();
        float expResult = 12;
        float result = instance.getFontSize();
        assertEquals(expResult, result, 0.0);
    }
}
