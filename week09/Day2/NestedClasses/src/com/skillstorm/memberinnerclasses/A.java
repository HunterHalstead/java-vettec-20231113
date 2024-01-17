package com.skillstorm.memberinnerclasses;

public class A {
	private int x = 1;

	void printXs() {
		System.out.println("A:" + x);
		// System.out.println(B.x)
		// System.out.println(this.B.x);
		// System.out.println(B.this.x);
		B b = new B();
		System.out.println("B:" + x);
	}

	public class B {
		private int x = 2;

		public void printXs() {
			System.out.println(x);
			System.out.println(/* class A's x */ A.this.x);
		}

		public class C {
			private int x = 3;

			public void printXs() {
				System.out.println(x);
				System.out.println(/* class A's x */ A.this.x);
				System.out.println(/* class A's x */ B.this.x);
				System.out.println(/* class A's x */ C.this.x);
			}

		}
	}

}
