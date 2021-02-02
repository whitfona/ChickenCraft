import java.util.Scanner;

/**
 * Welcome to the world of 'ChickenCraft'
 * Interact with your chickens by feeding, playing or hitting them
 * @author Nick Whitford
 */

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /** Instantiate three chickens **/
        Chicken chicken1 = new Chicken();
        Chicken chicken2 = new Chicken();
        Chicken chicken3 = new Chicken();
        /** use chicken.setName(String) to change chicken's name **/
        System.out.print("Rename chicken 1: ");
        chicken1.setName(scanner.next());
        System.out.print("Rename chicken 2: ");
        chicken2.setName(scanner.next());
        //System.out.print("Rename chicken 3: "); //commented out so default displays
        //chicken3.setName(scanner.next());
        /** use chicken.setSeed(int) to change the initial amount of seed in chicken **/
        System.out.print("Set initial seed amount for " + chicken1.getName() + " : ");
        chicken1.setSeed(scanner.nextDouble());
        System.out.print("Set initial seed amount for " + chicken2.getName() + " : ");
        chicken2.setSeed(scanner.nextDouble());
        //System.out.print("set initial seed amount for " + chicken3.getName() + " : "); //commented out so default displays
        //chicken3.setSeed(scanner.nextDouble());


        /** Create variable to store user selection **/
        int action;

        do {
            System.out.println("1. " + chicken1);
            System.out.println("2. " + chicken2);
            System.out.println("3. " + chicken3);
            System.out.println();
            System.out.println("1. Feed    2. Play    3. Hit    4. Get Eggs    5. Quit");
            /** Save selection from user as 'action' **/
            System.out.print("Choice: ");
            action = scanner.nextInt();
            if (action < 1 || action > 5) {
                System.out.println("Invalid input, please select again");
            }

            /** If user selects options 1 to Feed a chicken **/
            if (action == 1) {
                int selection;
                double seedToFeed;
                do {
                    System.out.print("Which Chicken? ");
                    selection = scanner.nextInt();

                    if (selection < 1 || selection > 3) {
                        System.out.println("Invalid Selection, please choose again.");
                    } else {
                        System.out.print("How much feed? ");
                        seedToFeed = scanner.nextDouble();
                        if (selection == 1) { // if user selects chicken 1
                            chicken1.feedChickenSeed(seedToFeed);
                        } else if (selection == 2) { // if user selects chicken 2
                            chicken2.feedChickenSeed(seedToFeed);
                        } else { // if user selects chicken 3
                            chicken3.feedChickenSeed(seedToFeed);
                        }
                    }
                } while (selection < 1 || selection > 3);
            }
            /** If user selects options 2 to Play a chicken **/
            else if (action == 2) {
                int selection;
                int playmate;
                do {
                    System.out.print("Which Chicken? ");
                    selection = scanner.nextInt();
                    System.out.print("Which playmate? ");
                    playmate = scanner.nextInt();
                    if (selection < 1 || selection > 3 || playmate < 1 || playmate > 3) {
                        System.out.println("Invalid Selection, please choose again.");
                    } else {
                        if (selection == 1 && playmate == 2) {
                            chicken1.playWithChicken(chicken2);
                        } else if (selection == 1 && playmate == 3) {
                            chicken1.playWithChicken(chicken3);
                        } else if (selection == 2 && playmate == 3) {
                            chicken2.playWithChicken(chicken3);
                        } else {
                            System.out.println("Playmates must be different chickens!");
                        }
                    }
                } while (selection < 1 || selection > 3 || playmate < 1 || playmate > 3);
            }
            /** If user selects options 3 to Hit a chicken **/
            else if (action == 3) {
                int selection;
                do {
                    System.out.print("Which Chicken? ");
                    selection = scanner.nextInt();
                    if (selection < 1 || selection > 3) {
                        System.out.println("Invalid Selection, please choose again.");
                    } else {
                        System.out.println("Ouch!");
                        if (selection == 1) { // if user selects chicken 1
                            chicken1.hitChicken();
                        } else if (selection == 2) { // if user selects chicken 2
                            chicken2.hitChicken();
                        } else { // if user selects chicken 3
                            chicken3.hitChicken();
                        }
                    }
                } while (selection < 1 || selection > 3);
            }
            /** If user selects options 4 to get the eggs from a chicken **/
            else if (action == 4) {
                int selection;
                do {
                    System.out.print("Which Chicken? ");
                    selection = scanner.nextInt();
                    if (selection < 1 || selection > 3) {
                        System.out.println("Invalid Selection, please choose again.");
                    } else {
                        if (selection == 1) { // if user selects chicken 1
                            System.out.println("You got " + chicken1.getEggsFromChicken() + " eggs.");
                        } else if (selection == 2) { // if user selects chicken 2
                            System.out.println("You got " + chicken2.getEggsFromChicken() + " eggs.");
                        } else { // if user selects chicken 3
                            System.out.println("You got " + chicken3.getEggsFromChicken() + " eggs.");
                        }
                    }
                } while (selection < 1 || selection > 3);
            }

        } while (action != 5);
        System.out.println("Thanks for playing!");
    }
}
