package fasd;

public class Array_Of_Objects_main {

	public static void main(String[] args) {
		
		//Food[] refrigerator = new Food[3];
		
		Food food1 = new Food("pizza");
		Food food2 = new Food("hamburger");
		Food food3 = new Food("hotdog");
		
		Food[] refrigerator = {food1,food2,food3};
		
		//refrigerator[0] = food1;
		//refrigerator[1] = food2;
		//refrigerator[2] = food3;
		
		
//		System.out.println(refrigerator[0].name);
//		System.out.println(refrigerator[1].name);
//		System.out.println(refrigerator[2].name);
		
		// or
		
		for (int i = 0; i<refrigerator.length; i++) {
	       System.out.println(refrigerator[i].name);
		}
		
		// or 
		
		for( Food i: refrigerator){
		      System.out.println(i.name);
		}
		
	}
}