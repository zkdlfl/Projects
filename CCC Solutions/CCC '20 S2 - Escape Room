import java.util.*;
import java.io.*;
public class EscapeRoom {
	
	public static class Pair {
		int row;
		int col;
		public Pair(int r, int c) { 
			row=r; 
			col = c;
		}
	}
	
	static int M, N;
	static boolean[][] arr;
	static Map<Integer, LinkedList<Pair>> map;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt( br.readLine()  );
		N = Integer.parseInt(br.readLine()  );
		arr = new boolean[M+1][N+1];
		map = new HashMap<>();
		
		
		for(int i=1;i<=M;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=1, k=0;j<=N ;j++, k++) {
				arr[i][j] = false;
				int x = Integer.parseInt(s[k]);
				if( !map.containsKey(x) ) { map.put(x, new LinkedList<Pair>() ); }
				map.get(x).add( new Pair(i, j) );
			}
		}
		
		if( escape() ) System.out.println("yes");
		else System.out.println("no");
		
	}
	public static boolean escape() {
		Queue<Pair> qu = new LinkedList<>();
		qu.add( new Pair(M, N) );
		
		while( !qu.isEmpty() ) {
			Pair cur = qu.poll();
			int va = cur.row * cur.col;
			//System.out.println(va + " here ");
			LinkedList<Pair> temp = map.get( va );
			if( temp == null ) continue;
			for( Pair p : temp) {
				if( p.row ==1 && p.col == 1) { return true;}
				if( arr[p.row][p.col] ) { continue;}
				qu.add(p);
				arr[p.row][p.col] = true;
			}
		}
		return false;
	}
}
