public class Employee extends Staff implements ICalculator {
    private double soGioLamThem;
    static int countEm = 0;

    // constructor
    public Employee(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoLuong, String ngayVaoLam,
                    Department boPhanLamViec, int soNgayPhep, double soGioLamThem) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayPhep);
        this.soGioLamThem = soGioLamThem;

        countEm++;
    }
    public void setDepartment(Department dep) {

    }
    // đếm số lượng Nhân viên mỗi lần khởi tạo
    public static int getCountEm() {
        return countEm;
    }

    @Override
    public void displayInformation() {
        System.out.printf("%-10s%-20s%-10d%-15.1f%-15s%-10s%-10d%-22.1f",getMaNhanVien(), getTenNhanVien(), getTuoiNhanVien(),
                getHeSoLuong(), getNgayVaoLam(), getBoPhanLamViec().getMaBoPhan(), getSoNgayPhep(), soGioLamThem);
    }

    @Override
    public double calculateSalary() {
        return getHeSoLuong() * 3000000 + soGioLamThem * 200000;
    }
}
