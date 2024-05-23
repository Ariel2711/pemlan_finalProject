import java.util.ArrayList;

public class Enemy extends Character {
    ArrayList<Skill> listSkill;

    Enemy(String name, int damage, int armor, int speed, int criticalAttack){
        super.name = name;
        super.armor = armor;
        super.basicDamage = damage;
        super.speed = speed;
        super.criticalAttack = criticalAttack;
        super.health = 100;
        listSkill = new ArrayList<Skill>();
    }

    public void addSkill(Skill skill){
        listSkill.add(skill);
    }

    public int getAttackDamage(Skill skill){
        return (int)((skill.getSkillDamage() + super.basicDamage) * Math.random());
    }

    public String getName(){
        return name;
    }

    public int getBasicDamage(){
        return basicDamage;
    }

    public int getDefenseArmor(){
        return (int)(super.armor * Math.random());
    }

    public int getArmor(){
        return armor;
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
