package programing_6강;

public class ShapeFactory {
	
	 //use getShape method to get object of type shape 
	//주어진 정보를 기반으로 구체적인 클래스의 객체를 생성하는 팩토리를 생성한다.
	   public Shape getShape(String shapeType){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("CIRCLE")){
	         return new Circle();
	         
	      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle();
	         
	      } else if(shapeType.equalsIgnoreCase("SQUARE")){
	         return new Square();
	      }
	      
	      return null;
	   }
	//나중에 메인에서 getshape를 통해서만 객체 생성 할 수 있게 한다
}
