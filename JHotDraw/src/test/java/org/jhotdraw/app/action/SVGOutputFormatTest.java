/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;


import java.awt.KeyboardFocusManager;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import javax.swing.DefaultFocusManager;
import javax.swing.FocusManager;
import javax.swing.JTextField;
import net.n3.nanoxml.IXMLElement;
import org.jhotdraw.samples.svg.Gradient;
import org.jhotdraw.samples.svg.LinearGradient;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.FILL_GRADIENT;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.jhotdraw.samples.svg.io.SVGOutputFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stephanie
 */
public class SVGOutputFormatTest {
      public SVGOutputFormatTest() {
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
     * Test of actionPerformed method, of class CopyAction.
     */
    @Test
    public void testActionPerformed() {
        // TODO
    }

    @Test
    public void testAddingGradienttoList() {
        System.out.println("testAddingGradienttoList");

        // creating system under test
        SVGOutputFormat sut = new SVGOutputFormat();
        Gradient gradient = FILL_GRADIENT.get(new SVGRectFigure(0, 1, 1,1) );

        
        
        // running method that sould be tested
        String result = sut.addGradienttomap(gradient);
        
        // Asserts if the result is as expected.
        assertEquals(result, "0");        
    }
}
