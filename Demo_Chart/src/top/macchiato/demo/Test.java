package top.macchiato.demo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame("jfreechart统计表示例");  
		frame.setLayout(new GridLayout(2,2,10,10));
		//柱状图1
		ChartPanel barChartPanel = new ChartPanel(
	    		BarChart.createChart("水果", "水果种类", "水果数量", BarChart.createDatasetDemo1()));
	    frame.add(barChartPanel);
	    //柱状图2
		ChartPanel barChartPanel1 = new ChartPanel(
	    		BarChart.createChart("水果", "水果种类", "水果数量", BarChart.createDatasetDemo2()));
	    frame.add(barChartPanel1);
	    //饼状图
		ChartPanel pieChartPanel = new ChartPanel(
	    		PieChart.createPieChart3D("水果产量", PieChart.createDatasetDemo()));
		frame.add(pieChartPanel);
		//折线图
		ChartPanel lineChartPanel = new ChartPanel(
	    		LineChart.createLineChart("水果", "水果种类", "水果数量", LineChart.createDatasetDemo()));
	    frame.add(lineChartPanel);
	    
	    frame.setBounds(20, 20, 1600, 1000);  
	    frame.setVisible(true); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
