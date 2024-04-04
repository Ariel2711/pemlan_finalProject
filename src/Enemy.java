import java.util.ArrayList;

public class Enemy extends Character {
    ArrayList<Skill> listSkill;
    int level;

    Enemy(String name, double damage, double armor, int level){
        super.name = name;
        super.armor = armor;
        super.damage = damage;
        super.health = 100;
        this.level = level;
        listSkill = new ArrayList<Skill>();
        Skill skill1 = new Skill("Punch", 5 * level);
        Skill skill2 = new Skill("Kick", 10 * level);
        listSkill.add(skill1);
        listSkill.add(skill2);
    }

    public void addSkill(String skillName, double skillDamage){
        Skill skill = new Skill(skillName, skillDamage);
        listSkill.add(skill);
    }

    public double getEnemyDamage(int indexSkill){
        return (listSkill.get(indexSkill).getSkillDamage() + super.damage) * Math.random();
    }

    public double getEnemyArmor(){
        return super.armor * Math.random();
    }

    public double getHealth(){
        return super.health;
    }

    public void setHealth(double newHealth){
        super.health = newHealth;
    }
}
