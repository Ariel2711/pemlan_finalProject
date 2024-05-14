import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Hero> listHero = initAllHero();
        ArrayList<Enemy> listEnemies = initAllEnemies();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Daftar Karakter : ");
        for (int i = 0; i < listHero.size(); i++)
            System.out.println((i + 1) + ". " + listHero.get(i).name);

        boolean selectHero = true;
        int indexHero = -1;

        while (selectHero) {
            System.out.print("Pilih Karakter : ");
            indexHero = scanner.nextInt();

            if (indexHero > listHero.size())
                System.out.println("Pilihan tidak valid");
            else
                break;
        }

        System.out.println("================================");

        Hero selectedHero = listHero.get(indexHero - 1);

        System.out.println("Karakter Anda : " + selectedHero.name);
        System.out.println("Damage : " + selectedHero.damage);
        System.out.println("Armor : " + selectedHero.armor);
        System.out.println("Health : " + selectedHero.health);
        System.out.println("Skill : ");
        for (int i = 0; i < selectedHero.listSkill.size(); i++)
            System.out.println((i + 1) + ". " + selectedHero.listSkill.get(i).getSkillName() + " +" + selectedHero.listSkill.get(i).getSkillDamage());

        System.out.println("================================");

        for (int i = 0; i < listEnemies.size(); i++) {
            System.out.println("Musuh Anda : " + listEnemies.get(i).name + " level " + listEnemies.get(i).level);
            System.out.print("Mulai Pertarungan (y/n) : ");
            String mulai = scanner.next();

            if (!mulai.equals("y"))
                break;

            boolean isWin = fight(selectedHero, listEnemies.get(i), scanner);
            if (isWin && i == listEnemies.size() - 1)
                System.out.println("Selamat Anda Menang!!!");
            else if (isWin) {
                System.out.println("================================");
                continue;
            } else {
                System.out.println("Game Over");
                break;
            }
        }

        scanner.close();
    }

    public static ArrayList<Hero> initAllHero() {
        ArrayList<Hero> list = new ArrayList<Hero>();
        Hero hero1 = new Hero("Hero 1", 10, 5);
        Hero hero2 = new Hero("Hero 2", 7, 7);
        Hero hero3 = new Hero("Hero 3", 5, 10);
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        return list;
    }

    public static ArrayList<Enemy> initAllEnemies() {
        ArrayList<Enemy> list = new ArrayList<Enemy>();
        Enemy enemy1 = new Enemy("Enemy 1", 5, 5, 1);
        Enemy enemy2 = new Enemy("Enemy 2", 7, 7, 2);
        Enemy enemy3 = new Enemy("Enemy 3", 10, 10, 3);
        list.add(enemy1);
        list.add(enemy2);
        list.add(enemy3);
        return list;
    }

    public static boolean fight(Hero hero, Enemy enemy, Scanner scanner) {
        while (hero.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("===========================");
            System.out.println("Giliran Anda");
            for (int i = 0; i < hero.listSkill.size(); i++) {
                System.out.println(i + 1 + ". " + hero.listSkill.get(i).getSkillName());
            }
            System.out.print("Pilih Skill: ");
            Skill selectedSkill = hero.listSkill.get(scanner.nextInt() - 1);
            double skillDamage = (selectedSkill.getSkillDamage() - enemy.getEnemyArmor());
            if (skillDamage < 0) skillDamage = 0;
            double enemyHealth = enemy.getHealth() - skillDamage;
            enemy.setHealth(enemyHealth);
            System.out.println(hero.name + " menggunakan skill " + selectedSkill.getSkillName());
            System.out.println("Nyawa " + enemy.name + " berkurang sebanyak: " + skillDamage + "%");
            System.out.println("Nyawa " + enemy.name + " saat ini: " + (enemy.getHealth() < 0 ? 0 : enemy.getHealth()));

            System.out.println("===========================");
            if (enemy.getHealth() > 0) {
                Random random = new Random();
                int randomNumber = random.nextInt(enemy.listSkill.size());
                Skill enemySkill = enemy.listSkill.get(randomNumber);
                double enemySkillDamage = (enemySkill.getSkillDamage() - hero.getHeroArmor());
                if (enemySkillDamage < 0) enemySkillDamage = 0;
                double heroHealth = hero.getHealth() - enemySkillDamage;
                hero.setHealth(heroHealth);
                System.out.println(enemy.name + " menggunakan skill " + enemySkill.getSkillName());
                System.out.println("Nyawa " + hero.name + " berkurang sebanyak: " + enemySkillDamage + "%");
                System.out.println("Nyawa " + hero.name + " saat ini: " + (hero.getHealth() < 0 ? 0 : hero.getHealth()));
            }
        }

        boolean isWin = hero.getHealth() > 0;
        if (isWin)
            System.out.println("Anda Menang");
        else
            System.out.println("Anda Kalah");
        return isWin;
    }
}
