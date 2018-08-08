public class Thunder {
    private int x;
    private int y;
    private boolean isThunder;
    private boolean igFlag;
    private boolean isopen;
    private boolean isok = false;

    public int getHereboom() {
        return hereboom;
    }

    public void setHereboom(int hereboom) {
        this.hereboom = hereboom;
    }

    private int hereboom;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isThunder() {
        return isThunder;
    }

    public void setThunder(boolean thunder) {
        isThunder = thunder;
    }

    public boolean isIgFlag() {
        return igFlag;
    }

    public void setIgFlag(boolean igFlag) {
        this.igFlag = igFlag;
    }

    public boolean isIsopen() {
        return isopen;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }

    @Override
    public String toString() {
        return "Thunder{" +
                "isThunder=" + isThunder +
                ", hereboom=" + hereboom +
                '}';
    }
}
