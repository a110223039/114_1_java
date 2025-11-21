public class RPG {
    public static void main(String[] args) {
        SwordsMan hero = new SwordsMan("英雄", 100, 20);
        SwordsMan monster = new SwordsMan("怪物", 80, 15);

        Magician mage = new Magician("法師", 70, 10, 25);
        Magician enemyMage = new Magician("敵方法師", 60, 12, 20);

        System.out.println("戰鬥開始！");
        // 戰鬥開始
        hero.attack(monster);
        monster.attack(hero);
        mage.attack(enemyMage);
        enemyMage.attack(mage);

        mage.heal(hero);
        enemyMage.heal(monster);
        System.out.println("戰鬥結束！");
    }
}
