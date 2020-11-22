/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Color;
import java.awt.geom.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author haris
 */
public class SVGTextFigureTest {

    public SVGTextFigureTest() {
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

    /**
     * Test of get and setCoordinates, of class SVGTextFigure.
     */
    @Test
    public void testSetCoordinates() {
        System.out.println("setCoordinates");
        SVGTextFigure instance = new SVGTextFigure();
        Point2D.Double[] coordinates = instance.getCoordinates();
        instance.setCoordinates(new Point2D.Double[]{new Point2D.Double(3, 3)});
        assertNotEquals(coordinates, instance.getCoordinates());
    }

    /**
     * Test of getText method, of class SVGTextFigure.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        SVGTextFigure instance = new SVGTextFigure();
        String expResult = "Text";
        String result = instance.getText();
        assertEquals(expResult, result);
    }

    /**
     * Test of setText method, of class SVGTextFigure.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String newText = "Testing";
        SVGTextFigure instance = new SVGTextFigure();
        instance.setText(newText);
        assertEquals("Testing", instance.getText());
    }

    /**
     * Test of getFont method and the upper boundary, of class SVGTextFigure.
     */
    @Test
    public void testFontSize() {
        System.out.println("fontSize");
        SVGTextFigure instance = new SVGTextFigure();
        float expResult = instance.getFontSize();
        instance.setFontSize(Float.MAX_VALUE);
        float result = instance.getFontSize();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getTextColor method, of class SVGTextFigure.
     */
    @Test
    public void testGetTextColor() {
        System.out.println("getTextColor");
        SVGTextFigure instance = new SVGTextFigure();
        Color expResult = Color.black;
        Color result = instance.getTextColor();
        assertEquals(expResult, result);
    }

    @Test
    public void assertExistence() {
        System.out.println("assert SVGTextFigure not null");
        SVGTextFigure instance = new SVGTextFigure();
        assert instance != null;
    }
}
