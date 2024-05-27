import java.util.ArrayList;

public class Hero extends Character {
    private int level;
    private int xp;
    ArrayList<Skill> listSkill;

    Hero(String name, int damage, int armor, int speed, int criticalAttack){
        super.name = name;
        this.level = 1;
        this.xp = 0;
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

    public int getLevel(){
        return level;
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

    public void addXP(int xp) {
        this.xp += xp;
        if (this.xp >= level * 100) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        xp = 0;
        basicDamage += 5;
        armor += 5;
        speed += 5;
        System.out.println("===========================");
        System.out.println("Level Anda Bertambah");
        System.out.println("Basic Damage +5");
        System.out.println("Armor +5");
        System.out.println("Speed +5");
        System.out.println("===========================");
    }
}
