package dynamicAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfASet {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);

		List<ArrayList<Integer>> result = getSubsets(a, 0);
		
		for (ArrayList<Integer> integer : result) {
			for (Integer integer2 : integer) {
				System.out.println(integer2);
			}
			System.out.println("Next");
		}
	}

	private static List<ArrayList<Integer>> getSubsets(List<Integer> set, int index) {
		List<ArrayList<Integer>> allSubsets;
		
		if (set.size() == index) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		} else {
			allSubsets = getSubsets(set, index+1);
			int item = set.get(index);
			List<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subSet : allSubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subSet);
				newsubset.add(item);
				moreSubsets.add(newsubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}

}
