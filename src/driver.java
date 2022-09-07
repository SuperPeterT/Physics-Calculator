import java.text.DecimalFormat;
import java.util.*;

public class driver {

    public static void main(String[] args) {
        double mass, force, acceleration = 0;
        double velocity, angle, height, hmax = 0;
        double weight, angle1, angle2, t1, t2 = 0;

        DecimalFormat f = new DecimalFormat("##.00");

        System.out.println("Welcome to Peter's Multi Physics Calculator\n");
        Scanner input = new Scanner(System.in);

        char inPut;

        while (true) {
            System.out.println(
                    "Main Menu:\nA. Newton Second Law Calculator\nB. Projectile Maximum Height Calculator\nC. Object Hanging by Rope Tension Calculator\nX. Exit \n");
            System.out.print("Enter your choice: ");
            inPut = input.next().charAt(0);
            System.out.print("\n");

            if (inPut == 'A' || inPut == 'B' || inPut == 'C') {
                switch (inPut) {

                    case 'A':
                        System.out.println("Welcome to Peter's Newton's Second Law Calculator\n");
                        while (true) {
                            System.out.println(
                                    "Please select from the following options:\n\nA. Finding Mass (kg) given Force (N) and Acceleration (m/s^2)\nB. Finding Force (N) given Mass (kg) and Acceleration (m/s^2)"
                                            + "\nC. Finding Acceleration (m/s^2) given Mass (kg) and Force (N)\nX. Exit \n");
                            System.out.print("Enter your choice: ");
                            inPut = input.next().charAt(0);
                            System.out.print("\n");

                            if (inPut == 'A' || inPut == 'B' || inPut == 'C' || inPut == 'D' || inPut == 'E'
                                    || inPut == 'F') {
                                switch (inPut) {

                                    case 'A': // finding mass
                                        System.out.println("Equation to use:");
                                        System.out.printf("%9s", "F\n");
                                        System.out.printf("%10s", "M = ---\n");
                                        System.out.printf("%9s", "A\n");

                                        System.out.print("Enter force in Newtons (N): ");
                                        force = input.nextDouble();

                                        System.out.print("Enter acceleration in meter per second squared (m/s^2): ");
                                        acceleration = input.nextDouble();

                                        // calculation
                                        mass = force / acceleration;

                                        System.out.println("The mass is " + f.format(mass) + " kg\n");
                                        promptEnterKey();
                                        break;

                                    case 'B': // finding force

                                        System.out.println("Equation to use:");
                                        System.out.printf("%10s", "F = M * A\n");
                                        System.out.print("\n");
                                        System.out.print("Enter mass in kilograms (kg): ");
                                        mass = input.nextDouble();

                                        System.out.print("Enter acceleration in meter per second squared (m/s^2): ");
                                        acceleration = input.nextDouble();

                                        force = mass * acceleration;

                                        System.out.println("The force is " + f.format(force) + " N\n");
                                        promptEnterKey();
                                        break;

                                    case 'C': // finding acceleration
                                        System.out.println("Equation to use:");
                                        System.out.printf("%9s", "F\n");
                                        System.out.printf("%10s", "A = ---\n");
                                        System.out.printf("%9s", "M\n");

                                        System.out.print("Enter force in Newtons (N): ");
                                        force = input.nextDouble();

                                        System.out.print("Enter mass in kilograms (kg): ");
                                        mass = input.nextDouble();

                                        acceleration = force / mass;
                                        System.out.println("The acceleration is " + f.format(acceleration) + " m/s^2\n");
                                        promptEnterKey();
                                        break;

                                }

                            } // end of if statement

                            else if (inPut == 'X') {
                                break;
                            }

                            else {
                                System.out.print("Invalid menu option. Please enter A-C or X to exit.\n\n");
                                promptEnterKey();

                            }

                        } // end case A;

                        break;

                    case 'B':
                        System.out.println("Welcome to Peter's Maximum Height Projectile Calculator\n");
                        System.out.println("***IGNORING AIR RESISTANCE***");
                        System.out.println(
                                "Need to know velocity (m/s), angle of launch (degrees), and initial height (m)\n\n");
                        System.out.println("Equation to use:");
                        System.out.printf("%10s", "hmax = h + Vo^2 * sin(theta)^2 / (2 * g)");
                        System.out.print("\n\n");
                        System.out.print("Enter velocity in meters per second (m/s): ");
                        velocity = input.nextDouble();

                        System.out.print("Enter angle of launch in degrees: ");
                        angle = input.nextDouble();
                        angle = degToRad(angle);

                        System.out.print("Enter initial height (m): ");
                        height = input.nextDouble();

                        if (angle == 0) {
                            System.out.println("The max height is " + f.format(height) + " m");
                            promptEnterKey();
                            break;
                        }

                        else {
                            hmax =  height + (velocity * velocity) * (Math.sin(angle) * Math.sin(angle))  / (2 * 9.80);
                            System.out.println("The max height is " + f.format(hmax) + " m");
                            promptEnterKey();
                            break;
                        }

                    case 'C':
                        System.out.println(
                                "Please select how many ropes the object is hanging by:\nA. One Rope\nB. Two Ropes \n");
                        System.out.print("Enter your choice: ");
                        inPut = input.next().charAt(0);
                        if (inPut == 'A') { // one rope
                            System.out.println("Equation to use:");
                            System.out.println("Tension = m * g\n");
                            System.out.print("Enter mass of object in kilograms (kg): ");
                            mass = input.nextDouble();
                            t1 = mass * 9.81;
                            System.out.println("The tension force is " + f.format(t1) + " N");
                            promptEnterKey();
                            break;
                        }
                        if (inPut == 'B') { // two rope
                            System.out.println("Equation to use:");
                            System.out.printf("%9s", "tension1 = cos(theta) * sin(beta) / cos(beta) + sin(theta)\n");
                            System.out.printf("%9s", "tension2 = cos(beta) * sin(theta) / cos(theta) + sin(beta)\n\n");
                            System.out.print("Enter mass of object in kilograms (kg): ");
                            mass = input.nextDouble();
                            weight = mass * 9.81;

                            System.out.print("Enter angle of first rope in degrees: ");
                            angle1 = input.nextDouble();
                            angle1 = degToRad(angle1);

                            System.out.print("Enter angle of second rope in degrees: ");
                            angle2 = input.nextDouble();
                            angle2 = degToRad(angle2);

                            t1 = weight / ((Math.cos(angle1) * Math.sin(angle2) / Math.cos(angle2) + Math.sin(angle1)));
                            t2 = weight / ((Math.cos(angle2) * Math.sin(angle1) / Math.cos(angle1) + Math.sin(angle2)));

                            System.out.println("The tension force in rope one is  " + f.format(t1) + " N");
                            System.out.println("The tension force in rope two is  " + f.format(t2) + " N");
                            promptEnterKey();
                            break;
                        }

                }// end switch statement
            } // end if statement
            else if (inPut == 'X') {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.print("Invalid menu option. Please enter A-B or X to exit.\n\n");
                promptEnterKey();
            }

        }
    }

    public static double degToRad(double x) {
        x = x * Math.PI / 180;

        return x;
    }

    public static void promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}

/*
 * https://www.calculatorsoup.com/calculators/physics/force.php (Newton Second Law)
 * https://www.omnicalculator.com/physics/tension (Tension Force)
 * https://www.omnicalculator.com/physics/maximum-height-projectile-motion (Maximum Height)
 */
