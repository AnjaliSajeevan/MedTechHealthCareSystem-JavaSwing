/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Driver;

import java.util.ArrayList;

/**
 *
 * @author sayu
 */
public class DriverDirectory {
    private ArrayList<Driver> driverlist;
    
    public DriverDirectory(){
    driverlist=new ArrayList<Driver>();
    
    }

    public ArrayList<Driver> getDriverlist() {
        return driverlist;
    }

    public void setDriverlist(ArrayList<Driver> driverlist) {
        this.driverlist = driverlist;
    }
    public Driver addDriver(Driver d)
    {
        driverlist.add(d);
        return d;
    }
    public void deleteDriver(Driver d)
    {
        driverlist.remove(d);
    }
    public void updateDriver(Driver d)
    {
        for(Driver dr:driverlist)
        {
        if(dr.getId()== d.getId())
            dr=d;
        }
    }
}
