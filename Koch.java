/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {

        //// Uncomment the first code block to test the curve function.
        //// Uncomment the second code block to test the snowflake function.
        //// Uncomment only one block in each test, and remember to compile
        //// the class whenever you change the test.

        /*
        // Tests the curve function:
        // Gets n, x1, y1, x2, y2,
        // and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
        curve(Integer.parseInt(args[0]),
              Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
              Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        */

        /*
        // Tests the snowflake function:
        // Gets n, and draws a Koch snowflake of n edges in the standard canvass.
        snowFlake(Integer.parseInt(args[0]));
        */
    }

    /** Gets n, x1, y1, x2, y2,
     * and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        // תנאי עצירה: אם הגענו לעומק 0, מציירים את הקו הישר
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }
        
        // חישוב נקודות ה-1/3 וה-2/3
        double x_p2 = x1 + (x2 - x1) / 3.0;
        double y_p2 = y1 + (y2 - y1) / 3.0;
        double x_p4 = x1 + 2.0 * (x2 - x1) / 3.0;
        double y_p4 = y1 + 2.0 * (y2 - y1) / 3.0;

        // חישוב קודקוד המשולש (p3) לפי הנוסחה שניתנה
        double h = Math.sqrt(3) / 6.0;
        double x_p3 = (x1 + x2) / 2.0 - h * (y2 - y1);
        double y_p3 = (y1 + y2) / 2.0 + h * (x2 - x1);

        // 4 קריאות רקורסיביות עבור 4 המקטעים החדשים
        curve(n - 1, x1, y1, x_p2, y_p2);
        curve(n - 1, x_p2, y_p2, x_p3, y_p3);
        curve(n - 1, x_p3, y_p3, x_p4, y_p4);
        curve(n - 1, x_p4, y_p4, x2, y2);
    }

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
    public static void snowFlake(int n) {
        // A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        
        // קודקודים למשולש שווה צלעות התחלתי (ממורכז למסך)
        double x1 = 0.200, y1 = 0.650;
        double x2 = 0.800, y2 = 0.650;
        double x3 = 0.500, y3 = 0.130;

        // ציור שלוש עקומות קוך שמחברות את הקודקודים הללו
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}