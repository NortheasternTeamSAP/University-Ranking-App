/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UICommons;

import UI.MainJFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ankur Bywar
 */
public class WorkArea {
    JPanel mainWorkArea;
    MainJFrame mainJFrame;

    public JPanel getMainWorkArea() {
        return mainWorkArea;
    }

    public void setMainWorkArea(JPanel mainWorkArea) {
        this.mainWorkArea = mainWorkArea;
    }

    public MainJFrame getMainJFrame() {
        return mainJFrame;
    }

    public void setMainJFrame(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
    }
}
