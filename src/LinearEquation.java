import java.text.DecimalFormat;
    public class LinearEquation {

        //decimal format object for rounding
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
            //formula is square root of ((x2-x1)^2 + (y2-y1)^2)
            double num1 = Math.pow((x2 - x1), 2);
            double num2 = Math.pow((y2 - y1), 2);
            return roundedToHundredth(Math.sqrt(num2+num1));
        }

        /* calculates and returns the y-intercept of the line between (x1, y1) and (x2, y2),
        rounded to the nearest hundredth */
        public double yIntercept() {
            return roundedToHundredth(y1 - (slope() * x1));
        }

        /* Calculates and returns the slope of the line between (x1, y1) and
           (x2, y2), rounded to the nearest hundredth */
        public double slope() {
            return roundedToHundredth((double) (y2-y1)/(x2-x1));
        }

        /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5". */
        public String equation(){
            String equation;
            if (y1 == y2){
                return "y = " + y1;
            }
            if (slope() == 1){
                equation = "y = x";
            } else if (slope() == -1) {
                equation = "y = -x";
            } else if (((y2-y1)%(x2-x1)) == 0) {
                //checks to see if one is a multiple of the other, so it will just print whole number
                equation = "y = " + (int) slope() + "x";
            } else if ((x2-x1) < 0 && (y2-y1) < 0) {
                //checks to see if it's an overall positive fractional slope
                equation = "y = " + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x";
            } else if ((x2-x1) < 0 && (y2-y1) > 0) {
                //checks to see if negative fractional slope, but if (x2-x1) is negative so sign can be moved up
                equation = "y = " + "-" + (y2-y1) + "/" + Math.abs(x2-x1) + "x";
            } else {
                equation = "y = " + (y2-y1) + "/" + (x2-x1) + "x";
            }
            if (yIntercept() < 0){
                //checks if y-intercept is negative, so it can be subtracted instead of added
                equation += " - " + roundedToHundredth(Math.abs(yIntercept()));
            } else if (yIntercept() > 0) {
                equation += " + " + roundedToHundredth((yIntercept()));
            } else {
                //if y-intercept is 0, nothing is added
                equation += "";
            }
            return equation;
        }

        /* Returns a String of the coordinate point on the line that has the given x value, with
            both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
        public String coordinateForX(double xValue) {
            return "(" + xValue + ", " + roundedToHundredth((xValue * slope()) + yIntercept()) + ")";
        }

        //love it
        /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
            to the nearest hundredth */
        public double roundedToHundredth(double toRound) {
            return Double.parseDouble(format.format(toRound));
        }

        /* Returns a string that includes all information about the linear equation (points, equation, slope, y-int,
         distance */
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
