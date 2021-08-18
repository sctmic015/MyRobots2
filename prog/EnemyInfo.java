package prog;

public class EnemyInfo {
    public String name;
    public double distance;
    public double bearing;

    public EnemyInfo(String name, double distance, double bearing){
        this.name = name;
        this.distance = distance;
        this.bearing = bearing;
    }

    public String getName(){
        return name;
    }

    public double getDistance(){
        return distance;
    }

    public double getBearing(){
        return bearing;
    }
}
