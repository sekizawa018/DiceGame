import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("2P対戦>1/COM対戦>2  >");
		int select=sc.nextInt();
		int[] pp=new int[2];
		System.out.print("目標ポイントを設定してください>");
		int goal=sc.nextInt();
		while(true){
			for(int i=0;i<2;i++){
				saikoro(pp,i,goal,select);
				if(pp[i]>=goal){
					System.out.println(i==0 ? "A　Win!":"B Win!");
					return;
				}
			}
		}
	}
	public static void saikoro(int[] pp,int i,int goal,int select){
		Scanner sc=new Scanner(System.in);
		Random ra=new Random();
		int ran=0;
		int temp=0;
		int num=0;
		int com=0;
		System.out.println(i==0 ? "Aのターン":"B のターン");
		ran=ra.nextInt(6)+1;
		System.out.println("サイコロを振ります");
		System.out.println("Press Enter");
		pressEnter(select);
		System.out.println("最初の目は"+ran);
		if(ran!=1){
			pp[i]+=ran;
			if(pp[i]>=goal){
				return;
			}
		}else{
			System.out.println("最初のサイコロの目は"+ran);
			System.out.printf("残念!(%d)%n",pp[i]);
			System.out.println("Press Enter");
			pressEnter(select);
			return;
		}
		while(true){
			System.out.printf("現在のポイント(%d)%n",pp[i]);
			System.out.printf("さらにサイコロを振る？　1:振る2:やめとく>");
			if(select==2&&i==1){
				com=ra.nextInt(5);
				System.out.println();
				if(com>0){
					num=1;
				}else{
					num=2;
				}
			}else{
				num=sc.nextInt();
			}
			if(num==1){
				ran=ra.nextInt(6)+1;
				if(ran!=1){
					System.out.println("サイコロの目は"+ran);
					pp[i]+=ran;
					temp+=ran;
					if(pp[i]>=goal){
						return;
					}
				}else{
					pp[i]-=temp;
					System.out.println("サイコロの目は"+ran);
					System.out.printf("残念!ポイントは(%d)に戻った%n",pp[i]);
					System.out.println("Press Enter");
					pressEnter(select);
					return;
				}
			}else if(num==2){
				System.out.println("ターン終了");
				System.out.println("Press Enter");
				pressEnter(select);
				return;
			}else{
				System.out.println("番号が違います");
			}
		}
	}
	public static void pressEnter(int select){
		Scanner sc=new Scanner(System.in);
		if(select==2){
			sc.nextLine();
		}else{
			sc.nextLine();
			sc.nextLine();
		}
	}
}
