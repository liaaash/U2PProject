import java.text.DecimalFormat;
public class LinearEquation {
    DecimalFormat format = new DecimalFormat("#.##");
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /* Creates a LinearEquation object */
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance() {
        double num1 = Math.pow((x2 - x1), 2);
        double num2 = Math.pow((y2 - y1), 2);
        return roundedToHundredth(Math.sqrt(num2+num1));
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope() {
        return roundedToHundredth((double) (y2-y1)/(x2-x1));
    }
    /* calculates and returns the y-intercept of the line between (x1, y1) and (x2, y2),
    rounded to the nearest hundredth */
    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }

    public String equation(){
        String str;
        if (x1 == x2) {
            return "These points are on a vertical line: x = " + x1;
        }
        if (y1 == y2){
            return "y = " + y1;
        }
        if (slope() == 1){
            str = "y = x";
        } else if (slope() == -1) {
            str = "y = -x";
        } else if (((y2-y1)%(x2-x1)) == 0) {
            str = "y = " + (int) slope() + "x";
        } else if ((x2-x1) < 0 && (y2-y1) < 0) {
            str = "y = " + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x";
        } else if ((x2-x1) < 0 && (y2-y1) > 0) {
            str = "y = " + "-" + (y2-y1) + "/" + Math.abs(x2-x1) + "x";
        } else {
            str = "y = " + (y2-y1) + "/" + (x2-x1) + "x";
        }
        if (yIntercept() < 0){
            str += " - " + roundedToHundredth(Math.abs(yIntercept()));
        } else if (yIntercept() > 0) {
            str += " + " + roundedToHundredth((yIntercept()));
        } else {
            str += "";
        }
        return str;
    }

    public String coordinateForX(double xValue) {
        return "(" + xValue + ", " + (xValue * slope()) + (yIntercept()) + ")";
    }

    //love it
    public double roundedToHundredth(double toRound) {
        return Double.parseDouble(format.format(toRound));
    }
    public String lineInfo() {
        if (x1 == x2){
            return equation();
        }
        String str = "The two points are " + "(" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        str += "\nThe equation of the line between these two points are: " + equation();
        if (slope() == 0) {
            str += "\nThe slope of this line is: 0";
        } else {
            str += "\nThe slope of this line is: " + (slope());
        }
        str += "\nThe y-intercept of this line is: " + (yIntercept());
        str += "\nThe distance between the two points is: " + (distance()) + "\n";
        return str;
    }

}
