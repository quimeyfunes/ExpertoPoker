/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import javax.swing.JPanel;

/**
 *
 * @author alverbner
 */
public abstract class Step extends JPanel {

    private boolean active = true;

    public boolean isActive(){
        return this.active;
    }

    protected void setActive(boolean active){
        this.active = active;
    }

    public abstract boolean executeStep();
}
