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
            System.out.println((i + 1) + ". " + listHero.get(i).getName());
    
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
                scanner.next();
            }
        }
    
        System.out.println("================================");
    
        Hero selectedHero = listHero.get(indexHero - 1);
    
        System.out.println("Petarung Anda : " + selectedHero.getName());
        System.out.println("Damage Basic : +" + selectedHero.getBasicDamage());
        System.out.println("Armor : +" + selectedHero.getArmor());
        System.out.println("Health : +" + selectedHero.getHealth());
        System.out.println("Speed : +" + selectedHero.getSpeed());
        System.out.println("Critical Attack : +" + selectedHero.getCriticalAttack());
        System.out.println("Skill : ");
        for (int i = 0; i < selectedHero.listSkill.size(); i++)
            System.out.println((i + 1) + ". " + selectedHero.listSkill.get(i).getSkillName() + " +" + selectedHero.listSkill.get(i).getSkillDamage());
    
        System.out.println("================================");
    
        for (int i = 0; i < listEnemies.size(); i++) {
            Enemy enemy = listEnemies.get(i);
            System.out.println("Musuh Anda : " + enemy.getName());
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
            selectedHero.addXP(100);
            
            boolean playerFirst = selectedHero.getSpeed() > enemy.getSpeed();
            
            boolean isWin = fight(selectedHero, enemy, scanner, playerFirst);
            System.out.println("===========================");
                if (isWin && i == listEnemies.size() - 1)
                    System.out.println("Selamat Anda Telah Menyelesaikan Game Ini");
                else if (isWin)
                    continue;
                else {
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

        Hero hero4 = new Hero("Arjuna Bintang", 40, 15, 65, 80);
        Skill skill10 = new Skill("Panah Bintang", 15);
        Skill skill11 = new Skill("Tembakan Kosmik", 20);
        Skill skill12 = new Skill("Hujan Meteor", 35);
        hero4.addSkill(skill10);
        hero4.addSkill(skill11);
        hero4.addSkill(skill12);

        Hero hero5 = new Hero("Dewi Angkasa", 25, 35, 80, 75);
        Skill skill13 = new Skill("Ledakan Galaksi", 20);
        Skill skill14 = new Skill("Badai Kosmik", 20);
        Skill skill15 = new Skill("Tarian Supernova", 30);
        hero5.addSkill(skill13);
        hero5.addSkill(skill14);
        hero5.addSkill(skill15);

        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);
        list.add(hero5);

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

        Enemy enemy4 = new Enemy("Jahat Senja", 30, 20, 70, 60);
        Skill skill10 = new Skill("Tendangan Malam", 15);
        Skill skill11 = new Skill("Tusukan Gelap", 25);
        Skill skill12 = new Skill("Serangan Bayangan", 35);
        enemy4.addSkill(skill10);
        enemy4.addSkill(skill11);
        enemy4.addSkill(skill12);

        Enemy enemy5 = new Enemy("Durjana Malam", 35, 30, 90, 75);
        Skill skill13 = new Skill("Pukulan Dewa Kegelapan", 20);
        Skill skill14 = new Skill("Ledakan Hitam", 30);
        Skill skill15 = new Skill("Kekuatan Gelap", 40);
        enemy5.addSkill(skill13);
        enemy5.addSkill(skill14);
        enemy5.addSkill(skill15);

        list.add(enemy1);
        list.add(enemy2);
        list.add(enemy3);
        list.add(enemy4);
        list.add(enemy5);

        return list;
    }

    public static boolean fight(Hero hero, Enemy enemy, Scanner scanner, boolean isPlayerFirst) {
        while (hero.getHealth() > 0 && enemy.getHealth() > 0) {
            if (isPlayerFirst) {
                attack(hero, enemy, scanner, true);
                if (enemy.getHealth() > 0) {
                    attack(enemy, hero, scanner, false);
                }
            } else {
                attack(enemy, hero, scanner, false);
                if (hero.getHealth() > 0) {
                    attack(hero, enemy, scanner, true);
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
    
    private static void attack(Character attacker, Character defender, Scanner scanner, boolean isPlayer) {
        System.out.println("===========================");
        if (isPlayer) {
            System.out.println("Giliran Anda");
            Skill selectedSkill = selectSkill((Hero) attacker, scanner);
            int damage = calculateDamage((Hero) attacker, (Enemy) defender, selectedSkill, true);
            ((Enemy)defender).setHealth(((Enemy)defender).getHealth() - damage);
            System.out.println("Anda menggunakan jurus " + selectedSkill.getSkillName());
            System.out.println("Nyawa " + ((Enemy)defender).name + " berkurang sebanyak : -" + damage);
            System.out.println("Nyawa " + ((Enemy)defender).name + " saat ini : " + Math.max(((Enemy)defender).getHealth(), 0));
        } else {
            System.out.println("Giliran " + attacker.name);
            Skill selectedSkill = selectRandomSkill((Enemy) attacker);
            int damage = calculateDamage((Enemy) attacker, (Hero) defender, selectedSkill, false);
            ((Hero)defender).setHealth(((Hero)defender).getHealth() - damage);
            System.out.println(attacker.name + " menggunakan jurus " + selectedSkill.getSkillName());
            System.out.println("Nyawa Anda berkurang sebanyak : -" + damage);
            System.out.println("Nyawa Anda saat ini : " + Math.max(((Hero)defender).getHealth(), 0));
        }
    }

    private static Skill selectSkill(Hero hero, Scanner scanner) {
        for (int i = 0; i < hero.listSkill.size(); i++)
            System.out.println((i + 1) + ". " + hero.listSkill.get(i).getSkillName() + " +" + hero.listSkill.get(i).getSkillDamage());

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
                scanner.next();
            }
        }

        return selectedSkill;
    }

    private static Skill selectRandomSkill(Enemy enemy) {
        Random random = new Random();
        return enemy.listSkill.get(random.nextInt(enemy.listSkill.size()));
    }

    private static int calculateDamage(Character attacker, Character defender, Skill skill, boolean isPlayer) {
        if (isPlayer) {
            Random random = new Random();
            int criticalAttack = random.nextInt(100);
            int skillDamage = ((Hero)attacker).getAttackDamage(skill);
            if (criticalAttack < (100 - ((Hero)attacker).getCriticalAttack())) skillDamage -= ((Enemy)defender).getDefenseArmor();
            if (skillDamage < 0) skillDamage = 0;
            return skillDamage;
        } else {
            Random random = new Random();
            int criticalAttack = random.nextInt(100);
            int skillDamage = ((Enemy)attacker).getAttackDamage(skill);
            if (criticalAttack < (100 - ((Enemy)attacker).getCriticalAttack())) skillDamage -= ((Hero)defender).getDefenseArmor();
            if (skillDamage < 0) skillDamage = 0;
            return skillDamage;
        }
    }
}
