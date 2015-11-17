import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the tester class that will display interactive commands that the user
 * sees on the console. This class uses the {@link RedBlackTree} class to hold
 * the entire dictionary.
 * 
 * @author Nikhil
 * 
 */
public class RedBlackTreeTester {

	/**
	 * Main method to load the dictionary and start testing the words.
	 * PRE-CONDITION: Name of the files are entered in command line.
	 * 
	 * @param args
	 */

	static RedBlackTree rbt = new RedBlackTree();

	public static void main(String[] args) {

		String input = null;
		System.out
				.println("Both files are ready to be loaded. Which file do you want to use?");
		System.out
				.println("Press 1 to test shortwords.txt, press 2 to load the entore dictionary.");

		try (Scanner inputObj = new Scanner(System.in)) {

			if (inputObj.hasNext()) {
				input = inputObj.next();
			}

			if (input != null && (input.trim().compareTo("1") == 0)) {
				// Load short words
				try (Scanner loaderObj = new Scanner(new File("shortwords.txt"))) {

					// insert the words from short words
					while (loaderObj.hasNext()) {
						rbt.insert(loaderObj.nextLine());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

			else if (input != null && (input.trim().compareTo("2") == 0)) {
				// Load full dictionary
				try (Scanner loaderObj = new Scanner(new File("words.txt"))) {

					// insert the words from words. Populate the entire
					// dictionary
					while (loaderObj.hasNext()) {
						rbt.insert(loaderObj.nextLine());
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Red Black Tree is loaded with " + rbt.getSize()
					+ " words");
			System.out.println("The height of the tree is " + rbt.height());
			System.out.println("2*Lg(n+1)="
					+ (2 * Math.log(rbt.getSize() + 1) / Math.log(2)));

			// Words loaded. Either shortwords or full dictionary based on user
			// input

			System.out.println("\nLegal commands are:");
			System.out
					.println("<p>  display the entire word tree with a level order traversal. \n"
							+ "<s>   print the words of the tree in sorted order (use an inorder traversal)\n"
							+ "<r>   print the words of the tree in reverse sorted order.\n"
							+ "<!>   to quit.\n"
							+ "<c>   <word> to spell check this word\n"
							+ "<a>   <word> add word to tree.\n"
							+ "<f>   <fileName> to check a text file for spelling errors.\n");

			System.out.print(">");

			while (inputObj.hasNext()) {
				input = inputObj.next();

				switch (input.trim().toLowerCase()) {
				case ("p"):
					System.out.println("Level Order Traversal");
					rbt.levelOrderTraversal();
					break;
				case ("s"):
					System.out.println("In-order traversal");
					rbt.inOrderTraversal();
					break;
				case ("r"):
					System.out.println("Reverse sorted traversal");
					rbt.reverseInOrderTraversal();
					break;
				case ("!"):
					System.out.println("Bye");
					System.exit(0);
				case ("c"):
					String word;
					if (inputObj.hasNext()) {
						word = inputObj.next();
						if (rbt.contains(word)) {
							System.out.println("Found " + word + " after "
									+ rbt.getRecentCompares() + " comparisons");
						} else {
							System.out.println(word
									+ " Not in dictionary. Perhaps you mean\n"
									+ rbt.closeBy(word));
						}
					}
					break;
				case ("a"):
					word = null;
					if (inputObj.hasNext()) {
						word = inputObj.next().trim();
						if (rbt.contains(word)) {
							System.out.println("The word '" + word
									+ "' is already in the dictionary");
						} else {
							rbt.insert(word);
							System.out.println(word
									+ " was added to the dictionary");
						}
					}
					break;
				case ("f"):
					if (inputObj.hasNext()) {
						String fileName = inputObj.next().trim();
						word = null;
						boolean errorFreeFlag = true;
						try (Scanner obj = new Scanner(new File(fileName));) {

							while (obj.hasNext()) {
								word = obj.next().trim();
								if (word.charAt(word.length() - 1) == '.') {
									word = word.substring(0, word.length() - 1);
								}
								if (!rbt.contains(word)) {
									errorFreeFlag = false;
									System.out
											.println("'"
													+ word
													+ "' was not found in the dictionary.");
								}

							}
							if (errorFreeFlag == true) {
								System.out.println("No spelling errors found.");
							}
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
					break;

				default:
					break;
				}

				System.out.print("\n>");
			}

		}
	}
}
