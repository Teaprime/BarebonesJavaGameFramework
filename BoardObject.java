public class BoardObject {
    private int posX=0;

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void setXY(int x, int y){
        if (!(x<0)){
            setPosX(x);
        }
        if (!(y<0)){
            setPosY(y);
        }
    }

    private int posY=0;
    private int sizeX=10;
    private int sizeY=10;

    public String getImage() {
        return imageName;
    }

    public void setImage(String image) {
        this.imageName = image;
    }

    private String imageName;

    public BoardObject(int spawnX, int spawnY, int setSizeX, int setSizeY){
        posX=spawnX;
        posY=spawnY;
        sizeX=setSizeX;
        sizeY=setSizeY;
    }
    public BoardObject(){

    }
    public BoardObject(String setImage,int setSizeX, int setSizeY){
        imageName=setImage;
        sizeX=setSizeX;
        sizeY=setSizeY;
    }
}
