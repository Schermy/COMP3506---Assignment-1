package student42331580;

import java.io.*;
import java.util.StringTokenizer;
import datastructures.*;

public class Agent implements IAgent {

	private ILinkedList<Stock> buyOrders;
	private ILinkedList<Stock> sellOrders;
	private ILinkedList<Stock> transactions;

	/*
	 * Default constructor
	 */
	public Agent() {
		// You may choose which data structures you would like to use

		this.buyOrders = new LinkedList<Stock>();
		this.sellOrders = new LinkedList<Stock>();
		this.transactions = new LinkedList<Stock>();
	}

	/*
	 * Takes a file name as input and parses the commands in the file
	 */
	public int parseInput(String fileName) {

        int ret = 0;

        try {
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream dstream = new DataInputStream(fstream);
            InputStreamReader isreader = new InputStreamReader(dstream);
            BufferedReader file = new BufferedReader(isreader);

            //Parse each line in the file add add the parameters to the appropriate Queue
            String line;
            int LineNumber = 1;
            int nodeIdx = 0;
            Node node = new Node<Stock>(null, null);

            while ((line = file.readLine())  != null) {

                if (line != "") { //Skip Line if Empty
                    StringTokenizer st = new StringTokenizer(line);

                    if (st.countTokens() != 4) {
                        System.err.println("Command on line "+LineNumber+" is not well formed.");
                        ret = -1;
                    }

                    String transactionType = st.nextToken();
                    String stockName = st.nextToken();
                    int quantity = Integer.parseInt(st.nextToken());
                    String tempPrice = st.nextToken();
                    double price = Double.parseDouble(tempPrice.substring(1, tempPrice.length()));

                    Stock stock = new Stock(stockName, quantity, price);
                    node.setElement(stock);

                    System.out.println(node.getElement().getClass());

                    if (node.getElement().getClass().getName() == "buy") {
                        this.buyOrders.addHead(node);
                    }
                    else if (stock.getName().getClass().getName() == "sell") {
                        this.sellOrders.addHead(node);

                    }
                }

                LineNumber++;





            }
        }
        catch (FileNotFoundException e){//Catch exception if any
            System.err.println("File Not Found: " + e.getMessage());
        }
        catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }


		return ret; // To prevent an error in the project
	}

	/*
	 * Tries to match buy and sell orders. See assignment spec for more detail.
	 */
	public void exchange() {
		// Implement this method
	}

	/*
	 * Returns a string of the buy and sell orders. See assignment spec for more
	 * detail.
	 */
	public String printQueues() {
		// Implement this method
		return ""; // To prevent an error in the project
	}

	/*
	 * Returns a string of the transactions. See assignment spec for more
	 * detail.
	 */
	public String printTransactions() {
		// Implement this method
		return ""; // To prevent an error in the project

	}

	public int sizeSell() {
		return this.sellOrders.size();
	}

	public int sizeBuy() {
		return this.buyOrders.size();
	}

	public int sizeTransaction() {
		return this.transactions.size();
	}

}
