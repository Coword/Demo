package top.macchiato.demo;
import java.awt.Font;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart {
	
	private static JFreeChart lineChart = null;
	private static DefaultCategoryDataset dataset = null;
	/**
	  * @Title: createLineChart
	  * @Description: 创建折线图
	  * @param @param chartTitle	柱状图标题
	  * @param @param xName			x坐标名称
	  * @param @param yName			y坐标名称
	  * @param @param dataset		柱状图数据集
	  * @param @return    参数
	  * @return JFreeChart    返回类型
	  * @throws
	  * 设置字体是为了解决中文乱码问题
	  */
	public static JFreeChart createLineChart(
			String chartTitle, String xName,String yName, CategoryDataset dataset) {
		lineChart = ChartFactory.createLineChart(chartTitle, xName, 
				yName, dataset, PlotOrientation.VERTICAL,true,true,false);
		CategoryPlot categoryplot = (CategoryPlot) lineChart.getPlot();
		//字体设置
		Font labelFont = new Font("宋体", Font.BOLD, 12);
		// 设置标题的字体
		lineChart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
		// 设置图示的字体
		lineChart.getLegend().setItemFont(labelFont);
		//横轴 x
	    CategoryAxis domainAxis = categoryplot.getDomainAxis();
	    domainAxis.setLabelFont(labelFont);// 轴标题
	    domainAxis.setTickLabelFont(labelFont);// 轴数值
	    //纵轴 y
	    NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
	    numberaxis.setLabelFont(labelFont);
	    numberaxis.setTickLabelFont(labelFont);
	    numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	    numberaxis.setAutoRangeIncludesZero(true);
	    // x轴 // 分类轴网格是否可见
	    categoryplot.setDomainGridlinesVisible(true);
	    // y轴 //数据轴网格是否可见
	    categoryplot.setRangeGridlinesVisible(true);
	    // 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
	    LineAndShapeRenderer lineandshaperenderer = 
	    		(LineAndShapeRenderer) categoryplot.getRenderer();
	    //数据点可见
	    lineandshaperenderer.setBaseShapesVisible(true); 
	    //数据点间连线可见
	    lineandshaperenderer.setBaseLinesVisible(true); 
	    // 显示折点数据
	    lineandshaperenderer
	            .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	    lineandshaperenderer.setBaseItemLabelsVisible(true);
	 
	    return lineChart;
	}
	
	/**
	  * @Title: createDatasetDemo
	  * @Description: 创建折线图数据集Demo
	  * @param @return    参数
	  * @return DefaultCategoryDataset    返回类型
	  * @throws
	  */
	public static DefaultCategoryDataset createDatasetDemo() {  
		dataset = new DefaultCategoryDataset();  
		dataset.addValue(100, "苹果", "北京"); 
		dataset.addValue(200, "苹果", "上海");
		dataset.addValue(300, "苹果", "广州");
		dataset.addValue(400, "苹果", "成都");
		dataset.addValue(500, "苹果", "深圳");
		
		dataset.addValue(50, "梨子", "北京"); 
		dataset.addValue(150, "梨子", "上海");
		dataset.addValue(250, "梨子", "广州");
		dataset.addValue(350, "梨子", "成都");
		dataset.addValue(450, "梨子", "深圳");
		
		dataset.addValue(150, "香蕉", "北京"); 
		dataset.addValue(250, "香蕉", "上海");
		dataset.addValue(350, "香蕉", "广州");
		dataset.addValue(450, "香蕉", "成都");
		dataset.addValue(550, "香蕉", "深圳");
		
        return dataset;  
    }
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame("Java数据统计图之柱状图");  
//	    ChartPanel chartPanel = new ChartPanel(
//	    		createLineChart("水果", "水果种类", "水果数量", createDatasetDemo()));
//	    frame.add(chartPanel);
//	    frame.setBounds(20, 20, 800, 500);  
//	    frame.setVisible(true); 
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}

}
