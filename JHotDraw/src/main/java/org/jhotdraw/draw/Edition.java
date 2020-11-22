
  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.geom.*;
import org.jhotdraw.util.ResourceBundleUtil;
/**
 *
 * @author mkkl
 */
public class Edition {
    
    public static UndoableEdit endEditHelper(FloatingTextArea textArea, TextHolderFigure typingTarget) {
        if (typingTarget != null) {
            typingTarget.willChange();

            final TextHolderFigure editedFigure = typingTarget;
            final String oldText = typingTarget.getText();
            final String newText = textArea.getText();

            if (newText.length() > 0) {
                typingTarget.setText(newText);
            } else {
                    typingTarget.setText("");
            }

            UndoableEdit edit = new AbstractUndoableEdit() {

                @Override
                public String getPresentationName() {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                    return labels.getString("attribute.text.text");
                }

                @Override
                public void undo() {
                    super.undo();
                    editedFigure.willChange();
                    editedFigure.setText(oldText);
                    editedFigure.changed();
                }

                @Override
                public void redo() {
                    super.redo();
                    editedFigure.willChange();
                    editedFigure.setText(newText);
                    editedFigure.changed();
                }
            };
            return edit;
        }
        return null;
    }
}
