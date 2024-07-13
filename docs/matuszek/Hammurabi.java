package hammurabi.docs.matuszek;//package hammurabi;
import java.util.Random;         // imports go here
import java.util.Scanner;

public class Hammurabi {

   public int population = 100;
   public int bushels = 2800;
   public int acresOwned = 1000;
   public int landValue= 19;
   public boolean gameOn = true;


Random rand = new Random();  // this is an instance variable
Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) { // required in every Java program
            new Hammurabi().playGame();
        }

        void playGame() {
            System.out.println("hello world");
            // declare local variables here: grain, population, etc.

            // statements go after the declations
            System.out.println("O great hammurabi.docs.matuszek.Hammurabi!\n" +
                    "You are in year 1 of your ten year rule.\n" +
                    "In the previous year 0 people starved to death.\n" +
                    "In the previous year 5 people entered the kingdom.\n" +
                    "The population is now 100.\n" +
                    "We harvested 3000 bushels at 3 bushels per acre.\n" +
                    "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                    "The city owns 1000 acres of land.\n" +
                    "Land is currently worth 19 bushels per acre.");
            while(gameOn) {
                askHowManyAcresToBuy(19, bushels);
                askHowManyAcresToSell(acresOwned);
                askHowMuchGrainToFeedPeople(bushels);
                askHowManyAcresToPlant(acresOwned, population, bushels);
                plagueDeaths(population);
                starvationDeaths(population, bushels);
                uprising(population, 0);

            }
            scanner.close();






        }

        //other methods go here
        int askHowManyAcresToBuy(int price, int bushels){
            System.out.println("How many acres of land would you like to buy \n");
            int userInput = scanner.nextInt();
            price = userInput * 19;
            if(bushels >= price){
                this.bushels-= price;
                this.acresOwned += userInput;
            }else{
                System.out.println("You dont have enough bushels to purchase the acres.");
            }
            System.out.println("You have " + this.bushels + " amount of bushels left, and you have " + this.acresOwned + " amount of acres"  );
            return userInput;
        }
        public int askHowManyAcresToSell(int acresOwned){
            System.out.println("How many acres of land would you like to sell \n");
            int userInput = scanner.nextInt();
            if(userInput <= acresOwned){
                this.acresOwned -= userInput;
                this.bushels += userInput * landValue;
            }else{
                System.out.println("You don't enough acres to sell that amount");
            }
            System.out.println("You have " + this.bushels + " amount of bushels left");
            return userInput;
        }

        public int askHowMuchGrainToFeedPeople(int bushels){
            System.out.println("How many bushels would you like to feed the people \n");
            int userInput = scanner.nextInt();
            if(this.bushels >= userInput){
                this.bushels -= userInput;
            }else{
                System.out.println("You don't have enough bushels to give, you currently have " + this.bushels + " amount of bushels");
            }
            System.out.println("Thank you for feeding the people " + userInput + " amount of bushels, you currently have " + this.bushels + " amount left.");
            return userInput;
        }
        public int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
            while(true) {
                System.out.println("How many acres would you like to plant with grain?");
                int acresToPlant = scanner.nextInt();
                int amountOfBushelsNeeded = acresToPlant * 2;
                int amountOfPeopleNeeded = acresToPlant / 10;
                if (acresOwned >= acresToPlant && bushels >= amountOfBushelsNeeded && this.population >= amountOfPeopleNeeded) {
                    System.out.println("You're in the process of planting " + acresToPlant + " amount of acres");
                    this.bushels -= amountOfBushelsNeeded;
                    return acresToPlant;
                    //break;
                } else {
                    System.out.println("You can't plant these amount of acres");
                }
            }
        }

        public int plagueDeaths(int population){
            Random random = new Random();
            //System.out.println("your population is: " + this.population);
            if(random.nextInt(101) < 15){
                System.out.println("Unfortunately, due to the plague your population has been cut in half");
                this.population -= this.population /2;
                return this.population;
            }
            //System.out.println("the new population is: " + this.population);
            return 0;
        }

        public int starvationDeaths(int population, int bushelsFedToPeople){
            int amountOfBushelsNeeded = population * 20;
            if(bushelsFedToPeople>=amountOfBushelsNeeded){
                this.bushels -= amountOfBushelsNeeded;
                return 0;
            }
                int bushelsShort = amountOfBushelsNeeded - bushelsFedToPeople;
                double amountOfPeopleStarved = (double) bushelsShort /20;
                double numberCeil = Math.ceil(amountOfPeopleStarved);
                this.population -= (int) numberCeil;
                return (int) numberCeil;
        }

        public boolean uprising(int population, int howManyPeopleStarved){
            double populationNumber = (double) population * 0.45;
            if(howManyPeopleStarved > populationNumber){
                System.out.println("You're fired, game is done ");
                gameOn = false;
                return true;
            }
            return false;

        }
        public int immigrants(int population, int acresOwned, int grainInStorage){
            if(starvationDeaths(population, grainInStorage) == 0){
               int results=  (20 * acresOwned + grainInStorage) / (100 * population) + 1;
                System.out.println("you gains this much immigrants");
                return results;
            }
            System.out.println("no immigrants");
            return 0;

        }

        public int harvest(int acres){
            Random random = new Random();
            int randomNum = random.nextInt(6)+1;
            this.bushels += acres * randomNum;
            return acres * randomNum;
        }

        public int grainEatenByRats(int bushels){
            Random random = new Random();
            //System.out.println("your population is: " + this.population);
            if(random.nextInt(101) < 40){
                Random random2 = new Random();
               // random2.nextInt()
               double randomNumber2 = random2.nextInt(21) + 10;
                    return (int) (bushels * randomNumber2 / 100);

            }
            return 0;
        }

    public int newCostOfLand(){
            Random random = new Random();
            int newPrice = random.nextInt(7) + 17;
            return newPrice;
    }






























//    public int plagueDeaths(int i) {
//            return 4;
//    }

//    public int starvationDeaths(int i, int i1) {
//            return 0;
//    }

//    public boolean uprising(int i, int i1) {
//            return false;
//    }

//    public int immigrants(int i, int i1, int i2) {
//            return 0;
//    }

//    public int harvest(int i) {
//            return 0;
//    }

//    public int grainEatenByRats(int i) {
//            return 0;
//    }

//    public int newCostOfLand() {
//            return 0;
//    }
}
