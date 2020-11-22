/*
 * @(#)SVGAttributedFigure.java  1.0  December 10, 2006
 *
 * Copyright (c) 1996-2007 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import org.jhotdraw.draw.*;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;
import org.jhotdraw.samples.svg.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.util.*;
import org.jhotdraw.xml.*;

/**
 * SVGAttributedFigure.
 *
 * @author Werner Randelshofer
 * @version 1.0 December 10, 2006 Created.
 */
public abstract class SVGAttributedFigure extends AbstractAttributedFigure {

    /**
     * Creates a new instance.
     */
    public SVGAttributedFigure() {
    }

    public void draw(Graphics2D g) {
        double opacity = OPACITY.get(this);
        opacity = Math.min(Math.max(0d, opacity), 1d);
        if (opacity != 0d) {
            if (opacity != 1d) {
                Rectangle2D.Double drawingArea = getDrawingArea();

                Rectangle2D clipBounds = g.getClipBounds();
                if (clipBounds != null) {
                    Rectangle2D.intersect(drawingArea, clipBounds, drawingArea);
                }

                if (!drawingArea.isEmpty()) {

                    BufferedImage buf = new BufferedImage(
                            Math.max(1, (int) ((2 + drawingArea.width) * g.getTransform().getScaleX())),
                            Math.max(1, (int) ((2 + drawingArea.height) * g.getTransform().getScaleY())),
                            BufferedImage.TYPE_INT_ARGB);
                    Graphics2D gr = buf.createGraphics();
                    gr.scale(g.getTransform().getScaleX(), g.getTransform().getScaleY());
                    gr.translate((int) -drawingArea.x, (int) -drawingArea.y);
                    gr.setRenderingHints(g.getRenderingHints());
                    drawFigure(gr);
                    gr.dispose();
                    Composite savedComposite = g.getComposite();
                    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
                    g.drawImage(buf, (int) drawingArea.x, (int) drawingArea.y,
                            2 + (int) drawingArea.width, 2 + (int) drawingArea.height, null);
                    g.setComposite(savedComposite);
                }
            } else {
                drawFigure(g);
            }
        }
    }

    /**
     * This method is invoked before the rendered image of the figure is
     * composited.
     */
    public void drawFigure(Graphics2D g) {
        AffineTransform savedTransform = null;
        if (TRANSFORM.get(this) != null) {
            savedTransform = g.getTransform();
            g.transform(TRANSFORM.get(this));
        }

        Paint paint = SVGAttributeKeys.getFillPaint(this);
        if (paint != null) {
            g.setPaint(paint);
            drawFill(g);
        }
        paint = SVGAttributeKeys.getStrokePaint(this);
        if (paint != null && STROKE_WIDTH.get(this) > 0) {
            g.setPaint(paint);
            g.setStroke(SVGAttributeKeys.getStroke(this));
            drawStroke(g);
        }
        if (TRANSFORM.get(this) != null) {
            g.setTransform(savedTransform);
        }
    }

    @Override
    public <T> void setAttribute(AttributeKey<T> key, T newValue) {
        if (key == TRANSFORM) {
            invalidate();
        }
        super.setAttribute(key, newValue);
    }

    @Override
    public Collection<Action> getActions(Point2D.Double p) {
        LinkedList<Action> actions = new LinkedList<Action>();
        if (TRANSFORM.get(this) != null) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
            actions.add(new AbstractAction(labels.getString("edit.removeTransform.text")) {
                public void actionPerformed(ActionEvent evt) {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
                    SVGAttributedFigure.this.willChange();
                    fireUndoableEditHappened(
                            TRANSFORM.setUndoable(SVGAttributedFigure.this, null)
                    );
                    SVGAttributedFigure.this.changed();
                }
            });
        }
        return actions;
    }

    @Override
    final public void write(DOMOutput out) throws IOException {
        throw new UnsupportedOperationException("Use SVGStorableOutput to write this Figure.");
    }

    @Override
    final public void read(DOMInput in) throws IOException {
        throw new UnsupportedOperationException("Use SVGStorableInput to read this Figure.");
    }

    public Rectangle2D.Double getDrawingArea(Rectangle2D.Double cachedDrawingArea) {
        if (cachedDrawingArea == null) {
            Rectangle2D rx = getBounds();
            Rectangle2D.Double r = (rx instanceof Rectangle2D.Double)
                    ? (Rectangle2D.Double) rx
                    : new Rectangle2D.Double(rx.getX(), rx.getY(), rx.getWidth(), rx.getHeight());
            double g = SVGAttributeKeys.getPerpendicularHitGrowth(this);
            Geom.grow(r, g, g);
            if (TRANSFORM.get(this) == null) {
                cachedDrawingArea = r;
            } else {
                cachedDrawingArea = new Rectangle2D.Double();
                cachedDrawingArea.setRect(TRANSFORM.get(this).createTransformedShape(r).getBounds2D());
            }
        }
        return (Rectangle2D.Double) cachedDrawingArea.clone();
    }

    public void setFontSize(float size) {
        // FONT_SIZE.basicSet(this, new Double(size));
        Point2D.Double p = new Point2D.Double(0, size);
        AffineTransform tx = TRANSFORM.get(this);
        if (tx != null) {
            try {
                tx.inverseTransform(p, p);
                Point2D.Double p0 = new Point2D.Double(0, 0);
                tx.inverseTransform(p0, p0);
                p.y -= p0.y;
            } catch (NoninvertibleTransformException ex) {
                ex.printStackTrace();
            }
        }
        FONT_SIZE.set(this, Math.abs(p.y));
    }

    public float getFontSize() {
        //   return FONT_SIZE.get(this).floatValue();
        Point2D.Double p = new Point2D.Double(0, FONT_SIZE.get(this));
        AffineTransform tx = TRANSFORM.get(this);
        if (tx != null) {
            tx.transform(p, p);
            Point2D.Double p0 = new Point2D.Double(0, 0);
            tx.transform(p0, p0);
            p.y -= p0.y;
        }
        return (float) Math.abs(p.y);
    }
}
