/**
 * @(#)ToolBarLayout.java  1.0  Apr 13, 2008
 *
 * Copyright (c) 2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.gui;

import java.awt.*;
import java.io.Serializable;
import javax.swing.BoxLayout;

/**
 * A layout which lays out components horizontally or vertically according
 * to their preferred size.
 *
 * @author Werner Randelshofer
 * @version 1.0 Apr 13, 2008 Created.
 */
public class ToolBarLayout implements LayoutManager2, Serializable {
    
    ToolBarAxis Axis = new ToolBarAxis();
    private int axis= Axis.getXAxis();


    public ToolBarLayout() {  
    }
    /**
     * Creates a layout manager that will lay out components along the
     * given axis.  
     *
     * @param axis  the axis to lay out components along. Can be one of:
     *              <code>BoxLayout.X_AXIS</code>,
     *              <code>BoxLayout.Y_AXIS</code>,
     *
     * @exception AWTError  if the value of <code>axis</code> is invalid 
     */
    public ToolBarLayout(int axis) {
        this.axis = axis;
    }


    public void addLayoutComponent(Component comp, Object constraints) {
    }

    public Dimension maximumLayoutSize(Container target) {
        return preferredLayoutSize(target);
    }

    public float getLayoutAlignmentX(Container target) {
        if(axis == Axis.getXAxis()){
        }
        if(axis == Axis.getYAxis()){
            return 0f;
        }
        
        return 0f;    
        
    // -- DEPRECATED CODE --          
    //        switch (axis) {
    //            case Y_AXIS:
    //                return 0f;
    //            case X_AXIS:
    //            default:
    //                return 0f;
        
    }

    public float getLayoutAlignmentY(Container target) {
        
////     -- DEPRECATED CODE --     
//            switch (axis) {
//                case Y_AXIS:
//                    return 0f;
//                case X_AXIS:
//                default:
//                    return 0f;
//            }
//    
        if(this.axis == Axis.getXAxis()){
            
        }
        if(this.axis == Axis.getYAxis()){
            return 0f;
        }
        
        return 0f;
    }

    public void invalidateLayout(Container target) {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        int w = 0;
        int h = 0;
        System.out.println("THIS IS PARENT" + parent);
        
        if(axis == Axis.getXAxis()){
                for (Component c : parent.getComponents()) {
                    Dimension ps = c.getPreferredSize();
                    h = Math.max(h, ps.height);
                    w += ps.width;
                }  
        }
        if(axis == Axis.getYAxis()){
            for (Component c : parent.getComponents()) {
                    Dimension ps = c.getPreferredSize();
                    w = Math.max(w, ps.width);
                    h += ps.height;
                
            }    
        }  
//        switch (axis) {
//            case 1:
//                for (Component c : parent.getComponents()) {
//                    Dimension ps = c.getPreferredSize();
//                    w = Math.max(w, ps.width);
//                    h += ps.height;
//                }
//                break;
//            case 0:
//            default:
//                for (Component c : parent.getComponents()) {
//                    Dimension ps = c.getPreferredSize();
//                    h = Math.max(h, ps.height);
//                    w += ps.width;
//                }
//        }
        
        Insets i = parent.getInsets();
        
        return new Dimension(w + i.left + i.right, h + i.top + i.bottom);
    }

    public Dimension minimumLayoutSize(Container parent) {
        return preferredLayoutSize(parent);
    }

    public void layoutContainer(Container parent) {
        Dimension ps = preferredLayoutSize(parent);
        System.out.println(ps);
        assert ps != null;
        
        Insets insets = parent.getInsets();
        
        int w = ps.width - insets.left - insets.right;
        int h = ps.height - insets.top - insets.bottom;
        int x = insets.left;
        int y = insets.top;
        
        if(axis == Axis.getXAxis()){
                for (Component c : parent.getComponents()) {
                    ps = c.getPreferredSize();
                    c.setBounds(x, y, ps.width, h);
                    x += ps.width;
                }
        }
        if(axis == Axis.getYAxis()){
                for (Component c : parent.getComponents()) {
                    ps = c.getPreferredSize();
                    c.setBounds(x, y, w, ps.height);
                    y += ps.height;
                }
            }
 
//        switch (axis) {
//            case 1:
//                for (Component c : parent.getComponents()) {
//                    ps = c.getPreferredSize();
//                    c.setBounds(x, y, w, ps.height);
//                    y += ps.height;
//                }
//                break;
//            case 0:
//            default:
//                for (Component c : parent.getComponents()) {
//                    ps = c.getPreferredSize();
//                    c.setBounds(x, y, ps.width, h);
//                    x += ps.width;
//                }
//        }
    }
}
        



        

    

