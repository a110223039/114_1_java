public class SwordsMan  extends Role{

    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void attack(SwordsMan opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.printf(this.getName() + " 攻擊 " + opponent.getName() + "，造成 " + this.getAttackPower() + " 點傷害！%n");
    }
}
