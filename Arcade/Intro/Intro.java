
public class CodeFightIntro {
    
    public CodeFightIntro() {}
    
    // THE JOURNEY BEGINS
    
    // Write a function that returns the sum of two numbers.
    // Precondition: -1000 ≤ param2 ≤ 1000
    int add(int param1, int param2) { return param1 + param2; }
    
    // Given a year, return the century it is in. The first century spans from
    // the year 1 up to and including the year 100, the second - from the year
    // 101 up to and including the year 200, etc.
    // Precondition: 1 ≤ year ≤ 2005
    int centuryFromYear(int year) {
        int century = year / 100;
        
        if (0 != year % 100)
        century ++;
        
        return century;
    }
    
    // Given the string, check if it is a palindrome.
    // Precondition: 1 ≤ inputString.length ≤ 10^5
    boolean checkPalindrome(String inputString) {
        int x = inputString.length();
        
        if(0 == x || 1 == x) {
            return true;
        } else if(inputString.charAt(0) != inputString.charAt(x - 1)) {
            return false;
        } else {
            return checkPalindrome(inputString.substring(1, x - 1));
        }
    }
    
    // EDGE OF THE OCEAN
    
    // Given an array of integers, find the pair of adjacent elements that has the
    // largest product and return that product.
    // Preconditions: 2 ≤ inputArray.length ≤ 10, -1000 ≤ inputArray[i] ≤ 1000
    int adjacentElementsProduct(int[] inputArray) {
        int product = inputArray[0] * inputArray[1];
        int length = inputArray.length;
        
        for(int i = 2; i < length; i++) {
            int pro = inputArray[i - 1] * inputArray[i];
            if(pro > product)
            product = pro;
        }
        
        return product;
    }
    
    // Below we will define an n-interesting polygon. Your task is to find the
    // area of a polygon for a given n.
    // Precondition: 1 ≤ n < 10^4
    int shapeArea(int n) {
        if(0 == n || 1 == n) {
            return n;
        } else {
            return (n - 1) * 4 + shapeArea(n - 1);
        }
    }
    
    // Ratiorg got statues of different sizes as a present from CodeMaster for his
    // birthday, each statue having an non-negative integer size. Since he likes
    // to make things perfect, he wants to arrange them from smallest to largest
    // so that each statue will be bigger than the previous one exactly by 1. He
    // may need some additional statues to be able to accomplish that. Help him
    // figure out the minimum number of additional statues needed.
    // Preconditions: 1 ≤ statues.length ≤ 10,0 ≤ statues[i] ≤ 20.
    int makeArrayConsecutive2(int[] statues) {
        int min = 20;
        int max = 0;
        
        for(int i = 0; i < statues.length; i ++) {
            if(statues[i] < min)
            min = statues[i];
            if(max < statues[i])
            max = statues[i];
        }
        
        return max - min - statues.length + 1;
    }
    
    // Given a sequence of integers as an array, determine whether it is possible
    // to obtain a strictly increasing sequence by removing no more than one
    // element from the array.
    // Preconditions: 2 ≤ sequence.length ≤ 10^5, -105 ≤ sequence[i] ≤ 105.
    boolean almostIncreasingSequence(int[] sequence) {
        int count = 0;
        
        for(int i = 1; i < sequence.length; i++)
        if(sequence[i - 1] >= sequence[i]) {
            count ++;
            if(i != 1 &&
            i < sequence.length - 1 &&
            sequence[i - 1] >= sequence[i + 1] &&
            !(sequence[i - 2] < sequence[i]  &&
            sequence[i] < sequence[i + 1]))
            count ++;
        }
        
        return count < 2;
    }
    
    // After they became famous, the CodeBots all decided to move to a new building
    // and live together. The building is represented by a rectangular matrix of
    // rooms. Each cell in the matrix contains an integer that represents the price
    // of the room. Some rooms are free (their cost is 0), but that's probably because
    // they are haunted, so all the bots are afraid of them. That is why any room
    // that is free or is located anywhere below a free room in the same column is
    // not considered suitable for the bots to live in.
    // Help the bots calculate the total price of all the rooms that are suitable for them.
    // Preconditions: 1 ≤ matrix.length ≤ 5, 1 ≤ matrix[i].length ≤ 5, 0 ≤ matrix[i][j] ≤ 10.
    int matrixElementsSum(int[][] matrix) {
        int sum = 0;
        
        for(int column = 0; column < matrix[0].length; column ++)
        for(int row = 0; row < matrix.length; row ++)
        if(matrix[row][column] != 0)
        sum += matrix[row][column];
        else
        break;
        
        return sum;
    }
    
    // SMOOTH SAILING
    
    // Given an array of strings, return another array containing all of its
    // longest strings.
    // Preconditions: 1 ≤ inputArray.length ≤ 10, 1 ≤ inputArray[i].length ≤ 10.
    String[] allLongestStrings(String[] inputArray) {
        
        ArrayList<String> allLongestStrings = new ArrayList<String>();
        int max = 0;
        
        for(int i = 0; i < inputArray.length; i++) {
            
            if(max < inputArray[i].length()) {
                max = inputArray[i].length();
                allLongestStrings.clear();
            }
            
            if(max == inputArray[i].length())
            allLongestStrings.add(inputArray[i]);
            
        }
        
        return allLongestStrings.toArray(new String[allLongestStrings.size()]);
    }
    
    // Given two strings, find the number of common characters between them.
    // Preconditions: 1 ≤ s1.length ≤ 15, 1 ≤ s2.length ≤ 15.
    // Precondition: A string consisting of lowercase English letters.
    int commonCharacterCount(String s1, String s2) {
        int count = 0;
        ArrayList<Integer> list_s2 = new ArrayList<>();
        
        for(int i = 0; i < s1.length(); i++)
        for(int j = 0; j < s2.length(); j++)
        if(!list_s2.contains(j) && s1.charAt(i) == s2.charAt(j)) {
            count ++;
            list_s2.add(j);
            break;
        }
        
        return count;
    }
    
    // Ticket numbers usually consist of an even number of digits. A ticket number
    // is considered lucky if the sum of the first half of the digits is equal to
    // the sum of the second half.
    // Given a ticket number n, determine if it's lucky or not.
    // Precondition: A ticket number represented as a positive integer with an
    // even number of digits.
    // Precondition: 10 ≤ n < 10^6.
    boolean isLucky(int n) {
        int sum_first = 0, sum_second = 0;
        String number = "" + n;
        int partition = number.length() / 2;
        
        for(int i = 0; i < partition; i++) {
            sum_first += Integer.parseInt(number.charAt(i) + "");
            sum_second += Integer.parseInt(number.charAt(i + partition) + "");
        }
        
        return sum_first == sum_second;
    }
    
    // Some people are standing in a row in a park. There are trees between them
    // which cannot be moved. Your task is to rearrange the people by their heights
    // in a non-descending order without moving the trees. People can be very tall!
    // Precondition: If a[i] = -1, then the ith position is occupied by a tree.
    // Otherwise a[i] is the height of a person standing in the ith position.
    // Precondition: 1 ≤ a.length ≤ 1000, -1 ≤ a[i] ≤ 1000.
    int[] sortByHeight(int[] a) {
        for(int i = 1; i < a.length; i++)
        if(a[i] != -1)
        for(int j = 0; j < i; j++)
        if(a[j] != -1 && a[i] < a[j]) {
            int aux = a[i];
            a[i] = a[j];
            a[j] = aux;
        }
        
        return a;
    }
    
    // You have a string s that consists of English letters, punctuation marks,
    // whitespace characters, and brackets. It is guaranteed that the parentheses
    // in s form a regular bracket sequence.
    // Your task is to reverse the strings contained in each pair of matching
    // parentheses, starting from the innermost pair. The results string should
    // not contain any parentheses.
    // Input string s: A string consisting of English letters, punctuation marks,
    // whitespace characters and brackets. It is guaranteed that parentheses form
    // a regular bracket sequence.
    // Precondition: 5 ≤ s.length ≤ 55.
    String reverseParentheses(String s) {
        String tmpCh = "", tmpChRe = "", tmp = "";
        int l = s.length();
        int n = 0, j = 0;
        
        for(int i = 0; i < l; i ++)
        if ('(' == s.charAt(i))
        n ++;
        
        int T[] = new int[n];
        for(int i = 0; i < l; i ++)
        if('(' == s.charAt(i)) {
            T[j] = i;
            j ++;
        }
        
        j = 0;
        while(n > 0) {
            j = T[n - 1] + 1;
            while(')' != s.charAt(j)) {
                tmpCh = tmpCh + s.charAt(j);
                j ++;
            }
            
            for(int q = tmpCh.length() - 1; q >= 0; q --)
            tmpChRe = tmpChRe + tmpCh.charAt(q);
            
            tmp = s.substring(0, T[ n - 1]) + tmpChRe + s.substring(T[n - 1] + tmpChRe.length() + 2);
            s = tmp;
            n --;
            tmp = "";
            tmpCh = "";
            tmpChRe = "";
        }
        
        return s;
    }
    
    // EXPLORING THE WATERS
    
    // Several people are standing in a row and need to be divided into two teams.
    // The first person goes into team 1, the second goes into team 2, the third
    // goes into team 1 again, the fourth into team 2, and so on.
    // You are given an array of positive integers - the weights of the people.
    // Return an array of two integers, where the first element is the total weight
    // of team 1, and the second element is the total weight of team 2 after the
    // division is complete.
    // [input] array.integer a
    // Precondition: 1 ≤ a.length ≤ 10^5, 45 ≤ a[i] ≤ 100.
    int[] alternatingSums(int[] a) {
        int[] res = new int[2];
        
        for(int i = 0; i < a.length; i += 2) {
            res[0] += a[i];
            
            if(i + 1 < a.length)
            res[1] += a[i + 1];
        }
        
        return res;
    }
    
    // Given a rectangular matrix of characters, add a border of asterisks(*) to it.
    // [input] array.string picture: A non-empty array of non-empty equal-length strings.
    // Precondition: 1 ≤ picture.length ≤ 100, 1 ≤ picture[i].length ≤ 100.
    String[] addBorder(String[] picture) {
        int len = picture[0].length() + 2;
        String[] p = new String[picture.length + 2];
        
        p[0] = "";
        p[p.length - 1] = "";
        
        for(int i = 0; i < len; i ++) {
            p[0] += "*";
            p[p.length - 1] += "*";
        }
        
        for(int i = 0; i < picture.length; i++) {
            p[i + 1] = "*" + picture[i] + "*";
        }
        
        return p;
    }
    
    // Two arrays are called similar if one can be obtained from another by swapping
    // at most one pair of elements in one of the arrays.
    // Given two arrays a and b, check whether they are similar.
    // [input] array.integer a: Array of integers.
    // Precondition: 3 ≤ a.length ≤ 10^5, 1 ≤ a[i] ≤ 1000.
    // [input] array.integer b: Array of integers.
    // Precondition: 3 ≤ b.length ≤ 10^5, 1 ≤ b[i] ≤ 1000.
    boolean areSimilar(int[] a, int[] b) {
        int[] aDif = new int[2], bDif = new int[2];
        
        int count = 0;
        for (int i = 0; i < a.length; i ++)
        if (a[i] != b[i]) {
            if (count == 2) return false;
            aDif[count] = a[i];
            bDif[count] = b[i];
            count ++;
        }
        
        return aDif[0] == bDif[1] && aDif[1] == bDif[0];
    }
    
    // You are given an array of integers. On each move you are allowed to increase
    // exactly one of its element by one. Find the minimal number of moves required
    // to obtain a strictly increasing sequence from the input.
    // [input] array.integer inputArray
    // Precondition: 3 ≤ inputArray.length ≤ 10^5, -10^5 ≤ inputArray[i] ≤ 10^5.
    int arrayChange(int[] inputArray) {
        int count = 0, index = 1;
        
        while ( index < inputArray.length )
        if ( inputArray[index -1] >= inputArray[index] ) {
            inputArray[index] ++;
            count ++;
        } else {
            index ++;
        }
        
        return count;
    }
    
    // Given a string, find out if its characters can be rearranged to form a palindrome.
    // [input] string inputString: A string consisting of lowercase English letters.
    // Precondition: 1 ≤ inputString.length ≤ 50.
    boolean palindromeRearranging(String inputString) {
        int len = inputString.length();
        
        if (1 == len) return true;
        
        int[] alphabet = new int[26];
        int t = 0;
        
        for(int index = 0; index < len; index ++)
        alphabet[inputString.charAt(index) - 'a'] ++;
        
        for(int i : alphabet)
        if(i % 2 == 1)
        t ++;
        
        return len % 2 == t;
    }
    
    // ISLAND OF KNOWLEDGE
    
    // Call two arms equally strong if the heaviest weights they each are able to
    // lift are equal.
    // Call two people equally strong if their strongest arms are equally strong
    // (the strongest arm can be both the right and the left), and so are their
    // weakest arms.
    // Given your and your friend's arms' lifting capabilities find out if you
    // two are equally strong.
    // Precondition: 0 ≤ yourLeft ≤ 20
    boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        boolean strong = false;
        
        if (yourLeft == friendsLeft && yourRight == friendsRight) {
            strong = true;
        } else if (yourLeft == friendsRight && yourRight == friendsLeft) {
            strong = true;
        }
        
        return strong;
    }
    
    // Given an array of integers, find the maximal absolute difference between
    // any two of its adjacent elements.
    // Preconditions: 3 ≤ inputArray.length ≤ 10, -15 ≤ inputArray[i] ≤ 15
    int arrayMaximalAdjacentDifference(int[] inputArray) {
        int maximal = 0;
        
        for (int i = 1; i < inputArray.length; i ++) {
            int dif = inputArray[i] - inputArray[i - 1];
            if (dif < 0)
            dif *= -1;
            if (dif > maximal)
            maximal = dif;
        }
        
        return maximal;
    }
    
    // An IP address is a numerical label assigned to each device (e.g., computer,
    // printer) participating in a computer network that uses the Internet
    // Protocol for communication. There are two versions of the Internet protocol,
    // and thus two versions of addresses. One of them is the IPv4 address.
    // IPv4 addresses are represented in dot-decimal notation, which consists of
    // four decimal numbers, each ranging from 0 to 255 inclusive, separated by
    // dots, e.g., 172.16.254.1.
    // Given a string, find out if it satisfies the IPv4 address naming rules.
    // Precondition: 1 ≤ inputString.length ≤ 30
    boolean isIPv4Address(String inputString) {
        int len = inputString.length();
        if (7 > len || 15 < len) return false;
        
        int count = 4;
        try {
            int ini = 0, fi = 0;
            for (int i = 0; i <= len; i ++) {
                if (i == len) {
                    fi = i;
                    
                    String st = inputString.substring(ini, fi);
                    int num = Integer.parseInt(st);
                    
                    if (255 < num) return false;
                    
                    count --;
                } else if ('.' == inputString.charAt(i)) {
                    fi = i;
                    
                    String st = inputString.substring(ini, fi);
                    int num = Integer.parseInt(st);
                    
                    if (255 < num) return false;
                    
                    ini = i + 1;
                    count --;
                }
            }
        } catch (NumberFormatException ex) {
            return false;
        }
        
        return 0 == count;
    }
    
    // You are given an array of integers representing coordinates of obstacles
    // situated on a straight line.
    // Assume that you are jumping from the point with coordinate 0 to the right.
    // You are allowed only to make jumps of the same length represented by some
    // integer.
    // Find the minimal length of the jump enough to avoid all the obstacles.
    // Precondition: Non-empty array of positive integers.
    // Preconditions: 2 ≤ inputArray.length ≤ 1000, 1 ≤ inputArray[i] ≤ 1000
    int avoidObstacles(int[] inputArray) {
        int jump = 1, len = inputArray.length;
        
        int maxNumArray = 0;
        for (int i = 0; i < len; i ++)
        if (maxNumArray < inputArray[i])
        maxNumArray = inputArray[i];
        
        for (int i = 1; jump * i <= maxNumArray; i ++)
        for (int j = 0; j < len; j ++)
        if (inputArray[j] == jump * i) {
            i = 0;
            jump ++;
            break;
        }
        
        return jump;
    }
    
    //Last night you partied a little too hard. Now there's a black and white
    // photo of you that's about to go viral! You can't let this ruin your
    // reputation, so you want to apply the box blur algorithm to the photo to
    // hide its content.
    // The pixels in the input image are represented as integers. The algorithm
    // distorts the input image in the following way: Every pixel x in the output
    // image has a value equal to the average value of the pixel values from the
    // 3 × 3 square that has its center at x, including x itself. All the pixels
    // on the border of x are then removed.
    // Return the blurred image as an integer, with the fractions rounded down.
    // Preconditions: 3 ≤ image.length ≤ 10, 3 ≤ image[0].length ≤ 10, 0 ≤ image[i][j] ≤ 255.
    int[][] boxBlur(int[][] image) {
        int[][] photo = new int[image.length - 2][image[0].length - 2];
        
        int sum;
        for (int i = 1; i < image.length - 1; i ++) {
            for (int j = 1; j < image[0].length - 1; j ++) {
                sum = image[i-1][j-1] + image[i-1][j] + image[i-1][j+1] +
                image[i][j-1] + image[i][j] + image[i][j+1] +
                image[i+1][j-1] + image[i+1][j] + image[i+1][j+1];
                
                photo[i-1][j-1] = sum / 9;
            }
        }
        
        return photo;
    }
    
    // In the popular Minesweeper game you have a board with some mines and those
    // cells that don't contain a mine have a number in it that indicates the total
    // number of mines in the neighboring cells. Starting off with some arrangement
    // of mines we want to create a Minesweeper game setup.
    // Preconditions: 2 ≤ matrix.length ≤ 100, 2 ≤ matrix[0].length ≤ 100.
    int[][] minesweeper(boolean[][] matrix) {
        int[][] minesweeper = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i ++)
        for (int j = 0; j < matrix[0].length; j ++)
        if (matrix[i][j])
        for (int m = i - 1; m <= i + 1; m ++)
        for (int n = j - 1; n <= j + 1; n++)
        if ( !(m == i && n == j) )
        try {
            minesweeper[m][n] ++;
        } catch (Exception ex) {
            
        }
        
        return minesweeper;
    }
    
    // RAINS OF REASON
    
    // Given an array of integers, replace all the occurrences of elemToReplace
    // with substitutionElem.
    // Preconditions: 2 ≤ inputArray.length ≤ 10, 0 ≤ inputArray[i] ≤ 10.
    int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        for (int i = 0; i < inputArray.length; i ++)
        if (inputArray[i] == elemToReplace)
        inputArray[i] = substitutionElem;
        
        return inputArray;
    }
    
    // Check if all digits of the given integer are even.
    // Precondition: 1 ≤ n ≤ 10^9.
    boolean evenDigitsOnly(int n) {
        int len = Integer.toString(n).length();
        
        for (int i = 0; i < len; i ++) {
            if (0 != n % 2) return false;
            n = n / 10;
        }
        
        return true;
    }
    
    // Correct variable names consist only of English letters, digits and
    // underscores and they can't start with a digit.
    // Check if the given string is a correct variable name.
    // Precondition: 1 ≤ name.length ≤ 10.
    boolean variableName(String name) {
        char c = name.charAt(0);
        if ( !(('A' <= c && 'Z' >= c) ||
        ('a' <= c && 'z' >= c) ||
        ('_' == c)) )
        return false;
        
        for (int i = 1; i < name.length(); i ++) {
            c = name.charAt(i);
            if ( !(('A' <= c && 'Z' >= c) ||
            ('a' <= c && 'z' >= c) ||
            ('0' <= c && '9' >= c) ||
            ('_' == c)) )
            return false;
        }
        
        return true;
    }
    
    // Given a string, replace each its character by the next one in the English
    // alphabet (z would be replaced by a).
    // Precondition: 1 ≤ inputString.length ≤ 1000.
    String alphabeticShift(String inputString) {
        String next = "";
        
        char c;
        for (int i = 0; i < inputString.length(); i ++) {
            c = inputString.charAt(i);
            if ('z' == c)
            c = 'a';
            else
            c ++;
            next += c;
        }
        
        return next;
    }
    
    // Given two cells on the standard chess board, determine whether they have
    // the same color or not.
    boolean chessBoardCellColor(String cell1, String cell2) {
        int letter1 = (int) cell1.charAt(0);
        int letter2 = (int) cell2.charAt(0);
        int num1 = (int) cell1.charAt(1);
        int num2 = (int) cell2.charAt(1);
        
        return Math.abs(letter1 - letter2) % 2 == Math.abs(num1 - num2) % 2;
    }
    
    // THROUGH THE FOG
    
    // Consider integer numbers from 0 to n - 1 written down along the circle in
    // such a way that the distance between any two neighboring numbers is equal
    // (note that 0 and n - 1 are neighboring, too).
    // Given n and firstNumber, find the number which is written in the radially
    // opposite position to firstNumber.
    // Precondition: 4 ≤ n ≤ 20, 0 ≤ firstNumber ≤ n - 1.
    int circleOfNumbers(int n, int firstNumber) {
        if (n / 2 > firstNumber)
        return n / 2 + firstNumber;
        else
        return firstNumber - n / 2;
    }
    
    // You have deposited a specific amount of money into your bank account. Each
    // year your balance increases at the same growth rate. With the assumption
    // that you don't make any additional deposits, find out how long it would take
    // for your balance to pass a specific threshold.
    // [input] integer deposit: The initial deposit, guaranteed to be a positive integer.
    // Precondition: 1 ≤ deposit ≤ 100.
    // [input] integer rate: The rate of increase. Each year the balance increases
    // by the rate percent of the current sum.
    // Precondition: 1 ≤ rate ≤ 100.
    // [input] integer threshold: The target balance.
    // Precondition: deposit < threshold ≤ 200.
    int depositProfit(int deposit, int rate, int threshold) {
        double ratePercentage = (double) rate / 100;
        double newDeposit = (double) deposit;
        
        int count = 0;
        while (newDeposit < threshold) {
            newDeposit += newDeposit * (ratePercentage);
            count ++;
        }
        
        return count;
    }
    
    // Given a sorted array of integers a, find an integer x from a such that the
    // value of abs(a[0] - x) + abs(a[1] - x) + ... + abs(a[a.length - 1] - x) is
    // the smallest possible (here abs denotes the absolute value).
    // If there are several possible answers, output the smallest one.
    // [input] array.integer a: A non-empty array of integers, sorted in ascending order.
    // Precondition: 1 ≤ a.length ≤ 1000, -10^6 ≤ a[i] ≤ 10^6.
    int absoluteValuesSumMinimization(int[] a) {
        int l = a.length;
        return l % 2 == 0? a[l/2 - 1] : a[l/2];
    }
    
    // Given an array of equal-length strings, check if it is possible to rearrange
    // the strings in such a way that after the rearrangement the strings at
    // consecutive positions would differ by exactly one character.
    // [input] array.string inputArray: A non-empty array of strings of lowercase letters.
    // Preconditions: 2 ≤ inputArray.length ≤ 10, 1 ≤ inputArray[i].length ≤ 15.
    boolean stringsRearrangement(String[] inputArray) {
        boolean[] used = new boolean[inputArray.length];
        findSequence(inputArray, null, used, 0);
        return success;
    }
    
    boolean success = false; // modified by findSequence
    
    void findSequence(String[] a, String prev, boolean[] used, int n) {
        // recursive backtracking procedure to find admissible
        // sequence of strings in the array. String prev is the
        // previous string in the sequence, used[] keeps track
        // of which strings have been used so far, and n is the
        // current length of the sequence.
        if (n == a.length) {
            success = true;
            return;
        }
        
        for (int i = 0; i < a.length; i++)
        if ( !used[i] && (prev == null || differByOne(prev, a[i])) ) {
            used[i] = true;
            findSequence(a, a[i], used, n + 1);
            used[i] = false;
        }
    }
    
    boolean differByOne(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++)
        if (a.charAt(i) != b.charAt(i))
        count++;
        
        return count == 1;
    }
    
    // Given array of integers, remove each kth element from it.
    // [input] array.integer inputArray.
    // Preconditions: 5 ≤ inputArray.length ≤ 15, -20 ≤ inputArray[i] ≤ 20.
    // [input] integer k.
    // Precondition: 1 ≤ k ≤ 10.
    int[] extractEachKth(int[] inputArray, int k) {
        int[] outputArray;
        int len = inputArray.length - (inputArray.length / k);
        outputArray = new int[len];
        
        int j = 0;
        int count = k;
        for (int i = 0; i < inputArray.length && j < len; i ++)
        if (i + 1 == count)
        count += k;
        else
        outputArray[j ++] = inputArray[i];
        
        
        return outputArray;
    }
    
    // Find the leftmost digit that occurs in a given string.
    // [input] string inputString: A string containing at least one digit.
    // Precondition: 3 ≤ inputString.length ≤ 10.
    char firstDigit(String inputString) {
        int i = 0;
        while (true)
        if (inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9')
        break;
        else
        i ++;
        
        return inputString.charAt(i);
    }
    
    // Given a string, find the number of different characters in it.
    // [input] string s: A string of lowercase English letters.
    // Precondition: 3 ≤ s.length ≤ 1000.
    int differentSymbolsNaive(String s) {
        char[] characters = new char[s.length()];
        
        characters[0] = s.charAt(0);
        int len = 1;
        char c;
        boolean duplicated;
        for (int i = 1; i < s.length(); i++) {
            duplicated = false;
            c = s.charAt(i);
            
            for (int j = 0; j < len; j ++)
            if (c == characters[j]) {
                duplicated = true;
                break;
            }
            
            if ( !duplicated )
            characters[len ++] = c;
        }
        
        return len;
    }
    
    // Given array of integers, find the maximal possible sum of some of its k consecutive elements.
    // [input] array.integer inputArray: Array of positive integers.
    // Precondition: 3 ≤ inputArray.length ≤ 10^5, 1 ≤ inputArray[i] ≤ 1000.
    // [input] integer k: An integer (not greater than the length of inputArray).
    // Precondition: 1 ≤ k ≤ inputArray.length.
    int arrayMaxConsecutiveSum(int[] inputArray, int k) {
        int maxSum, sum = 0;
        
        int i;
        for (i = 0; i < k; i ++)
        sum += inputArray[i];
        
        maxSum = sum;
        for (i = k; i < inputArray.length; i ++) {
            sum -= inputArray[i - k];
            sum += inputArray[i];
            
            if (sum > maxSum)
            maxSum = sum;
        }
        
        return maxSum;
    }
    
    // DARK WILDERNESS
    
    // Each day a plant is growing by upSpeed meters. Each night that plant's
    // height decreases by downSpeed meters due to the lack of sun heat. Initially,
    // plant is 0 meters tall. We plant the seed at the beginning of a day. We want
    // to know when the height of the plant will reach a certain level.
    // [input] integer upSpeed: A positive integer representing the daily growth.
    // Precondition: 3 ≤ upSpeed ≤ 100.
    // [input] integer downSpeed: A positive integer representing the nightly decline.
    // Precondition: 2 ≤ downSpeed < upSpeed.
    // [input] integer desiredHeight: A positive integer representing the threshold.
    // Precondition: 4 ≤ desiredHeight ≤ 1000.
    int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        int days = 1;
        int height = upSpeed;
        
        while (height < desiredHeight) {
            height += upSpeed - downSpeed;
            days ++;
        }
        
        return days;
    }
    
    // You found two items in a treasure chest! The first item weighs weight1 and
    // is worth value1, and the second item weighs weight2 and is worth value2. What
    // is the total maximum value of the items you can take with you, assuming that
    // your max weight capacity is maxW and you can't come back for the items later?
    // Note that there are only two items and you can't bring more than one item of
    // each type, i.e. you can't take two first items or two second items.
    // [input] integer v1.
    // Precondition: 2 ≤ v1 ≤ 20.
    // [input] integer w1.
    // Precondition: 2 ≤ w1 ≤ 10.
    // [input] integer v2.
    // Precondition: 2 ≤ v2 ≤ 20.
    // [input] integer w2.
    // Precondition: 2 ≤ w2 ≤ 10.
    // [input] integer mW.
    // Precondition: 1 ≤ mW ≤ 20.
    int knapsackLight(int v1, int w1, int v2, int w2, int mW) {
        return w1 + w2 <= mW ? v1 + v2 : v1 > v2 && w1 <= mW ? v1 : w2 <= mW ? v2 : w1 <= mW ? v1 : 0;
    }
    
    // Given a string, output its longest prefix which contains only digits.
    // [input] string inputString.
    // 3 ≤ inputString.length ≤ 35.
    String longestDigitsPrefix(String inputString) {
        String prefix = "";
        
        for (int i = 0; i < inputString.length(); i ++)
        if (inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9')
        prefix += inputString.charAt(i);
        else
        break;
        
        return prefix;
    }
    
    // Let's define digit degree of some positive integer as the number of times
    // we need to replace this number with the sum of its digits until we get to
    // a one digit number.
    // Given an integer, find its digit degree.
    // [input] integer n.
    // Precondition: 5 ≤ n ≤ 10^9.
    int digitDegree(int n) {
        String string = "" + n;
        int degree = 0;
        
        while (n >= 10) {
            n = 0;
            for (int i = 0; i < string.length(); i ++)
            n += Integer.parseInt("" + string.charAt(i));
            
            string = "" + n;
            degree ++;
        }
        
        return degree;
    }
    
    // Given the positions of a white bishop and a black pawn on the standard chess
    // board, determine whether the bishop can capture the pawn in one move.
    // The bishop has no restrictions in distance for each move, but is limited to
    // diagonal movement. Check out the example below to see how it can move:
    // [input] string bishop: Coordinates of the white bishop in the chess notation.
    // [input] string pawn: Coordinates of the black pawn in the same notation.
    boolean bishopAndPawn(String bishop, String pawn) {
        int column = (int) bishop.charAt(0) - (int) pawn.charAt(0);
        int row = (int) bishop.charAt(1) - (int) pawn.charAt(1);
        
        return column == row || column + row == 0;
    }
    
    // ERUPTION OF LIGHT
    
    // A string is said to be beautiful if b occurs in it no more times than a;
    // c occurs in it no more times than b; etc.
    // Given a string, check whether it is beautiful.
    // [input] string inputString: A string of lowercase letters.
    // Precondition: 3 ≤ inputString.length ≤ 50.
    boolean isBeautifulString(String inputString) {
        boolean beautiful = true;
        int[] alphabet = new int['z' - 'a' + 1];
        
        for (int i = 0; i < inputString.length(); i ++)
        alphabet[inputString.charAt(i) - 'a'] ++;
        
        for (int i = 1; i < alphabet.length && beautiful; i ++)
        if (alphabet[i - 1] < alphabet[i])
        beautiful = false;
        
        return beautiful;
    }
    
    // An email address such as "John.Smith@example.com" is made up of a local
    // part ("John.Smith"), an "@" symbol, then a domain part ("example.com").
    // The domain name part of an email address may only consist of letters, digits,
    // hyphens and dots. The local part, however, also allows a lot of different
    // special characters. Here you can look at several examples of correct and
    // incorrect email addresses.
    // Given a valid email address, find its domain part.
    // [input] string address.
    // Precondition: 10 ≤ address.length ≤ 50.
    String findEmailDomain(String address) {
        String domain = "";
        
        for (int i = address.length() - 1; address.charAt(i) != '@'; i --)
        domain = address.charAt(i) + domain;
        
        return domain;
    }
    
    // Given a string, find the shortest possible string which can be achieved by
    // adding characters to the end of initial string to make it a palindrome.
    // [input] string st: A string consisting of lowercase English letters.
    // Precondition: 3 ≤ st.length ≤ 10.
    String buildPalindrome(String st) {
        int len = st.length();
        
        String sub = "";
        for (int i = 0; i < len; i ++)
        if ( checkPalindrome(st.substring(i, len)) ) {
            i--;
            while (i >= 0)
            st += st.charAt(i --);
            break;
        }
        
        return st;
    }
    
    // Elections are in progress!
    // Given an array of the numbers of votes given to each of the candidates so
    // far, and an integer k equal to the number of voters who haven't cast their
    // vote yet, find the number of candidates who still have a chance to win the
    // election.
    // The winner of the election must secure strictly more votes than any other
    // candidate. If two or more candidates receive the same (maximum) number of
    // votes, assume there is no winner at all.
    // [input] array.integer votes: A non-empty array of non-negative integers. Its
    // ith element denotes the number of votes cast for the ith candidate.
    // Precondition: 4 ≤ votes.length ≤ 10^5, 0 ≤ votes[i] ≤ 10^4.
    // [input] integer k: The number of voters who haven't cast their vote yet.
    // Precondition: 0 ≤ k ≤ 10^5.
    int electionsWinners(int[] votes, int k) {
        int candidates = 0;
        
        int maxVotes = 0;
        int initialCandidates = 0;
        for (int i = 0; i < votes.length; i ++)
        if (maxVotes < votes[i]) {
            maxVotes = votes[i];
            initialCandidates = 1;
        } else if (maxVotes == votes[i]) {
            initialCandidates ++;
        }
        
        for (int i = 0; i < votes.length; i ++)
        if ( votes[i] + k > maxVotes )
        candidates ++;
        
        if (k == 0 && initialCandidates == 1)
        candidates = 1;
        
        return candidates;
    }
    
    // A media access control address (MAC address) is a unique identifier assigned
    // to network interfaces for communications on the physical network segment.
    // The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly
    // form is six groups of two hexadecimal digits (0 to 9 or A to F), separated
    // by hyphens (e.g. 01-23-45-67-89-AB).
    // Your task is to check by given string inputString whether it corresponds
    // to MAC-48 address or not.
    // [input] string inputString.
    // Precondition: 15 ≤ inputString.length ≤ 20.
    boolean isMAC48Address(String inputString) {
        boolean correct = true;
        
        int len = inputString.length();
        if (len != 17) correct = false;
        
        char c1, c2;
        int groups = 0;
        for (int i = 0; i < len && correct; i += 3) {
            c1 = inputString.charAt(i);
            c2 = inputString.charAt(i + 1);
            boolean b1 = (c1 >= 'A' && c1 <= 'F') || (c1 >= '0' && c1 <= '9');
            boolean b2 = (c2 >= 'A' && c2 <= 'F') || (c2 >= '0' && c2 <= '9');
            
            if ( b1 && b2 )
            continue;
            else
            correct = false;
        }
        
        for (int i = 2; i < len && correct; i += 3)
        if ( inputString.charAt(i) != '-')
        correct = false;
        
        return correct;
    }
    
    // RAINBOW OF CLARITY
    
    // Determine if the given character is a digit or not.
    // [input] char symbol: A character which is either a digit or not.
    boolean isDigit(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }
    
    // Given a string, return its encoding defined as follows:
    // First, the string is divided into the least possible number of disjoint
    // substrings consisting of identical characters.
    // Next, each substring with length greater than one is replaced with a
    // concatenation of its length and the repeating character.
    // Finally, all the new strings are concatenated together in the same order
    // and a new string is returned.
    // [input] string s: String consisting of lowercase English letters.
    // Precondition: 4 ≤ s.length ≤ 15.
    String lineEncoding(String s) {
        String encoding = "";
        
        int count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i ++)
        if (c == s.charAt(i)) {
            count ++;
        } else {
            if (count != 1)
            encoding += count;
            encoding += c;
            c = s.charAt(i);
            count = 1;
        }
        
        if (count != 1)
        encoding += count;
        encoding += c;
        
        return encoding;
    }
    
    // Given a position of a knight on the standard chessboard, find the number of
    // different moves the knight can perform.
    // The knight can move to a square that is two squares horizontally and one
    // square vertically, or two squares vertically and one square horizontally
    // away from it. The complete move therefore looks like the letter L. Check out
    // the image below to see all valid moves for a knight piece that is placed on
    // one of the central squares.
    // [input] string cell: String consisting of 2 letters - coordinates of the
    // knight on an 8 × 8 chessboard in chess notation.
    int chessKnight(String cell) {
        int moves;
        
        char column = cell.charAt(0);
        char row = cell.charAt(1);
        
        int c = Math.min(column - 'a', 'h' - column) + 1;
        int r = Math.min(row - '1', '8' - row) + 1;
        
        moves = c + r;
        if (moves == 5) moves ++;
        
        return moves;
    }
    
    // Given some integer, find the maximal number you can obtain by deleting
    // exactly one digit of the given number.
    // [input] integer n.
    // 10 ≤ n ≤ 10^6.
    int deleteDigit(int n) {
        int maximal = 0;
        String number = "" + n;
        
        String sub;
        for (int i = 0; i < number.length(); i ++) {
            sub = number.substring(0, i) + number.substring(i + 1, number.length());
            n = Integer.parseInt(sub);
            if (n > maximal)
            maximal = n;
        }
        
        return maximal;
    }
    
    // LAND OF LOGIC
    
    // Define a word as a sequence of consecutive English letters. Find the longest
    // word from the given string.
    // [input] string text.
    // Precondition: 4 ≤ text.length ≤ 50.
    String longestWord(String text) {
        String word = "";
        
        char c;
        String w = "";
        for (int i = 0; i < text.length(); i ++) {
            c = text.charAt(i);
            if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c < 'Z') ) {
                w += c;
            } else {
                if (w.length() > word.length())
                word = w;
                w = "";
            }
        }
        
        if (w.length() > word.length())
        word = w;
        
        return word;
    }
    
    // Check if the given string is a correct time representation of the 24-hour clock.
    // [input] string time: A string representing time in HH:MM format. It is
    // guaranteed that the first two characters, as well as the last two characters,
    // are digits.
    boolean validTime(String time) {
        String h = time.substring(0, 2);
        String m = time.substring(3, 5);
        
        int hour = Integer.parseInt(h);
        int min = Integer.parseInt(m);
        
        return min < 60 && hour < 24;
    }
    
    // CodeMaster has just returned from shopping. He scanned the check of the items
    // he bought and gave the resulting string to Ratiorg to figure out the total
    // number of purchased items. Since Ratiorg is a bot he is definitely going to
    // automate it, so he needs a program that sums up all the numbers which appear
    // in the given input.
    // Help Ratiorg by writing a function that returns the sum of numbers that
    // appear in the given inputString.
    // [input] string inputString.
    // Precondition: 6 ≤ inputString.length ≤ 60.
    int sumUpNumbers(String inputString) {
        int sum = 0;
        
        String number = "";
        char c;
        for (int i = 0; i < inputString.length(); i ++) {
            c = inputString.charAt(i);
            
            if (c >= '0' && c <= '9') {
                number += c;
            } else if (number.length() != 0) {
                sum += Integer.parseInt(number);
                number = "";
            }
        }
        
        if (number.length() != 0)
        sum += Integer.parseInt(number);
        
        return sum;
    }
    
    // Given a rectangular matrix containing only digits, calculate the number of
    // different 2 × 2 squares in it.
    // [input] array.array.integer matrix.
    // Preconditions: 1 ≤ matrix.length ≤ 100, 1 ≤ matrix[i].length ≤ 100, 0 ≤ matrix[i][j] ≤ 9.
    int differentSquares(int[][] matrix) {
        Set<Integer> squares = new HashSet<>();
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int m;
        for (int i = 0; i < rows - 1; i ++)
        for (int j = 0; j < columns - 1; j ++) {
            m = matrix[i][j] * 1000000 +
            matrix[i][j + 1] * 100 +
            matrix[i + 1][j] * 10000 +
            matrix[i + 1][j + 1];
            squares.add(m);
        }
        
        return squares.size();
    }
    
    // Given an integer product, find the smallest positive (i.e. greater than 0)
    // integer the product of whose digits is equal to product. If there is no such
    // integer, return -1 instead.
    // [input] integer product.
    // Precondition: 0 ≤ product ≤ 600.
    int digitsProduct(int product) {
        if (product < 10)
        return product == 0 ? 10 : product;
        
        String r = "";
        for (int i = 9; i > 1; i --)
        while (product % i == 0) {
            product /= i;
            r = Character.toString( (char) ('0' + i) )  + r;
        }
        
        return product != 1 ? -1 : Integer.parseInt(r);
    }
    
    // You are given an array of desired filenames in the order of their creation.
    // Since two files cannot have equal names, the one which comes later will have
    // an addition to its name in a form of (k), where k is the smallest positive
    // integer such that the obtained name is not used yet.
    // Return an array of names that will be given to the files.
    // [input] array.string names.
    // Precondition: 5 ≤ names.length ≤ 15, 1 ≤ names[i].length ≤ 15.
    String[] fileNaming(String[] names) {
        Set<String> files = new HashSet<>();
        
        String n;
        boolean added;
        for (int i = 0; i < names.length; i ++) {
            n = names[i];
            
            added = files.add(n);
            for (int j = 1; !added; j ++) {
                n = names[i] + "(" + j + ")";
                added = files.add(n);
            }
            
            names[i] = n;
        }
        
        return names;
    }
    
    // You are taking part in an Escape Room challenge designed specifically for
    // programmers. In your efforts to find a clue, you've found a binary code
    // written on the wall behind a vase, and realized that it must be an encrypted
    // message. After some thought, your first guess is that each consecutive 8 bits
    // of the code stand for the character with the corresponding extended ASCII code.
    // Assuming that your hunch is correct, decode the message.
    // [input] string code: A string, the encrypted message consisting of characters '0' and '1'.
    // Precondition: 0 < code.length < 800.
    String messageFromBinaryCode(String code) {
        String msg = "";
        
        int exp = 7;
        int c = 0;
        for (int i = 0; i < code.length(); i ++) {
            if (code.charAt(i) == '1')
            c += Math.pow(2, exp);
            
            if (exp == 0) {
                msg += (char) c;
                c = 0;
                exp = 7;
            } else {
                exp --;
            }
        }
        
        return msg;
    }
    
    // Construct a square matrix with a size N × N containing integers from 1 to
    // N * N in a spiral order, starting from top-left and in clockwise direction.
    // [input] integer n: Matrix size, a positive integer.
    // Precondition: 3 ≤ n ≤ 100.
    int[][] spiralNumbers(int n) {
        int[][] ans = new int[n][];
        
        for (int i = 0; i < n; i ++)
        ans[i] = new int[n];
        
        int p = 1, r = 0;
        for ( ; n > 0; n -= 2){
            for (int a = 0; a < n; a ++) ans[r][a + r] = p ++;
            for (int b = r + 1; b < n + r; b ++) ans[b][n - 1 + r] = p ++;
            for (int c = n - 2 + r; c >= r; c --) ans[n - 1 + r][c] = p ++;
            for (int d = n - 2 + r; d > r; d --) ans[d][r] = p ++;
            r ++;
        }
        
        return ans;
    }
    
    // Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid
    // with digits so that each column, each row, and each of the nine 3 × 3 sub-grids
    // that compose the grid contains all of the digits from 1 to 9.
    // This algorithm should check if the given grid of numbers represents a correct
    // solution to Sudoku.
    // [input] array.array.integer grid: A matrix representing 9 × 9 grid already
    // filled with numbers from 1 to 9.
    boolean sudoku(int[][] grid) {
        boolean correct = true;
        int result = 362880; // 1*2*3*4*5*6*7*8*9;
        
        int n;
        // Correct row
        for (int row = 0; row < 9; row ++) {
            n = 1;
            for (int elem : grid[row])
            n *= elem;
            if (n != result)
            return false;
        }
        
        // Correct column
        for (int column = 0; column < 9; column ++) {
            n = 1;
            for (int row = 0; row < 9; row ++)
            n *= grid[row][column];
            if (n != result)
            return false;
        }
        
        // Correct grids
        for (int i = 0; i < 3; i ++)
        for (int j = 0; j < 3; j ++) {
            n = 1;
            for (int row = i * 3; row < i * 3 + 3; row ++)
            for (int column = j * 3; column < j * 3 + 3; column ++)
            n *= grid[row][column];
            if (n != result)
            return false;
        }
        
        return correct;
    }
}
