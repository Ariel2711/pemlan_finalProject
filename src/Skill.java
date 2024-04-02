public class Skill {
    private String skillName;
    private double skillDamage;

    Skill(String skillName, double skillDamage){
        this.skillName = skillName;
        this.skillDamage = skillDamage;
    }

    public String getSkillName(){
        return skillName;
    }

    public double getSkillDamage(){
        return skillDamage;
    }
}
