import java.util.ArrayList;

public class Hero extends Character {
    ArrayList<Skill> listSkill;

    Hero(String name, double damage, double armor){
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

    public void addSkill(String skillName, double skillDamage){
        Skill skill = new Skill(skillName, skillDamage);
        listSkill.add(skill);
    }

    public double getHeroDamage(int indexSkill){
        return listSkill.get(indexSkill).getSkillDamage() * super.damage * Math.random();
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
