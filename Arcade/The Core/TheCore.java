
public class TheCore {
	
	public TheCore() {}
	
	// INTRO GATES
	
	// You are given a two-digit integer n. Return the sum of its digits.
	// [input] integer n: A positive two-digit integer.
	// Precondition: 10 ≤ n ≤ 99.
	int addTwoDigits(int n) {
		return n / 10 + n % 10;
	}
	
	// Given an integer n, return the largest number that contains exactly n digits.
	// [input] integer n.
	// Precondition: 1 ≤ n ≤ 9.
	int largestNumber(int n) {
		return (int) Math.pow(10, n) - 1;
	}
	
	// n children have got m pieces of candy. They want to eat as much candy as
	// they can, but each child must eat exactly the same amount of candy as any
	// other child. Determine how many pieces of candy will be eaten by all the
	// children together. Individual pieces of candy cannot be split.
	// [input] integer n: The number of children.
	// Precondition: 1 ≤ n ≤ 10.
	// [input] integer m: The number of pieces of candy.
	// Precondition: 2 ≤ m ≤ 100.
	int candies(int n, int m) {
		return (m / n) * n;
	}
	
	// Your friend advised you to see a new performance in the most popular theater
	// in the city. He knows a lot about art and his advice is usually good, but not
	// this time: the performance turned out to be awfully dull. It's so bad you want
	// to sneak out, which is quite simple, especially since the exit is located right
	// behind your row to the left. All you need to do is climb over your seat and
	// make your way to the exit.
	// The main problem is your shyness: you're afraid that you'll end up blocking
	// the view (even if only for a couple of seconds) of all the people who sit
	// behind you and in your column or the columns to your left. To gain some courage,
	// you decide to calculate the number of such people and see if you can possibly
	// make it to the exit without disturbing too many people.
	// Given the total number of rows and columns in the theater (nRows and nCols,
	// respectively), and the row and column you're sitting in, return the number
	// of people who sit strictly behind you and in your column or to the left,
	// assuming all seats are occupied.
	// [input] integer nCols: An integer, the number of theater's columns.
	// Precondition: 1 ≤ nCols ≤ 1000.
	// [input] integer nRows: An integer, the number of theater's rows.
	// Precondition: 1 ≤ nRows ≤ 1000.
	// [input] integer col: An integer, the column number of your own seat (1-based).
	// Precondition: 1 ≤ col ≤ nCols.
	// [input] integer row: An integer, the row number of your own seat (1-based).
	// Precondition: 1 ≤ row ≤ nRows.
	int seatsInTheater(int nCols, int nRows, int col, int row) {
		return (nCols - (col - 1)) * (nRows - row);
	}
	
	// Given a divisor and a bound, find the largest integer N such that:
	// -> N is divisible by divisor.
	// -> N is less than or equal to bound.
	// -> N is greater than 0.
	// It is guaranteed that such a number exists.
	// [input] integer divisor.
	// Precondition: 2 ≤ divisor ≤ 10.
	// [input] integer bound.
	// Precondition: 5 ≤ bound ≤ 100.
	int maxMultiple(int divisor, int bound) {
		return bound - (bound % divisor);
	}
	
	// Consider integer numbers from 0 to n - 1 written down along the circle in such
	// a way that the distance between any two neighboring numbers is equal (note
	// that 0 and n - 1 are neighboring, too).
	// Given n and firstNumber, find the number which is written in the radially
	// opposite position to firstNumber.
	// [input] integer n: A positive even integer.
	// Precondition: 4 ≤ n ≤ 20.
	// [input] integer firstNumber.
	// Precondition: 0 ≤ firstNumber ≤ n - 1.
	int circleOfNumbers(int n, int firstNumber) {
		if(firstNumber < n / 2)
		return firstNumber + (n / 2);
		else
		return firstNumber - (n / 2);
	}
	
	// One night you go for a ride on your motorcycle. At 00:00 you start your engine,
	// and the built-in timer automatically begins counting the length of your ride,
	// in minutes. Off you go to explore the neighborhood.
	// When you finally decide to head back, you realize there's a chance the bridges
	// on your route home are up, leaving you stranded! Unfortunately, you don't
	// have your watch on you and don't know what time it is. All you know thanks
	// to the bike's timer is that n minutes have passed since 00:00.
	// Using the bike's timer, calculate the current time. Return an answer as the
	// sum of digits that the digital timer in the format hh:mm would show.
	// [input] integer n: The duration of your ride, in minutes. It is guaranteed
	// that you've been riding for less than a day (24 hours).
	// Precondition: 0 ≤ n < 60 · 24.
	int lateRide(int n) {
		int s1, s2, s3, s4;
		
		int hour = n / 60;
		int minutes = (n % 60);
		
		s1 = hour / 10;
		s2 = hour % 10;
		s3 = minutes / 10;
		s4 = minutes % 10;
		
		return s1 + s2 + s3 + s4;
	}
	
	// Some phone usage rate may be described as follows:
	// -> first minute of a call costs min1 cents,
	// -> each minute from the 2nd up to 10th (inclusive) costs min2_10 cents
	// -> each minute after 10th costs min11 cents.
	// You have s cents on your account before the call. What is the duration of
	// the longest call (in minutes rounded down to the nearest integer) you can have?
	// [input] integer min1.
	// Precondition: 1 ≤ min1 ≤ 10.
	// [input] integer min2_10.
	// Precondition: 1 ≤ min2_10 ≤ 10.
	// [input] integer min11.
	// Precondition: 1 ≤ min11 ≤ 10.
	// [input] integer s.
	// Precondition: 2 ≤ s ≤ 60.
	int phoneCall(int min1, int min2_10, int min11, int s) {
		int money = s;
		int minutes = 0;
		
		if ( money - min1 >= 0 ) {
			money -= min1;
			minutes ++;
		}
		
		for (int i = 1; i < 10 && money - min2_10 >= 0 && minutes >= 1; i ++, minutes ++)
		money -= min2_10;
		
		while (money - min11 >= 0 && minutes >= 10) {
			money -= min11;
			minutes ++;
		}
		
		return minutes;
	}
	
	// AT THE CROSSROADS
	
	// You are playing an RPG game. Currently your experience points (XP) total is
	// equal to experience. To reach the next level your XP should be at least at
	// threshold. If you kill the monster in front of you, you will gain more
	// experience points in the amount of the reward.
	// Given values experience, threshold and reward, check if you reach the next
	// level after killing the monster.
	// [input] integer experience.
	// Precondition: 3 ≤ experience ≤ 250.
	// [input] integer threshold.
	// Precondition: 5 ≤ threshold ≤ 300.
	// [input] integer reward.
	// Precondition: 2 ≤ reward ≤ 65.
	boolean reachNextLevel(int experience, int threshold, int reward) {
		return experience + reward >= threshold;
	}
	
	// You found two items in a treasure chest! The first item weighs weight1 and
	// is worth value1, and the second item weighs weight2 and is worth value2. What
	// is the total maximum value of the items you can take with you, assuming that
	// your max weight capacity is maxW and you can't come back for the items later?
	//Note that there are only two items and you can't bring more than one item of
	// each type, i.e. you can't take two first items or two second items.
	// [input] integer value1.
	// Precondition: 2 ≤ value1 ≤ 20.
	// [input] integer weight1.
	// Precondition: 2 ≤ weight1 ≤ 10.
	// [input] integer value2.
	// Precondition: 2 ≤ value2 ≤ 20.
	// [input] integer weight2.
	// Precondition: 2 ≤ weight2 ≤ 10.
	// [input] integer maxW.
	// Precondition: 1 ≤ maxW ≤ 20.
	int knapsackLight(int v1, int w1, int v2, int w2, int mW) {
		return w1 + w2 <= mW ? v1 + v2 : w1 <= mW && v1 >= v2 ? v1 : w2 <= mW ? (v2) : w1 <= mW ? v1 : 0;
	}
	
	// You're given three integers, a, b and c. It is guaranteed that two of these
	// integers are equal to each other. What is the value of the third integer?
	// [input] integer a.
	// Precondition: 1 ≤ a ≤ 10^9.
	// [input] integer b.
	// Precondition: 1 ≤ a ≤ 10^9.
	// [input] integer c.
	// Precondition: 1 ≤ a ≤ 10^9.
	int extraNumber(int a, int b, int c) {
		return a == b ? c : b == c ? a : b;
	}
	
	// Given integers a and b, determine whether the following pseudocode results
	// in an infinite loop:
	//   while a is not equal to b do
	//     increase a by 1
	//     decrease b by 1
	// Assume that the program is executed on a virtual machine which can store
	// arbitrary long numbers and execute forever.
	// [input] integer a.
	// Precondition: 0 ≤ a ≤ 20.
	// [input] integer b.
	// Precondition: 0 ≤ b ≤ 20.
	boolean isInfiniteProcess(int a, int b) {
		return !(a <= b && a % 2 == b % 2);
	}
	
	// Consider an arithmetic expression of the form a#b=c. Check whether it is
	// possible to replace # with one of the four signs: +, -, * or / to obtain a
	// correct expression.
	// [input] integer a.
	// Precondition: 1 ≤ a ≤ 20.
	// [input] integer b.
	// Precondition: 1 ≤ b ≤ 20.
	// [input] integer c.
	// Precondition: 0 ≤ c ≤ 20.
	boolean arithmeticExpression(int a, int b, int c) {
		if (a + b == c) return true;
		if (a - b == c) return true;
		if (a * b == c) return true;
		if ((double) a / b == (double) c) return true;
		return false;
	}
	
	// In tennis, a set is finished when one of the players wins 6 games and the
	// other one wins less than 5, or, if both players win at least 5 games, until
	// one of the players wins 7 games.
	// Determine if it is possible for a tennis set to be finished with the score
	// score1 : score2.
	// [input] integer score1: Number of games won by the 1st player, non-negative
	// integer.
	// Precondition: 0 ≤ score1 ≤ 10.
	// [input] integer score2: Number of games won by the 2nd player, non-negative
	// integer.
	// Precondition: 0 ≤ score2 ≤ 10.
	boolean tennisSet(int s1, int s2) {
		return (s1 == 6 && s2 < 5) || (s2 == 7 && s1 >= 5 && s1 <= 6) ||
		(s2 == 6 && s1 < 5) || (s1 == 7 && s2 >= 5 && s2 <= 6);
	}
	
	// Once Mary heard a famous song, and a line from it stuck in her head. That
	// line was "Will you still love me when I'm no longer young and beautiful?".
	// Mary believes that a person is loved if and only if he/she is both young and
	// beautiful, but this is quite a depressing thought, so she wants to put her
	// belief to the test.
	// Knowing whether a person is young, beautiful and loved, find out if they
	// contradict Mary's belief.
	// A person contradicts Mary's belief if one of the following statements is true:
	//   -> they are young and beautiful but not loved;
	//   -> they are loved but not young or not beautiful.
	// [input] boolean young.
	// [input] boolean beautiful.
	// [input] boolean loved.
	boolean willYou(boolean young, boolean beautiful, boolean loved) {
		if (young && beautiful && loved) 
		return false;
		else 
		return (young && beautiful) || loved;
	}
	
	// You just bought a public transit card that allows you to ride the Metro for
	// a certain number of days.
	// Here is how it works: upon first receiving the card, the system allocates
	// you a 31-day pass, which equals the number of days in January. The second
	// time you pay for the card, your pass is extended by 28 days, i.e. the number
	// of days in February (note that leap years are not considered), and so on. The
	// 13th time you extend the pass, you get 31 days again.
	// You just ran out of days on the card, and unfortunately you've forgotten how
	// many times your pass has been extended so far. However, you do remember the
	// number of days you were able to ride the Metro during this most recent month.
	// Figure out the number of days by which your pass will now be extended, and
	// return all the options as an array sorted in increasing order.
	int[] metroCard(int lastNumberOfDays) {
		int[] a1 = {28, 30, 31};
		int[] a2 = {31};
		return lastNumberOfDays == 31 ? a1 : a2;
	}
	
	// CORNER OF 0s AND 1s
	
	// Implement the missing code, denoted by ellipses. You may not modify the
	// pre-existing code.
	// In order to stop the Mad Coder evil genius you need to decipher the encrypted
	// message he sent to his minions. The message contains several numbers that,
	// when typed into a supercomputer, will launch a missile into the sky blocking
	// out the sun, and making all the people on Earth grumpy and sad.
	// You figured out that some numbers have a modified single digit in their binary
	// representation. More specifically, in the given number n the kth bit from the
	// right was initially set to 0, but its current value might be different. It's
	// now up to you to write a function that will change the kth bit of n back to 0.
	// [input] integer n.
	// Precondition: 0 ≤ n ≤ 2^31 - 1.
	// [input] integer k: The 1-based index of the changed bit (counting from the right).
	// 1 ≤ k ≤ 31.
	int killKthBit(int n, int k) {
		return n & ~(1 << (k - 1));
	}
	
	// You are given an array of up to four non-negative integers, each less than 256.
	// Your task is to pack these integers into one number M in the following way:
	// -> The first element of the array occupies the first 8 bits of M;
	// -> The second element occupies next 8 bits, and so on.
	// Return the obtained integer M.
	// Note: the phrase "first bits of M" refers to the least significant bits of
	// M - the right-most bits of an integer.
	// [input] array.integer a.
	// Preconditions: 1 ≤ a.length ≤ 4, 0 ≤ a[i] < 256.
	int arrayPacking(int[] a) {
		int number = 0;
		String binary = "";
		
		String b;
		for (int n : a) {
			b = Integer.toBinaryString(n);
			binary = b + binary;
			
			for (int i = 0; i < 8 - b.length(); i ++)
			binary = "0" + binary;
		}
		
		return Integer.parseInt(binary, 2);
	}
	
	// You are given two numbers a and b where 0 ≤ a ≤ b. Imagine you construct an
	// array of all the integers from a to b inclusive. You need to count the number
	// of 1s in the binary representations of all the numbers in the array.
	// [input] integer a.
	// Precondition: 0 ≤ a ≤ b.
	// [input] integer b.
	// Precondition: 0 ≤ b ≤ b.
	int rangeBitCount(int a, int b) {
		int count = 0;
		
		String binary;
		for (int i = a; i <= b; i ++) {
			binary = Integer.toBinaryString(i);
			for (int j = 0; j < binary.length(); j ++)
			if (binary.charAt(j) == '1')
			count ++;
		}
		
		return count;
	}
	
	// Reverse the order of the bits in a given integer.
	// [input] integer a.
	// Precondition: 5 ≤ a ≤ 10^5.
	int mirrorBits(int a) {
		String binary = Integer.toBinaryString(a);
		
		String invBinary = "";
		for (int i = binary.length() - 1; i >= 0; i --)
		invBinary += binary.charAt(i);
		
		return Integer.parseInt(invBinary, 2);
	}
	
	// Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
	// Presented with the integer n, find the 0-based position of the second rightmost
	// zero bit in its binary representation (it is guaranteed that such a bit exists),
	// counting from right to left.
	// Return the value of 2position_of_the_found_bit.
	// [input] integer n.
	// Precondition: 4 ≤ n ≤ 2^30.
	int secondRightmostZeroBit(int n) {
		return ~(n | n + 1) & -~(n | n + 1);
	}
	
	// Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
	// You're given an arbitrary 32-bit integer n. Take its binary representation,
	// split bits into it in pairs (bit number 0 and 1, bit number 2 and 3, etc.)
	// and swap bits in each pair. Then return the result as a decimal number.
	// [input] integer n.
	// Precondition: 0 ≤ n ≤ 2^30.
	int swapAdjacentBits(int n) {
		return (((n & 0x2AAAAAAA) >> 1) | ((n & 0x15555555) << 1));
	}
	
	// Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
	// You're given two integers, n and m. Find position of the rightmost bit in
	// which they differ in their binary representations (it is guaranteed that such
	// a bit exists), counting from right to left.
	// Return the value of 2position_of_the_found_bit (0-based).
	// [input] integer n.
	// Precondition: 0 ≤ n ≤ 2^30.
	// [input] integer m.
	// Preconditions: 0 ≤ m ≤ 2^30, n ≠ m.
	int differentRightmostBit(int n, int m) {
		return -~((~(n^m))^((~(n^m))+1))/2;
	}
	
	// You're given two integers, n and m. Find position of the rightmost pair of equal bits in their binary representations (it is guaranteed that such a pair exists), counting from right to left.
	// Return the value of 2position_of_the_found_pair (0-based).
	// [input] integer n.
	// Precondition: 0 ≤ n ≤ 2^30.
	// [input] integer m.
	// Preconditions: 0 ≤ m ≤ 2^30.
	int equalPairOfBits(int n, int m) {
		return n + m + 1 & ~m - n ;
	}
	
	// LOOP TUNNEL
	
	// Given an integer n, find the minimal k such that:
	// -> k = m! (where m! = 1 * 2 * ... * m) for some integer m;
	// -> k >= n.
	// In other words, find the smallest factorial which is not less than n.
	// [input] integer n: A positive integer.
	// Precondition: 1 ≤ n ≤ 120.
	int leastFactorial(int n) {
		int k = 1;
		
		for (int i = 1; k < n; i ++)
		k *= i;
		
		return k;
	}
	
	// Given integers n, l and r, find the number of ways to represent n as a sum
	// of two integers A and B such that l ≤ A ≤ B ≤ r.
	// [input] integer n: A positive integer.
	// Precondition: 5 ≤ n ≤ 10^9.
	// [input] integer l: A positive integer.
	// Precondition: 1 ≤ l ≤ r.
	// [input] integer r: A positive integer.
	// l ≤ r ≤ 10^9, r - l ≤ 10^6.
	int countSumOfTwoRepresentations2(int n, int l, int r) {
		int count = 0;
		
		int i = n / 2;
		int j = n % 2 == 0 ? n / 2 : n / 2 + 1;
		while (i >= l && j <= r) {
			count ++;
			i --;
			j ++;
		}
		
		return count;
	}
	
	// You are standing at a magical well. It has two positive integers written on
	// it: a and b. Each time you cast a magic marble into the well, it gives you
	// a * b dollars and then both a and b increase by 1. You have n magic marbles.
	// How much money will you make?
	// [input] integer a.
	// Precondition: 1 ≤ a ≤ 2000.
	// [input] integer b.
	// Precondition: 1 ≤ b ≤ 2000.
	// [input] integer n: The number of magic marbles in your possession, a non-negative integer.
	// Precondition: 0 ≤ n ≤ 5.
	int magicalWell(int a, int b, int n) {
		int money = 0;
		
		for (int i = 1; i <= n; i ++)
		money += a ++ * b ++;
		
		return money;
	}
	
	// To prepare his students for an upcoming game, the sports coach decides to
	// try some new training drills. To begin with, he lines them up and starts with
	// the following warm-up exercise: when the coach says 'L', he instructs the
	// students to turn to the left. Alternatively, when he says 'R', they should
	// turn to the right. Finally, when the coach says 'A', the students should
	// turn around.
	// Unfortunately some students (not all of them, but at least one) can't tell
	// left from right, meaning they always turn right when they hear 'L' and left
	// when they hear 'R'. The coach wants to know how many times the students end
	// up facing the same direction.
	// Given the list of commands the coach has given, count the number of such
	// commands after which the students will be facing the same direction.
	// [input] string commands: String consisting of characters 'L', 'R' and 'A' only.
	// Precondition: 0 ≤ commands.length ≤ 35.
	int lineUp(String commands) {
		int count = 0;
		
		int pos = 0;
		char c;
		for (int i = 0; i < commands.length(); i ++) {
			c = commands.charAt(i);
			if (c == 'L') pos --;
			else if (c == 'R') pos ++;
			
			if (pos % 2 == 0) count ++;
		}
		
		return count;
	}
	
	// A little boy is studying arithmetics. He has just learned how to add two
	// integers, written one below another, column by column. But he always forgets
	// about the important part - carrying.
	// Given two integers, find the result which the little boy will get.
	// [input] integer param1: A non-negative integer.
	// Precondition: 0 ≤ param1 ≤ 99999.
	// [input] integer param2: A non-negative integer.
	// Precondition: 0 ≤ param2 ≤ 59999.
	int additionWithoutCarrying(int param1, int param2) {
		int sum = 0;
		
		for (int i = 1; param1 != 0 || param2 != 0; i *= 10) {
			int s = param1 % 10 + param2 % 10;
			sum += (s % 10) * i;
			param1 /= 10;
			param2 /= 10;
		}
		
		return sum;
	}
	
	// You have k apple boxes full of apples. Each square box of size m contains
	// m × m apples. You just noticed two interesting properties about the boxes:
	// -> 1. The smallest box is size 1, the next one is size 2,..., all the way
	//    up to size k.
	// -> 2. Boxes that have an odd size contain only yellow apples. Boxes that have
	//    an even size contain only red apples.
	// Your task is to calculate the difference between the number of red apples
	// and the number of yellow apples.
	// [input] integer k: A positive integer.
	// Precondition: 1 ≤ k ≤ 40.
	int appleBoxes(int k) {
		int yellow = 0, red = 0;
		
		for (int i = 1; i <= k; i += 2)
		yellow += i * i;
		
		for (int i = 0; i <= k; i += 2)
		red += i * i;
		
		return red - yellow;
	}
	
	// Define an integer's roundness as the number of trailing zeroes in it.
	// Given an integer n, check if it's possible to increase n's roundness by
	// swapping some pair of its digits.
	// [input] integer n: A positive integer.
	// Precondition: 100 ≤ n ≤ 10^9.
	boolean increaseNumberRoundness(int n) {
		int last;
		do {
			last = n % 10;
			n /= 10;
		} while (n > 0 && last == 0);
		
		for (; n > 0; n /= 10)
		if (n % 10 == 0)
		return true;
		
		return false;
	}
	
	// We want to turn the given integer into a number that has only one non-zero
	// digit using a tail rounding approach. This means that at each step we take
	// the last non 0 digit of the number and round it to 0 or to 10. If it's less
	// than 5 we round it to 0 if it's larger than or equal to 5 we round it to 10
	// (rounding to 10 means increasing the next significant digit by 1). The
	// process stops immediately once there is only one non-zero digit left.
	// [input] integer n: A positive integer.
	// Precondition: 1 ≤ value ≤ 10^8.
	int rounders(int n) {
		int last;
		int pos = 1;
		for (int number = n; number >= 10; number /= 10) {
			last = number % 10;
			n -= last * pos;
			
			pos *= 10;
			if (last >= 5) {
				n += pos;
				number += 10;
			}
		}
		
		return n;
	}
	
	// When a candle finishes burning it leaves a leftover. makeNew leftovers can
	// be combined to make a new candle, which, when burning down, will in turn
	// leave another leftover.
	// You have candlesNumber candles in your possession. What's the total number
	// of candles you can burn, assuming that you create new candles as soon as
	// you have enough leftovers?
	// [input] integer candlesNumber: The number of candles you have in your possession.
	// Precondition: 1 ≤ candlesNumber ≤ 15.
	// [input] integer makeNew: The number of leftovers that you can use up to create a new candle.
	// Precondition: 2 ≤ makeNew ≤ 5.
	int candles(int candlesNumber, int makeNew) {
		int candles = candlesNumber;
		
		int leftlovers = candlesNumber;
		int cNumber = candlesNumber;
		int remains = 0;
		while (leftlovers >= makeNew) {
			leftlovers = cNumber + remains;
			cNumber = leftlovers / makeNew;
			candles += cNumber;
			remains = leftlovers % makeNew;
		}
		
		return candles;
	}
	
	// Imagine a white rectangular grid of n rows and m columns divided into two
	// parts by a diagonal line running from the upper left to the lower right corner.
	// Now let's paint the grid in two colors according to the following rules:
	// -> A cell is painted black if it has at least one point in common with the diagonal;
	// -> Otherwise, a cell is painted white.
	// Count the number of cells painted black.
	// [input] integer n: The number of rows.
	// Precondition: 1 ≤ n ≤ 10^5.
	// [input] integer m: The number of columns.
	// Precondition: 1 ≤ m ≤ 10^5.
	int countBlackCells(int n, int m) {
		int max = 1;
		
		for (int i = 1; i <= n; i++)
		if (n % i == 0 && m % i == 0)
		max = i;
		
		return n + m + max - 2;
	}
	
	// LIST FOREST KNOWLEDGE
	
	// Given an integer size, return array of length size filled with 1s.
	// [input] integer size: A positive integer.
	// Precondition: 1 ≤ size ≤ 1000.
	int[] createArray(int size) {
		int[] array = new int[size];
		
		for (int i = 0; i < size; i ++)
		array[i] ++;
		
		return array;
	}
	
	// Given an array of integers, replace all the occurrences of elemToReplace
	// with substitutionElem.
	// [input] array.integer inputArray.
	// Precondition: 2 ≤ inputArray.length ≤ 10, 0 ≤ inputArray[i] ≤ 10.
	// [input] integer elemToReplace.
	// Precondition: 0 ≤ elemToReplace ≤ 10.
	int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
		for (int i = 0; i < inputArray.length; i ++)
		if (inputArray[i] == elemToReplace)
		inputArray[i] = substitutionElem;
		
		return inputArray;
	}
	
	// Reversing an array can be a tough task, especially for a novice programmer.
	// Mary just started coding, so she would like to start with something basic at
	// first. Instead of reversing the array entirely, she wants to swap just its
	// first and last elements.
	// Given an array arr, swap its first and last elements and return the resulting
	// array.
	// [input] array.integer arr.
	// Precondition: 0 ≤ arr.length ≤ 50, -10^4 ≤ arr[i] ≤ 10^4.
	int[] firstReverseTry(int[] arr) {
		int len = arr.length;
		
		if (len > 1) {
			int ini = arr[0];
			int fi = arr[len - 1];
			
			arr[0] = fi;
			arr[len - 1] = ini;
		}
		
		return arr;
	}
	
	// Given two arrays of integers a and b, obtain the array formed by the elements
	// of a followed by the elements of b.
	// [input] array.integer a.
	// Precondition: 1 ≤ a.length ≤ 10, 1 ≤ a[i] ≤ 15.
	// [input] array.integer b.
	// Precondition: 1 ≤ b.length ≤ 10, 1 ≤ b[i] ≤ 15.
	int[] concatenateArrays(int[] a, int[] b) {
		int[] outputArray = new int[a.length + b.length];
		
		int i;
		for (i = 0; i < a.length; i ++)
		outputArray[i] = a[i];
		
		for (int j = 0; i < outputArray.length; i ++, j ++)
		outputArray[i] = b[j];
		
		return outputArray;
	}
	
	// Remove a part of a given array between given 0-based indexes l and r (inclusive).
	// [input] array.integer inputArray.
	// Precondition: 2 ≤ inputArray.length ≤ 10, -10 ≤ inputArray[i] ≤ 10.
	// [input] integer l: Left index of the part to be removed (0-based).
	// Precondition: 0 ≤ l ≤ r.
	// [input] integer r: Right index of the part to be removed (0-based).
	// Precondition: l ≤ r < inputArray.length.
	int[] removeArrayPart(int[] inputArray, int l, int r) {
		int[] out = new int[inputArray.length - (r - l) - 1];
		
		int i;
		for (i = 0; i < l; i ++)
		out[i] = inputArray[i];
		
		for (int j = r + 1; j < inputArray.length; i ++, j ++)
		out[i] = inputArray[j];
		
		return out;
	}
	
	// We define the middle of the array arr as follows:
	// -> if arr contains an odd number of elements, its middle is the element whose
	//    index number is the same when counting from the beginning of the array and
	//    from its end;
	// -> if arr contains an even number of elements, its middle is the sum of the
	//    two elements whose index numbers when counting from the beginning and from
	//    the end of the array differ by one.
	// An array is called smooth if its first and its last elements are equal to
	// one another and to the middle. Given an array arr, determine if it is smooth
	// or not.
	// [input] array.integer arr: The given array.
	// Precondition: 2 ≤ arr.length ≤ 10^4, -10^3 ≤ arr[i] ≤ 10^3.
	boolean isSmooth(int[] arr) {
		int len = arr.length;
		int middle = arr[len / 2];
		
		if (len % 2 == 0)
		middle += arr[len / 2 - 1];
		
		return arr[0] == arr[len - 1] && arr[0] == middle;
	}
	
	// We define the middle of the array arr as follows:
	// -> if arr contains an odd number of elements, its middle is the element whose
	//    index number is the same when counting from the beginning of the array and
	//    from its end;
	// -> if arr contains an even number of elements, its middle is the sum of the
	// two elements whose index numbers when counting from the beginning and from
	// the end of the array differ by one.
	// Given array arr, your task is to find its middle, and, if it consists of two
	// elements, replace those elements with the value of middle. Return the
	// resulting array as the answer.
	// [input] array.integer arr: The given array.
	// Precondition: 2 ≤ arr.length ≤ 10^4, -10^3 ≤ arr[i] ≤ 10^3.
	int[] replaceMiddle(int[] arr) {
		if (arr.length % 2 == 1) return arr;
		
		int[] out = new int[arr.length - 1];
		
		out[out.length / 2] = arr[arr.length / 2 - 1] + arr[arr.length / 2];
		
		int i;
		for (i = 0; i < out.length / 2; i++)
		out[i] = arr[i];
		
		for (i++; i < out.length; i++)
		out[i] = arr[i + 1];
		
		return out;
	}
	
	// Ratiorg got statues of different sizes as a present from CodeMaster for his
	// birthday, each statue having an non-negative integer size. Since he likes to
	// make things perfect, he wants to arrange them from smallest to largest so
	// that each statue will be bigger than the previous one exactly by 1. He may
	// need some additional statues to be able to accomplish that. Help him figure
	// out the minimum number of additional statues needed.
	// [input] array.integer statues: An array of distinct non-negative integers.
	// Precondition: 1 ≤ statues.length ≤ 10, 0 ≤ statues[i] ≤ 20.
	int makeArrayConsecutive2(int[] statues) {
		int min = 20;
		int max = 0;
		
		for (int elem : statues) {
			if (min > elem)
			min = elem;
			if (max < elem)
			max = elem;
		}
		
		return max - min - statues.length + 1;
	}
	
	// LABYRINTH OF NESTED LOOPS
	
	// Determine if the given number is a power of some non-negative integer.
	// [input] integer n: A positive integer.
	// Precondition: 1 ≤ n ≤ 400.
	boolean isPower(int n) {
		if (n == 1) return true;
		
		int result = 0;
		
		for (int i = 2; i <= 20 && result != n; i++) {
			result = i * i;
			
			while (result < n)
			result *= i;
		}
		
		return result == n;
	}
	
	// Find the number of ways to express n as sum of some (at least two) consecutive
	// positive integers.
	// [input] integer n: A positive integer.
	// Precondition: 1 ≤ n ≤ 25.
	int isSumOfConsecutive2(int n) {
		int res = 0;
		
		int number;
		for (int ini = 1; ini < n / 2 + 1; ini ++) {
			number = n;
			
			for (int subtrahend = ini; number > 0; subtrahend ++)
			number -= subtrahend;
			
			if (number == 0)
			res ++;
		}
		
		return res;
	}
	
	// Consider a sequence of numbers a0, a1, ..., an, in which an element is equal to the sum of squared digits of the previous element. The sequence ends once an element that has already been in the sequence appears again.
	// Given the first element a0, find the length of the sequence.
	// [input] integer a0: First element of a sequence, positive integer.
	// Precondition: 1 ≤ a0 ≤ 650.
	int squareDigitsSequence(int a0) {
		Set<Integer> sequence = new HashSet<>();
		
		int aNext = a0;
		
		while (sequence.add(aNext)) {
			a0 = aNext;
			aNext = 0;
			
			while (a0 > 0) {
				aNext += Math.pow(a0 % 10, 2);
				a0 /= 10;
			}
		}
		
		return sequence.size() + 1;
	}
	
	// You work in a company that prints and publishes books. You are responsible
	// for designing the page numbering mechanism in the printer. You know how many
	// digits a printer can print with the leftover ink. Now you want to write a
	// function to determine what the last page of the book is that you can number
	// given the current page and numberOfDigits left. A page is considered numbered
	// if it has the full number printed on it (e.g. if we are working with page 102
	// but have ink only for two digits then this page will not be considered numbered).
	// It's guaranteed that you can number the current page, and that you can't
	// number the last one in the book.
	// [input] integer current: A positive integer, the number on the current page which is not yet printed.
	// Precondition: 1 ≤ current ≤ 1000.
	// [input] integer numberOfDigits: A positive integer, the number of digits which your printer can print.
	// Precondition: 1 ≤ numberOfDigits ≤ 1000.
	int pagesNumberingWithInk(int current, int numberOfDigits) {
		int i, j;
		for (i = current; numberOfDigits > 0; i ++) {
			for (j = i; j > 0 && numberOfDigits > 0; j /= 10)
			numberOfDigits --;
			
			if (numberOfDigits == 0 && j != 0) break;
		}
		
		return i - 1;
	}
	
	// Let's say that number a feels comfortable with number b if a ≠ b and b lies
	// in the segment [a - s(a), a + s(a)], where s(x) is the sum of x's digits.
	// How many pairs (a, b) are there, such that a < b, both a and b lie on the
	// segment [l, r], and each number feels comfortable with the other (so a feels
	// comfortable with b and b feels comfortable with a)?
	// [input] integer l.
	// Precondition: 1 ≤ l ≤ r ≤ 1000.
	// [input] integer r.
	// Precondition: 1 ≤ l ≤ r ≤ 1000.
	int comfortableNumbers(int l, int r) {
		int comf = 0;
		
		boolean[][] arr = new boolean[2000][2000];
		
		int i, j, sum;
		for (i = l; i <= r; i ++) {
			sum = 0;
			for (j = i; j > 0; j /= 10)
			sum += j % 10;
			
			for (j = i - sum; j <= i + sum; j ++)
			if (i != j)
			arr[i][j] = true;
		}
		
		for (i = 0; i < arr.length; i ++)
		for (j = i + 1; j < arr[i].length; j ++)
		if (arr[i][j] && arr[j][i])
		comf ++;
		
		return comf;
	}
	
	// We define the weakness of number x as the number of positive integers smaller than x that have more divisors than x.
	// It follows that the weaker the number, the greater overall weakness it has. For the given integer n, you need to answer two questions:
	// -> what is the weakness of the weakest numbers in the range [1, n]?
	// -> how many numbers in the range [1, n] have this weakness?
	// Return the answer as an array of two elements, where the first element is the answer to the first question, and the second element is the answer to the second question.
	// [input] integer n.
	// Precondition: 1 ≤ n ≤ 1000.
	int[] weakNumbers(int n) {
		int[] result = new int[2];
		
		int[] divs = new int[n + 1];
		int[] weaks = new int[n + 1];
		
		int i, j;
		for (i = 1; i <= n; i ++) {
			for (j = 1; j <= i; j ++)
			if (i % j == 0)
			divs[i] ++;
			for (j = i - 1; j > 0; j --)
			if (divs[j] > divs[i])
			weaks[i] ++;
		}
		
		for (i = 1; i <= n; i ++)
		if (weaks[i] > result[0])
		result[0] = weaks[i];
		for (i = 1; i <= n; i ++)
		if (weaks[i] == result[0])
		result[1] ++;
		
		return result;
	}
	
	// A rectangle with sides equal to even integers a and b is drawn on the Cartesian plane. Its center (the intersection point of its diagonals) coincides with the point (0, 0), but the sides of the rectangle are not parallel to the axes; instead, they are forming 45 degree angles with the axes.
	// How many points with integer coordinates are located inside the given rectangle (including on its sides)?
	// [input] integer a: A positive even integer.
	// Precondition: 2 ≤ a ≤ 50.
	// [input] integer b: A positive even integer.
	// Precondition: 2 ≤ b ≤ 50.
	int rectangleRotation(int a, int b) {
		
	}
	
}
