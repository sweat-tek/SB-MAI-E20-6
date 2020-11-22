/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author admin
 */
public class TextAreaCreationToolTest {
    
    public TextAreaCreationToolTest() {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    /*
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setRubberbandColor method, of class TextAreaCreationTool.
     */
    @org.junit.jupiter.api.Test
    public void testSetRubberbandColor() {
        System.out.println("setRubberbandColor");
        Color c = null;
        TextAreaCreationTool instance = null;
        instance.setRubberbandColor(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deactivate method, of class TextAreaCreationTool.
     */
    @org.junit.jupiter.api.Test
    public void testDeactivate() {
        System.out.println("deactivate");
        DrawingEditor editor = null;
        TextAreaCreationTool instance = null;
        instance.deactivate(editor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mousePressed method, of class TextAreaCreationTool.
     */
    @org.junit.jupiter.api.Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;
        TextAreaCreationTool instance = null;
        instance.mousePressed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pointCheck method, of class TextAreaCreationTool.
     */
    @org.junit.jupiter.api.Test
    public void testPointCheck() {
        System.out.println("pointCheck");
        Figure pressedFigure = null;
        Point2D.Double p = null;
        TextHolderFigure textHolder = null;
        MouseEvent e = null;
        TextAreaCreationTool instance = null;
        instance.pointCheck(pressedFigure, p, textHolder, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creationFinished method, of class TextAreaCreationTool.
     */
    @org.junit.jupiter.api.Test
    public void testCreationFinished() {
        System.out.println("creationFinished");
        Figure createdFigure = null;
        TextAreaCreationTool instance = null;
        instance.creationFinished(createdFigure);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class TextAreaCreationTool.
     */
    @org.junit.jupiter.api.Test
    public void testDraw() {
        System.out.println("draw");
        Graphics2D g = null;
        TextAreaCreationTool instance = null;
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of beginEdit method, of class TextAreaCreationTool.
     */
    @org.junit.jupiter.api.Test
    public void testBeginEdit() {
        System.out.println("beginEdit");
        TextHolderFigure textHolder = null;
        TextAreaCreationTool instance = null;
        instance.beginEdit(textHolder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endEdit method, of class TextAreaCreationTool.
     */
    @org.junit.jupiter.api.Test
    public void testEndEdit() {
        System.out.println("endEdit");
        TextAreaCreationTool instance = null;
        instance.endEdit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class TextAreaCreationTool.
     */
    @org.junit.jupiter.api.Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent event = null;
        TextAreaCreationTool instance = null;
        instance.actionPerformed(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
