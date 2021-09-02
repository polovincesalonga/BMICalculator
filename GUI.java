import java.awt.Color;
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout; 
import java.awt.Insets; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;  
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JSlider; 
import javax.swing.JTextField; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener;
import javax.swing.JTextArea; 
import javax.swing.JLabel; 
import javax.swing.JFormattedTextField;
import java.text.NumberFormat;
import java.text.DecimalFormat;





public class GUI extends JFrame implements ChangeListener, ActionListener{

    private JLabel weightLabel; 
    private JLabel HeightInLabel; 
    private JLabel HeightFtLabel;




    private JTextField weightField;
    private JTextField HeightInField; 
    private JTextField HeightFtField;

    private JSlider HeightFtSlider;
    private JSlider HeightInSlider;


    private JButton calculate;

    private JTextArea outputArea;




    GUI() 
    {


        int feetMin = 0; 
        int feetMax = 6; 
        int feetInit = 5; 
        int inchesMin = 0; 
        int inchesMax = 9; 
        int inchesInit = 4;


        GridBagConstraints layout = null;

        setTitle("BMI Calculator"); 


        //labels 
        weightLabel = new JLabel("Weight"); 
        HeightFtLabel = new JLabel("Feet"); 
        HeightInLabel = new JLabel("Inches");


        //text fields 
        weightField = new JTextField(15); 
        weightField.setEditable(true);
        weightField.setText("00.0");
        

        HeightFtField = new JTextField(15); 
        HeightFtField.setEditable(false);
        HeightFtField.setText("5");

        HeightInField = new JTextField(15); 
        HeightInField.setEditable(false);
        HeightInField.setText("4");


       



        //height feet slider 
        HeightFtSlider = new JSlider(feetMin,feetMax,feetInit); 
        HeightFtSlider.addChangeListener(this); 
        HeightFtSlider.setMajorTickSpacing(10); 
        HeightFtSlider.setMinorTickSpacing(1); 
        HeightFtSlider.setPaintTicks(true); 
        HeightFtSlider.setPaintLabels(true);


        //height inches slider 
        HeightInSlider = new JSlider(inchesMin,inchesMax,inchesInit); 
        HeightInSlider.addChangeListener(this); 
        HeightInSlider.setMajorTickSpacing(10); 
        HeightInSlider.setMinorTickSpacing(1); 
        HeightInSlider.setPaintTicks(true); 
        HeightInSlider.setPaintLabels(true);


        //calculate button
        calculate = new JButton("Calculate"); 
        calculate.addActionListener(this); 
        calculate.setBackground(Color.GREEN);
        calculate.setOpaque(true); 


        //output area 
        outputArea = new JTextArea(10,30); 
        outputArea.setEditable(false); 
    


        //layout 
        setLayout(new GridBagLayout());
        
        //weight label
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.anchor = GridBagConstraints.LINE_START;
        layout.gridx = 0; 
        layout.gridy = 0; 
        add(weightLabel, layout); 

        //weight text field
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10);
        layout.anchor = GridBagConstraints.LINE_START;
        layout.gridx = 1; 
        layout.gridy = 0; 
        add(weightField,layout);


        //height feet label; 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10);
        layout.anchor = GridBagConstraints.LINE_START;
        layout.gridx = 0; 
        layout.gridy = 1; 
        add(HeightFtLabel,layout);

        //height feet field 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10);
        layout.anchor = GridBagConstraints.LINE_START; 
        layout.gridx = 1; 
        layout.gridy = 1; 
        add(HeightFtField,layout); 

        //HeightFt slider positioning 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.fill = GridBagConstraints.HORIZONTAL; 
        layout.gridx = 0; 
        layout.gridy = 2;
        layout.gridwidth = 2; 
        add(HeightFtSlider,layout);


        //height inches label 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.anchor = GridBagConstraints.LINE_START;
        layout.gridx = 0; 
        layout.gridy = 4; 
        add(HeightInLabel,layout); 

        //height inches field 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10);
        layout.anchor = GridBagConstraints.LINE_START; 
        layout.gridx = 1; 
        layout.gridy = 4; 
        add(HeightInField,layout); 

        //height inches slider 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.fill = GridBagConstraints.HORIZONTAL; 
        layout.gridx = 0; 
        layout.gridy = 5; 
        layout.gridwidth = 2; 
        add(HeightInSlider,layout);


        //position the button 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.anchor = GridBagConstraints.LINE_START; 
        layout.gridx = 0; 
        layout.gridy = 6; 
        add(calculate,layout); 


        //position the output area 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.fill = GridBagConstraints.HORIZONTAL; 
        layout.gridx = 0; 
        layout.gridy = 7; 
        add(outputArea,layout);



    }

    @Override 
    public void stateChanged(ChangeEvent event) 
    {
        int sliderValue; 
        String strSliderValue; 


        JSlider getSource = (JSlider) event.getSource();  

        if(getSource == HeightFtSlider) 
        {
            sliderValue = HeightFtSlider.getValue(); 
            strSliderValue = Integer.toString(sliderValue);
            HeightFtField.setText(strSliderValue);
        }

        else if(getSource == HeightInSlider) 
        {
            sliderValue = HeightInSlider.getValue(); 
            strSliderValue = Integer.toString(sliderValue); 
            HeightInField.setText(strSliderValue);
        }
    }

    @Override 
    public void actionPerformed(ActionEvent event) 
    {
        int feet; 
        int inch; 
        int height;
        String weight; 
        double weightVal; 
        double totalBMI;
        String result;

        CalculateBMI calc = new CalculateBMI();
        DecimalFormat df = new DecimalFormat("##.0");


        feet = HeightFtSlider.getValue(); 
        inch = HeightInSlider.getValue(); 
        height = (feet * 12)  + inch;
        weight = weightField.getText();
        weightVal = Double.parseDouble(weight);


        totalBMI = calc.calcBMI(weightVal,height); 
        
        


        outputArea.setText("BMI Result");


        if(totalBMI < 18.5) 
        {
            result = "Underweight";
        } 


        else if (totalBMI > 18.5 && totalBMI < 25) 
        {
            result = "Optimal";
        }

        else     
        {
            result = "Overweight";
        }

        outputArea.append("\nWeight: " + weight + "\nHeight in Feet: " + feet + 
        "\nHeight in Inches: " + inch + "\nTotal BMI: " + df.format(totalBMI) + 
        "\nResult: " + result);


    }


    
}
