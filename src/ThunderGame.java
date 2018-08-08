import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.Scanner;

public class ThunderGame implements MouseListener, MouseMotionListener {
    private static ThunderGame thunderGame;
    private static ThunderPanel thunderPanel;
    private static int width = 800;
    private static int height = 600;
    int ThunderSize = 10;
    private static JFrame frame;
    static Thunder[][] thunders = new Thunder[8][6];

    public static void main(String[] args) {
        thunderGame = new ThunderGame();
    }

    public static void regame() {
        main(new String[0]);
    }

    ThunderGame() {
        Scanner scanner = new Scanner(System.in);
/*        width = scanner.nextInt();
        height = scanner.nextInt();
        ThunderSize= scanner.nextInt();*/
        frame = new JFrame();
        frame.setBackground(new Color(255, 255, 255));
        frame.setSize(width + 15, height + 35);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        thunderPanel = new ThunderPanel(width, height, thunders);
        frame.add(thunderPanel);
        thunders = thunderPanel.getThunders();
        setboom();
        giveHereboom(thunders);
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
    }

    public static void soutThunder(Thunder[][] t) {
        for (Thunder[] t1 : t) {
            for (Thunder t2 : t1) {
                System.out.println(t2);
            }
        }
    }

    public void setboom() {
        for (int i = 0; i < ThunderSize; i++) {
            Random random = new Random();
            int boomx = random.nextInt(8);
            int boomy = random.nextInt(6);
            if (!thunders[boomx][boomy].isThunder()) {
                thunders[boomx][boomy].setThunder(true);
            } else {
                i--;
            }
        }
    }

    private void isboom(int x, int y) {
        if (!thunders[x / 100][y / 100].isThunder()) {
            thunders[x / 100][y / 100].setIsopen(true);
        } else {
            thunders[x / 100][y / 100].setIsopen(true);
        }
        thunderPanel.repaint();
    }

    public void giveHereboom(Thunder[][] thunders) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                int num = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        if (x == -1 || x == 8 || y == -1 || y == 6) {
                            continue;
                        }
                        if (thunders[x][y].isThunder()) {
                            num++;
                        }
                    }
                }
                thunders[i][j].setHereboom(num);
            }
        }
    }

    public void maybeThunder(int i, int j) {
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x == i && y == j) {
                    continue;
                }
                if (x == -1 || x == 8 || y == -1 || y == 6) {
                    continue;
                }
                try {
                    if (!thunders[x][y].isThunder() && !thunders[x][y].isIsopen()) {
                        thunders[x][y].setIsopen(true);
                        if (thunders[x][y].getHereboom() == 0) {
                            maybeThunder(x, y);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(x + "," + y);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!thunders[(e.getX() - 15) / 100][(e.getY() - 35) / 100].isThunder() && !thunders[(e.getX() - 15) / 100][(e.getY() - 35) / 100].isIsopen() && thunders[(e.getX() - 15) / 100][(e.getY() - 35) / 100].getHereboom() == 0) {
            maybeThunder((e.getX() - 15) / 100, (e.getY() - 15) / 100);
        }
        isboom(e.getX() - 15, e.getY() - 35);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
