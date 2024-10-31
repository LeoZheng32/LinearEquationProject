import java.util.Scanner;

public class LinearEquationLogic {
    private String cord1;
    private String cord2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private final Scanner scan;

    public LinearEquationLogic() {
        cord1 = null;
        cord2 = null;
        scan = new Scanner(System.in);
    }

    public void start() {
        getData();
        getXAndYValue();
        print();
    }

    private void getData() {
        System.out.println("Hello there please give me 2 coordinates");
        System.out.print("Coordinate 1: ");
        cord1 = scan.nextLine();
        System.out.print("Coordinate 2: ");
        cord2 = scan.nextLine();
    }

    private void getXAndYValue() {
        x1 = Integer.parseInt(cord1.substring(1, cord1.indexOf(",")));
        y1 = Integer.parseInt(cord1.substring(cord1.indexOf(",") + 2, cord1.indexOf(")")));
        x2 = Integer.parseInt(cord2.substring(1, cord2.indexOf(",")));
        y2 = Integer.parseInt(cord2.substring(cord2.indexOf(",") + 2, cord2.indexOf(")")));
    }

    private void print() {
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
        System.out.println("Equation: " + equation.equation());
        System.out.println("y-intercept: " + equation.yIntercept());
        System.out.println("Slope: " + equation.slope());
        System.out.println("Distance: " + equation.distance());
        System.out.println();
        System.out.println("----- Line info -----");
        System.out.println(equation.lineInfo());
        System.out.println();
        System.out.print("Enter a value for x: ");
        double findYForX = scan.nextDouble();
        scan.nextLine();
        System.out.println("Coordinate for x: " + equation.coordinateForX(findYForX));
        boolean inputAnotherX = true;
        while (inputAnotherX) {
            System.out.println();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            String answer = scan.nextLine();
            if (answer.equals("y")) {
                start();
            } else {
                inputAnotherX = false;
            }
        }
    }
}
