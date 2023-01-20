package Practice_Package;

import org.testng.annotations.Test;

public class testng {
	
 @Test
 public void create()
 {
	 System.out.println("create the class");
 }
 @Test (invocationCount=2)
 public void update() {
	 System.out.println("update the class");
 }
 @Test 
 public void delete() {
	 System.out.println("delete the class");
 
}
}