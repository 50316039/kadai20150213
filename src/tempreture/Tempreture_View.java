package tempreture;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Tempreture_View extends Frame implements ActionListener,WindowListener{
	
	public Tempreture_View(){
		addWindowListener(this);
		setTitle("Tempreture");
		
		int year,month;
		double tempreture;
		ResultSet rs;
		MySQL3 mysql3 = new MySQL3();
		rs = mysql3.selectAll();
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		try {
			while(rs.next()){
				year = rs.getInt("year");
				month = rs.getInt("month");
				tempreture= rs.getDouble("tempreture");
				setLayout(new FlowLayout(FlowLayout.CENTER));
				add(new Label("["+year+"年  "+month+"月　　　"+tempreture+"℃ ]"));
				
				if(year==2013){
					data.addValue(tempreture,"気温 2013年",month+"月");
				}else if(year==2014){
					data.addValue(tempreture,"気温 2014年",month+"月");
				}
			}	
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
		JFreeChart chart = 
			ChartFactory.createLineChart("平均気温",
                           "月",
                           "気温(℃)",
                           data,
                           PlotOrientation.VERTICAL,
                           true,
                           false,
                           false);

		ChartPanel cpanel = new ChartPanel(chart);
		add(cpanel, BorderLayout.CENTER);
	
	}
	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
