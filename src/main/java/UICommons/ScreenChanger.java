/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UICommons;

import UI.MainJFrame;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Ankur Bywar
 */
public interface ScreenChanger {
    
    default void nextScreen(WorkArea workArea, JPanel nextScreen, String screenName) {
        workArea.getMainWorkArea().removeAll();
        workArea.getMainWorkArea().add(screenName , nextScreen);
        workArea.getMainWorkArea().setAlignmentX(SwingConstants.CENTER);
        workArea.getMainWorkArea().setAlignmentY(SwingConstants.CENTER);
        CardLayout layout = (CardLayout)workArea.getMainWorkArea().getLayout();
        Dimension d = nextScreen.getLayout().preferredLayoutSize(nextScreen);
        workArea.getMainJFrame().setSize(d);
        layout.next(workArea.getMainWorkArea()); 
    }
}
