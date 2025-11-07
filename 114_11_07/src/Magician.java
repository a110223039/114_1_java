public class Magician  extends Role{

    private int healPower;

    public Magician(String name, int health, int attackPower,int healPower) {
        super(name, health, attackPower);
        this.healPower = healPower;
    }

    public int getHealPower() {
        return healPower;
    }


    public void attack(Magician opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.printf(this.getName() + " 攻擊 " + opponent.getName() + "，造成 " + this.getAttackPower() + " 點傷害！" + opponent);
    }

    public void heal(SwordsMan ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治療 " + ally.getName() + "，恢復 " + this.healPower + " 點生命值！" + ally);
    }

    @Override
    public String toString() {
        return super.toString() + ", 治療力: "+ healPower+"\n";
    }

}
