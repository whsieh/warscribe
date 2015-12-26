package warscribe.data;

import java.util.Random;

public class Roller {

	public static int roll(int num, int sides, int bonus) {
		int sum = 0;
		for (int i = 0; i < num; i++)
			sum += randomNumber(sides);
		sum += bonus;
		return sum;
	}

	public static int randomNumber(int sides) {
		Random randInt = new Random();
		int large_int = 0;
		for (int i = 1; i <= 100000000; i *= 10) {
			large_int += i * randInt.nextInt(10);
		}
		return (large_int % sides) + 1;
	}

	public static int roll_single(String in) {
		int n = 0, s = 0, b = 0;

		if (in.indexOf("d") != -1 && in.indexOf("+") != -1) {

			n = Integer.parseInt(in.substring(0, in.indexOf("d")));
			s = Integer.parseInt(in.substring(in.indexOf("d") + 1, in.indexOf("+")));
			b = Integer.parseInt(in.substring(in.indexOf("+") + 1, in.length()));

		} else if (in.indexOf("d") != -1 && in.indexOf("+") == -1) {

			n = Integer.parseInt(in.substring(0, in.indexOf("d")));
			s = Integer.parseInt(in.substring(in.indexOf("d") + 1, in.length()));
			b = 0;

		} else {

			n = 0;
			s = 0;
			b = Integer.parseInt(in);

		}

		return roll(n, s, b);
	}

	public static int roll(String in) {
		if (in.indexOf("&") == -1)
			return roll_single(in);
		else {

			int sum = 0;
			String[] rolls = new String[0];

			while (in.indexOf("&") != -1) {
				rolls = Misc.add(rolls, in.substring(0, in.indexOf("&")));
				in = in.substring(in.indexOf("&") + 1, in.length());
			}
			rolls = Misc.add(rolls, in);

			for (int i = 0; i < rolls.length; i++) {
				sum += roll_single(rolls[i]);
			}
			return sum;
		}
	}

	public static void randomTest(int num, int sides) {
		int[] distr = new int[sides];
		for (int i = 0; i < num; i++) {
			int randomNum = randomNumber(sides);
			System.out.println(randomNum);
			distr[randomNum - 1]++;
		}
		System.out.println("===================Results:===================\n");
		for (int c = 0; c < sides; c++) {
			System.out.println((c + 1) + ": " + 100.0 * distr[c] / num + "%");
		}
	}

}
