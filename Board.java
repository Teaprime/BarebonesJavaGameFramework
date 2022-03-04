import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Board extends JPanel {
    private ArrayList<BufferedImage> loadedImages;
    //For checking if image is already loaded
    private ArrayList<String> loadedImagesNames;
    HashMap<String, BufferedImage> imageMap;
    //private ArrayList<BoardObject> boardObjects; This array moved to gamestate
    private Gamestate gameState;


    @Override
    public void paint(Graphics g){
        super.paint(g);
        //g.drawImage(loadedImages.get(0),0,0,null);
        paintBoardObjects(g);
    }

    private void paintBoardObjects(Graphics g){
        for(int i=0;i<gameState.getBoardObjectsSize();i++){
            BoardObject obj= gameState.getBoardObject(i);
            paintBoardObject(g,obj);
        }
    }

    private void paintBoardObject(Graphics g, BoardObject obj){
        String imageName=obj.getImage();
        if(!imageMap.containsKey(imageName)) {
            loadImage(imageName);
        }
        g.drawImage(imageMap.get(obj.getImage()), obj.getPosX(), obj.getPosY(), null);
        debugDraw(g, obj);
    }

    public void debugDraw(Graphics g, BoardObject obj){
        //Put extra debug draw actions here, comment out to disable
        //maybe i should have a debug boolean
        //g.drawRect(obj.getPosX(),obj.getPosY(),obj.getSizeX(),obj.getSizeY());
    }


    public Board(){
        loadedImages=new ArrayList<>();
        loadedImagesNames=new ArrayList<>();
        imageMap=new HashMap<>();
    }
    public Board(Gamestate gState){
        this();
        gameState=gState;
    }
    public void addBoardObject(BoardObject object){
        if(!isImageLoaded(object.getImage())){
            loadImage(object.getImage());
        }
        gameState.addBoardObject(object);
    }

    public boolean loadImageOld(String name){
        if(isImageLoaded(name)){return true;}
        try {
            //should refactor this to use hash tables and enums
            loadedImages.add(ImageIO.read(new File(name)));
            return true;
        } catch (IOException ex) {
            // handle exception...
            System.out.println("failed to load "+name+" as image");
            return false;
        }
    }

    public boolean loadImage(String name){
        if(imageMap.containsKey(name)){return true;}
        try {
            //should refactor this to use hash tables and enums
            imageMap.put(name,ImageIO.read(new File(name)));
            return true;
        } catch (IOException ex) {
            // handle exception...
            System.out.println("failed to load "+name+" as image");
            return false;
        }
    }

    private boolean isImageLoaded(String name){
        for(int i=0;i<loadedImagesNames.size();i++){
            if(name.equals(loadedImagesNames.get(i))){
                return true;
            }
        }
        return false;
    }

    public void tickGame(){
        gameState.tickGame();
    }

}
