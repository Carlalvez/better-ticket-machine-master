/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // indicar por parámetro si está maquina va a ser una máquina de tipo normal o va a ser una máquina de tipo que venda billetes con premio. (TRUE = prizeMachine)
    private boolean prizeMachine;
    // Sets the maximum number of tickets that can be sold
    private int maxTicketsToSell;
    // The total of tickets sold.
    private int ticketsSold;
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, boolean trueForPrizeMachineFalseToNormal, int ticketsToSell)
    {
        //True, Prize Machine.
        prizeMachine = trueForPrizeMachineFalseToNormal; 
        maxTicketsToSell = ticketsToSell;
        price = cost;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
    * Receive an amount of money from a customer.
    * Check that the amount is sensible.
    * Si no hay ticket, no recibe cantidad y sout mensaje en pantalla.
    * Si ingresas suficiente dinero, compras ticket  
    */
    public void insertMoney(int amount)
    {
        if (ticketsSold >= maxTicketsToSell){ 
            System.out.println("Stock Out");
            System.out.println("try again in another machine");    
        }
        else if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Revisa si la maquina contiene ticket.
            if (prizeMachine == true) {
                // Simula si imprime ticket
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                
                // Simula si imprime ticket gratuito
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Free Ticket");
                System.out.println("# Congratulations");
                System.out.println("# You won a free ticket");
                System.out.println("##################");
    
               // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
            }
            else{
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();
                
                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
                 // Add 1 to the total of Tickets sold.
                ticketsSold += 1;
            }
        }
        else {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
   
    /**
     Modifica el primer método de esta actividad para que solo vacíe la maquina en caso de que no haya ninguna operación en curso
     */
    public int emptyMachine()
        {  int amountToCollect = -1;
            if (balance != 0){
           System.out.println("Hay una operación en curso.");
           System.out.println("Por favor, inténtelo más tarde.");
           amountToCollect = -1;
        } else {
             amountToCollect = total;
             total = 0;
         }
         return amountToCollect;}
    }