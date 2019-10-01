package programing_6��;

public class ShapeFactory {
	
	 //use getShape method to get object of type shape 
	//�־��� ������ ������� ��ü���� Ŭ������ ��ü�� �����ϴ� ���丮�� �����Ѵ�.
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
	//���߿� ���ο��� getshape�� ���ؼ��� ��ü ���� �� �� �ְ� �Ѵ�
}
