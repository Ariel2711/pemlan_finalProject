import java.util.ArrayList;

public class Enemy extends Character {
    ArrayList<Skill> listSkill;
    int level;

    Enemy(String name, double damage, double armor, double health, int level){
        super.name = name;
        super.armor = armor;
        super.damage = damage;
        super.health = health;
        this.level = level;
        listSkill = new ArrayList<Skill>();
        Skill skill1 = new Skill("Punch", 10 * level);
        Skill skill2 = new Skill("Kick", 15 * level);
        listSkill.add(skill1);
        listSkill.add(skill2);
    }

    public void addSkill(String skillName, double skillDamage){
        Skill skill = new Skill(skillName, skillDamage);
        listSkill.add(skill);
    }

    public double getHeroDamage(){
        return super.damage * Math.random();
    }

    public double getHeroArmor(){
        return super.armor * Math.random();
    }

    public double getHealth(){
        return super.health;
    }

    public void setHealth(double newHealth){
        super.health = newHealth;
    }
}
