import java.util.ArrayList;

public class Gamestate {
    private ArrayList<BoardObject> boardobjects;
    private int tick=0;
    public Gamestate(){
        boardobjects=new ArrayList<>();
    }
    //This function should be overriden as much as possible for many parameters certain objects may have, maybe even return array of objects
    public BoardObject getBoardObject(int index){
        if(index<boardobjects.size() && index>=0) {
            return boardobjects.get(index);
        }
        System.out.println("Invalid index, returning null");
        return null;
    }
    public void addBoardObject(BoardObject bObj){
        boardobjects.add(bObj);
    }
    public int getBoardObjectsSize(){
        return boardobjects.size();
    }
    public void tickGame(){
        double doubleTick=(double)tick;
        BoardObject obj=boardobjects.get(0);
        //obj.setPosX(obj.getPosX()+(int)(Math.cos(doubleTick/17)*10));
        obj.setPosX(obj.getPosX()+1);
        obj.setPosY(obj.getPosY()+(int)(Math.sin(doubleTick/17)*10));
        //obj.setPosY(obj.getPosY()+1);
        //Game updating behaviour goes here
        tick++;
    }
}
