import java.util.Stack;

public class SolutionA {

    private static Stack<String> history = new Stack<String>();

    public static Boolean isBrowsingHistoryEmpty() { // [TimeComplexity= O(1)]
        // Check Size of History ,If 0 then return true
        if (history.size() == 0)
            return true;
        else
            return false;
    }


    public static String mostRecentlyVisitedSite() { // [TimeComplexity= O(1)]

        return history.peek(); //Peek will return the top most element from Stack

    }

    public static void addSiteToHistory(String url) { // [TimeComplexity= O(1)]
        history.push(url); //Push method will add the site to the top of the history Stack
    }


    public static void goBackInTime(int n) {  // [TimeComplexity= O(N)]

        if (!isBrowsingHistoryEmpty()) { // Check if the user has an empty browsing history, then do nothing
            while (n > 0) {          // Looping up to n times from top of the Stack for traverse back in time
                history.pop();   //Removes the n most recently websites from the browsing history
                n--;
            }
        }

    }

    public static void printBrowsingHistory() {

        if (history.isEmpty()) {//Check browser history availability
            System.out.println("No Browsing History");
        } else {
            System.out.println(history); // Print history
        }
    }

    public static void main(String[] args) {
        System.out.println(isBrowsingHistoryEmpty()); // Checking if Browsing History is Empty
        addSiteToHistory("www.google.co.in"); // Navigating to Google
        addSiteToHistory("www.facebook.com"); // Navigating to Facebook
        addSiteToHistory("www.upgrad.com"); // Navigating to UpGrad
        System.out.println(isBrowsingHistoryEmpty()); // Checking if Browsing History is Empty
        System.out.println(mostRecentlyVisitedSite()); // Fetching most recently visited site (UpGrad)
        addSiteToHistory("www.youtube.com"); // Navigating to Youtube
        goBackInTime(2); // Going back by 2 sites
        addSiteToHistory("www.yahoo.com"); // Navigating to UpGrad platform site
        System.out.println(mostRecentlyVisitedSite()); // Fetching most recently visited site (UpGrad Learn Platform)
        printBrowsingHistory(); // Printing browsing history

    }

}

/**
 * Your code should have the following Output:
 * <p>
 * true
 * false
 * www.upgrad.com
 * www.yahoo.com
 * [www.google.co.in, www.facebook.com, www.yahoo.com]
 */
