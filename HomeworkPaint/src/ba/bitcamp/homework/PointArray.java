package ba.bitcamp.homework;

public class PointArray {

	private Point[] points;
	private int length;
	
	public PointArray() {
		this.points = new Point[10];
		this.length = 0;
	}
	
	public void addPoint(Point p){
		if(length == points.length){
			resize();
		}
		this.points[length++] = p;
		System.out.println(length);
	}
	
	public void setLength(int length){
		this.length = length;
	}
	
	public int getLength(){
		return length;
	}
	
	public Point elementAt(int index){
		return points[index];
	}

	private void resize() {
		Point[] tmp = new Point[points.length * 2];
		for (int i = 0; i < points.length; i++) {
			tmp[i] = points[i];
		}
		points = tmp;
	}
}
