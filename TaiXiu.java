package main;

import java.util.Random;
import java.util.Scanner;

public class TaiXiu {
	public static Boolean CheckLogin(String password) {
		if (password.length() < 6) {
			return false;
		}

		boolean HasLetter = false;

		for (char c : password.toCharArray()) {
			if (Character.isLetter(c)) {
				HasLetter = true;
				break;
			}
		}
		if (!HasLetter) {
			return false;
		}

		boolean HasNumber = false;
		for (char c : password.toCharArray()) {
			if (Character.isDigit(c)) {
				HasNumber = true;
				break;
			}
		}
		if (!HasNumber) {
			return false;
		}

		boolean HasOneUpper = false;
		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c)) {
				HasOneUpper = true;
				break;
			}
		}
		if (!HasOneUpper) {
			return false;
		}
		Boolean HasSpace = true;
		for (char c : password.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				HasSpace = false;
				break;
			}
		}
		if (!HasSpace) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String password ="";
		while(true) {
			System.out.println("Chú ý nhập mật khẩu có trên 6 ký tự ,1 chữ cái ,và một chữ số,1 chữ hoa ,không có dấu cách");
			System.out.print("Mời nhập mật khẩu : ");
			String newPass = sc.nextLine();
			if(CheckLogin(newPass)) {
				password = newPass;
				System.out.println("\n Mật khẩu đã được thiết lập ");
				break;
			} else {
				System.out.println("\n Vui lòng nhập lại ");
			}
		}
		int count =0;
		while(true) {
			
			System.out.print("Mời nhập mật khẩu để đăng nhập: ");
			String loginPass = sc.nextLine();
			if(loginPass.equals(password)) {
				System.out.println("\n Đăng nhập thành công ");
				break;
			} else {
				System.out.println("\n Vui lòng nhập lại ");
				count++;
			}
			if(count > 5) {
				System.out.println("\n Nhập sai quá 5 lần đã bị khóa  ");
				System.exit(0);
				break;
			}
			
			
		}
//		game tài xỉu
		int taiKhoanNguoiChoi = 50000;
		int LuaChon;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("+-----------Menu Trò Chơi----------+");
			System.out.println("+ 01 Tiếp tục chơi game            +");
			System.out.println("+ 02 Nhấn phím bất kỳ để thoát     +");
			System.out.println("+----------------------------------+");
			System.out.println("Mời lựa chọn của bạn : ");
			LuaChon = input.nextInt();
			if(LuaChon == 1) {
				System.out.println("+-----------Băt Đầu Chơi-----------+");
				System.out.println("+ Tài khoản của bạn đang có là :"+taiKhoanNguoiChoi);
				int DatCuoc = 0;
				do {
					System.out.println("+ Bạn muốn cược bao nhiêu :        +");
					DatCuoc = input.nextInt();
					
					if(DatCuoc<=0 || DatCuoc> taiKhoanNguoiChoi )
						System.out.println("+     Mời nhập lại mức cược        +");
				}while(DatCuoc<=0 || DatCuoc> taiKhoanNguoiChoi );
				int luaChonTaiXiu = 0;
				do {
					System.out.println("+-----------Menu Trò Chơi----------+");
					System.out.println("+         1 Chọn Xỉu               +");
					System.out.println("+         2 Chọn Tài               +");
					System.out.println("+----------------------------------+");
					luaChonTaiXiu = input.nextInt();
				}while(luaChonTaiXiu!=1&&luaChonTaiXiu!=2);
				Random xucXac1 = new Random();
				Random xucXac2 = new Random();
				Random xucXac3 = new Random();
				
				int KetQua1 = xucXac1.nextInt(5)+1;
				int KetQua2 = xucXac2.nextInt(5)+1;
				int KetQua3 = xucXac3.nextInt(5)+1;
				int Tong = KetQua1+KetQua2+KetQua3;
				System.out.println("\t Kết quả là : "+KetQua1+"-"+KetQua2+"-"+KetQua3);
				if(Tong ==3 || Tong==18) {
					System.out.println("+----------- Bạn đã thua ----------+");
					System.out.println(" ");
					taiKhoanNguoiChoi -= DatCuoc;
				} 
				else if(Tong > 3 && Tong <= 10 ) {
					if(luaChonTaiXiu == 2) {
						System.out.println("+----------- Bạn đã thua ----------+");
						System.out.println(" ");
						taiKhoanNguoiChoi -= DatCuoc;
					}else {
						System.out.println("+----------- Bạn đã Thắng ---------+");
						System.out.println(" ");
						taiKhoanNguoiChoi += DatCuoc;
					}
				}
				else if(Tong > 10 && Tong < 18 ) {
					if(luaChonTaiXiu == 1) {
						System.out.println("+----------- Bạn đã thua ----------+");
						System.out.println(" ");
						taiKhoanNguoiChoi -= DatCuoc;
					}else {
						System.out.println("+----------- Bạn đã Thắng ---------+");
						System.out.println(" ");
						taiKhoanNguoiChoi += DatCuoc;
					}
				}
			}
		} while(LuaChon == 1);
		
	}
}
