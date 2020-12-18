public class Drug {

    private String drugName;
    private int drugDoses;
    private boolean isOnFullStomach;
    private String startingDate;
    private String finalDate;

    public Drug( String drugName , int drugDoses , boolean isOnFullStomach , String startingDate , String finalDate ){

        this.drugName = drugName;
        this.drugDoses = drugDoses;
        this.isOnFullStomach = isOnFullStomach;
        this.startingDate = startingDate;
        this.finalDate = finalDate;
    }

    public boolean isExpired(){

        //ToDO
        return false;
    }

    public String getDrugName(){ return drugName; }

    public boolean getIsONFullStomach(){ return isOnFullStomach; }

    public int getDrugDoses(){ return drugDoses; }

    public String getStartingDate(){ return startingDate; }

    public String getFinalDate(){ return finalDate; }

}
