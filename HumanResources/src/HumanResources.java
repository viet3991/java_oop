/*
 * HumanResources: Quản lý nhân viên trong công ty: hiển thị thông tin nhân viên, tìm kiếm nhân viên,
 *                 hiển thị bản lương, thêm nhân viên, hiển thị thông tin các bộ phận
 * author: vietpqFX11399
 * version: 1.5
 * since: 12/29/2021
 */

import java.util.ArrayList;
import java.util.Scanner;

public class HumanResources {
    public static void main(String[] args) {
        // khai báo danh sách nhân viên
        ArrayList<Staff> listStaff = new ArrayList<>();

        // khai báo danh sách bộ phận
        ArrayList<Department> listDep = new ArrayList<>();

        // tạo danh sách các Bộ phận
        listDep.add(new Department("BU", "Kinh Doanh"));
        listDep.add(new Department("PR", "Dự Án"));
        listDep.add(new Department("TE", "Kỹ Thuật"));

        // tạo các instance của Department dùng cho việc tạo danh sách nhân viên
        Department BU = new Department("BU");
        Department PR = new Department("PR");
        Department TE = new Department("TE");

        // tạo danh sách nhân viên (Nhân viên): 5BU, 2PR, 2TE
        listStaff.add(new Employee("E11", "Nguyễn Văn A", 23, 1.5,
                "15/02/2019", TE, 8, 7.5));
        listStaff.add(new Employee("E15", "Trần Thị C", 27, 1.5,
                "19/04/2015", BU, 3, 1.5));
        listStaff.add(new Employee("E12", "Phan Văn B", 29, 1.5,
                "10/12/2015", TE, 10, 4.5));
        listStaff.add(new Employee("E09", "Lê Văn L", 30, 1.5,
                "01/02/2014", BU, 10, 12.5));
        listStaff.add(new Employee("E19", "Trần Trung Q", 28, 1.5,
                "25/10/2017", PR, 8, 9.5));
        listStaff.add(new Employee("E27", "Hứa Thị T", 24, 1.5,
                "21/11/2018", BU, 12, 15.5));
        listStaff.add(new Employee("E20", "Nguyễn Văn D", 20, 1.5,
                "01/09/2019", PR, 3, 5.5));
        listStaff.add(new Employee("E13", "Võ Thị Mai", 28, 1.5,
                "01/02/2016", BU, 9, 10));
        listStaff.add(new Employee("E10", "Trần Cẩm D", 32, 1.5,
                "15/07/2014", BU, 5, 7));

        // tạo danh sách nhân viên (Quản lý): 2BU, 1PR, 1TE
        listStaff.add(new Manager("M05", "Lê Quốc T", 35, 2.5,
                "12/10/2012", TE, 9, "Technical Leader"));
        listStaff.add(new Manager("M06", "Nguyễn Thi H", 31, 2.5,
                "10/01/2013",PR, 5, "Project Leader"));
        listStaff.add(new Manager("M07", "Phan Quoc D", 30, 2.5,
                "09/04/2014", BU, 8, "Business Leader"));
        listStaff.add(new Manager("M08", "Nguyễn Thị T", 35, 2.5,
                "12/09/2012", BU, 4, "Business Leader"));


        /* -------------------------------------------------------------------------------------------- */

        // giới thiệu chương trình
        gioiThieu();

        // biến chọn chức năng
        int menu;
        // tạo vòng lặp làm việc cho đến khi kết thúc (người dùng chọn 0)
        do {
            // gọi phương thức chọn chức năng
            menu = chonChucNang();
            // giá trị trả về sẽ gọi đến chức năng nhất định
            switch (menu) {
                case 1 -> hienthiDanhSachNV(listStaff);
                case 2 -> hienthiBoPhanCongTy(listStaff, listDep);
                case 3 -> hienthiNVTheoBoPhan(listStaff, listDep);
                case 4 -> themNV(listStaff);
                case 5 -> timkiemNV(listStaff);
                case 6 -> hienthiBangLuongNV(listStaff);
                case 7 -> hienthiBangLuongNVTangDan(listStaff);
                case 8 -> hienthiBangLuongNVGiamDan(listStaff);

//                default:
//                    throw new IllegalStateException("Unexpected value: " + menu);
            }
        // nếu chọn 0 sẽ kết thúc chương trình
        } while (menu != 0);

        // gọi phuong thức thông báo kết thúc phiên làm việc
        ketThuc();

    }

    // giới thiệu các chức năng để chọn
    public static void gioiThieu() {
        System.out.println("==========================================================");
        System.out.println("===================== HUMAN RESOURCES ====================");
        System.out.println("==========================================================");
        System.out.println("MENU -----------------------------------------------------");
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
        System.out.println("2. Hiển thị các bộ phận trong công ty");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
        System.out.println("4. Thêm nhân viên mới vào công ty: bao gồm 2 loại");
        System.out.println("   - Thêm nhân viên thông thường ");
        System.out.println("   - Thêm nhân viên là cấp quản lý (có thêm chức vụ)");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
        System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
        System.out.println("0. Thoát khỏi phiên làm việc.");
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }

    // chọn chức năng
    public static int chonChucNang() {
        Scanner sc = new Scanner(System.in);
        // biến chọn chức năng làm việc
        int menu;
        do {
            System.out.print("Chọn chức năng (0 - 8):   ");
            // kiểm tra giá trị nhập vào có phải số nguyên hay ko?
            while (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập lại !!! ---> Không phải số nguyên !!!");
                System.out.print("Chọn chức năng (0 - 8):   ");
                sc.nextLine();
            }
            menu = sc.nextInt();

            if (menu != 0 && menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5 && menu != 6 && menu != 7
                    && menu != 8) {
                System.out.println("Vui lòng nhập lại !!! ---> Chỉ chấp nhận số từ 0 - 8 !!!");
            }
            // nếu biến chọn nằm ngoài con số từ 0 đến 8, phải chọn lại
        } while(menu != 0 && menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5 && menu != 6 && menu != 7
                && menu != 8);

        return menu;
    }

    // kết thúc chương trình
    public static void ketThuc() {
        System.out.println("==========================================================");
        System.out.println("====================== SEE YOU LATER =====================");
        System.out.println("==========================================================");
    }

    // hiển thị danh sách toàn bộ nhân viên
    public static void hienthiDanhSachNV(ArrayList<Staff> listStaff) {
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Danh sách nhân viên -----------------------------------");
        System.out.println();
        System.out.printf("%-10s%-20s%-10s%-15s%-15s%-10s%-10s%-22s\n","MaNV", "TenNV", "Tuoi", "HesoLuong", "NgayVaoLam",
                "BoPhan", "NgayPhep", "GioTangCa/ChucDanh");

        // duyệt qua danh sách nhân viên
        for (Staff staff : listStaff) {
            // in ra thông tin từng nhân viên
            staff.displayInformation();
            System.out.println();
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    // hiển thị danh sách các bộ phận trong công ty
    public static void hienthiBoPhanCongTy(ArrayList<Staff> listStaff, ArrayList<Department> listDep) {
        System.out.println("----------------------------------------------------------");
        System.out.println("2. Các bộ phận -------------------------------------------");
        System.out.println();

        // hiển thị số lượng Nhân viên và Quản lý
        System.out.println("Tổng số nhân viên: " + Staff.getCountStaff() + "     Quản lý: " + Manager.getCountMa() +
                "     Nhân viên: " + Employee.getCountEm());
        System.out.println();
        System.out.printf("%-10s%-15s%-5s\n", "MaBoPhan", "TenBoPhan", "SoLuongNV");

        // duyệt qua danh sách bộ phận để lấy mã bộ phận
        for (Department department : listDep) {
            // biến đếm số lượng nhân viên mỗi bộ phận
            int count = 0;
            // duyệt qua danh sách nhân viên để điếm số lượng nhân viên tương ứng mỗi bộ phận
            for (Staff staff : listStaff) {
                if (staff.getBoPhanLamViec().getMaBoPhan().equals(department.getMaBoPhan())) {
                    count++;
                }
            }
            // cập nhật số lượng nhân viên vào thuộc tính "soLuongNV" của mỗi phần tử trong danh sách bộ phận
            department.setSoluongNV(count);
            System.out.print(department);
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    // hiển thị danh sách nhân viên theo từng bộ phận
    public static void hienthiNVTheoBoPhan(ArrayList<Staff> listStaff, ArrayList<Department> listDep) {
        System.out.println("----------------------------------------------------------");
        System.out.println("3. Danh sách nhân viên theo bộ phận ----------------------");
        System.out.println();
        System.out.printf("%-10s%-20s%-10s%-15s%-15s%-10s%-10s%-22s\n","MaNV", "TenNV", "Tuoi", "HesoLuong", "NgayVaoLam",
                "BoPhan", "NgayPhep", "GioTangCa/ChucDanh");

        // duyệt qua danh sách bộ phận để lấy mã bộ phận
        for (Department department : listDep) {
            System.out.println();
            System.out.println("Bộ phận " + department.getTenBoPhan() + ": ");
            // duyệt qua danh sách nhân viên và so sánh với mã bộ phận
            for (Staff staff : listStaff) {
                // kiểm tra từ khóa tìm kiếm với tên nhân viên hoặc mã nhân viên
                if (department.getMaBoPhan().equals(staff.getBoPhanLamViec().getMaBoPhan())) {
                    staff.displayInformation();
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    // thêm nhân viên hoặc quản lý
    public static void themNV(ArrayList<Staff> listStaff) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------------------------------");
        System.out.println("4. Thêm nhân viên ----------------------------------------");
        System.out.println("   - Chọn 1 để thêm Nhân viên ----------------------------");
        System.out.println("   - Chọn 2 để thêm Quản lý ------------------------------");

        // lựa chọn thêm nhân viên hay quản lý, chỉ cho phép nhập 1 hoặc 2
        int choose;
        do {
            System.out.print("Chọn chức năng (1 hoặc 2):   ");
            // kiểm tra giá trị nhập vào có phải số nguyên hay ko?
            while (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập lại !!! ---> Không phải số nguyên !!!");
                System.out.print("Chọn chức năng (1 hoặc 2):   ");
                sc.nextLine();
            }
            choose = sc.nextInt();
            if (choose != 1 && choose != 2) {
                System.out.println("Vui lòng nhập lại !!! ---> Chỉ chấp nhận 1 hoặc 2!!!");
            }
        } while(choose != 1 && choose != 2);

        // nhập thông tin Nhân viên từ người dùng, thêm Nhân viên vào danh sách nhân viên
        if (choose == 1) {
            System.out.println("----------------------------------------------------------");
            System.out.print("Thêm bao nhiêu nhân viên:                 ");
            int count = sc.nextInt();
            for (int i = 0; i < count; i++) {
                System.out.println("----------------------------------------");
                sc.nextLine();
                System.out.print("Mã Nhân viên (E99,...):                 ");
                String id = sc.nextLine().toUpperCase();
                System.out.print("Tên Nhân viên:                          ");
                String name = sc.nextLine();
                System.out.print("Tuổi Nhân viên:                         ");
                int age = sc.nextInt();
                System.out.print("Hệ số lương:                            ");
                double coeff = sc.nextDouble();
                System.out.print("Ngày vào làm (DD/MM/YYYY):              ");
                String dateStart = sc.next();
                // gọi phương thức để chọn bộ phận làm việc cho nhân viên
                Department nameDep = chonBoPhan(sc);
                //
                System.out.print("Số ngày phép:                           ");
                int dayOff = sc.nextInt();
                System.out.print("Số giờ làm thêm:                        ");
                double OT = sc.nextDouble();
                // thêm 1 nhân viên danh sách nhân viên
                listStaff.add(new Employee(id, name, age, coeff, dateStart, nameDep, dayOff, OT));
            }
        // nhập thông tin Quản lý từ người dùng, thêm Quản lý vào danh sách nhân viên
        } else {
            System.out.println("----------------------------------------------------------");
            System.out.print("Thêm bao nhiêu quản lý:                 ");
            int count = sc.nextInt();
            for (int i = 0; i < count; i++) {
                System.out.println("----------------------------------------");
                sc.nextLine();
                System.out.print("Mã Quản lý (M98,...):                   ");
                String id = sc.nextLine().toUpperCase();
                System.out.print("Tên Quản lý:                            ");
                String name = sc.nextLine();
                System.out.print("Tuổi Quản lý:                           ");
                int age = sc.nextInt();
                System.out.print("Hệ số lương:                            ");
                double coeff = sc.nextDouble();
                System.out.print("Ngày vào làm (DD/MM/YYYY):              ");
                String dateStart = sc.next();
                // gọi phương thức để chọn bộ phận làm việc cho nhân viên
                Department nameDep = chonBoPhan(sc);
                //
                System.out.print("Số ngày phép:                           ");
                int dayOff = sc.nextInt();

                // chọn chức danh cho Quản lý, chỉ cho phép nhập 1 hoặc 2 hoặc 3
                System.out.println("Chức danh ------------              ");
                System.out.println(" 1 - Business Leader");
                System.out.println(" 2 - Project Leader");
                System.out.println(" 3 - Technical Leader");
                int chon;
                do {
                    System.out.print("Chọn chức danh:                         ");
                    chon = sc.nextInt();
                    if (chon != 1 && chon != 2 && chon != 3) {
                        System.out.println("Chỉ chọn 1 hoặc 2 hoặc 3");
                    }
                } while (chon != 1 && chon != 2 && chon != 3);

                String chucDanh;
                if (chon == 1) {
                    chucDanh = "Business Leader";
                } else if (chon == 2) {
                    chucDanh = "Project Leader";
                } else {
                    chucDanh = "Technical Leader";
                }
                //
                // thêm 1 quản lý vào danh sách nhân viên
                listStaff.add(new Manager(id, name, age, coeff, dateStart, nameDep, dayOff, chucDanh));
            }
        }

        System.out.println("----------------------------------------------------------");
    }

    // phương thức tìm kiếm nhân viên theo tên hoặc mã nhân viên
    public static void timkiemNV(ArrayList<Staff> listStaff) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------------------------------");
        System.out.println("5. Tìm kiếm nhân viên theo tên hoặc mã nhân viên ---------");
        System.out.println();
        System.out.print("Nhập tên nhân viên hoặc mã nhân viên:            ");
        String search = sc.nextLine().toLowerCase();
        boolean flag = false;
        //
        // vòng lặp để duyệt cả danh sách để kiểm tra có kết quả tìm kiếm hay không?
        for (Staff staff : listStaff) {
            // kiểm tra từ khóa tìm kiếm với tên nhân viên hoặc mã nhân viên
            // contains: tìm kiếm chuỗi trong chuỗi
            if (staff.getTenNhanVien().toLowerCase().contains(search) ||
                    staff.getMaNhanVien().toLowerCase().contains(search)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Kết quả: ");
            System.out.printf("%-10s%-20s%-10s%-15s%-15s%-10s%-10s%-22s\n","MaNV", "TenNV", "Tuoi", "HesoLuong", "NgayVaoLam",
                    "BoPhan", "NgayPhep", "GioTangCa/ChucDanh");

            // vòng lặp để duyệt cả danh sách
            for (Staff staff : listStaff) {
                // kiểm tra từ khóa tìm kiếm với tên nhân viên hoặc mã nhân viên
                if (staff.getTenNhanVien().toLowerCase().contains(search) ||
                        staff.getMaNhanVien().toLowerCase().contains(search)) {
                    staff.displayInformation();
                    System.out.println();
                }
            }
        } else {
            System.out.println("--->>> Không có kết quả tìm kiếm");
        }

        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    // hiển thị bản lương cho toàn bộ nhân viên trong công ty
    public static void hienthiBangLuongNV(ArrayList<Staff> listStaff) {
        System.out.println("----------------------------------------------------------");
        System.out.println("6. Bảng lương nhân viên ----------------------------------");
        System.out.println();
        System.out.printf("%-10s%-20s%-10s%-15s%-15s%-10s%-10s%-22s%-10s\n","MaNV", "TenNV", "Tuoi", "HesoLuong", "NgayVaoLam",
                "BoPhan", "NgayPhep", "GioTangCa/ChucDanh", "Lương");

        // duyệt qua danh sách nhân viên,
        for (Staff staff : listStaff) {
            staff.displayInformation();
            // thêm lương nhân viên ở cuối mỗi phần tử trong danh sách
            System.out.printf("%.1f", ((ICalculator) staff).calculateSalary());
            System.out.println();
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    // hiển thị bản lương cho toàn bộ nhân viên trong công ty theo thứ tự tăng dần
    public static void hienthiBangLuongNVTangDan(ArrayList<Staff> listStaff) {
        System.out.println("----------------------------------------------------------");
        System.out.println("7. Bảng lương nhân viên theo thứ tự tăng dần -------------");
        System.out.println();
        System.out.printf("%-10s%-20s%-10s%-15s%-15s%-10s%-10s%-22s%-10s\n", "MaNV", "TenNV", "Tuoi", "HesoLuong", "NgayVaoLam",
                "BoPhan", "NgayPhep", "GioTangCa/ChucDanh", "Lương");

        // tạo danh sách nhân viên bản sao
        ArrayList<Staff> listStaffClone = new ArrayList<>();
        listStaffClone = (ArrayList<Staff>)listStaff.clone();

        // duyệt qua danh sách nhân viên,
        for (int i = 0; i < listStaffClone.size(); i++) {
            for (int j = i + 1; j < listStaffClone.size(); j++) {
                //
                if (((ICalculator) listStaffClone.get(i)).calculateSalary() >= ((ICalculator) listStaffClone.get(j)).calculateSalary()) {
                    // đổi vị trí phần tử i và phần tử j
                    Staff temp = listStaffClone.get(i);
                    listStaffClone.set(i, listStaffClone.get(j));
                    listStaffClone.set(j, temp);
                }
            }
            listStaffClone.get(i).displayInformation();
            // thêm lương nhân viên ở cuối mỗi phần tử trong danh sách nhân viên
            System.out.printf("%.1f", ((ICalculator) listStaffClone.get(i)).calculateSalary());
            System.out.println();
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    // hiển thị bản lương cho toàn bộ nhân viên trong công ty theo thứ tự giảm dần
    public static void hienthiBangLuongNVGiamDan(ArrayList<Staff> listStaff) {
        System.out.println("----------------------------------------------------------");
        System.out.println("8. Bảng lương nhân viên theo thứ tự giảm dần -------------");
        System.out.println();
        System.out.printf("%-10s%-20s%-10s%-15s%-15s%-10s%-10s%-22s%-10s\n", "MaNV", "TenNV", "Tuoi", "HesoLuong", "NgayVaoLam",
                "BoPhan", "NgayPhep", "GioTangCa/ChucDanh", "Lương");

        // tạo danh sách nhân viên bản sao
        ArrayList<Staff> listStaffClone = new ArrayList<>();
        listStaffClone = (ArrayList<Staff>)listStaff.clone();

        // duyệt qua danh sách nhân viên,
        for (int i = 0; i < listStaffClone.size(); i++) {
            for (int j = i + 1; j < listStaffClone.size(); j++) {
                //
                if (((ICalculator) listStaffClone.get(i)).calculateSalary() < ((ICalculator) listStaffClone.get(j)).calculateSalary()) {
                    // đổi vị trí phần tử i và phần tử j
                    Staff temp = listStaffClone.get(i);
                    listStaffClone.set(i, listStaffClone.get(j));
                    listStaffClone.set(j, temp);
                }
            }
            listStaffClone.get(i).displayInformation();
            // thêm lương nhân viên ở cuối mỗi phần tử trong danh sách
            System.out.printf("%.1f", ((ICalculator) listStaffClone.get(i)).calculateSalary());
            System.out.println();
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");
    }

    // phương thức cho phép chọn bộ phận làm việc của nhân viên
    public static Department chonBoPhan(Scanner sc) {
        System.out.println("Bộ phận làm việc --------");
        System.out.println(" 1 - Business");
        System.out.println(" 2 - Project");
        System.out.println(" 3 - Technical");

        // chỉ cho phép chọn 1 trong 3 số: 1, 2, 3
        int chon;
        do {
            System.out.print("Chọn bộ phận:                           ");
            chon = sc.nextInt();
            if (chon != 1 && chon != 2 && chon != 3) {
                System.out.println("Chỉ chọn 1 hoặc 2 hoặc 3");
            }
        } while (chon != 1 && chon != 2 && chon != 3);

        // trả về instance
        Department nameDep;
        if (chon == 1) {
            nameDep = new Department("BU");
        } else if (chon == 2) {
            nameDep = new Department("PR");
        } else {
            nameDep = new Department("TE");
        }
        return nameDep;
    }
}
