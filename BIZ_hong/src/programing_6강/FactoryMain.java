package programing_6강;

public class FactoryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShapeFactory shapeFactory = new ShapeFactory();

	      //get an object of Circle and call its draw method.
		//팩토리를 사용하여 유형과 같은 정보를 전달하여 구체적인 클래스의 객체를 가져옵니다
	      Shape shape1 = shapeFactory.getShape("CIRCLE");

	      //call draw method of Circle
	      shape1.draw();

	      //get an object of Rectangle and call its draw method.
	      Shape shape2 = shapeFactory.getShape("RECTANGLE");

	      //call draw method of Rectangle
	      shape2.draw();

	      //get an object of Square and call its draw method.
	      Shape shape3 = shapeFactory.getShape("SQUARE");

	      //call draw method of square
	      shape3.draw();
	   }//새로운 구체적인 객체를 얻으려면 팩트로리 클래스의 get만 사용해야함
		
		
	}


