public class CalculateBMI {

    private double totalBMI; 


    public double calcBMI(double weight, double height) 
    {
        totalBMI = (weight * 703) / (height * height); 

        return totalBMI;
    }
    
}
