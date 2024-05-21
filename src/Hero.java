import java.util.ArrayList;

public class Hero extends Character {
    protected int level;
    ArrayList<Skill> listSkill;

    Hero(String name, int damage, int armor, int speed, int criticalAttack){
        super.name = name;
        this.level = 0;
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

    public int getHeroDamage(Skill skill){
        return (int)((skill.getSkillDamage() + super.damage + (level * 5)) * Math.random());
    }

    public int getHeroArmor(){
        return (int)((super.armor + (level * 5)) * Math.random());
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
