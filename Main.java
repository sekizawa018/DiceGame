//二人で遊ぶサイコロゲーム
//サイコロを振って出た目がポイントになる
//先に１００ポイントに到達したほうが勝利
//プレイヤーは自分のターンに何度でもサイコロを振ることができるが、
//サイコロの目が１だった場合、そのターンに得たポイントは没収され、ターンが相手に移る。
import java.util.*;
public class Main{
	public static void main(String[] args){
		int[] pp=new int[2];
		while(true){
			for(int i=0;i<2;i++){
				saikoro(pp,i);
				if(pp[i]>100){
					System.out.println(i==0 ? "A　Win!":"B Win!");
					return;
				}
			}
		}
	}
	public static void saikoro(int[] pp,int i){
		Scanner sc=new Scanner(System.in);
		int ran=0;
		int temp=0;
		int num=0;
		System.out.println(i==0 ? "Aのターン":"B のターン");
		ran=new Random().nextInt(6)+1;
		System.out.println("最初の目は"+ran);
		if(ran!=1){
			pp[i]+=ran;
		}else{
			System.out.println("サイコロの目は"+ran);
			System.out.printf("残念!(%d)%n",pp[i]);
			return;
		}
		while(true){
			System.out.printf("現在のポイント(%d)%n",pp[i]);
			System.out.printf("さらにサイコロを振る？　1:振る2:やめとく>");
			num=sc.nextInt();
			if(num==1){
				ran=new Random().nextInt(6)+1;
				if(ran!=1){
					System.out.println("サイコロの目は"+ran);
					pp[i]+=ran;
					temp+=ran;
					if(pp[i]>100){
						return;
					}
				}else{
					pp[i]-=temp;
					System.out.println("サイコロの目は"+ran);
					System.out.printf("残念!ポイントは(%d)に戻った%n",pp[i]);
					System.out.println("Press Enter");
					sc.nextLine();
					sc.nextLine();
					return;
				}
			}else if(num==2){
				System.out.println("ターン終了");
				System.out.println("Press Enter");
				sc.nextLine();
				sc.nextLine();
				return;
			}else{
				System.out.println("番号が違います");
			}
		}
	}
}
