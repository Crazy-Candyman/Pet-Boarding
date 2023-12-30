import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    // Instance field
    private static final ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static final ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static String menuSelection;

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.print("Enter a menu selection: ");
    }

    // Dog list array
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", 1, 25.6, "05-12-2019", "United States",
                false, "United States", "Phase II");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", 3, 35.2, "02-03-2020", "United States", false, "United " +
                "States", "Phase I");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", 4, 25.6, "12-12-2019", "Canada", false,
                "Canada", "In-Service");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Monkey list array
    public static void initializeMonkeyList() {
    }

    // This method to intake a new dog
    public static void intakeNewDog(Scanner scanner) {
        // Reads in name.
        String name = inputValidator("dog", "name");

        // If dog name is in list then it returns to menu.
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Reads in breed of dog.
        String breed = inputValidator("dog", "breed");

        // Reads in gender of dog.
        // Infinite loop until "1" or "2" is selected.
        String gender;
        do {
            System.out.println("Is the dog male or female:");
            System.out.print("\t[1] Male\n\t[2] Female\nEnter a selection: ");
            gender = scanner.nextLine();
            if (gender.equals("1")) {
                gender = "Male";
                break;
            } else if (gender.equals("2")) {
                gender = "Female";
                break;
            }
        } while (true);

        // Reads in age of dog.
        // Infinite loop until age is between 0-31.
        int age;
        do {
            try {
                System.out.print("How old is the dog (0-31): ");
                age = scanner.nextInt();
                if (age > 0 && age < 31) {
                    break;
                } else {
                    System.out.println("You did not enter an age between 0 - 31");
                }
            } catch (InputMismatchException error) { // Catches error if input is a letter.
                System.out.println("Please use numbers, not letters.");
                scanner.nextLine();
            }
        } while (true);

        // Reads in weight of dog.
        // Infinite loop until weight is between 0-210.
        double weight;
        do {
            try {
                System.out.print("Enter dogs weight (lbs)\nmust be between 0-210: ");
                weight = scanner.nextDouble();
                if (weight > 0 && weight < 210) {
                    break;
                } else {
                    System.out.println("You did not enter a weight between 0 - 210 lbs");
                }
            } catch (InputMismatchException error) { // Catches error if input is a letter.
                System.out.println("Please use numbers, not letters.");
                scanner.nextLine();
            }
        } while (true);

        // This clears line
        scanner.nextLine();

        // Reads in date that animal was acquired.
        String dateOfAcquisition = obtainDateOfAquisition();

        // Reads in country that animal was acquired.
        System.out.print("Enter country of acquisition: ");
        String countryOfAcquisition = scanner.nextLine();

        // Reads in country that dog is in service.
        System.out.print("Enter country that dog is in service: ");
        String countryInService = scanner.nextLine();

        // Reads in training status of animal.
        String trainingStatus = obtainTrainingStatus();

        // Reads in if animal is reserved: true or false.
        // Infinite loop until true or false is selected.
        boolean reserved;
        do {
            System.out.println("Enter if dog is reserved: ");
            System.out.println("\t[1] Yes\n\t[2] No\nEnter a Selection: ");
            String selector = scanner.nextLine();
            if (selector.equals("1")) {
                reserved = true;
                break;
            } else if (selector.equals("2")) {
                reserved = false;
                break;
            }
        } while (true);

        // This takes all the inputted information and constructs a new Dog object.
        Dog dog = new Dog(name, breed, gender, age, weight, dateOfAcquisition,
                countryOfAcquisition, reserved, countryInService, trainingStatus);

        // This adds the new Dog object into dogList array.
        dogList.add(dog);
        System.out.println("Dog added to list");
    }

    // Method to intake a new monkey
    public static void intakeNewMonkey(Scanner scanner) {
        // Reads in name of monkey.
        String name = inputValidator("monkey", "name");

        // If monkey is in monkeyList array than program returns to menu.
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Reads in species.
        // Loops until user reads in certain species.
        String species;
        do {
            System.out.println("Enter monkeys species: ");
            species = scanner.nextLine();
        } while (!"capuchin".equalsIgnoreCase(species) && !"guenon".equalsIgnoreCase(species) && !"macaque".equalsIgnoreCase(species) && !
                "marmose".equalsIgnoreCase(species) && !"squirrel monkey".equalsIgnoreCase(species) && !"tamarin".equalsIgnoreCase(species));

        // Reads in gender of monkey.
        // Infinite loop until male or female is selected.
        String gender;
        do {
            System.out.println("Is the monkey male or female:");
            System.out.print("\t[1] Male\n\t[2] Female\nEnter a selection: ");
            gender = scanner.nextLine();
            if (gender.equals("1")) {
                gender = "Male";
                break;
            } else if (gender.equals("2")) {
                gender = "Female";
                break;
            }
        } while (true);

        // Reads in age of monkey.
        // Loops until monkey is between 0-40 years old.
        int age;
        do {
            try {
                System.out.print("How old is the monkey (0-40): ");
                age = scanner.nextInt();
                if (age > 0 && age < 40) {
                    break;
                } else {
                    System.out.println("Please enter an age between 0 - 40.");
                }
            } catch (InputMismatchException error) { // Catches error if letter is entered.
                System.out.println("Please enter a number, not a letter.");
                scanner.nextLine();
            }
        } while (true);

        // Reads in weight of monkey.
        // Loops until weight is between 0 - 140 lbs.
        double weight;
        do {
            try {
                System.out.print("Enter monkeys weight (lbs)\nMust be between 0 - 140: ");
                weight = scanner.nextDouble();
                if (weight > 0 && weight < 140) {
                    break;
                } else {
                    System.out.println("Please enter a weight between 0 - 140 lbs.");
                }
            } catch (InputMismatchException error) { // Catch error if letter is entered.
                System.out.println("Please enter a number, not a letter.");
                scanner.nextLine();
            }
        } while (true);

        // Reads in tail length of monkey.
        // Loops until tail length is between 0 - 32 inches.
        double tailLength;
        do {
            try {
                System.out.print("Enter monkeys tail length (in): ");
                tailLength = scanner.nextDouble();
                if (tailLength > 0 && tailLength < 32) {
                    break;
                } else {
                    System.out.println("Please enter a tail length between 0 - 32 inches long.");
                }
            } catch (InputMismatchException error) { // Catch error if letter is entered.
                System.out.println("Please enter a number, not a letter.");
                scanner.nextLine();
            }
        } while (true);

        // Reads in height of monkey.
        // Loops until height is between 0 - 108 inches.
        double height;
        do {
            try {
                System.out.print("Enter monkeys height (in): ");
                height = scanner.nextDouble();
                if (height > 0 && height < 108) {
                    break;
                } else {
                    System.out.println("Please enter a height between 0 - 108 inches.");
                }
            } catch (InputMismatchException error) { //  Catch error is letter is entered.
                System.out.println("Please enter a number, not a letter.");
                scanner.nextLine();
            }
        } while (true);

        // Reads in body length of monkey.
        // Loops until length is between 0 - 108 inches.
        double bodyLength;
        do {
            try {
                System.out.print("Enter monkeys body length (in): ");
                bodyLength = scanner.nextDouble();
                if (bodyLength > 0 && bodyLength < 108) {
                    break;
                } else {
                    System.out.println("Please enter a length between 0 - 108 inches.");
                }
            } catch (InputMismatchException error) { //  Catch eror is letter is entered.
                System.out.println("Please enter a number, not a letter.");
                scanner.nextLine();
            }
        } while (true);

        // Clears scanner.
        scanner.nextLine();

        // Reads in date monkey was acquired.
        String dateOfAcquisition = obtainDateOfAquisition();

        //Reads in country monkey was acquired.
        System.out.println("Enter country of acquisition: ");
        String countryOfAcquisition = scanner.nextLine();

        // Reads in country that monkey is in service.
        System.out.println("Enter country that monkey is in service: ");
        String countryInService = scanner.nextLine();

        // Reads in training status of monkey.
        String trainingStatus = obtainTrainingStatus();

        // Reads in if monkey is reserved: true or false.
        // Loops until true or false is selected.
        boolean reserved;
        do {
            System.out.println("Enter if monkey is reserved: ");
            System.out.println("\t[1] Yes\n\t[2] No\nEnter a Selection: ");
            String selector = scanner.nextLine();
            if (selector.equals("1")) {
                reserved = true;
                break;
            } else if (selector.equals("2")) {
                reserved = false;
                break;
            }
        } while (true);

        // Uses inputted information and constructs a new Monkey object.
        Monkey monkey = new Monkey(name, age, species, gender, weight, tailLength, bodyLength, height,
                dateOfAcquisition, countryOfAcquisition, reserved, countryInService, trainingStatus);

        // Adds the new Monkey object into monkeyList array.
        monkeyList.add(monkey);
        System.out.println("Monkey added to list");
    }

    // Method to reserve an animal
    public static void reserveAnimal(Scanner scanner) {
        // Loops until animal type matches "dog" or "monkey".
        do {
            System.out.print("\nEnter animal type: ");
            System.out.println("\nDog\nMonkey\n");
            System.out.println("Enter 'Q' to return to menu. ");
            String animalType = scanner.nextLine();

            // If dog is entered.
            if (animalType.equalsIgnoreCase("dog")) {
                // If dogList is NOT empty.
                if (!dogList.isEmpty()) {
                    // Enter country of service.
                    System.out.print("Enter country of service: ");
                    String inServiceCountry = scanner.nextLine();
                    // Check if country of service matches a dog in array list.
                    for (Dog dog : dogList) {
                        if (dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry)) {
                            dog.setReserved(true);
                            System.out.println("You have reserved " + dog.getName());
                            break;
                        } else {
                            System.out.println("No country listed for that animal.");
                        }
                    }
                }
                // If monkey is entered.
            } else if (animalType.equalsIgnoreCase("monkey")) {
                // If monkeyList is NOT empty.
                if (!monkeyList.isEmpty()) {
                    // Enter country of service.
                    System.out.print("Enter country of service: ");
                    String inServiceCountry = scanner.nextLine();
                    // Check if country of service matches a monkey in array list.
                    for (Monkey monkey : monkeyList) {
                        if (monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry)) {
                            monkey.setReserved(true);
                            System.out.println("You have reserved " + monkey.getName());
                            break;
                        } else {
                            System.out.println("No country listed for that animal.");
                        }
                    }
                } else {
                    System.out.println("Sorry, no monkeys available yet.");
                }
                // Returns to menu if "Q" or "q" is entered.
            } else if (animalType.equalsIgnoreCase("q")) {
                return;
                // If "dog", "monkey" or "q" not entered.
            } else {
                System.out.println("Sorry that animal is not available");
            }
        } while (true);
    }

    // This method prints list of monkeys
    public static void printMonkeys() {
        if (!monkeyList.isEmpty()) {
            for (Monkey monkey : monkeyList) {
                System.out.println(monkey.getName());
            }
        } else {
            System.out.println("Sorry, we have no monkeys at this time.");
        }
    }

    // This method prints list of dogs
    public static void printDogs() {
        if (!dogList.isEmpty()) {
            for (Dog dog : dogList) {
                System.out.println(dog.getName());
                System.out.println(dog.getAcquisitionDate());
            }
        } else {
            System.out.println("Sorry, we have no dogs at this time.");
        }
    }

    // This method prints a list of reservable animals that are in service and reserved is false.
    public static void printReservableAnimals() {
        System.out.println("---Monkeys---");
        if (!monkeyList.isEmpty()) {
            for (Monkey monkey : monkeyList) {
                if (!monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in service")) {
                    System.out.println(monkey);
                }
            }
        } else {
            System.out.println("No monkeys available");
            System.out.println();
        }

        System.out.println("---Dogs---");
        if (!dogList.isEmpty()) {
            for (Dog dog : dogList) {
                if (!dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in-service")) {
                    System.out.println(dog.getName() + " is available for reserve");
                }
            }
        } else {
            System.out.println("No dogs available");
            System.out.println();
        }
    }

    // This method directs menu option here and redirects.
    static void printAnimals() {
        switch (menuSelection) {
            case "4" -> printDogs();
            case "5" -> printMonkeys();
            case "6" -> printReservableAnimals();
        }
    }

    // This method will loop until input are letters only.

    /**
     * This method reads user input for a name of the animal and validates
     * there are only letters in the input. (ex: Max, Spot, Marcel)
     *
     * @param animal To concatenate sentence referring to which animal type.
     * @param x      To concatenate sentence referring to "name", "breed", etc.
     * @return Name of animal
     */
    public static String inputValidator(String animal, String x) {
        String result;
        boolean isInputValid = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.printf("What is the %s's %s: ", animal, x);
            result = scanner.nextLine();

            for (int i = 0; i < result.length(); i++) {
                if (Character.isLetter(result.charAt(i))) {
                    isInputValid = true;
                } else {
                    isInputValid = false;
                    break;
                }
            }
        } while (!isInputValid);

        return result;
    }

    // This method will loop until a training status is selected.
    // This method returns a String: ex (Phase I)
    public static String obtainTrainingStatus() {
        String trainingStatus;
        boolean validator;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter training status: ");
            System.out.println("\t[1] Phase I");
            System.out.println("\t[2] Phase II");
            System.out.println("\t[3] Phase III");
            System.out.println("\t[4] Phase IV");
            System.out.println("\t[5] Phase V");
            System.out.println("\t[6] In Service");
            System.out.println("\t[7] Intake");
            System.out.println();
            System.out.print("Enter a Selection: ");
            trainingStatus = scanner.nextLine();
            validator = false;
            switch (trainingStatus) {
                case "1":
                    trainingStatus = "Phase I";
                    validator = true;
                    break;
                case "2":
                    trainingStatus = "Phase II";
                    validator = true;
                    break;
                case "3":
                    trainingStatus = "Phase III";
                    validator = true;
                    break;
                case "4":
                    trainingStatus = "Phase IV";
                    validator = true;
                    break;
                case "5":
                    trainingStatus = "Phase V";
                    validator = true;
                    break;
                case "6":
                    trainingStatus = "In Service";
                    validator = true;
                    break;
                case "7":
                    trainingStatus = "Intake";
                    validator = true;
                    break;
                default:
                    System.out.println("Please enter a valid selection.");
            }
        } while (!validator);

        return trainingStatus;
    }

    // This method will loop until a proper date is selected.
    // This method breaks down into month, date and year.
    // returns String: ex (03-09-2012)
    public static String obtainDateOfAquisition() {

        Scanner scanner = new Scanner(System.in);
        String dateOfAcquisition;
        System.out.println("Enter date of acquisition: ");

        int month;
        do {
            System.out.println("enter month");
            month = scanner.nextInt();
        } while (month < 0 && month > 12);

        int date;
        do {
            System.out.println("enter date");
            date = scanner.nextInt();
        } while (date < 0 && date > 31);

        int year;
        do {
            System.out.println("enter year");
            year = scanner.nextInt();
        } while (year < 2022);

        scanner.nextLine();

        dateOfAcquisition = String.format("%02d-%02d-%4d", month, date, year);

        return dateOfAcquisition;
    }

    // Driver main field for program start.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        initializeDogList();
        initializeMonkeyList();

        // Loop until "q" or "Q" is entered.
        do {
            displayMenu(); // Displays menu options.
            menuSelection = input.nextLine();
            switch (menuSelection) {
                case "1":
                    intakeNewDog(input);
                    break;
                case "2":
                    intakeNewMonkey(input);
                    break;
                case "3":
                    reserveAnimal(input);
                    break;
                case "4", "5", "6":
                    printAnimals();
                    break;
                case "q":
                    break;
                default:
                    System.out.println("Please enter a valid selection.");
            }
        } while (!menuSelection.equalsIgnoreCase("q"));
    }

}

