public class LinearEquation {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return roundedToHundredth(distance);
    }

    public Object slope() {
        if (x1 != x2) {
            double slope = (double) (y2 - y1) / (x2 - x1);
            return roundedToHundredth(slope);
        }
        return null;
    }

    public Object yIntercept() {
        if (slope() == null) {
            return null;
        }
        return y1 - ((double) slope() * x1);
    }

    public String equation() {
        String slope = "";
        String interceptVal = "";

        if ((double) yIntercept() < 0) {
            interceptVal = "- " + Math.abs((double) yIntercept());
        } else {
            if ((double) yIntercept() != 0) {
                interceptVal += "+ " + yIntercept();
            }
        }

        if ((double) (y2 - y1) / (x2 - x1) % 1 == 0) {
            slope += (double) (y2 - y1) / (x2 - x1);
            return "y = " + slope + "x " + interceptVal;
        } else if (x1 == x2){
            return "x = " + x1;
        } else {
            int x = x2 - x1;
            int y = y2 - y1;
            if (x / 2 != 0 && y / 2 != 0 && x % 2 == 0 && y % 2 == 0) {
                while (x / 2 != 0 && y / 2 != 0 && x % 2 == 0 && y % 2 == 0) {
                    x /= 2;
                    y /= 2;
                }
            }
            if (x / 3 != 0 && y / 3 != 0 && x % 3 == 0 && y % 3 == 0) {
                while (x / 3 != 0 && y / 3 != 0 && x % 3 == 0 && y % 3 == 0) {
                    x /= 3;
                    y /= 3;
                }
            }
            if (x / 5 != 0 && y / 5 != 0 && x % 5 == 0 && y % 5 == 0) {
                while (x / 5 != 0 && y / 5 != 0 && x % 5 == 0 && y % 5 == 0) {
                    x /= 5;
                    y /= 5;
                }
            }
            if (x / 7 != 0 && y / 7 != 0 && x % 7 == 0 && y % 7 == 0) {
                while (x / 7 != 0 && y / 7 != 0 && x % 7 == 0 && y % 7 == 0) {
                    x /= 7;
                    y /= 7;
                }
            }
            return "y = " + y + "/" + x + "x " + interceptVal;
        }
    }

    public String coordinateForX(double x) {
        if (slope() == null) {
            if (x != x1) {
                return "undefined (No Y value for the coordinate of x (" + x + "))";
            } else {
                return "(" + x + ", Any y value)";
            }
        }
        return "(" + x + ", " + (x * (double) slope() + (double) yIntercept()) + ")";
    }

    public String lineInfo() {
        String yInterceptVal;
        if (yIntercept() == null) {
            yInterceptVal = "No Y-intercept";
        } else {
            yInterceptVal = (double) yIntercept() + "";
        }
        String slopeVal;
        if (slope() == null) {
            slopeVal = "undefined";
        } else {
            slopeVal = (double) slope() + "";
        }

        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") \n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The y-intercept of this line is: " + yInterceptVal + "\n" +
                "The slope of this line is: " + slopeVal + "\n" +
                "The distance between these points is " + distance();
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}