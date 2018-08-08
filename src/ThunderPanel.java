import javax.swing.*;
import java.awt.*;


public class ThunderPanel extends JPanel {
    int width;
    int height;
    Thunder[][] thunders;

    ThunderPanel(int width, int height, Thunder[][] thunders) {
        this.width = width;
        this.height = height;
        thunders = new Thunder[width / 100][height / 100];
        for (int i = 0; i < width; i += 100) {
            for (int j = 0; j < height; j += 100) {
                Thunder thunder = new Thunder();
                thunder.setX(i / 100);
                thunder.setY(j / 100);
                thunder.setThunder(false);
                thunder.setIsopen(false);
                thunders[i / 100][j / 100] = thunder;
            }
        }
        giveThunder(thunders);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < width; i += 100) {
            for (int j = 0; j < height; j += 100) {
                g.drawLine(i, j, i, j + 99);
                g.drawLine(i, j, i + 99, j);
                if (thunders[i / 100][j / 100].isIsopen()) {
                    if (thunders[i / 100][j / 100].isThunder()) {
                        g.drawString("boom", i + 49, j + 49);
                        ThunderGame.regame();
                    } else {
                        g.drawString(thunders[i / 100][j / 100].getHereboom() + "", i + 49, j + 49);
                    }
                }
            }
        }
    }

    public void giveThunder(Thunder[][] thunders) {
        this.thunders = thunders;
    }

    public Thunder[][] getThunders() {
        return thunders;
    }
}
