import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Hero> listHero = initAllHero();
        ArrayList<Enemy> listEnemies = initAllEnemies();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat Datang di Duel Legenda");
        System.out.println("Daftar Petarung : ");
        for (int i = 0; i < listHero.size(); i++)
            System.out.println((i + 1) + ". " + listHero.get(i).name);

        boolean selectHero = true;
        int indexHero = -1;

        while (selectHero) {
            System.out.print("Pilih Petarung Anda : ");
            try {
                indexHero = scanner.nextInt();
                if (indexHero > 0 && indexHero <= listHero.size()) {
                    selectHero = false;
                } else {
                    System.out.println("Pilihan tidak valid. Coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka. Coba lagi.");
                scanner.next(); // Clear the invalid input
            }
        }

        System.out.println("================================");

        Hero selectedHero = listHero.get(indexHero - 1);

        System.out.println("Petarung Anda : " + selectedHero.name);
        System.out.println("Damage Basic : +" + selectedHero.damage);
        System.out.println("Armor : +" + selectedHero.armor);
        System.out.println("Health : +" + selectedHero.health);
        System.out.println("Speed : +" + selectedHero.getSpeed());
        System.out.println("Critical Attack : +" + selectedHero.getCriticalAttack());
        System.out.println("Skill : ");
        for (int i = 0; i < selectedHero.listSkill.size(); i++)
            System.out.println((i + 1) + ". " + selectedHero.listSkill.get(i).getSkillName() + " +" + selectedHero.listSkill.get(i).getSkillDamage());

        System.out.println("================================");

        for (int i = 0; i < listEnemies.size(); i++) {
            System.out.println("Musuh Anda : " + listEnemies.get(i).name);
            boolean isValidInput = false;
        
            while (!isValidInput) {
                try {
                    System.out.print("Mulai Pertarungan (y/n) : ");
                    String mulai = scanner.next();
                    if (mulai.equalsIgnoreCase("y") || mulai.equalsIgnoreCase("n")) {
                        isValidInput = true;
                        if (mulai.equalsIgnoreCase("n"))
                            System.exit(0);
                    } else {
                        System.out.println("Masukan tidak valid. Harap masukkan 'y' untuk ya atau 'n' untuk tidak.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Masukan harus berupa huruf. Coba lagi.");
                    scanner.next();
                }
            }
        
            if (!isValidInput)
                break;
        
            selectedHero.setHealth(100);
            selectedHero.level++;
            boolean isWin = fight(selectedHero, listEnemies.get(i), scanner);
            if (isWin && i == listEnemies.size() - 1)
                System.out.println("Selamat Anda Telah Menyelesaikan Game Ini");
            else if (isWin) {
                System.out.println("===========================");
                continue;
            } else {
                System.out.println("Game Berakhir");
                break;
            }
        }
        

        scanner.close();
    }

    public static ArrayList<Hero> initAllHero() {
        ArrayList<Hero> list = new ArrayList<Hero>();
        Hero hero1 = new Hero("Kirana Wibawa", 30, 25, 70, 60);
        Skill skill1 = new Skill("Serangan Cahaya Batin", 10);
        Skill skill2 = new Skill("Tarian Pedang Angkasa", 20);
        Skill skill3 = new Skill("Gelombang Cahaya Abadi", 30);
        hero1.addSkill(skill1);
        hero1.addSkill(skill2);
        hero1.addSkill(skill3);
        Hero hero2 = new Hero("Raka Serdadu", 35, 20, 75, 70);
        Skill skill4 = new Skill("Tebasan Kilat", 10);
        Skill skill5 = new Skill("Bom Tangan Tempur", 20);
        Skill skill6 = new Skill("Pukulan Palu", 30);
        hero2.addSkill(skill4);
        hero2.addSkill(skill5);
        hero2.addSkill(skill6);
        Hero hero3 = new Hero("Satria Bayu", 30, 30, 90, 85);
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
        Enemy enemy1 = new Enemy("Bara Pralaya", 20, 20, 80, 70);
        Skill skill1 = new Skill("Bayangan Gelap", 10);
        Skill skill2 = new Skill("Kutukan Kelam", 20);
        Skill skill3 = new Skill("Tombak Lava", 30);
        enemy1.addSkill(skill1);
        enemy1.addSkill(skill2);
        enemy1.addSkill(skill3);
        Enemy enemy2 = new Enemy("Durjana Karna", 25, 15, 50, 65);
        Skill skill4 = new Skill("Bola Api Neraka", 10);
        Skill skill5 = new Skill("Meteor Neraka", 20);
        Skill skill6 = new Skill("Api Manipulasi", 30);
        enemy2.addSkill(skill4);
        enemy2.addSkill(skill5);
        enemy2.addSkill(skill6);
        Enemy enemy3 = new Enemy("Ratu Sengketa", 30, 25, 75, 80);
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
            if (hero.getSpeed() >= enemy.getSpeed()) {
                playerAttack(hero, enemy, scanner);
                if (enemy.getHealth() > 0) {
                    enemyAttack(enemy, hero);
                }
            } else {
                enemyAttack(enemy, hero);
                if (hero.getHealth() > 0) {
                    playerAttack(hero, enemy, scanner);
                }
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

    private static void playerAttack(Hero hero, Enemy enemy, Scanner scanner) {
        System.out.println("===========================");
        System.out.println("Giliran Anda");
        for (int i = 0; i < hero.listSkill.size(); i++)
            System.out.println(i + 1 + ". " + hero.listSkill.get(i).getSkillName() + " +" + hero.listSkill.get(i).getSkillDamage());
        
        boolean validInput = false;
        Skill selectedSkill = null;
        
        while (!validInput) {
            try {
                System.out.print("Pilih Jurus : ");
                int skillIndex = scanner.nextInt();
                if (skillIndex > 0 && skillIndex <= hero.listSkill.size()) {
                    selectedSkill = hero.listSkill.get(skillIndex - 1);
                    validInput = true;
                } else {
                    System.out.println("Pilihan tidak valid. Coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka. Coba lagi.");
                scanner.next(); // Clear the invalid input
            }
        }

        Random random = new Random();
        int criticalAttack = random.nextInt(100);
        int skillDamage = hero.getHeroDamage(selectedSkill);
        if (criticalAttack < (100 - hero.getCriticalAttack())) skillDamage -= enemy.getEnemyArmor();
        if (skillDamage < 0) skillDamage = 0;
        int defenderHealth = enemy.getHealth() - skillDamage;
        enemy.setHealth(defenderHealth);
        System.out.println("Anda menggunakan jurus " + selectedSkill.getSkillName());
        System.out.println("Nyawa " + enemy.name + " berkurang sebanyak : -" + skillDamage);
        System.out.println("Nyawa " + enemy.name + " saat ini : " + (enemy.getHealth() < 0 ? 0 : enemy.getHealth()));
    }

    private static void enemyAttack(Enemy enemy, Hero hero) {
        System.out.println("===========================");
        Random random = new Random();
        Skill enemySkill = enemy.listSkill.get(random.nextInt(enemy.listSkill.size()));
        int criticalAttack = random.nextInt(100);
        int skillDamage = enemy.getEnemyDamage(enemySkill);
        if (criticalAttack < (100 - enemy.getCriticalAttack())) skillDamage -= hero.getHeroArmor();
        if (skillDamage < 0) skillDamage = 0;
        int defenderHealth = hero.getHealth() - skillDamage;
        hero.setHealth(defenderHealth);
        System.out.println(enemy.name + " menggunakan jurus " + enemySkill.getSkillName());
        System.out.println("Nyawa Anda berkurang sebanyak : -" + skillDamage);
        System.out.println("Nyawa Anda saat ini : " + (hero.getHealth() < 0 ? 0 : hero.getHealth()));
    }
}