package top.macchiato.demo;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


/**
  * @ClassName: PieChart
  * @Description: 创建饼状图表并设定数据集
  * @author 满城烟雨 wenjie.leung@hotmail.com
  * @date 2016年3月20日
  *
  */
public class PieChart {
	private static JFreeChart pieChart = null;
	private static DefaultPieDataset dataset = null;
	
	/**
	  * @Title: createPieChart3D
	  * @Description:	创建饼状图
	  * @param @param chartTitle	饼状图标题
	  * @param @param dataset		饼状图数据集
	  * @param @return    参数
	  * @return JFreeChart    返回类型
	  * @throws
	  * 设置字体是为了解决中文乱码问题
	  */
	public static JFreeChart createPieChart3D(
			String chartTitle, PieDataset dataset) {
		pieChart = ChartFactory.createPieChart3D(
				chartTitle, dataset, true, true, false);
		//获取图表区域对象
		PiePlot3D piePlot = (PiePlot3D) pieChart.getPlot();
		//设置图片中显示百分比:自定义方式，{0} 表示选项，{1} 表示数值， {2} 表示所占比例 ,小数点后两位
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
	            "{0}={1}({2})", NumberFormat.getNumberInstance(),
	            new DecimalFormat("0.00%")));
		//没有数据的时候显示的内容  
        piePlot.setNoDataMessage("无数据显示");  
        piePlot.setCircular(false);  
        piePlot.setLabelGap(0.02D);  
        
        piePlot.setIgnoreNullValues(true);	//设置不显示空值  
        piePlot.setIgnoreZeroValues(true);	//设置不显示负值  
        pieChart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
        piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));
        pieChart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
		return pieChart;
	}
	
	/**
	  * @Title: createDatasetDemo
	  * @Description: 创建饼状图数据集Demo
	  * @param @return    参数
	  * @return DefaultPieDataset    返回类型
	  * @throws
	  */
	public static DefaultPieDataset createDatasetDemo() {  
        dataset = new DefaultPieDataset();  
        dataset.setValue("苹果",100);  
        dataset.setValue("梨子",200);  
        dataset.setValue("葡萄",300); 
        dataset.setValue("香蕉",400);  
        dataset.setValue("荔枝",500);  
        return dataset;  
	}  
//	public static void main(String[] args) {
//		JFrame frame = new JFrame("Java数据统计图之柱状图");  
//	    ChartPanel chartPanel = new ChartPanel(
//	    		createPieChart3D("水果产量", createDatasetDemo()));
//	    frame.add(chartPanel);
//	    frame.setBounds(20, 20, 800, 500);  
//	    frame.setVisible(true); 
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}

}
