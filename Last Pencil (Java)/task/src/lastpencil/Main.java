package lastpencil;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static String pencil = "|";

    public static final String player = "John";
    public static final String bot = "Jack";

    public static void main(String[] args) {

        int count = 1;
        System.out.println("How many pencils would you like to use:");
        while (true) {
            try {
                count = Integer.parseInt(sc.nextLine());
                if (count > 0) {
                    break;
                } else if (count == 0){
                    System.out.println("The number of pencils should be positive");
                } else {
                    System.out.println("The number of pencils should be numeric");
                }
            } catch (Exception e) {
                System.out.println("The number of pencils should be numeric");
            }
        }

        ArrayList<String> pencils = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            pencils.add(pencil);
        }


        System.out.println("Who will be the first (" + player + ", " + bot + "): ");
        String input = "";
        while (true) {
            input = sc.nextLine();{
                if (input.equals(player) || input.equals(bot)) {
                    break;
                } else {
                    System.out.println("Choose between " + player + " and " + bot);
                }
            }
        }

        String name = "";

        int turn = 0;
        if (input.equals(bot)) {
            turn = 1;
        }

        while (true) {
            if (turn % 2 == 0) {
                name = player(player, pencils);
            } else {
                name = player(bot, pencils);
            }

            if (pencils.isEmpty()) {
                if (name.equals(player)) {
                    System.out.println(bot + " won!");
                } else {
                    System.out.println(player + " won!");
                }
                break;
            }

            turn++;
        }

    }

    public static String player(String name, ArrayList<String> pencils) {
        System.out.println(pencil.repeat(pencils.size()));
        System.out.println(name + "'s turn");

        int count = 0;

        while (true) {
            if (name.equals(player)) {
                try {
                    count = Integer.parseInt(sc.nextLine());
                    if (count <= 3 && count > 0) {
                        if (count > pencils.size()) {
                            System.out.println("Too many pencils were taken");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Possible values: '1', '2' or '3'");
                    }
                } catch (Exception e) {
                    System.out.println("Possible values: '1', '2' or '3'");
                }
            } else if (name.equals(bot)) {
                if (pencils.size() % 4 == 1) {
                    if (pencils.size() == 1) {
                        count = 1;
                    } else {
                        count = rand.nextInt(2) + 1;
                    }
                } else {
                    if (pencils.size() % 4 == 0) {
                        count = 3;
                    } else if (pencils.size() % 4 == 3) {
                        count = 2;
                    } else {
                        count = 1;
                    }
                }
                System.out.println(count);
                break;
            }
        }

        for (int i = 0; i < count; i++) {
            pencils.remove(0);
        }

        return name;
    }
}
