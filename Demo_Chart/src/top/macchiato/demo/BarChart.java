package top.macchiato.demo;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


/**
  * @ClassName: BarChart
  * @Description: 创建柱状图表并设定数据集
  * @author 满城烟雨 wenjie.leung@hotmail.com
  * @date 2016年3月20日
  *
  */
public class BarChart {
	
	private static JFreeChart barChart = null;
	private static DefaultCategoryDataset dataset = null;
	
	/**
	  * @Title: createChart
	  * @Description: 创建柱状图
	  * @param @param chartTitle	柱状图标题
	  * @param @param xName			x坐标名称
	  * @param @param yName			y坐标名称
	  * @param @param dataset		柱状图数据集
	  * @param @return    参数
	  * @return JFreeChart    返回类型
	  * @throws
	  * 设置字体是为了解决中文乱码问题
	  */
	public static JFreeChart createChart(String chartTitle, String xName,
	            String yName, CategoryDataset dataset) {
		barChart = ChartFactory.createBarChart(chartTitle, xName, 
        		yName, dataset, PlotOrientation.VERTICAL,true, true, false);
		//获取图表区域对象  
		CategoryPlot plot = barChart.getCategoryPlot();	
		//横坐标 
	    CategoryAxis domainAxis = plot.getDomainAxis(); 
	    //横坐标x轴标题字体  
	    domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));
	    //横坐标x轴坐标字体  
	    domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12)); 
	    //纵坐标
	    ValueAxis rangeAxis = plot.getRangeAxis(); 
	    //纵坐标y轴标题字体
	    rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
	    //纵坐标y轴坐标字体
	    barChart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
	    //标题字体  
	    barChart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
	    BarRenderer barRenderer = (BarRenderer) plot.getRenderer();
	    // 设置柱子宽度
        barRenderer.setMaximumBarWidth(0.05);
        // 设置每个柱之间距离
        barRenderer.setItemMargin(0.05);
        //显示每个柱的数值，并修改该数值的字体属性
        barRenderer.setIncludeBaseInRange(true);
        barRenderer.setBaseItemLabelGenerator(
        		new StandardCategoryItemLabelGenerator());
        barRenderer.setBaseItemLabelsVisible(true);
        
	    return barChart;
	}
	
	/**
	  * @Title: createDatasetDemo1
	  * @Description: 创建柱状图数据集demo1
	  * @param @return    参数
	  * @return CategoryDataset    返回类型
	  * @throws
	  */
	public static CategoryDataset createDatasetDemo1() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        dataset.addValue(100, "北京", "苹果");  
        dataset.addValue(100, "上海", "苹果");  
        dataset.addValue(100, "广州", "苹果");  
        dataset.addValue(200, "北京", "梨子");  
        dataset.addValue(200, "上海", "梨子");  
        dataset.addValue(200, "广州", "梨子");  
        dataset.addValue(300, "北京", "葡萄");  
        dataset.addValue(300, "上海", "葡萄");  
        dataset.addValue(300, "广州", "葡萄");  
        dataset.addValue(400, "北京", "香蕉");  
        dataset.addValue(400, "上海", "香蕉");  
        dataset.addValue(400, "广州", "香蕉");  
        dataset.addValue(500, "北京", "荔枝");  
        dataset.addValue(500, "上海", "荔枝");  
        dataset.addValue(500, "广州", "荔枝");  
        return dataset;
	}
	
	/**
	  * @Title: createDatasetDemo2
	  * @Description: 创建统计表数据集demo1
	  * @param @return    参数
	  * @return CategoryDataset    返回类型
	  * @throws
	  */
	public static CategoryDataset createDatasetDemo2(){
		dataset = new DefaultCategoryDataset();  
	    dataset.addValue(100, "苹果", "苹果");  
	    dataset.addValue(200, "梨子", "梨子");  
	    dataset.addValue(300, "葡萄", "葡萄");  
	    dataset.addValue(400, "香蕉", "香蕉");  
	    dataset.addValue(500, "荔枝", "荔枝");  
	    return dataset;  
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame("Java数据统计图之柱状图");  
//	    ChartPanel chartPanel = new ChartPanel(
//	    		createChart("水果", "水果种类", "水果数量", createDatasetDemo1()));
//	    frame.add(chartPanel);
//	    frame.setBounds(20, 20, 800, 500);  
//	    frame.setVisible(true); 
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}

}
