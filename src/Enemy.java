import java.util.ArrayList;

public class Enemy extends Character {
    ArrayList<Skill> listSkill;

    Enemy(String name, int damage, int armor, int speed, int criticalAttack){
        super.name = name;
        super.armor = armor;
        super.damage = damage;
        super.speed = speed;
        super.criticalAttack = criticalAttack;
        super.health = 100;
        listSkill = new ArrayList<Skill>();
    }

    public void addSkill(Skill skill){
        listSkill.add(skill);
    }

    public int getEnemyDamage(Skill skill){
        return (int)((skill.getSkillDamage() + super.damage) * Math.random());
    }

    public int getEnemyArmor(){
        return (int)(super.armor * Math.random());
    }

    public int getHealth(){
        return super.health;
    }

    public int getSpeed(){
        return speed;
    }

    public int getCriticalAttack(){
        return criticalAttack;
    }

    public void setHealth(int newHealth){
        super.health = newHealth;
    }
}
