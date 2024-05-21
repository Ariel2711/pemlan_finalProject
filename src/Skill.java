public class Skill {
    private String skillName;
    private int skillDamage;

    Skill(String skillName, int skillDamage){
        this.skillName = skillName;
        this.skillDamage = skillDamage;
    }

    public String getSkillName(){
        return skillName;
    }

    public int getSkillDamage(){
        return skillDamage;
    }
}
