package com.acquisio.basic.java.question01;

/**
 * QUESTION 01: FooBar You have a program that loop from 1 to 50.
 * <p>
 * The program must follow those rules: - Must print 'Foo' if the value can be
 * divided by 3. - Must print 'Bar' if the value can be divided by 5. -
 * Otherwise, print the current integer value in the loop.
 *
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is
 * necessary.
 */
public class FooBar {
	public static void main(String[] args) {
		FooBar main = new FooBar();
		for (int i = 1; i <= 50; i++) {
			System.out.println(i +  " " + main.fooBar(i));
		}
	}

	/**
	 * Return a string containing 'Foo' if the input value can be
	 * divided by 3. - return  a string containing 'Bar' if the value can be divided by 5.
	 * @param value
	 * @return
	 */
	String fooBar(int value) {		
		String result = "";
		if (value % 3 == 0) {
			result = "Foo";
		} 
		if (value % 5 == 0) {
			result +=  "Bar";
		}
		if ( result.length() > 0 )
			return result;
				
		return Integer.toString(value);
	}
}
