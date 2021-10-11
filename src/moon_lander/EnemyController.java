package moon_lander;

import java.util.LinkedList;
import java.awt.Graphics2D;

public class EnemyController {

    LinkedList<Moving_Enemy> e = new LinkedList<Moving_Enemy>();

    Moving_Enemy tempEnemy;
    PlayerRocket playerRocket;

    public EnemyController(int count) {
        for (int i = 0; i < count; i++) {
            addEnemy(new Moving_Enemy());
        }
    }

    public void ResetController(int count) {
        e.clear();
        for (int i = 0; i < 5; i++) {
            addEnemy(new Moving_Enemy());
        }
    }

    public void Draw(Graphics2D g2d) {
        for (int i = 0; i < e.size(); i++) {
            tempEnemy = e.get(i);

            tempEnemy.Draw(g2d);
        }
    }

    public void Update() {
        for (int i = 0; i < e.size(); i++) {
            tempEnemy = e.get(i);

            tempEnemy.tick();
        }
    }

    public LinkedList<Moving_Enemy> getEnemyList() {
        return e;
    }

    public void addEnemy(Moving_Enemy Enemy) {
        e.add(Enemy);
    }

    public void removeEnemy(Moving_Enemy Enemy) {
        e.remove(Enemy);
    }
}