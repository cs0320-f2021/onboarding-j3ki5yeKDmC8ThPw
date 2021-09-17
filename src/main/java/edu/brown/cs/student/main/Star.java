package edu.brown.cs.student.main;

import javax.servlet.ServletOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Star {

    ArrayList<String> _starID;
    ArrayList<String> _properName;
    ArrayList<Double> _xList;
    ArrayList<Double> _yList;
    ArrayList<Double> _zList;

    public Star(String file) {
        _starID = new ArrayList<>();
        _properName = new ArrayList<>();
        _xList = new ArrayList<>();
        _yList  = new ArrayList<>();
        _zList = new ArrayList<>();
        this.loadData(file);
    }

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

    public void positionFinder(int k) {

    }

    public void nameFinder(int k) {

    }

}
