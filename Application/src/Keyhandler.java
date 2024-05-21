import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Author- Shuvaranjan Sarkar
 */
public class Keyhandler implements KeyListener {
    Gui gui;
public Keyhandler(Gui gui){
    this.gui=gui;

}
    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
      if ( e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
        gui.file.newSave();
        
      }
      if ( e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S) {
        gui.file.saveAs();
        
      }
      if ( e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        gui.file.exit();
        
      }
      if ( e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
        gui.file.newFile();
        
      }
      if ( e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
        gui.file.newOpen();
        
      }
      if ( e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
        gui.functionEdit.undo();
        
      }
      if ( e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y) {
        gui.functionEdit.redo();
        
      }
      if ( e.isControlDown() && e.getKeyCode() == KeyEvent.VK_J) {
        gui.functionAbout.About();
        
      }
      if ( e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P) {
        gui.file.Print();
        
      }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
}
