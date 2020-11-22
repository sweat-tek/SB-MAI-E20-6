/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author admin
 */
public class TextAreaEditingToolTest {
    
    public TextAreaEditingToolTest() {
    }
    
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
     * Test of deactivate method, of class TextAreaEditingTool.
     */
    @Test
    public void testDeactivate() {
        System.out.println("deactivate");
        DrawingEditor editor = null;
        TextAreaEditingTool instance = null;
        instance.deactivate(editor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mousePressed method, of class TextAreaEditingTool.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = null;
        TextAreaEditingTool instance = null;
        instance.mousePressed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class TextAreaEditingTool.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics2D g = null;
        TextAreaEditingTool instance = null;
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of beginEdit method, of class TextAreaEditingTool.
     */
    @Test
    public void testBeginEdit() {
        System.out.println("beginEdit");
        TextHolderFigure textHolder = null;
        TextAreaEditingTool instance = null;
        instance.beginEdit(textHolder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endEdit method, of class TextAreaEditingTool.
     */
    @Test
    public void testEndEdit() {
        System.out.println("endEdit");
        TextAreaEditingTool instance = null;
        instance.endEdit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class TextAreaEditingTool.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent event = null;
        TextAreaEditingTool instance = null;
        instance.actionPerformed(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseDragged method, of class TextAreaEditingTool.
     */
    @Test
    public void testMouseDragged() {
        System.out.println("mouseDragged");
        MouseEvent e = null;
        TextAreaEditingTool instance = null;
        instance.mouseDragged(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
