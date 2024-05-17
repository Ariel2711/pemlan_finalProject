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
            System.out.println("Musuh Anda : " + listEnemies.get(i).name);
            System.out.print("Mulai Pertarungan (y/n) : ");
            String mulai = scanner.next();

            if (!mulai.equals("y"))
                break;

            boolean isWin = fight(selectedHero, listEnemies.get(i), scanner);
            if (isWin && i == listEnemies.size() - 1)
                System.out.println("Selamat Anda Menang!!!");
            else if (isWin) {
                System.out.println("===========================");
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
        Hero hero1 = new Hero("Kirana Wibawa", 10, 5);
        Skill skill1 = new Skill("Serangan Cahaya Batin", 10);
        Skill skill2 = new Skill("Tarian Pedang Angkasa", 20);
        Skill skill3 = new Skill("Gelombang Cahaya Abadi", 30);
        hero1.addSkill(skill1);
        hero1.addSkill(skill2);
        hero1.addSkill(skill3);
        Hero hero2 = new Hero("Raka Serdadu", 8, 7);
        Skill skill4 = new Skill("Tebasan Kilat", 10);
        Skill skill5 = new Skill("Bom Tangan Tempur", 20);
        Skill skill6 = new Skill("Pukulan Palu", 30);
        hero2.addSkill(skill4);
        hero2.addSkill(skill5);
        hero2.addSkill(skill6);
        Hero hero3 = new Hero("Satria Bayu", 9, 10);
        Skill skill7 = new Skill("Tarian Angin Puing", 10);
        Skill skill8 = new Skill("Hembusan Cepat", 20);
        Skill skill9 = new Skill("Pedang Badai", 30);
        hero3.addSkill(skill7);
        hero3.addSkill(skill8);
        hero3.addSkill(skill9);
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        return list;
    }

    public static ArrayList<Enemy> initAllEnemies() {
        ArrayList<Enemy> list = new ArrayList<Enemy>();
        Enemy enemy1 = new Enemy("Bara Pralaya", 5, 7);
        Skill skill1 = new Skill("Bayangan Gelap", 10);
        Skill skill2 = new Skill("Kutukan Kelam", 20);
        Skill skill3 = new Skill("Tombak Lava", 30);
        enemy1.addSkill(skill1);
        enemy1.addSkill(skill2);
        enemy1.addSkill(skill3);
        Enemy enemy2 = new Enemy("Durjana Karna", 7, 9);
        Skill skill4 = new Skill("Bola Api Neraka", 10);
        Skill skill5 = new Skill("Meteor Neraka", 20);
        Skill skill6 = new Skill("Api Manipulasi", 30);
        enemy2.addSkill(skill4);
        enemy2.addSkill(skill5);
        enemy2.addSkill(skill6);
        Enemy enemy3 = new Enemy("Ratu Sengketa", 8, 11);
        Skill skill7 = new Skill("Pesona Kejahatan", 10);
        Skill skill8 = new Skill("Ledakan Emosi", 20);
        Skill skill9 = new Skill("Bayangan Kegelapan", 30);
        enemy3.addSkill(skill7);
        enemy3.addSkill(skill8);
        enemy3.addSkill(skill9);
        list.add(enemy1);
        list.add(enemy2);
        list.add(enemy3);
        return list;
    }

    public static boolean fight(Hero hero, Enemy enemy, Scanner scanner) {
        while (hero.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("===========================");
            System.out.println("Giliran Anda");
            for (int i = 0; i < hero.listSkill.size(); i++) 
                System.out.println(i + 1 + ". " + hero.listSkill.get(i).getSkillName() + " +" + hero.listSkill.get(i).getSkillDamage());
            System.out.print("Pilih Jurus: ");
            Skill selectedSkill = hero.listSkill.get(scanner.nextInt() - 1);
            double skillDamage = (hero.getHeroDamage(selectedSkill) - enemy.getEnemyArmor());
            if (skillDamage < 0) skillDamage = 0;
            double enemyHealth = enemy.getHealth() - skillDamage;
            enemy.setHealth((int)enemyHealth);
            System.out.println("Anda menggunakan jurs " + selectedSkill.getSkillName());
            System.out.println("Nyawa " + enemy.name + " berkurang sebanyak: " + (int)skillDamage);
            System.out.println("Nyawa " + enemy.name + " saat ini: " + (enemy.getHealth() < 0 ? 0 : enemy.getHealth()));

            if (enemy.getHealth() > 0) {
                System.out.println("===========================");
                Random random = new Random();
                int randomNumber = random.nextInt(enemy.listSkill.size());
                Skill enemySkill = enemy.listSkill.get(randomNumber);
                double enemySkillDamage = (enemy.getEnemyDamage(enemySkill) - hero.getHeroArmor());
                if (enemySkillDamage < 0) enemySkillDamage = 0;
                double heroHealth = hero.getHealth() - enemySkillDamage;
                hero.setHealth((int)heroHealth);
                System.out.println(enemy.name + " menggunakan jurus " + enemySkill.getSkillName());
                System.out.println("Nyawa Anda berkurang sebanyak: " + (int)enemySkillDamage);
                System.out.println("Nyawa Anda saat ini: " + (hero.getHealth() < 0 ? 0 : hero.getHealth()));
            }
        }

        System.out.println("===========================");
        boolean isWin = hero.getHealth() > 0;
        if (isWin)
            System.out.println("Anda Menang");
        else
            System.out.println("Anda Kalah");
        return isWin;
    }
}
