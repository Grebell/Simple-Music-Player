import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
public class project3 extends Object{
	public abstract class Shape{
		public String name;
		
		/**
 		*@param name
 		*/
		public Shape(String name){
		this.name = name;
		}
		public String getName(){
		return name;
		}
		
		public abstract double getArea();
	}

//__________________________________________________________________________________________//

	public static class Rectangle extends Shape{
		private double base;
		private double height;

		/**
		 *@param name  	 	 
		 *@param base
		 *@param height
 		*/
		public Rectangle(String name, double base, double height){
		this.name = name;
		this.base = base;
		this.height = height;
		}

		@Override
		public double getArea(){
		return base * height;
		}
//- - - - - - - - - - - - - - - - - - - -- - - - - - - - -- -- -//
	}
	public static class Square extends Rectangle{
		public Square(String name, Double side){
		super(name,side,side);
		}
	}

//________________________________________________________________________________________//

	public static class Triangle extends Shape{
		private double base;
		private double height;
	
                /**
                 *@param name
                 *@param base
             	 *@param height
                */
		public Triangle(String name, double base, double height){
			super(name);
			this.base = base;
			this.height = height;
		}
		@Override
		public double getArea(){
		return base*height;		
		}
	}

//______________________________________________________________________________________//
	public static class Circle extends Shape{
		private double radius;
		/**
		 *@param name
		 *@param radius
		*/
		public Circle(String name,double radius){
		super(name);
		this.radius = radius;
		}
		
		@Override
		public double getArea(){
			return Math.PI * radius * radius;
		}
	}


//_____________________________________________________________________________________//

	public static void main(String Args[]){
		Scanner readFile = null;
		ArrayList<Shape>shapes = new ArrayList<Shape>();

		try{
			readFile = new Scanner(new File("shapes.txt"));
			while(readFile.hasNext()){
				String str = readFile.nextLine();
				String arr[]=str.split(", ");
				if (arr[0].equalsIgnoreCase("Rectangle")){
					double base = Double.parseDouble(arr[2]);
					double height = Double.parseDouble(arr[3]);
					Rectangle r = new Rectangle(arr[1],base,height);
					shapes.add(r);
				}else if (arr[0].equalsIgnoreCase("Square")){
					double side = Double.parseDouble(arr[2]);
					Square sq = new Square(arr[1],side);
					shapes.add(sq);
				}else if (arr[0].equalsIgnoreCase("Triangle")){
					double base = Double.parseDouble(arr[2]);
					double height = Double.parseDouble(arr[3]);
					Triangle tr = new Triangle(arr[1],base,height);
					shapes.add(tr);
				}else if (arr[0].equalsIgnoreCase("Circle")){
					double radius = Double.parseDouble(arr[2]);
					Circle ci = new Circle(arr[1],radius);
					shapes.add(ci);
				}
			}
			readFile.close();
			double totalArea=getCumulativeArea(shapes);
			String shapeName=getLargestShape(shapes);
			System.out.printf("Total area: %.2f sq\n", totalArea);
			System.out.println("The biggest shape is "+shapeName);
	}catch(FileNotFoundException e){
		e.printStackTrace();
		}
	}
//___________________________________________________________________________________//
	private static String getLargestShape(ArrayList<Shape>shapes){
		int maxIndex=0;
		for(int i=0;i<shapes.size();i++){
			if(shapes.get(maxIndex).getArea()<shapes.get(i).getArea()){
				maxIndex=i;		
				}	
			}
		return shapes.get(maxIndex).getName();
	}
	private static double getCumulativeArea(ArrayList<Shape>shapes){
		double totalArea=0.0;
		for(int i=0;i<shapes.size();i++){
			totalArea+=shapes.get(i).getArea();
		}
		return totalArea;
	}
}

