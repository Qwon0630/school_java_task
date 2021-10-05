package moon_lander;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Unmoved_Enemy {
    /* x좌표를 설정시에 랜덤한 값을 사용함 */
    private Random random;
    /* enemy x position */
    public int x;
    /* enemy y position */
    public int y;
    /* 플레이어가 적에게 닿았는지 확인 */
    public boolean isTouched;
    /* Images */
    /* 공중에 떠있는 움직이지 않는 적 이미지 */
    private BufferedImage UnmovedEnemyImg;
    /* 이미지의 넓이 */
    private int UnmovedEnemyImgWidth;
    /* 이미지의 높이 */
    // private int UnmovedEnemyImgHeight;

    private String image = "/resources/images/bomb.png";

    public Unmoved_Enemy() {
        initialize();
        LordEnemy();
        x = random.nextInt(Framework.frameWidth - UnmovedEnemyImgWidth);
    }

    public void initialize() {
        random = new Random();
        isTouched = false;
        ResetUnmovedEnemy();
    }

    private void LordEnemy() {
        try {
            URL enemyImgUrl = this.getClass().getResource(image);
            UnmovedEnemyImg = ImageIO.read(enemyImgUrl);
            UnmovedEnemyImgWidth = UnmovedEnemyImg.getWidth();
            // UnmovedEnemyImgHeight = UnmovedEnemyImg.getHeight();
        } catch (Exception e) {
            Logger.getLogger(Unmoved_Enemy.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void ResetUnmovedEnemy() {
        isTouched = false;
        x = random.nextInt(Framework.frameWidth - UnmovedEnemyImgWidth);
        y = 5;
    }

    public void Draw(Graphics2D g2d) {
        g2d.setColor(Color.black);
        g2d.drawImage(UnmovedEnemyImg, x, y, null);
    }
}
