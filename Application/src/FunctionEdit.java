public class FunctionEdit {
    Gui gui;
    public FunctionEdit(Gui gui) {
        this.gui = gui;

        
    }
    
    public void undo(){
        gui.undoManager.undo();
    }
    public void redo(){
        gui.undoManager.redo();
    }
}
