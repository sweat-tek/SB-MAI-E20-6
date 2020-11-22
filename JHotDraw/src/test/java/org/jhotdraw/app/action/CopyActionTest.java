package org.jhotdraw.app.action;

import java.awt.KeyboardFocusManager;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import javax.swing.DefaultFocusManager;
import javax.swing.FocusManager;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kevin Hansen
 */
public class CopyActionTest {

    public CopyActionTest() {
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
    public void testOnActionPerformed() {
        System.out.println("onActionPerformed");

        // example Component to be copied
        JTextField componentX = new JTextField("Copy me please and thank you");
        componentX.grabFocus();
        componentX.selectAll();
        // example ActionEvent
        ActionEvent evt = new ActionEvent(componentX, ActionEvent.ACTION_PERFORMED, "edit.copy");
        // CopyAction instance
        CopyAction instance = new CopyAction();
        instance.onActionPerformed(evt, componentX);

        // empty Component for comparison
        JTextField componentY = new JTextField("");

        // retrieve copied data from clipboard
        Transferable transferable = componentX.getToolkit().getSystemClipboard().getContents(componentY);
        // import to componentY
        componentY.getTransferHandler().importData(componentY, transferable);
        // assert whether componentY matches componentX (X was succesfully copied to Y)
        assertEquals(componentY.getText(), componentX.getText());
    }
}
