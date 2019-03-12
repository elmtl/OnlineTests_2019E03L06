package com.acquisio.basic.java.question03;

/**
 * QUESTION 04: StackOverflow
 * This program crashes after throwing StackOverflowError exception:
 * Fix the factorial method.
 *
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */
public class IssueResolving {
	public static void main(String[] args) {
		IssueResolving instance = new IssueResolving();
		System.out.println(instance.factorial(7));
	}

	/***
	 * To calulate the factorial ex: 3!  = 3 x 2 x 1
	 * @param n input value
	 * @return calculated factorial
	 */
	int factorial(int n) {
		// TODO: Fix code here.
		if (n > 0) {
			int result = 0;
			result = factorial(n - 1) * n;
			return result;
		}
		return 1;
	}

}
