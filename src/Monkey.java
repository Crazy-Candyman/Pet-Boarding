public class Monkey extends RescueAnimal {

    private double tailLength;
    private double height;
    private double bodyLength;
    private String speciesType;

    public Monkey(String name, int age, String speciesType, String gender, double weight, double tailLength,
                  double bodyLength, double height, String acquisitionDate, String acquisitionCountry,
                  boolean reserved, String inServiceCountry, String trainingStatus) {
        setName(name);
        setAge(age);
        setSpeciesType(speciesType);
        setGender(gender);
        setWeight(weight);
        setTailLength(tailLength);
        setBodyLength(bodyLength);
        setHeight(height);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    public double getBodyLength() {
        return bodyLength;
    }

    public void setSpeciesType(String speciesType) {
        this.speciesType = speciesType;
    }

    public String getSpeciesType() {
        return speciesType;
    }
}
