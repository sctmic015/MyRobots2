package prog;

import robocode.*;
import robocode.Robot;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * MyFirstRobot - a robot by (your name here)
 */
public class MyFirstRobot extends Robot
{
    /**
     * run: MyFirstRobot's default behavior
     */
    boolean firstScan = true;
    ArrayList<EnemyInfo> enemyInfos = new ArrayList<EnemyInfo>();
    EnemyInfo closestRobot;
    public void run() {
        // Initialization of the robot should be put here

        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:

        // setColors(Color.red,Color.blue,Color.green); // body,gun,radar

        // Robot main loop
        while(true) {
            // Replace the next 4 lines with any behavior you would like
            //turnRadarRight(360);
            turnGunRight(360);
            ahead(100);
            back(100);
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Add Scanned Robots into arrayList
        String enemyName = e.getName();
        double distance = e.getDistance();
        double bearing = e.getBearing();


        boolean isRobotInList = false;
        for (int i = 0; i < enemyInfos.size(); i ++){
            if (enemyName == enemyInfos.get(i).getName()){
                isRobotInList = true;
            }
        }
        if (isRobotInList == false) {
            enemyInfos.add(new EnemyInfo(enemyName, distance, bearing));
            System.out.println(enemyName);
        }

        // Find the closest robot
        double closestDistance = enemyInfos.get(0).getDistance();
        closestRobot = enemyInfos.get(0);
        for (int i = 0; i < enemyInfos.size(); i ++){
            if (enemyInfos.get(i).getDistance() < closestDistance){
                closestDistance = enemyInfos.get(i).getDistance();
                closestRobot = enemyInfos.get(i);
            }
        }

        if (enemyName == closestRobot.getName()){
            fire(3);
        }
        // Move gun to bearing of closest robot


    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        back(10);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        back(20);
    }
}
