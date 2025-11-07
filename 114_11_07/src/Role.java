import javax.swing.*;
import javax.swing.plaf.PanelUI;

public class Role extends Object {
    private String name;

    private int health;

    private int attackPower;

    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public  String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getAttackPower() {
        return attackPower;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlice() {
        return this.health > 0;
    }

    @Override
    public String toString() {
        return   name + "生命值: " + health;
    }
}
