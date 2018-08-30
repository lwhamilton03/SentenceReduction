import java.util.ArrayList;

public class Sentence {

	String sent;
	ArrayList<String> newList = new ArrayList<String>();
	ArrayList<String> newList2 = new ArrayList<String>();

	public void compress(String sent) {
		
		String[] list = sent.split(" ");
		
		int count = 0; 

		for (int i = 1; i <= list.length; i++) {
			
			if (count > 0)	
			{
				count--;
				continue;
			}
			
			boolean added = true;
			String temp = list[i-1]; 
			int k = i; 
			
			
			
			while (added)
			{
				if ( i == list.length) break;
				
				int wordLength = list[k].length();
				int wordLengthBefore = temp.length();

				if (wordLength > wordLengthBefore) 
				{
					wordLength = wordLengthBefore;
				}

				added = false;

				for (int j = wordLength; j > 0; j--) {
					if (temp.substring(wordLengthBefore - j).equals(list[k].substring(0, j)))
					{
					
						temp = temp.substring(0, wordLengthBefore - j) + list[k];
						count ++;
						//	newList.add(list[i - 1].substring(0, wordLengthBefore - j) + list[i]);
						added = true;
					}

				}

				k++; 
			}
			
				newList.add(temp);
			if(i == (list.length-1)) 
			{
				newList.add(list[i]);
			}
//			if (!added)
//			{
//				newList.add(list[i]);
//			}
		}

		// for(int i = 1; i <= newList.size() - 1; i++)
		// {
		// int wordLength = newList.get(i).length();
		// int wordLengthBefore = newList.get(i-1).length();
		//
		// if (wordLength > wordLengthBefore)
		// {
		// wordLength = wordLengthBefore;
		// }
		//
		// boolean added = false;
		//
		// for(int j = wordLength; j > 0; j--)
		// {
		// if(newList.get(i-1).substring(wordLengthBefore -
		// j).equals(newList.get(i).substring(0, j)))
		// {
		// newList2.add(newList.get(i-1).substring(0, wordLengthBefore - j) +
		// newList.get(i));
		// added = true;
		// }
		//
		// }
		//
		// if (!added)
		// {
		// newList2.add(list[i]);
		// }
		// }

		print();

	}

	public void print() {
		for (String letter : newList) {
			System.out.println(letter);
		}
	}
}
