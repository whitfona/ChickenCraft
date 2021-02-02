
/**
 * This class creates the chickens, User is able to set name and initial amount of seed in chicken's stomach
 * and then interact with chicken.
 * @author Nick Whitford
 */
public class Chicken {
    //create all the variables
    /** Set if chicken is happy or sad, happy by default **/
    private boolean happyOrSad = true;
    /** Set if chicken is alive or dead, alive by default **/
    private boolean aliveOrDead = true;
    /** Set initial name of chicken **/
    private String name = "Nancy";
    /** Set initial number of hearts for chicken **/
    private int hearts = 4;
    /** Set set initial amount of seed in chicken **/
    private double seed = 0.1;
    /** Initialize eggs so it can be used in calculations later **/
    public int eggs;

    // ************* START OF GETTERS *************
    // Getter for eggs
    public int getEggs() {
        return eggs;
    }
    // Getter for name
    public String getName() {
        return name;
    }

    //************* START OF SETTERS *************
    // Setter for name to change chicken's name
    public void setName(String name) {
        this.name = name;
    }
    // Setter to seed to change initial value of seed
    public void setSeed(double seed) {
        this.seed = seed;
    }

    // ************* START OF METHODS *************
    // Feed chicken amount of seed input by user
    /**
     * Adds the amount of seed input by user into chicken's stomach and make it sad
     * amoutOfSeedToFeed is the amount of seed in kg input by the user
     * @param amountOfSeedToFeed
     */
    public void feedChickenSeed(double amountOfSeedToFeed) {
        // Check if chicken is alive or dead
        if (this.seed > 2.0 || this.hearts == 0) {
            System.out.println("You can't feed a dead chicken!");
        } else {
            // update amount of seed in chicken
            this.seed += amountOfSeedToFeed;
            // increase hearts by 1, to a max of four
            this.hearts += 1;
            // check number of hearts is not over 4
            if (this.hearts > 4) {
                this.hearts = 4;
            }
            // set happy or sad status to happy after being fed
            this.happyOrSad = true;
            // check if amount of seed in chicken is over 2.0kg
            if (this.seed > 2.0) {
                this.aliveOrDead = false;
                this.hearts = 0;
            }
        }
    }

    // Play with two chickens
    /**
     * Allows to chickens to play and makes them both happy
     * playmate is the second chicken (playmate) input by the user
     * @param playmate
     */
    public void playWithChicken(Chicken playmate) {
        if (this.hearts <= 0 || playmate.hearts <= 0) {
            System.out.println("You can't play with a dead chicken!");
        } else {
            this.happyOrSad = true;
            playmate.happyOrSad = true;
            System.out.println("This chickens are happy after playing!");
        }
    }

    // Hit chicken
    /**
     * Hit the chicken selected by the user, reduce it's hearts by one and make it sad
     */
    public void hitChicken() {
        if (this.hearts <= 0) {
            System.out.println("You can't hit a dead chicken!");
        } else {
            // reduce hearts of chicken by 1
            this.hearts -= 1;
            // update if chicken is happy or sad
            this.happyOrSad = false;

            // check if number of hearts is 0 or less
            if (this.hearts  <= 0) {
                this.aliveOrDead = false;
                this.hearts = 0;
            }
        }
    }

    // Get number of eggs from chicken
    /**
     * Calculates the number of eggs from selected chicken (x2 if happy) and makes chicken sad
     * @return number of eggs from the chicken
     */
    public int getEggsFromChicken() {
        if (this.hearts <= 0) {
            System.out.println("You can't get eggs from a dead chicken!");
        } else {
            // check if chicken is happy or sad
            if (this.happyOrSad) {
                double eggMath = this.seed / 0.25;
                this.eggs = (int)eggMath;
                // reduce amount of seed in chicken
                this.seed -= this.eggs * 0.25;
                // double number of eggs because chicken is happy
                this.eggs *= 2;
                // make chicken sad from laying eggs
                this.happyOrSad = false;
            } else {
                // get number of eggs from chicken
                double eggMath = this.seed / 0.25;
                this.eggs = (int)eggMath;
                // reduce amount of seed in chicken
                this.seed -= this.eggs * 0.25;
                // make chicken sad from laying eggs
                this.happyOrSad = false;
            }
        }
        return this.eggs;
    }

    // toString, displays information about the chicken
    /**
     * Prints all variables as a string.
     * @return output formatted as a string
     */
    public String toString() {
        /** Create variable to write 'happy' or 'sad' **/
        String happyOrSadOutput = "Happy";
        if (!happyOrSad) {
            happyOrSadOutput = "Sad";
        }
        /** Create variable to write 'alive' or 'dead' **/
        String aliveOrDeadOutput = "Alive";
        if (!aliveOrDead) {
            aliveOrDeadOutput = "Dead";
        }

        return happyOrSadOutput + " " + aliveOrDeadOutput + " Chicken " + name + ":" + String.format(" %.2f ", seed) + "kg seeds," + String.format(" %d ", hearts) + "hearts.";
    }
}
