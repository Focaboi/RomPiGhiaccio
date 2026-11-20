package combat;

import models.Entity;

public class BattleUtils {
    public static void dealDamage (int dmg, Entity target) {
        target.takeDamage(dmg);
    }
}
