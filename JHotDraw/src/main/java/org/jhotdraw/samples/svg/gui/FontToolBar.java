/*
 * @(#)StrokeToolBar.java  1.2  2008-05-23
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.samples.svg.gui;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import javax.swing.border.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.SliderUI;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.gui.FigureAttributeEditorHandler;
import org.jhotdraw.gui.JAttributeSlider;
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.JFontChooser;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.gui.plaf.palette.*;
import org.jhotdraw.text.FontFormatter;
import org.jhotdraw.text.JavaNumberFormatter;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * StrokeToolBar.
 *
 * @author Werner Randelshofer
 * @version 1.2 2008-05-23 Hide the toolbar if nothing is selected, and no
 * creation tool is active.
 * <br>1.1 2008-03-26 Don't draw button borders.
 * <br>1.0 May 1, 2007 Created.
 */
public class FontToolBar extends AbstractToolBar {

    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel(new GridBagLayout());
    JPanel panel2 = new JPanel(new GridBagLayout());
    JPanel panel3 = new JPanel(new GridBagLayout());
    
    GridBagConstraints gbc;
    AbstractButton btn;
    

    private SelectionComponentDisplayer displayer;

    /**
     * Creates new instance.
     */
    public FontToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString("font.toolbar"));
        JFontChooser.loadAllFonts();
        setDisclosureStateCount(3);
    }

    @Override
    public void setEditor(DrawingEditor newValue) {
        DrawingEditor oldValue = getEditor();
        if (displayer != null) {
            displayer.dispose();
            displayer = null;
        }
        super.setEditor(newValue);
        if (newValue != null) {
            displayer = new SelectionComponentDisplayer(editor, this) {

                @Override
                public void updateVisibility() {
                    boolean newValue = editor != null
                            && editor.getActiveView() != null
                            && (isVisibleIfCreationTool && ((editor.getTool() instanceof TextCreationTool) || editor.getTool() instanceof TextAreaCreationTool)
                            || containsTextHolderFigure(editor.getActiveView().getSelectedFigures()));
                    component.setVisible(newValue);

                    // The following is needed to trick BoxLayout
                    if (newValue) {
                        component.setPreferredSize(null);
                    } else {
                        component.setPreferredSize(new Dimension(0, 0));
                    }

                    component.revalidate();
                }

                private boolean containsTextHolderFigure(Collection<Figure> figures) {
                    for (Figure f : figures) {
                        if (f instanceof TextHolderFigure) {
                            return true;
                        } else if (f instanceof CompositeFigure) {
                            if (containsTextHolderFigure(((CompositeFigure) f).getChildren())) {
                                return true;
                            }
                        }
                    }
                    return false;

                }
            };
        }
    }

    private void initialize() 
    {
        panel.setBorder(new EmptyBorder(5, 5, 5, 8));

        panel.setOpaque(false);
        panel1.setOpaque(false);
        panel2.setOpaque(false);
        panel3.setOpaque(false);
        
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
    }

    private void fontFacePopupUI(int columnAmount, int gridW) 
    {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        
        JAttributeTextField<Font> faceField = new JAttributeTextField<>();

        faceField.setColumns(columnAmount);
        faceField.setToolTipText(labels.getString("attribute.font.toolTipText"));
        faceField.setHorizontalAlignment(JAttributeTextField.RIGHT);
        faceField.putClientProperty("Palette.Component.segmentPosition", "first");
        faceField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(faceField));
        faceField.setHorizontalAlignment(JTextField.LEADING);
        faceField.setFormatterFactory(FontFormatter.createFormatterFactory());

        new FigureAttributeEditorHandler<>(FONT_FACE, faceField, editor);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = gridW;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(faceField, gbc);
        btn = ButtonFactory.createFontButton(editor, labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(btn, gbc);
    }

    private void fontSizeSliderUI() 
    {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        
        JAttributeTextField<Double> sizeField = new JAttributeTextField<>();
        
        sizeField.setColumns(1);
        sizeField.setToolTipText(labels.getString("attribute.fontSize.toolTipText"));
        sizeField.setHorizontalAlignment(JAttributeTextField.RIGHT);
        sizeField.putClientProperty("Palette.Component.segmentPosition", "first");
        sizeField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(sizeField));
        sizeField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(0d, 1000d, 1d));
        sizeField.setHorizontalAlignment(JTextField.LEADING);
        new FigureAttributeEditorHandler<Double>(FONT_SIZE, sizeField, editor);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(3, 0, 0, 0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = 2;
        gbc.weightx=1f;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(sizeField, gbc);
        
        JPopupButton sizePopupButton = new JPopupButton();
        JAttributeSlider sizeSlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 12);
        sizePopupButton.add(sizeSlider);
        labels.configureToolBarButton(sizePopupButton, "attribute.fontSize");
        sizePopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(sizePopupButton));
        sizePopupButton.setPopupAnchor(SOUTH_EAST);
        
        new SelectionComponentRepainter(editor, sizePopupButton);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(3, 0, 0, 0);
        panel2.add(sizePopupButton, gbc);
        sizeSlider.setUI((SliderUI) PaletteSliderUI.createUI(sizeSlider));
        sizeSlider.setScaleFactor(1d);
        
        new FigureAttributeEditorHandler<Double>(FONT_SIZE, sizeSlider, editor);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth=2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(panel2, gbc);
    }

    private void fontStyleButtonsUI() 
    {
        
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        
        btn = ButtonFactory.createFontStyleBoldButton(editor, labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        btn.putClientProperty("Palette.Component.segmentPosition", "first");
        gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 0);
        panel.add(btn, gbc);
        
        btn = ButtonFactory.createFontStyleItalicButton(editor, labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        btn.putClientProperty("Palette.Component.segmentPosition", "middle");
        gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 0);
        panel.add(btn, gbc);
        
        btn = ButtonFactory.createFontStyleUnderlineButton(editor, labels);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        btn.putClientProperty("Palette.Component.segmentPosition", "last");
        gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(btn, gbc);
    }

    @Override
    protected String getID() 
    {
        return "font";
    }

    @Override
    protected int getDefaultDisclosureState() 
    {
        return 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
