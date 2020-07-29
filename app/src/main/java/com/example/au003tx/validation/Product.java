package com.example.au003tx.validation;

public class Product {

    private String machinetype, make, model, year_of_install, maxkv, ma, walldistance_A, walldistance_B, walldistance_C, walldistance_D, wallmaterial, wallthickness_A,  wallthickness_B,  wallthickness_C,  wallthickness_D;

    public Product(String machinetype,String make,String model,String year_of_install,String maxkv,String ma,String walldistance_A,String walldistance_B,String walldistance_C,String walldistance_D,String wallmaterial,String wallthickness_A,String wallthickness_B,String wallthickness_C,String wallthickness_D)
    {
        this.machinetype = machinetype;
        this.make = make;
        this.model = model;
        this.year_of_install = year_of_install;
        this.maxkv = maxkv;
        this.ma = ma;
        this.walldistance_A = walldistance_A;
        this.walldistance_B = walldistance_B;
        this.walldistance_C = walldistance_C;
        this.walldistance_D = walldistance_D;
        this.wallmaterial = wallmaterial;
        this.wallthickness_A = wallthickness_A;
        this.wallthickness_B = wallthickness_B;
        this.wallthickness_C = wallthickness_C;
        this.wallthickness_D = wallthickness_D;


    }

    public String getMachinetype(){return machinetype;}
    public String getmake(){return make;}
    public String getmodel(){return model;}
    public String getYear_of_install(){return year_of_install;}
    public String getmaxkv(){return maxkv;}
    public String getma(){return ma;}
    public String getWalldistance_A(){return walldistance_A;}
    public String getWalldistance_B(){return walldistance_B;}
    public String getWalldistance_C(){return walldistance_C;}
    public String getWalldistance_D(){return walldistance_D;}
    public String getWallmaterial(){return wallmaterial;}
    public String getWallthickness_A(){return wallthickness_A;}
    public String getWallthickness_B(){return wallthickness_B;}
    public String getWallthickness_C(){return wallthickness_C;}
    public String getWallthickness_D(){return wallthickness_D;}
}
