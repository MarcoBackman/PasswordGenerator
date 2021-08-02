import java.io.File;
import java.lang.Exception;

import PassGen.calculation.*;

class Run {
	public static void main(String[] args) {
		Run inst = new Run();	
		inst.run();
	}
	
	void run () {
		Generate test1 = new Generate(true, true, false, false, false, true);
		System.out.println("Password: " + test1.generate(6));
		System.out.println("Password: " + test1.generate(10));
		Generate test2 = new Generate(true, true, true, true, false, true);
		System.out.println("Password: " +test2.generate(10));
		System.out.println("Password: " +test2.generate(15));
		Generate test3 = new Generate(true, true, true, true, true, true);
		System.out.println("Password: " +test3.generate(20));
		try {
			System.out.println(new File(".").getCanonicalPath());	
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
