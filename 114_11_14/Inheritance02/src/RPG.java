public class RPG {
    public static void main(String[] args) {
        SwordsMan hero = new SwordsMan("英雄", 100, 20);
        SwordsMan monster = new SwordsMan("怪物", 80, 15);

        Magician mage = new Magician("法師", 70, 10, 25);
        Magician enemyMage = new Magician("敵方法師", 60, 12, 20);

        Role[] gameRoles = {hero, monster, mage, enemyMage};

        System.out.println("戰鬥開始！");
        // 戰鬥開始
        for (Role currentRole : gameRoles) {
            if (!currentRole.isAlive()) {
                continue; // 跳過已經死亡的角色
            }
            if (currentRole instanceof SwordsMan)
                currentRole.attack(gameRoles[(int) (Math.random() * gameRoles.length)]);
            else if (currentRole instanceof Magician)
                if (Math.random() < 0.5) {
                    currentRole.attack(gameRoles[(int) (Math.random() * gameRoles.length)]);
                } else {
                    currentRole.heal(gameRoles[(int) (Math.random() * gameRoles.length)]);
                }
        }
    }
}
