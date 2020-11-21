/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import javax.swing.undo.AbstractUndoableEdit;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author haris
 */
public class TextUndoableEdit extends AbstractUndoableEdit {
    
    private TextHolderFigure editedFigure;
    private String oldText;
    private String newText;
    
    public TextUndoableEdit(TextHolderFigure editedF, String oldText, String newText){
        this.editedFigure = editedF;
        this.oldText = oldText;
        this.newText = newText;
    }
    
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
}
