class Factorial {

	void factorialFinder(int number) {
		int result = 1;
		for (int i = number; i >= 1; i--) {
			result = result * i;
		}
		System.out.println(result);

	}
}