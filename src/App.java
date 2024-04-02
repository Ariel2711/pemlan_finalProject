import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Hero> listHero = initAllHero();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Daftar Karakter : ");
        for (int i = 0; i < listHero.size(); i++) {
            System.out.println((i+1) + ". " + listHero.get(i).name);
            System.out.println("================================");
        }

        boolean selectHero = true;
        int indexHero = -1;
        while (selectHero) {
            System.out.print("Pilih Karakter : ");
            indexHero = scanner.nextInt();

            if(indexHero > listHero.size()){
                System.out.println("Pilihan tidak valid");
            }else{
                break;
            }
        }

        Hero selectedHero = listHero.get(indexHero - 1);
        System.out.println();
        System.out.println("Karakter Anda : ");
        System.out.println("Nama : " + selectedHero.name);
        System.out.println("Damage : " + selectedHero.damage);
        System.out.println("Armor : " + selectedHero.armor);
        System.out.println("Health : " + selectedHero.health);
        System.out.println("Daftar Skill : ");
        for (int i = 0; i < selectedHero.listSkill.size(); i++) {
            System.out.println("\tNama Skill : " + selectedHero.listSkill.get(i).getSkillName());
            System.out.println("\tDamage Skill : " + selectedHero.listSkill.get(i).getSkillDamage());
            System.out.println("================================");
        }

        scanner.close();
    }

    public static ArrayList<Hero> initAllHero(){
        ArrayList<Hero> list = new ArrayList<Hero>();
        Hero hero1 = new Hero("Hero 1", 10, 5);
        Hero hero2 = new Hero("Hero 2", 7, 7);
        Hero hero3 = new Hero("Hero 3", 5, 10);
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        return list;
    }
}
