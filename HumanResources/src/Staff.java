public abstract class Staff {
    private String maNhanVien;
    private String tenNhanVien;
    private int tuoiNhanVien;
    private double heSoLuong;
    private String ngayVaoLam;
    private Department boPhanLamViec;
    private int soNgayPhep;

    static int countStaff = 0;

    // constructor
    public Staff(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoLuong, String ngayVaoLam,
                 Department boPhanLamViec, int soNgayPhep) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tuoiNhanVien = tuoiNhanVien;
        this.heSoLuong = heSoLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhanLamViec = boPhanLamViec;
        this.soNgayPhep = soNgayPhep;

        countStaff++;
    }

    //
    public static int getCountStaff() {
        return countStaff;
    }


    // getter and setter
    public String getMaNhanVien() {
        return maNhanVien;
    }
//    public void setMaNhanVien(String maNhanVien) {
//        this.maNhanVien = maNhanVien;
//    }
    //
    public String getTenNhanVien() {
        return tenNhanVien;
    }
//    public void setTenNhanVien(String tenNhanVien) {
//        this.tenNhanVien = tenNhanVien;
//    }
    //
    public int getTuoiNhanVien() {
        return tuoiNhanVien;
    }
//    public void setTuoiNhanVien(int tuoiNhanVien) {
//        this.tuoiNhanVien = tuoiNhanVien;
//    }
    //
    public double getHeSoLuong() {
        return heSoLuong;
    }
//    public void setHeSoLuong(double heSoLuong) {
//        this.heSoLuong = heSoLuong;
//    }
    //
    public String getNgayVaoLam() {
        return ngayVaoLam;
    }
//    public void setNgayVaoLam(String ngayVaoLam) {
//        this.ngayVaoLam = ngayVaoLam;
//    }
    //
    public Department getBoPhanLamViec() {
        return boPhanLamViec;
    }
//    public void setBoPhanLamViec(Department boPhanLamViec) {
//        this.boPhanLamViec = boPhanLamViec;
//    }
    //
    public int getSoNgayPhep() {
        return soNgayPhep;
    }
//    public void setSoNgayPhep(int soNgayPhep) {
//        this.soNgayPhep = soNgayPhep;
//    }

    // abstract method
    public abstract void displayInformation();
}
