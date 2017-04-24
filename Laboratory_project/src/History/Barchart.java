package History;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;



public class Barchart extends Application {
	String monthN[]={"Januray","February","March","April","May","June","July","August","September","October","November","December"};
	int mon[]={12,34,34,65,78,90,76,12,33,44,56};
	int yr1;
	


/*	public Barchart(int yr2, String[] monthName2, int[] month2) {
		// TODO Auto-generated constructor stub
	yr=yr2;
		monthName=monthName2;
		month=month2;
		System.out.println(yr);
	
	}*/
	@Override
	public void start(Stage stage){
		// TODO Auto-generated method stub
		   stage.setTitle("Bar Chart Sample");
	        final CategoryAxis xAxis = new CategoryAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        final BarChart<String,Number> bc = 
	            new BarChart<String,Number>(xAxis,yAxis);
	        bc.setTitle("Laboratory History");
	        xAxis.setLabel("Month");       
	        yAxis.setLabel("Damage Occured");
	 
	        XYChart.Series series = new XYChart.Series();
	        series.setName(Integer.toString(yr1)); 
	       
	        
	        	series.getData().add(new XYChart.Data(monthN[0], mon[0]));	
	        	series.getData().add(new XYChart.Data(monthN[1], mon[1]));
	        	series.getData().add(new XYChart.Data(monthN[2], mon[2]));
	        	series.getData().add(new XYChart.Data(monthN[3], mon[3]));
	        	series.getData().add(new XYChart.Data(monthN[4], mon[4]));
	        	series.getData().add(new XYChart.Data(monthN[5], mon[5]));
	        	series.getData().add(new XYChart.Data(monthN[6], mon[6]));
	        	series.getData().add(new XYChart.Data(monthN[7], mon[7]));
	        	series.getData().add(new XYChart.Data(monthN[8], mon[8]));
	        	series.getData().add(new XYChart.Data(monthN[9], mon[9]));
	        	series.getData().add(new XYChart.Data(monthN[10], mon[10]));
	        Scene scene  = new Scene(bc,800,600);
	        bc.getData().addAll(series);       
	        stage.setScene(scene);
	        stage.show();
	}
	public static void main(String args[]){
	
		
		launch(args);
	}

}
