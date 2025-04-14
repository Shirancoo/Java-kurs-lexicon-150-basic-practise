package org.example;

public class Car implements Rentable {
    private String märke;
    private String modell;
    private int prisPerDag;
    private boolean ärInne;
    private CarType carType;

    public Car(String märke, String modell, int prisPerDag, boolean ärInne, CarType carType) {
        this.märke = märke;
        this.modell = modell;
        this.prisPerDag = prisPerDag;
        this.ärInne = ärInne;
        this.carType = carType;
    }

    public String getMärke() {
        return märke;
    }

    public void setMärke(String märke) {
        this.märke = märke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getPrisPerDag() {
        return prisPerDag;
    }

    public void setPrisPerDag(int prisPerDag) {
        this.prisPerDag = prisPerDag;
    }

    public boolean isÄrInne() {
        return ärInne;
    }

    public void setÄrInne(boolean ärInne) {
        this.ärInne = ärInne;
    }


    @Override
    public void rent() {

        if (ärInne) {
            ärInne = false;
        } else {
            System.out.println("Bilen är redan uthyrd.");
        }
    }

    @Override
    public void returnCar() {
        if (!ärInne) {
            ärInne = true;
            System.out.println("Bilen har återlämnats och är nu tillgänglig.");
        } else {
            System.out.println("Bilen är redan tillgänglig.");
        }

    }

    public String getSummary() {
        return "Märke: " + märke +
                " | Modell: " + modell +
                " | PrisPerDag: " + prisPerDag + "Kr" +
                " | CarType: " + carType;
    }
}

