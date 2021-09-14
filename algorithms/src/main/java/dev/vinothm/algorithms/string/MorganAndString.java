package dev.vinothm.algorithms.string;

class MorganAndString {

    /*
     * Complete the 'morganAndString' function below.
     *
     * The function is expected to return a STRING. The function accepts following
     * parameters: 1. STRING a 2. STRING b
     */

    public static String morganAndString(String a, String b) {
	// Write your code here
	StringBuilder str = new StringBuilder(a.length() + b.length());
	int i = 0;
	int j = 0;
	while (i < a.length() || j < b.length()) {
	    char first = '*';
	    if (i < a.length()) {
		first = a.charAt(i);
	    }
	    char second = '*';
	    if (j < b.length()) {
		second = b.charAt(j);
	    }
	    if (first == '*' && second != '*') {
		str.append(second);
		j++;
	    } else if (second == '*' && first != '*') {
		str.append(first);
		i++;
	    } else if (first == second) {
		if (canGetFirst(i, j, a, b)) {
		    str.append(first);
		    i++;
		} else {
		    str.append(second);
		    j++;
		}
	    } else if (second < first) {
		str.append(second);
		j++;
	    } else {
		str.append(first);
		i++;
	    }
	}
	return str.toString();
    }

    private static boolean canGetFirst(int i, int j, String a, String b) {
	while (i < a.length() - 1 && j < b.length() - 1 && a.charAt(i) == b.charAt(j)) {
	    i++;
	    j++;
	}

	return a.charAt(i) < b.charAt(j);
    }

    public static void main(String[] args) {
	System.out.println(MorganAndString.morganAndString("MZBM", "FGAKWMOAWLZQJY"));
    }

}
