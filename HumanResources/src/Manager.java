public class Manager extends Staff implements ICalculator {
    private String chucDanh;
    static int countMa = 0;

    // constructor
    public Manager(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoLuong, String ngayVaoLam,
                   Department boPhanLamViec, int soNgayPhep, String chucDanh) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayPhep);
        this.chucDanh = chucDanh;

        countMa++;
    }

    // đếm số lượng Quản lý mỗi lần khởi tạo
    public static int getCountMa() {
        return countMa;
    }

    @Override
    public void displayInformation() {
        System.out.printf("%-10s%-20s%-10d%-15.1f%-15s%-10s%-10d%-22s",getMaNhanVien(), getTenNhanVien(), getTuoiNhanVien(),
                getHeSoLuong(), getNgayVaoLam(), getBoPhanLamViec().getMaBoPhan(), getSoNgayPhep(), chucDanh);
    }

    @Override
    public double calculateSalary() {
        double luongQuanLy;
        if (chucDanh.equals("Business Leader")) {
            luongQuanLy = getHeSoLuong() * 5000000 + 8000000;
        } else if (chucDanh.equals("Project Leader")) {
            luongQuanLy = getHeSoLuong() * 5000000 + 5000000;
        } else {
            luongQuanLy = getHeSoLuong() * 5000000 + 6000000;
        }

        return luongQuanLy;
    }
}
