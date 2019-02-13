
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Sam Lamba
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value
	

	/**
	 * Create WordGram initializes WordGram contents and loads up the data needed for WordGram. Determine the length, start and source code here. Assigns the selected elements to a myWords
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int x = start; x < start+size; x++)//check
		{
			myWords[x-start]=source[x];
		}
		myToString = "";
		myHash = 5;
		
		// TODO: initialize myWords and others as needed
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Calculates the length/size of WordGram by looking at myWords length
	 * @length of myWords in Word Gram
	 */
	public int length(){
		int length = this.myWords.length;
		return length;
	}

	/**
	 * checks if myWord is equal to an object given. If it is exactly the same (including size and content and type) then returns true
	 * returns a boolean
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		
		}
		WordGram wg = (WordGram) o;
		if  (this.toString().equals(wg.toString()))
		{
			return true;
		}
		return false;
	}
	/**
	 * figures out a hashcode for a string providing it hasn't been already calculated
	 * @return an int for myHash either way
	 */
	@Override
	public int hashCode(){
		if (myHash == 5)
		{
		myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete a new WordGram based on a element that needs to be added. Moves everything one to the left and adds and element to the last index.
	 * @param last is last String of returned WordGram
	 * @return a new WordGram
	 */
	public WordGram shiftAdd(String last) {
		String [] one = new String [myWords.length];
		for (int x = 1; x<one.length;x++)
		{
			one[x-1] = myWords[x];
		}
		one[myWords.length-1]= last;
		
		WordGram wg = new WordGram(one,0,myWords.length);
		
		// TODO: Complete this method
		return wg;
	}
	/**
	 * Converts the elements in myWords to a string with spaces between words
	 * @return a string with all the elements and spaces between the words
	 */
	@Override
	public String toString(){
		if (myToString != "")
		{
			return myToString;
		}
		//for (String k : myWords)
		//{
			myToString = String.join(" ", myWords);
		//}
		return myToString;
	}
}
