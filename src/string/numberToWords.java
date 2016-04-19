//273. Integer to English Words
//Convert a non-negative integer to its english words representation. 

//why 10->twenty?

package string;

public class numberToWords {
	public static void main(String[] args){
		int input=123893;
		//String s=chunkToWord(128);
		//System.out.print(s);
		System.out.print(numberToWords(1000000000));
	}
	public static String numberToWords(int num){ 
		String s;
		if (num < 0) {
            return "";
        }
		if(num == 0){
			return "Zero";
		}
		//1 234 345 789
		if(num/1000000 > 0){
			if (num/1000000000 > 0){
				s = chunkToWord(num/1000000000) + " Billion ";
				num = num%1000000000; 
			}
			else 
				s = "";
			if(chunkToWord(num/1000000).isEmpty() == false){
				s += chunkToWord(num/1000000) + " Million ";
			}
			//1000
			num = num%1000000;
			if(num/1000 != 0)
				s += chunkToWord(num/1000)+ " Thousand " + chunkToWord(num%1000);
			else
				s += chunkToWord(num%1000);
		}
		//12 345
		else if(num/1000 > 0){
			s = chunkToWord(num/1000)+ " Thousand " + chunkToWord(num%1000);
		}
		else
			s = chunkToWord(num);
		return s.trim();
	}
	//A helper function that takes a number less than 1000 and convert just that chunk to words.
	public static String chunkToWord(int n){
		String s1,s2, s3,s;
		switch(n/100){
			case 1 : s1 = "One Hundred"; break;
			case 2 : s1 = "Two Hundred"; break;
			case 3 : s1 = "Three Hundred"; break;
			case 4 : s1 = "Four Hundred"; break;
			case 5 : s1 = "Five Hundred"; break;
			case 6 : s1 = "Six Hundred"; break;
			case 7 : s1 = "Seven Hundred"; break;
			case 8 : s1 = "Eight Hundred"; break;
			case 9 : s1 = "Nine Hundred"; break;
			default: s1 = ""; break;
		}
		//n=113
		int m=n/10; //m=11
		
		switch(m%10){
			case 2 : s2 = "Twenty"; break;
			case 3 : s2 = "Thirty"; break;
			case 4 : s2 = "Forty"; break;
			case 5 : s2 = "Fifty"; break;
			case 6 : s2 = "Sixty"; break;
			case 7 : s2 = "Seventy"; break;
			case 8 : s2 = "Eighty"; break;
			case 9 : s2 = "Ninety"; break;
			default: s2 = ""; break;
		}
		//m=11,n=113->n%10 =3
		if(m%10 == 1){
			switch ((m%10)*10+n%10){
				case 10 : s2 = "Ten"; break;
				case 11 : s2 = "Eleven"; break;
				case 12 : s2 = "Twelve"; break;
				case 13 : s2 = "Thirteen"; break;
				case 14 : s2 = "Fourteen"; break;
				case 15 : s2 = "Fifteen"; break;
				case 16 : s2 = "Sixteen";break;
				case 17 : s2 = "Seventeen"; break;
				case 18 : s2 = "Eighteen"; break;
				case 19 : s2 = "Nineteen"; break;
			}
			s3 = "";
		}		
		else{
			switch(n%10){
				case 1 : s3 = "One"; break;
				case 2 : s3 = "Two"; break;
				case 3 : s3 = "Three"; break;
				case 4 : s3 = "Four"; break;
				case 5 : s3 = "Five"; break;
				case 6 : s3 = "Six"; break;
				case 7 : s3 = "Seven"; break;
				case 8 : s3 = "Eight"; break;
				case 9 : s3 = "Nine"; break;
				default: s3 = ""; break;
			}
		}
		if(s1.isEmpty() && s2.isEmpty() == false && s3.isEmpty() == false){
			s = s2 + " " + s3;
		}
		else if(s2.isEmpty() && s1.isEmpty() == false && s3.isEmpty() == false){
			s = s1 + " " + s3;
		}
		else if(s3.isEmpty() && s2.isEmpty() == false && s1.isEmpty() == false){
			s = s1 + " " + s2;
		}
		else if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty() == false){
			s = s3;
		}
		else if(s1.isEmpty() == false && s2.isEmpty() && s3.isEmpty()){
			s = s1;
		}
		else if(s1.isEmpty() && s2.isEmpty() == false && s3.isEmpty()){
			s = s2;
		}
		else if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty()){
			s = "";
		}
		else {
			s = s1 + " " + s2 + " " + s3;
		}
		return s.trim();
	}
}
