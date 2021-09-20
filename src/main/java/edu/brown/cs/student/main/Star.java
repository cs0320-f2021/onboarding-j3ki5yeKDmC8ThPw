package edu.brown.cs.student.main;

import javax.servlet.ServletOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Star {

    // array lists hold each column of the csv separately
    ArrayList<String> _starID;
    ArrayList<String> _properName;
    ArrayList<Double> _xList;
    ArrayList<Double> _yList;
    ArrayList<Double> _zList;

    /**
     * Method is responsible for instantiating all of the array lists and
     * passing the file path to the load data method
     * @param file
     */
    public Star(String file) {
        _starID = new ArrayList<>();
        _properName = new ArrayList<>();
        _xList = new ArrayList<>();
        _yList  = new ArrayList<>();
        _zList = new ArrayList<>();
        this.loadData(file);
    }

    /**
     * Method responsible for adding each entry of the csv file to the appropriate
     * array list. All of the star IDs, proper names, x coordinates, y coordinates,
     * and z coordinates will be separated and added to their respective array lists.
     * @param file
     */
    public void loadData(String file) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                _starID.add(values[0]);
                _properName.add(values[1]);
                _xList.add(Double.parseDouble(values[2]));
                _yList.add(Double.parseDouble(values[3]));
                _zList.add(Double.parseDouble(values[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method handles the case when the star coordinates are given
     * and not the star name.
     * @param k
     * @param x
     * @param y
     * @param z
     */
    public void positionFinder(int k, double x, double y, double z) {
        this.findDistances(k,x,y,z);
    }

    /**
     * This method handles the case when the star name is given but not the
     * star coordinates.
     * @param k
     * @param starName
     */
    public void nameFinder(int k, String starName) {
        int i = _properName.indexOf(starName);
        double x = _xList.get(i);
        double y = _yList.get(i);
        double z = _zList.get(i);
        this.findDistances(k,x,y,z);

    }

    /**
     * This method is responsible for finding the distances between the star given
     * and each of the stars in the csv. Once those distances are found, they're added
     * to a separate 2D array of distances and corresponding index values. This is done
     * so that when the 2D array is sorted, the index of the star is attached to it
     * and can be easily accessed to find the names of the top 'k' number of closest stars
     * @param k
     * @param x
     * @param y
     * @param z
     */
    public void findDistances(int k, double x, double y, double z) {
        double[][] distanceArray = new double[_xList.size()][2];
        double distance;
        String[] starList = new String[k];
        for(int i=0; i<_xList.size(); i++) {
            distance = Math.sqrt(Math.pow(_xList.get(i)-x,2) + Math.pow(_yList.get(i)-y,2) + Math.pow(_zList.get(i)-z,2));
            distanceArray[i][0] = distance;     // 1st column is the distance
            distanceArray[i][1] = i;        // 2nd column is the index
        }
        Arrays.sort(distanceArray, Comparator.comparingDouble(a -> a[0])); //(a,b) -> Double.compare(a[0],b[0])
        for(int i=0; i<k; i++) {
            starList[i] = _properName.get((int)distanceArray[i][1]);
        }
        System.out.println(_properName);
    }
}

// https://stackoverflow.com/questions/15452429/java-arrays-sort-2d-array