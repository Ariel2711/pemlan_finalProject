import java.util.ArrayList;

public class Enemy extends Character {
    ArrayList<Skill> listSkill;
    int level;

    Enemy(String name, int damage, int armor, int level){
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

    public void addSkill(String skillName, int skillDamage){
        Skill skill = new Skill(skillName, skillDamage);
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

    public void setHealth(int newHealth){
        super.health = newHealth;
    }
}
