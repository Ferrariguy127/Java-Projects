import java.util.Random;

public class Rabbit {

    //sex
    private static final int MIN_GESTATION_DAYS = 28;
    private static final int MAX_GESTATION_DAYS = 32;
    private static final int MIN_LITTER_SIZE = 3;
    private static final int MAX_LITTER_SIZE = 8;
    private boolean isFemale;
    private int age;
    private boolean isPregnant;
    private int gestationPeriod;
    private int daysInGestation;
    private int daysAfterDelivery;
    //Basic Object for Rabbit to create it initially
    public Rabbit(boolean isFemale) {
        this.isFemale = isFemale;
        this.age = 0;
        this.isPregnant = false;
        this.daysInGestation = 0;
        this.daysAfterDelivery = -1;
    }
    //When Rabbits give birth allows a 50/50 chance of it being male or female
    public Rabbit() {
        this.isFemale = new Random().nextBoolean();
        this.age = 0;
        this.isPregnant = false;
        this.daysInGestation = 0;
        this.daysAfterDelivery = -1; //counts down from 7 til it becomes pregnant again
    }
    private void setRandomGestationPeriod() {
        this.gestationPeriod = new Random().nextInt(MAX_GESTATION_DAYS - MIN_GESTATION_DAYS + 1) + MIN_GESTATION_DAYS;
    }
    public int getGestationPeriod(){
        return gestationPeriod;
    }
    public int getDaysInGestation(){
        return daysInGestation;
    }
    public boolean isFemale() {
        return isFemale;
    }
    public int getAge() {
        return age;
    }
    //Increment age increases the age, gestation and as long is it above
    //0 days past delivery it can become pregnant again
    public void incrementAge() {
        age++;
        if (isPregnant) {
            daysInGestation++;
        } else if (daysAfterDelivery >= 0) {
            daysAfterDelivery++;
        }
    }
    //checks if the Rabbit is pregnant, returns true if is or false if isn't
    public boolean isPregnant() {
        return isPregnant;
    }

    public void setPregnant() {
        setRandomGestationPeriod();
        isPregnant = true;
    }

    public int getDaysAfterDelivery() {
        return daysAfterDelivery;
    }
    //sets days after delivery
    public void setDaysAfterDelivery(int daysAfterDelivery) {
        this.daysAfterDelivery = daysAfterDelivery;
    }
    //give birth takes the max number of potential rabbits and subtracts the minimum
    //to give a random amount between those values
    public int giveBirth() {
        this.daysAfterDelivery=0;
        return new Random().nextInt(MAX_LITTER_SIZE - MIN_LITTER_SIZE + 1) + MIN_LITTER_SIZE;
    }
}