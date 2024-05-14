import java.util.ArrayList;

public class Hero extends Character {
    ArrayList<Skill> listSkill;

    Hero(String name, int damage, int armor){
        super.name = name;
        super.armor = armor;
        super.damage = damage;
        super.health = 100;
        listSkill = new ArrayList<Skill>();
        Skill skill1 = new Skill("Punch", 10);
        Skill skill2 = new Skill("Kick", 15);
        listSkill.add(skill1);
        listSkill.add(skill2);
    }

    public void addSkill(String skillName, int skillDamage){
        Skill skill = new Skill(skillName, skillDamage);
        listSkill.add(skill);
    }

    public int getHeroDamage(Skill skill){
        return (int)((skill.getSkillDamage() + super.damage) * Math.random());
    }

    public int getHeroArmor(){
        return (int)(super.armor * Math.random());
    }

    public int getHealth(){
        return super.health;
    }

    public void setHealth(int newHealth){
        super.health = newHealth;
    }
}
