import java.util.ArrayList;

public class Department {
    private String maBoPhan;
    private String tenBoPhan;
    private int soluongNV;
    private ArrayList<Staff> listStaff;

    // constructor
    public Department(String maBoPhan, String tenBoPhan) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
    }
    public Department(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }


    // getter, setter
    public String getMaBoPhan() {
        return maBoPhan;
    }
//    public void setMaBoPhan(String maBoPhan) {
//        this.maBoPhan = maBoPhan;
//    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }
//    public void setTenBoPhan(String tenBoPhan) {
//        this.tenBoPhan = tenBoPhan;
//    }

//    public int getSoluongNV() {
//        return soluongNV;
//    }
    public void setSoluongNV(int soluongNV) {
        this.soluongNV = soluongNV;
    }

    // method
    public String toString() {
        String s = String.format("%-10s%-15s%-5d\n", maBoPhan, tenBoPhan, soluongNV);
        return s;
    }
}
