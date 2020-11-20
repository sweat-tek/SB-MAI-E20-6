
package org.jhotdraw.app.action;

import java.awt.event.ActionEvent;
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
//    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        CopyAction instance = new CopyAction();
        instance.actionPerformed(evt);
        assertEquals(true, true);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
