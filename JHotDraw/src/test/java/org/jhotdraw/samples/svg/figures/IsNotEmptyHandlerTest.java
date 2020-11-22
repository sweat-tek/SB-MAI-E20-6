/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.OPACITY;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
        

/**
 *
 * @author marc
 */
public class IsNotEmptyHandlerTest {

    Graphics2D g;
    
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        BufferedImage startingImg = new BufferedImage(500,500, BufferedImage.TYPE_INT_ARGB);
        g = startingImg.createGraphics();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void notEmptyHandlerTest(){
        IsNotEmptyHandler handler = new IsNotEmptyHandler();
        double opacity = 0.75;
        opacity = Math.min(Math.max(0d, opacity), 1d);
        Rectangle2D.Double drawingArea = new Rectangle2D.Double(50,250,30,210);
        BufferedImage buf = new BufferedImage(
                            Math.max(1, (int) ((2 + drawingArea.width) * g.getTransform().getScaleX())),
                            Math.max(1, (int) ((2 + drawingArea.height) * g.getTransform().getScaleY())),
                            BufferedImage.TYPE_INT_ARGB);
        Graphics2D fullGraphic = handleNonEmptyFull(g,opacity,drawingArea,buf);
        Graphics2D splitHandled = handler.handleNonEmpty1(g, opacity, drawingArea, buf);
        splitHandled = handler.handleNonEmpty2(g, opacity, drawingArea, splitHandled, buf);
        
        assertEquals(fullGraphic, splitHandled);
        
        
    }
    
    private Graphics2D handleNonEmptyFull(Graphics2D g, double opacity, Rectangle2D.Double drawingArea,BufferedImage buf){
        Graphics2D gr = buf.createGraphics();
                    gr.scale(g.getTransform().getScaleX(), g.getTransform().getScaleY());
                    gr.translate((int) -drawingArea.x, (int) -drawingArea.y);
                    gr.setRenderingHints(g.getRenderingHints());
                    gr.dispose();
                    Composite savedComposite = g.getComposite();
                    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
                    g.drawImage(buf, (int) drawingArea.x, (int) drawingArea.y,
                            2 + (int) drawingArea.width, 2 + (int) drawingArea.height, null);
                    g.setComposite(savedComposite);
                    return g;
    }
}
